package com.example.lcoyl.localhackday.AzureCV;


import org.apache.http.client.utils.URIBuilder;

import java.io.File;


public class ObjectIdentifier extends Identifier {


    public ObjectIdentifier(File image) {
        super(image);
    }

    @Override
    protected URIBuilder addParamaters(URIBuilder builder){
        builder.setParameter("visualFeatures", "Categories,Description,Color");
        builder.setParameter("language", "en");
        return builder;
    }


    @Override
    protected String getEndPoint() {
        return super.endpoint+"analyze";        //url for object identifier
    }
}
