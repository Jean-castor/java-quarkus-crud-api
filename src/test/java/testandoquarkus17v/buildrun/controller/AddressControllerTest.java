package testandoquarkus17v.buildrun.controller;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class AddressControllerTest {

    @Test
    public void testGetAddressEndpoint(){
        given()
                .when().get("/address")
                .then()
                .statusCode(200).contentType(ContentType.JSON).body("size()", greaterThanOrEqualTo(0));
    }
}