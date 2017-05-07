package emotion.api.controller;

import com.google.cloud.vision.spi.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.*;
import com.google.cloud.vision.v1.WebDetection.*;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.protobuf.ByteString;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayezhou on 2017/5/2.
 */
public class GoogleVisionController {

    //filepath: relative
    public static void detectWebEntity(String filepath, PrintStream out) throws IOException {
        ImageAnnotatorClient vision = ImageAnnotatorClient.create();

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
        requests.add(request);//TODO: add more

        // Performs label detection on the image file
        BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
        List<AnnotateImageResponse> responses = response.getResponsesList();

        for (AnnotateImageResponse res : responses) {
            if (res.hasError()) {
                System.out.printf("Error: %s\n", res.getError().getMessage());
                return;
            }
            WebDetection annotation = res.getWebDetection();
            out.println("Entity:Id:Score");
            out.println("===============");
            //TODO: only those score high than 0.5, one or two is enough, only need the discription & link
            for (WebEntity entity : annotation.getWebEntitiesList()) {
                out.println(entity.getDescription() + " : " + entity.getEntityId() + " : "
                        + entity.getScore());
            }
            out.println("\nPages with matching images: Score\n==");
            for (WebPage page : annotation.getPagesWithMatchingImagesList()) {
                out.println(page.getUrl() + " : " + page.getScore());
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        detectWebEntity("test.png", System.out);
        double a = 0;
        double sum = 0;
        for (int i = 0; i < 24; i++) {
            a = sum * (1.0 + 0.07/12.0) - sum + 400;
            System.out.println(i + " month income: " + a);
            sum += a;
            System.out.println(i + " month total: " + sum);
        }
        System.out.println(sum);
    }
}
