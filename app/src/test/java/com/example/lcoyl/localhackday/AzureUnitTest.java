package com.example.lcoyl.localhackday;

import com.example.lcoyl.localhackday.AzureAPI.ComputerVision;

import org.json.JSONObject;
import org.junit.Test;

import java.io.File;

public class AzureUnitTest {
    @Test
    public void getPhoto(){
        File image = new File("C:\\Users\\Adam Collins\\Pictures\\liam.jpg");
        System.out.println(image.exists());
        ComputerVision cv = new ComputerVision();
        JSONObject json = cv.imageData(image);
        System.out.println(json);

    }

    @Test
    public void getURLPhoto(){
        ComputerVision cv = new ComputerVision();
        cv.urlImage();
    }
}
