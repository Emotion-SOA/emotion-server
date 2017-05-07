package emotion.api.controller;

import emotion.api.request.AddImageRequest;
import emotion.api.response.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.util.Base64;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by lifengshuang on 01/05/2017.
 */

@RestController
@RequestMapping("/image")
public class ImageController {


    @Autowired
    private ServletContext servletContext;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public
    @ResponseBody
    Object addImage(@RequestBody AddImageRequest request) {
        String absolutePath = servletContext.getRealPath("/");
        File imageDir = new File(absolutePath + "image" + File.separator);
        if (!imageDir.exists()) {
            if (!imageDir.mkdir()) {
                return new ErrorResponse("Image directory creation failed");
            }
        }
        int id = imageDir.listFiles().length;
        int slashIndex = request.getBase64().indexOf('/');
        int semicolonIndex = request.getBase64().indexOf(';');
        int commaIndex = request.getBase64().indexOf(',');
        String type = request.getBase64().substring(slashIndex + 1, semicolonIndex);
        String filename = id + "." + type;
        File imageFile = new File(absolutePath + "image" + File.separator + filename);
        String dataPart = request.getBase64().substring(commaIndex + 1);
        try {
            byte[] raw = Base64.getDecoder().decode(dataPart);
            FileOutputStream fileOutputStream = new FileOutputStream(imageFile);
            fileOutputStream.write(raw);
            fileOutputStream.close();
            return new AddImageResponse("/image/" + filename);
        } catch (IOException e) {
            return new ErrorResponse("Image creation failed");
        }
    }

    private class AddImageResponse {
        private String imageName;

        public AddImageResponse(String imageName) {
            this.imageName = imageName;
        }

        public String getImageName() {
            return imageName;
        }

        public void setImageName(String imageName) {
            this.imageName = imageName;
        }
    }


}
