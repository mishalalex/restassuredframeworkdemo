package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class UserTests {
    Faker faker;
    User userPayload;
    public Logger logger;

    @BeforeClass
    public void setup(){
        faker = new Faker();
        userPayload = new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());
        userPayload.setPassword(faker.internet().password());
        userPayload.setPhoneNumber(faker.phoneNumber().phoneNumber());

        logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1)
    public void testCreateNewUser(){
        logger.info("**************** Creating new user ****************");
        Response response = UserEndPoints.createUser(userPayload);
        response.then().log().status();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("**************** Successfully created new user ****************");
    }

    @Test(priority = 2)
    public void testGetUserByName(){
        logger.info("**************** Reading user details ****************");
        Response response = UserEndPoints.readUser(userPayload.getUsername());
        response.then().log().status();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("**************** Successfully read user details ****************");
    }

    @Test(priority = 3)
    public void testUpdateUserByUsername(){
        logger.info("**************** Updating user information ****************");
        userPayload.setPassword(faker.internet().password());
        userPayload.setPhoneNumber(faker.phoneNumber().phoneNumber());

        Response response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
        response.then().log().status();

        Assert.assertEquals(response.getStatusCode(), 200);

        Response responseAfterUpdateOperation = UserEndPoints.readUser(this.userPayload.getUsername());
        Assert.assertEquals(responseAfterUpdateOperation.getStatusCode(), 200);
        logger.info("**************** Successfully updated the user information ****************");
    }

    @Test(priority = 4)
    public void testDeleteUserByUsername(){
        logger.info("**************** Deleting the user by username ****************");
        Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
        response.then().log().status();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("**************** Successfully deleted the user ****************");
    }
}
