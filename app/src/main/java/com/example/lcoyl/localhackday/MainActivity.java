package com.example.lcoyl.localhackday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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
        RequestQueue queue = Volley.newRequestQueue(this);
        if (!picfile.exists()) throw new AssertionError();

        String url = "http://my-json-feed";
        String text;

        request.setHeader("Content-Type", "application/octet-stream");
        request.setHeader("Ocp-Apim-Subscription-Key", "***");

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                          Log.d("HTTP response","Response: " + response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });
        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest);



try {
    URL url = new URL("http://somelink");

    URLConnection conn = url.openConnection();
    conn.setDoOutput(true);


    HttpURLConnection myURLConnection = (HttpURLConnection) conn;
    myURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    myURLConnection.setRequestProperty("Content-Length", "" + postData.getBytes().length);
    myURLConnection.setRequestProperty("Content-Language", "en-US");
}catch (Exception e){

}




    }
}
