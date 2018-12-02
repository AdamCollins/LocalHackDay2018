package com.example.lcoyl.localhackday;

import com.example.lcoyl.localhackday.AzureCV.Identifier;
import com.example.lcoyl.localhackday.AzureCV.ObjectIdentifier;
import com.example.lcoyl.localhackday.AzureCV.TextIdentifier;

import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONObject;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class AzureUnitTest {
    @Test
    public void getImageIdentity(){
        File image = new File("C:\\Users\\lcoyl\\Downloads\\Liam Coyle.jpeg");

        Identifier cv = new ObjectIdentifier(image);
        JSONObject json = cv.requestData2();
        System.out.println(json);
    }

    @Test
    public void getTextReader(){
        File image = new File("C:\\Users\\Adam Collins\\Pictures\\mango.jpg");


        System.out.println(image.exists());
        Identifier cv = new TextIdentifier(image);
        JSONObject json = cv.requestData();
        System.out.println(json);
    }


}
