package emotion.api.controller;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.*;

/**
 * Created by mayezhou on 2017/5/2.
 */
public class WastonApiController {
    public static void main(String[] args) {
        NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding(
                NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27,
                "63b4f5b3-9a8d-4e85-a2a4-8c76e35889da",
                "TR5Oyt3gPU25"
        );

        //TODO: should be an argument, text should be the combination of all surrounding posts
        //U know 2333333333333333333
        String text = "IBM is an American multinational technology " +
                "company headquartered in Armonk, New York, " +
                "United States, with operations in over 170 countries.";

        EntitiesOptions entitiesOptions = new EntitiesOptions.Builder()
                .emotion(true)
                .sentiment(true)
                .limit(2)
                .build();

        KeywordsOptions keywordsOptions = new KeywordsOptions.Builder()
                .emotion(true)
                .sentiment(true)
                .limit(2)
                .build();

        Features features = new Features.Builder()
                .entities(entitiesOptions)
                .keywords(keywordsOptions)
                .build();

        AnalyzeOptions parameters = new AnalyzeOptions.Builder()
                .text(text)
                .features(features)
                .build();

        AnalysisResults response = service
                .analyze(parameters)
                .execute();
        System.out.println(response);
    }

}
