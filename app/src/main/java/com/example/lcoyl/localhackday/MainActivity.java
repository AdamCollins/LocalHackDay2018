package com.example.lcoyl.localhackday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import org.apache.http.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void postRequest(){

    }
    private void getImage(){

    }
    public void testSendBinary() throws MalformedURLException {
        File picfile = new File("app/sampledata/my_file.jpeg");
        if (!picfile.exists()) throw new AssertionError();


        HttpClient httpclient = HttpClients.createDefault();

        try {
            URIBuilder builder = new URIBuilder("https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect");

            builder.setParameter("returnFaceId", "true");
            builder.setParameter("returnFaceLandmarks", "false");

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/octet-stream");
            request.setHeader("Ocp-Apim-Subscription-Key", "***");

            // Request body
            request.setEntity(new FileEntity(picfile));

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                System.out.println(EntityUtils.toString(entity));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
