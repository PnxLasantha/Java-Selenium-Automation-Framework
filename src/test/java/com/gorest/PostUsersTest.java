package com.gorest;

import com.gorestapi.constants.Endpoints;
import com.gorestapi.helpers.UsersServiceHelper;
import com.testUtil.ConfigManager;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PostUsersTest {
    private UsersServiceHelper usersServiceHelper;
    private static final String token  = ConfigManager.getInstance().getString("API_TOKEN");
    @BeforeClass
    public void init(){
        usersServiceHelper = new UsersServiceHelper();
    }


    @Test
    public void test_Post_CreateUser(){
      Response res =  usersServiceHelper.createUser(Endpoints.CREATE_USER,token,true);
        Assert.assertEquals(res.getStatusCode(), HttpStatus.SC_CREATED);
        Assert.assertNotNull(res.jsonPath().get("id"));

    }
    @Test
    public void test_Post_CreateUser_wrongBody(){
        Response res =  usersServiceHelper.createUser(Endpoints.CREATE_USER,token,false);
        Assert.assertEquals(res.getStatusCode(), HttpStatus.SC_UNPROCESSABLE_ENTITY);

    }

    @Test
    public void test_Post_CreateUser_InvalidToken(){
        Response res =  usersServiceHelper.createUser(Endpoints.CREATE_USER,"token",true);
        Assert.assertEquals(res.getStatusCode(), HttpStatus.SC_UNAUTHORIZED);

    }
    @Test
    public void test_Post_CreateUser_InvalidEndPoint(){
        Response res =  usersServiceHelper.createUser("/userr",token,true);
        Assert.assertEquals(res.getStatusCode(), HttpStatus.SC_NOT_FOUND);

    }
}
