package api.endpoints;

import api.payload.Order;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class StoreEndPoints {
    static ResourceBundle getURL(){
        // load the routes.properties file
        return ResourceBundle.getBundle("routes");
    }

    public static Response placeAnOrder(Order payload){
        String place_order_url = getURL().getString("place_order_url");
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(place_order_url);
    }

    public static Response readAnOrder(int order_id){
        String get_order_url = getURL().getString("get_order_url");
        return given()
                .pathParams("order_id",order_id)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(get_order_url);
    }

    public static Response deleteAnOrder(int order_id){
        String delete_order_url = getURL().getString("delete_order_url");
        return given()
                .pathParams("order_id",order_id)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .delete(delete_order_url);
    }

    public static Response getAllInventories(){
        String get_inventories_url = getURL().getString("get_inventories_url");
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(get_inventories_url);
    }
}
