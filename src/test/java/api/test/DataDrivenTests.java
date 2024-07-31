package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataDrivenTests {

    public Logger logger;
    @BeforeClass
    public void setup(){
        logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void testPostUser(String userId, String userName, String firstName, String lastName, String email, String password, String phone){
        logger.info("**************** Creating new user from excel test data ****************");
        User userPayload = new User();
        userPayload.setId(Integer.parseInt(userId));
        userPayload.setUsername(userName);
        userPayload.setFirstName(firstName);
        userPayload.setLastName(lastName);
        userPayload.setEmail(email);
        userPayload.setPassword(password);
        userPayload.setPhoneNumber(phone);

        Response response = UserEndPoints.createUser(userPayload);
        //System.out.println(response.body());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("**************** Created a new user from excel test data ****************");
    }

    @Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
    public void testDeleteUserByUsername(String username){
        logger.info("**************** Deleting the user created from test data ****************");
        Response response = UserEndPoints.deleteUser(username);
        //System.out.println(response.body());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("**************** Deleted the user created from test data ****************");
    }
}
