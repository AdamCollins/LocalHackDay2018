package com.example.lcoyl.localhackday;

import com.example.lcoyl.localhackday.AzureCV.ObjectIdentifier;
import com.example.lcoyl.localhackday.AzureCV.TextIdentifier;
import com.example.lcoyl.localhackday.Types.ImageData;
import org.json.JSONObject;

import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

public class ImageAnalyzer {
    public ImageData analyzeImage(File image){
        AtomicReference<JSONObject> objData = new AtomicReference<>();
        AtomicReference<JSONObject> textData = new AtomicReference<>();
        ObjectIdentifier oi = new ObjectIdentifier(image);
        TextIdentifier ti = new TextIdentifier(image);
        Thread objectIdThread = new Thread(()->{
            JSONObject json = oi.requestData();
//            System.out.println(json);
            objData.set(json);
        });
        Thread textIdThread = new Thread(()->{
            JSONObject json = ti.requestData();
//            System.out.println(json);
            textData.set(json);
        });
        objectIdThread.start();
        textIdThread.start();

        try {
            objectIdThread.join();
            textIdThread.join();
            return new ImageData(textData.get(), objData.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }


}

