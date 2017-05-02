package emotion.api.controller;

import emotion.api.request.AddImageRequest;
import emotion.api.response.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.io.*;

/**
 * Created by lifengshuang on 01/05/2017.
 */

@RestController
@RequestMapping("/image")
public class ImageController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public
    @ResponseBody
    Object getImage(@RequestParam int imageID) {
        File image = new File("image" + File.separator + imageID);
        if (image.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(image);
                // Not good to use available().
                byte[] data = new byte[fileInputStream.available()];
                int length = fileInputStream.read(data, 0, data.length);
                return new GetImageResponse(new String(data, 0, length));
            } catch (IOException e) {
                e.printStackTrace();
                return new ErrorResponse("Failed to read image");
            }
        } else {
            return new ErrorResponse("Image not found");
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public
    @ResponseBody
    Object addImage(@RequestBody AddImageRequest request) {
        File imageDir = new File("image");
        if (!imageDir.exists()) {
            if (!imageDir.mkdir()) {
                return new ErrorResponse("Image directory creation failed");
            }
        }
        int id = imageDir.listFiles().length;
        File image = new File("image" + File.separator + id);
        try {
            FileWriter fileWriter = new FileWriter(image);
            fileWriter.write(request.getBase64());
            fileWriter.close();
            return new AddImageResponse(id);
        } catch (IOException e) {
            return new ErrorResponse("Image creation failed");
        }
    }

    private class GetImageResponse {
        private String base64;

        public GetImageResponse(String base64) {
            this.base64 = base64;
        }

        public String getBase64() {
            return base64;
        }

        public void setBase64(String base64) {
            this.base64 = base64;
        }
    }

    private class AddImageResponse {
        private int imageID;

        public AddImageResponse(int imageID) {
            this.imageID = imageID;
        }

        public int getImageID() {
            return imageID;
        }

        public void setImageID(int imageID) {
            this.imageID = imageID;
        }
    }


}
