package com.example.lcoyl.localhackday.Types;

import org.json.JSONException;
import org.json.JSONObject;

public class ImageData {
    JSONObject textData;
    JSONObject objectData;
    public ImageData(JSONObject textData, JSONObject objectData) {
        this.textData = textData;
        this.objectData = objectData;
    }

    public JSONObject getObjectData() {
        return objectData;
    }

    public JSONObject getTextData() {
        return textData;
    }

    public String toSting(){
        try {
            JSONObject desc = objectData.getJSONObject("description").getJSONArray("captions").getJSONObject(0);
            String text = desc.getString("text");
            double confidence = desc.getDouble("confidence");
            text = text.replaceAll("hand","").replaceAll(" holding ", " ").replaceAll(" a "," ");
            return text;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }
}