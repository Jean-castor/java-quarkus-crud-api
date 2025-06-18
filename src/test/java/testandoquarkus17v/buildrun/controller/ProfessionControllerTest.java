package testandoquarkus17v.buildrun.controller;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

@QuarkusTest
public class ProfessionControllerTest {

    @Test
    public void testGetProfessionEndpoint(){
        given()
        .when().get("/profession")
          .then()
             .statusCode(200).contentType(ContentType.JSON).body("size()", greaterThanOrEqualTo(0));
    }
}
