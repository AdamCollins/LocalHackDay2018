package com.example.lcoyl.localhackday.AzureCV;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public abstract class Identifier {
    private final String api_key = "699c3c58d8aa4194b3aa198dcb6c5ba7";
    protected final String endpoint = "https://westcentralus.api.cognitive.microsoft.com/vision/v2.0/";
    private final File image;
    protected abstract String getEndPoint();
    protected abstract URIBuilder addParamaters(URIBuilder builder);
    protected Identifier(File image){
        this.image = image;
    }
    public boolean isImage(File image){
        return true;
    }

    public JSONObject requestData(){


        HttpClient httpclient = HttpClients.createDefault();

        JSONObject jsonRes = null;
        try {
            URIBuilder builder = new URIBuilder(getEndPoint());

            builder = addParamaters(builder);

            URI uri = builder.build();

            HttpPost request = new HttpPost(uri);
            //header for image
            request.setHeader("Content-Type", "application/octet-stream");
            //header for url
            request.setHeader("Ocp-Apim-Subscription-Key", api_key);

            // Request body For File
            request.setEntity(new FileEntity(image));

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();



            jsonRes = new JSONObject(EntityUtils.toString(entity));

            if (entity != null) {
                System.out.println(EntityUtils.toString(entity));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jsonRes;
    }
    public JSONObject requestData2(){


        HttpClient httpclient = HttpClients.createDefault();

        JSONObject jsonRes = null;
        try {
            URL url = new URL(getEndPoint());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type","application/octet-stream");
            conn.setRequestProperty("Ocp-Apim-Subscription-Key", api_key);
            conn.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            new FileEntity(image).writeTo(wr);
            wr.flush();
            wr.close();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


//            // Request body For File
//            request.setEntity(new FileEntity(image));
//
//            HttpResponse response = httpclient.execute(request);
            return new JSONObject(response.toString());


//            jsonRes = new JSONObject(EntityUtils.toString(entity));
//
//            if (entity != null) {
//                System.out.println(EntityUtils.toString(entity));
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jsonRes;
    }
}
