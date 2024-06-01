package com.elaa.fancode;

import com.aventstack.extentreports.ExtentTest;
import com.elaa.fancode.common.GetMethod;
import com.elaa.fancode.report.*;
import com.elaa.fancode.request.GetRequest;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {
    private ExtentTest test;
    private List<Integer> userIds;

    @BeforeClass
    public void setUpClass() {
        ReportUtils.initReport();
        
    }

    @Test(priority = 1)
    public void VerifyUsersAPI() {
    	test = ReportUtils.createTest("Verify users' Response and Status Code");
    	int statusCode = GetMethod.ResponseStatusCode(GetRequest.BaseURI(),
				GetRequest.ResourceUsers());
		Response responseBody = GetMethod.ResponseBody(GetRequest.BaseURI(),
				GetRequest.ResourceUsers());
        test.info("Status Code: " + statusCode);
        test.info("Response Body is : \n <code>" + responseBody.asPrettyString()+ "</code>");
    }
    @Test(priority = 2)
    public void VerifyTodoAPI() {
    	test = ReportUtils.createTest("Verify Todo' Response and Status Code");
    	int statusCode = GetMethod.ResponseStatusCode(GetRequest.BaseURI(),
				GetRequest.ResourceTodo());
    	Response responseBody = GetMethod.ResponseBody(GetRequest.BaseURI(),
				GetRequest.ResourceTodo());
        test.info("Status Code: " + statusCode);
        test.info("Response Body is : \n <code>" + responseBody.asPrettyString() + "</code>");
    }
    @Test(priority = 3)
    public void fetchUsersFromFanCodeCity() {
    	test = ReportUtils.createTest("Fancode City can be identified by lat between ( -40 to 5) and long between ( 5 to 100) in users api");
    	Response responseBody = GetMethod.ResponseBody(GetRequest.BaseURI(),
				GetRequest.ResourceUsers());
    	List<Integer> userIds = responseBody.jsonPath().getList("findAll { user -> " +
                "def lat = Float.parseFloat(user.address.geo.lat); " +
                "def lng = Float.parseFloat(user.address.geo.lng); " +
                "lat >= -40 && lat <= 5 && lng >= 5 && lng <= 100 }.id");

        this.userIds = userIds;
        test.info("Fetched users from FanCode city: " + userIds);
        Assert.assertFalse(userIds.isEmpty(), "No users found in FanCode city");
    }
    @Test(priority = 4)
    public void VerifyPostsAPI() {
    	test = ReportUtils.createTest("Verify Post' Response and Status Code");
    	int statusCode = GetMethod.ResponseStatusCode(GetRequest.BaseURI(),
				GetRequest.ResourcePosts());
    	Response responseBody = GetMethod.ResponseBody(GetRequest.BaseURI(),
				GetRequest.ResourcePosts());
        test.info("Status Code: " + statusCode);
        test.info("Response Body is : \n <code>" + responseBody.asPrettyString() + "</code>");
    }
    @Test(priority = 5)
    public void VerifyCommentsAPI() {
    	test = ReportUtils.createTest("Verify Comments' Response and Status Code");
    	int statusCode = GetMethod.ResponseStatusCode(GetRequest.BaseURI(),
				GetRequest.ResourceComments());
    	Response responseBody = GetMethod.ResponseBody(GetRequest.BaseURI(),
				GetRequest.ResourceComments());
        test.info("Status Code: " + statusCode);
        test.info("Response Body is : \n <code>" + responseBody.asPrettyString() + "</code>");
    }
    @Test(priority = 6)
    public void VerifyPhotosAPI() {
    	test = ReportUtils.createTest("Verify Photos' Response and Status Code");
    	int statusCode = GetMethod.ResponseStatusCode(GetRequest.BaseURI(),
				GetRequest.ResourcePhotos());
    	Response responseBody = GetMethod.ResponseBody(GetRequest.BaseURI(),
				GetRequest.ResourcePhotos());
        test.info("Status Code: " + statusCode);
        test.info("Response Body is : \n <code>" + responseBody.asPrettyString() + "</code>");
    }
    @Test(priority = 7)
    public void verifyTodosCompletionPercentage() {
    	test = ReportUtils.createTest("Verify users' todos completion percentage1");
    	Response responseBody = GetMethod.ResponseBody(GetRequest.BaseURI(),
				GetRequest.ResourceTodo());
    	List<Integer> usersWithIncompleteTodos = userIds.stream()
                .filter(userId -> {
                    List<Boolean> todos = responseBody.jsonPath().getList("findAll { todo -> todo.userId == " + userId + " }.completed");
                    long completedCount = todos.stream().filter(completed -> completed).count();
                    return completedCount <= todos.size() / 2;
                })
                .collect(Collectors.toList());

        test.info("Users with incomplete todos: " + usersWithIncompleteTodos);
        Assert.assertTrue(usersWithIncompleteTodos.isEmpty(), "Some users have not completed more than 50% of their todos");
    }
    

    @AfterClass
    public void tearDownClass() {
        ReportUtils.flushReport();
    }
}
