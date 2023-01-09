package com.gorest;

import com.gorestapi.constants.Endpoints;
import com.gorestapi.helpers.UsersServiceHelper;
import com.gorestapi.model.Users;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class GetUsersTest {

    private UsersServiceHelper usersServiceHelper;

    @BeforeClass
    public void init(){
        usersServiceHelper = new UsersServiceHelper();
    }

    @Test
    public void getAllUsers(){
        List<Users> usersList = usersServiceHelper.getAllUsers(Endpoints.GET_ALL_USERS);
        Assert.assertNotNull(usersList,"User list is null");
        Assert.assertFalse(usersList.isEmpty(), "User list is empty");
    }

}
