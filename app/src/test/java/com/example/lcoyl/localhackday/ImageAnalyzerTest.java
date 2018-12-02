package com.example.lcoyl.localhackday;

import com.example.lcoyl.localhackday.Types.ImageData;

import org.junit.Test;

import java.io.File;

public class ImageAnalyzerTest {
    @Test
    public void analyzeImageTest(){
        ImageAnalyzer ia = new ImageAnalyzer();
        ImageData data = ia.analyzeImage(new File("C:\\Users\\Adam Collins\\Pictures\\greenapple.jpg"));
        System.out.println(data.toSting());
    }
}
