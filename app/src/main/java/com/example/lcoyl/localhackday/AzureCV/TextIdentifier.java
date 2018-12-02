package com.example.lcoyl.localhackday.AzureCV;

import org.apache.http.client.utils.URIBuilder;

public class TextIdentifier  extends Identifier {



    @Override
    protected String getEndPoint() {
        return super.endpoint+"ocr"; //url for text identifier
    }

    @Override
    protected URIBuilder addParamaters(URIBuilder builder) {
        builder.setParameter("language", "unk");
        builder.setParameter("detectOrientation", "true");
        return builder;
    }
}
