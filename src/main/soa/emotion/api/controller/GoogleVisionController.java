package emotion.api.controller;

import com.google.cloud.vision.spi.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.*;
import com.google.cloud.vision.v1.WebDetection.*;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.protobuf.ByteString;
import emotion.api.response.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mayezhou on 2017/5/2.
 */

@RestController
public class GoogleVisionController {

    @Autowired
    private ServletContext servletContext;

    @RequestMapping(value = "/google-vision", method = RequestMethod.GET)
    public
    @ResponseBody
    Object googleVision(@RequestParam String imagePath) throws IOException {
        String absolutePath = servletContext.getRealPath("/") + imagePath;
        Path path = Paths.get(absolutePath);
        byte[] data;
        data = Files.readAllBytes(path);
        ByteString imgBytes = ByteString.copyFrom(data);

        // Builds the image annotation request
        List<AnnotateImageRequest> requests = new ArrayList<>();
        Image img = Image.newBuilder().setContent(imgBytes).build();
        Feature feat = Feature.newBuilder().setType(Type.WEB_DETECTION).build();//only use Web Entity Detection
        AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
                .addFeatures(feat)
                .setImage(img)
                .build();
        requests.add(request);
        ImageAnnotatorClient vision = ImageAnnotatorClient.create();

        // Performs label detection on the image file
        BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
        List<AnnotateImageResponse> responses = response.getResponsesList();

        GoogleVisionResponse googleVisionResponse = new GoogleVisionResponse();
        for (AnnotateImageResponse res : responses) {
            if (res.hasError()) {
                return new ErrorResponse("Error: " + res.getError().getMessage());
            }
            WebDetection annotation = res.getWebDetection();
            //TODO: only those score high than 0.5, one or two is enough, only need the discription & link
            for (WebEntity entity : annotation.getWebEntitiesList()) {
                googleVisionResponse.addEntity(new Entity(entity.getDescription(), entity.getEntityId(), entity.getScore()));
            }
            for (WebPage page : annotation.getPagesWithMatchingImagesList()) {
                googleVisionResponse.addUrl(page.getUrl());
            }
        }
        return googleVisionResponse;
    }

    private static class GoogleVisionResponse {
        private List<Entity> entities = new LinkedList<>();
        private List<String> urls = new LinkedList<>();

        public void addEntity(Entity entity) {
            entities.add(entity);
        }

        public void addUrl(String url) {
            urls.add(url);
        }

        public List<Entity> getEntities() {
            return entities;
        }

        public void setEntities(List<Entity> entities) {
            this.entities = entities;
        }

        public List<String> getUrls() {
            return urls;
        }

        public void setUrls(List<String> urls) {
            this.urls = urls;
        }
    }

    private static class Entity {
        private String description;
        private String id;
        private float score;

        public Entity(String description, String id, float score) {
            this.description = description;
            this.id = id;
            this.score = score;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public float getScore() {
            return score;
        }

        public void setScore(float score) {
            this.score = score;
        }
    }


    //filepath: relative
    public static Object detectWebEntity(String filepath, PrintStream out) throws IOException {

        //TODO: do in your own way, as long as the parameter to the request is ByteString
        Path path = Paths.get(filepath);
        byte[] data = Files.readAllBytes(path);
        ByteString imgBytes = ByteString.copyFrom(data);

        // Builds the image annotation request
        List<AnnotateImageRequest> requests = new ArrayList<>();
        Image img = Image.newBuilder().setContent(imgBytes).build();
        Feature feat = Feature.newBuilder().setType(Type.WEB_DETECTION).build();//only use Web Entity Detection
        AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
                .addFeatures(feat)
                .setImage(img)
                .build();
        requests.add(request);
        ImageAnnotatorClient vision = ImageAnnotatorClient.create();

        // Performs label detection on the image file
        BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
        List<AnnotateImageResponse> responses = response.getResponsesList();

        GoogleVisionResponse googleVisionResponse = new GoogleVisionResponse();
        for (AnnotateImageResponse res : responses) {
            if (res.hasError()) {
                return new ErrorResponse("Error: " + res.getError().getMessage());
            }
            WebDetection annotation = res.getWebDetection();
            //TODO: only those score high than 0.5, one or two is enough, only need the discription & link
            for (WebEntity entity : annotation.getWebEntitiesList()) {
                googleVisionResponse.addEntity(new Entity(entity.getDescription(), entity.getEntityId(), entity.getScore()));
            }
            for (WebPage page : annotation.getPagesWithMatchingImagesList()) {
                googleVisionResponse.addUrl(page.getUrl());
            }
        }
        return googleVisionResponse;
    }

    public static void main(String[] args) throws IOException {
        detectWebEntity("test.png", System.out);

    }
}
