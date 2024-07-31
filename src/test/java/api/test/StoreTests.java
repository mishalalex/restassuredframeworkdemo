package api.test;

import api.endpoints.StoreEndPoints;
import api.payload.Order;
import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class StoreTests {
    Faker faker;
    Order orderPayload;
    public Logger logger;

    @BeforeClass
    public void setupData() {
        faker = new Faker();
        orderPayload = new Order();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String fakeDate = dateFormat.format(faker.date().past(1, java.util.concurrent.TimeUnit.DAYS));

        orderPayload.setId(faker.idNumber().hashCode());
        orderPayload.setPetId(faker.idNumber().hashCode());
        orderPayload.setQuantity(faker.number().numberBetween(1, 5));
        orderPayload.setShipDate(fakeDate);
        orderPayload.setStatus("placed");
        orderPayload.setComplete(true);

        logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1)
    public void testPostOrder(){
        logger.info("**************** Placing a new order ****************");
        Response response = StoreEndPoints.placeAnOrder(orderPayload);
        response.then().log().status();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("**************** Order placed successfully ****************");
    }

    @Test(priority = 2)
    public void testReadOrder(){
        logger.info("**************** Retrieving the newly placed order ****************");
        Response response = StoreEndPoints.readAnOrder(orderPayload.getId());
        response.then().log().status();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("**************** Order retrieved successfully ****************");
    }

    @Test(priority = 3)
    public void testDeleteOrder(){
        logger.info("**************** Delete the order ****************");
        Response response = StoreEndPoints.deleteAnOrder(orderPayload.getId());
        response.then().log().status();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("**************** Order deleted successfully ****************");
    }

    @Test(priority = 4)
    public void testReadInventories(){
        logger.info("**************** Retrieve all items in the inventory ****************");
        Response response = StoreEndPoints.getAllInventories();
        response.then().log().status();
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("**************** Inventory items retrieved successfully ****************");
    }
}
