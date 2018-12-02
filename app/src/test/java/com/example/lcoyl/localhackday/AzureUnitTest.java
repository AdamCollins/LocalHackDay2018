package com.example.lcoyl.localhackday;

import com.example.lcoyl.localhackday.AzureCV.Identifier;
import com.example.lcoyl.localhackday.AzureCV.ObjectIdentifier;
import com.example.lcoyl.localhackday.AzureCV.TextIdentifier;

import org.json.JSONObject;
import org.junit.Test;

import java.io.File;

public class AzureUnitTest {
    @Test
    public void getImageIdentity(){
        File image = new File("C:\\Users\\Adam Collins\\Pictures\\liam.jpg");

        System.out.println(image.exists());
        Identifier cv = new ObjectIdentifier();
        JSONObject json = cv.requestData(image);
        System.out.println(json);
    }

    @Test
    public void getTextReader(){
        File image = new File("C:\\Users\\Adam Collins\\Pictures\\mango.jpg");

        System.out.println(image.exists());
        Identifier cv = new TextIdentifier();
        JSONObject json = cv.requestData(image);
        System.out.println(json);
    }


}
