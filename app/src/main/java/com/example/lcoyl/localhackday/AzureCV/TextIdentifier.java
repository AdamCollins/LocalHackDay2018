package com.example.lcoyl.localhackday.AzureCV;

import org.apache.http.client.utils.URIBuilder;

import java.io.File;

public class TextIdentifier  extends Identifier {


    public TextIdentifier(File image) {
        super(image);
    }

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
