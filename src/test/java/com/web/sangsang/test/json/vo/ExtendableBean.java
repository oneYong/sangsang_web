package com.web.sangsang.test.json.vo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WYKIM on 2017-01-20.
 */

public class ExtendableBean {
    public String name;
    private Map<String, String> properties;

    public ExtendableBean(String name){
        this.name = name;
        properties = new HashMap<>();
    }
    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    public void add(String key, String value){
        properties.put(key,value);
    }

}
