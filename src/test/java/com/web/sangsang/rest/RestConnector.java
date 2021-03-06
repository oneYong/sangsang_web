package com.web.sangsang.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.web.sangsang.cmm.entity.SsPlace;
import com.web.sangsang.cmm.entity.annotation.Table;
import com.web.sangsang.cmm.entity.PageEntity;
import com.web.sangsang.cmm.entity.SsUser;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okio.Buffer;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.Date;
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
                        List resultList = (List) response.body();
                        ObjectMapper mapper = new ObjectMapper();
                        Object resultObj = mapper.convertValue(resultList,  TypeFactory.defaultInstance().constructCollectionType(List.class, convertClass));
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
        final String token = "xxx";
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder().header("x-auth-token", token).build();
                return chain.proceed(request);
            }
        });
        OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(REST_HOST)
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .client(client)
                .build();
        RestService service = retrofit.create(RestService.class);
        return service;
    }

    public SsUser getUser(String source, String sourceId) {
        RestService service = getService();
        Call<SsUser> result = service.findUser(source,sourceId);
        SsUser object = getBody(result);
        return object;

    }

    public SsPlace getMuseum(Long id) {
        RestService service = getService();
        Call<Object> result = service.find(SsPlace.class.getAnnotation(Table.class).name(), id);
        SsPlace object = getBody(result,SsPlace.class);
        return object;
    }

    public List<SsPlace> getMuseum(String 공주) {
        RestService service = getService();
        PageEntity entity = new PageEntity();
        entity.setWhereClause(" name like '%" + 공주 + "%' ");
        //entity.setStart(0);
        //entity.setEnd(10);
        Call<List<Object>> result = service.list(SsPlace.class.getAnnotation(Table.class).name(), entity);
        List<SsPlace> object = getBody(result,SsPlace.class);
        return object;
    }

    public SsUser updateUser(SsUser obj) {
        RestService service = getService();
        // update ...
        obj.setLastTime(new Date());
        obj.setLeaveTime(new Date());
        obj.setName("야야양");
        Call<SsUser> result = service.updateUser(obj);
        SsUser object = getBody(result);
        return object;
    }
}
