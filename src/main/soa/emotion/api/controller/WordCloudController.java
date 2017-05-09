package emotion.api.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import emotion.api.request.WordCloudRequest;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lifengshuang on 08/05/2017.
 */
@RestController
public class WordCloudController {

    @RequestMapping(value = "/word-cloud", method = RequestMethod.POST)
    public
    @ResponseBody
    String wordCloud(@RequestBody WordCloudRequest request) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.post("https://wordcloudservice.p.mashape.com/generate_wc")
                .header("X-Mashape-Key", "yi47gNDxGlmshhQCvuZzgSplqrQRp13GWJnjsnzHFKd6PY8cQ6")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body("{\"f_type\":\"png\",\"width\":800,\"height\":500,\"s_max\":\"7\",\"s_min\":\"1\",\"f_min\":1,\"r_color\":\"TRUE\",\"r_order\":\"TRUE\",\"s_fit\":\"FALSE\",\"fixed_asp\":\"TRUE\",\"rotate\":\"TRUE\"," +
                        "\"textblock\":\"" + request.getText() + "\"}")
                .asJson();
        return response.getBody().toString();
    }

    public static void main(String[] args) throws UnirestException {
        String text = "He lived alone in a house of logs surrounded on all sides by the great forest. He seemed a part of the darkness and silence of the forest, for no one had ever known him to smile or speak an unnecessary word. His simple needs were supplied by selling or trading the skins of wild animals in the town. null One day Murlock was found in his cabin, dead. It was not a time and place for medical examiners and newspapers. I suppose it was agreed that he had died from natural causes or I should have been told, and should remember. As the prisoner fell, everything seemed black and empty. But then he felt a sharp pain in his neck and could not breathe. There were terrible pains running from his neck down through his body, his arms and his legs. He could not think. He could only feel, a feeling of living in a world of pain. A man stood on a railroad bridge in Alabama looking down into the swift waters of the Owl Creek River below. The mans hands were tied behind his back. There was a rope around his neck. The rope was tied to part of the bridge above him. Three soldiers of the northern army stood near the prisoner, waiting for their captains orders to hang him. The prisoner quickly opened his eyes and looked at the water. %22If I could only free my hands,%22 he thought. %22Then I could get the rope off my neck and jump into the river. I could swim under the water and escape the fire of their guns. I could reach the other side of the river and get home through the forest. My house is outside of their military area, and my wife and children are safe there. I would be, too%E2%80%A6%22 The occurrence, or event, in our story takes place during the Civil War of the eighteen sixties between the American states of the north and the states of the south. A group of soldiers is hanging a southern farm owner for trying to stop northern military movements across the Owl Creek Bridge. While these thoughts raced through the prisoners mind, the captain gave the soldiers the order to hang him. A soldier quickly obeyed. He made the rope firm around the prisoners neck. Then he dropped him through a hole in the bridge. Everybody was ready. The prisoner stood quietly. His eyes were not covered. He looked down and saw the water under the bridge. Now, he closed his eyes. I know only that the body was buried near the cabin, next to the burial place of his wife. She had died so many years before him that local tradition noted very little of her existence.";
        HttpResponse<JsonNode> response = Unirest.post("https://wordcloudservice.p.mashape.com/generate_wc")
                .header("X-Mashape-Key", "yi47gNDxGlmshhQCvuZzgSplqrQRp13GWJnjsnzHFKd6PY8cQ6")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body("{\"f_type\":\"png\",\"width\":800,\"height\":500,\"s_max\":\"7\",\"s_min\":\"1\",\"f_min\":1,\"r_color\":\"TRUE\",\"r_order\":\"TRUE\",\"s_fit\":\"FALSE\",\"fixed_asp\":\"TRUE\",\"rotate\":\"TRUE\"," +
                        "\"textblock\":\"" + text + "\"}")
                .asJson();
        System.out.println(response.getBody().toString());
    }
}
