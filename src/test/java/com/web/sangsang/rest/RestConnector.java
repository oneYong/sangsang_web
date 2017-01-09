package com.web.sangsang.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.sangsang.cmm.entity.annotation.Table;
import com.web.sangsang.cmm.entity.BaseEntity;
import com.web.sangsang.cmm.entity.PageEntity;
import com.web.sangsang.cmm.entity.SsMuseum;
import com.web.sangsang.cmm.entity.SsUser;
import okio.Buffer;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class RestConnector {


    private static final String REST_HOST = "http://localhost:8077/";


    private <T> T getBody(Call<?> result) {
        return getBody(result, null);
    }
    private <T> T getBody(Call<?> result,Class convertClass) {
        try {
            Response<?> response = result.execute();
            System.out.println("================================================================================");
            if(result.request().body() != null){
                final Buffer buffer = new Buffer();
                result.request().body().writeTo(buffer);
                System.out.println("REQUEST BODY : " + buffer.readUtf8());
            }
            System.out.println("REQUEST URL : " + result.request().url());
            if (response.isSuccessful()) {
                System.out.println("RESPONSE ROW: " + response.raw());
                Object body = response.body();
                if(convertClass == null){
                    return (T)body;
                }else{
                    if(body instanceof Map){
                        Map resultMap = (Map) response.body();
                        ObjectMapper mapper = new ObjectMapper();
                        Object resultObj = mapper.convertValue(resultMap, convertClass);
                        return (T)resultObj;
                    }else if(body instanceof List){
                        List resultMap = (List) response.body();
                        ObjectMapper mapper = new ObjectMapper();
                        Object resultObj = mapper.convertValue(resultMap, convertClass);
                        return (T)resultObj;
                    }else{
                        return null;
                    }
                }
            } else {
                // 400 이상     오류
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public RestService getService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(REST_HOST).addConverterFactory(GsonConverterFactory.create()).build();
        RestService service = retrofit.create(RestService.class);
        return service;
    }

    public SsUser getUser(String source, String sourceId) {
        RestService service = getService();
        Call<SsUser> result = service.findUser(source,sourceId);
        SsUser object = getBody(result);
        return object;

    }

    public SsMuseum getMuseum(Long id) {
        RestService service = getService();
        Call<Object> result = service.find(SsMuseum.class.getAnnotation(Table.class).name(), id);
        SsMuseum object = getBody(result,SsMuseum.class);
        return object;
    }

    public List<SsMuseum> getMuseum(String 공주) {
        RestService service = getService();
        PageEntity entity = new PageEntity();
        entity.setWhereClause(" name like '" + 공주 + "' ");
        entity.setStart(0);
        entity.setEnd(10);
        Call<List<Object>> result = service.list(SsMuseum.class.getAnnotation(Table.class).name(), entity);
        List<SsMuseum> object = getBody(result,SsMuseum.class);
        return object;
    }
}
