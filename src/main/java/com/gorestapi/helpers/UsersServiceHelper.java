package com.gorestapi.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.gorestapi.constants.Endpoints;
import com.gorestapi.model.Users;
import com.gorestapi.utils.ConfigManager;

import com.gorestapi.utils.TestDataGenerator;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;


import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersServiceHelper {

    private static final String BASE_URL = ConfigManager.getInstance().getString("API_BASE_URL");

    public UsersServiceHelper(){
    RestAssured.baseURI = BASE_URL;
    }
    private TestDataGenerator td = new TestDataGenerator();


    public List<Users> getAllUsers(String path){
        Response response = RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .get(path)
                .andReturn();

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        Type type = new TypeReference<List<Users>>(){}.getType();
        List<Users> userList = response.as(type);
        return userList;

    }

    public Response createUser(String path, String accessToken,boolean correctBody){
        Users users = new Users();
        users.setEmail("dk"+ td.generatTimeStamp() +"@gmai.com");
        users.setGender("male");
        users.setName("KL");

        if(correctBody) users.setStatus("active");


        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer "+accessToken);


        Response response = RestAssured.given()
                .headers(header)
                .contentType(ContentType.JSON)
                .basePath(path)
                .log().all().when()
                .body(users)
                .post().andReturn();


       return response;
    }
}
