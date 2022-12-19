package isssunexposure_tests.api;

import io.quarkus.test.junit.QuarkusTest;
import isssunexposure.api.gateways.IssSunExposureAPI;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class IssSunExposureAPITests {

    private static IssSunExposureAPI issSunExposureAPI;

    @BeforeAll
    public static void TestInitialise(){
        issSunExposureAPI = new IssSunExposureAPI();
    }

    @Test
    public void IssSunExposure_GetISSSunExposureWindowHistory_WithNoExceptionThrown_Return200Response(){

        // Arrange

        // Act
        var response = given()
                        .when()
                        .get("/iss");

        // Assert
        response.then()
                .statusCode(200)
                .body(is("{\"id\":25544,\"name\":\"iss\",\"windowsHistory\":[{\"StartTime\":1671303834,\"EndTime\":1671362784},{\"StartTime\":1671199197,\"EndTime\":1671362773}]}"));
    }

    @Test
    public void IssSunExposure_GetISSSunExposureWindowHistory_WithExceptionThrown_Return404ResponseWithNotValidMessage(){
        // TODO SunExposureService throws exception
        // Arrange

        // Act

        // Assert
        // TODO Verify log entry
    }

    @Test
    public void IssSunExposure_GetISSSunExposureWindowHistory_CallSunExposureService(){
        // TODO Check if the SunExposureService is called once
        // Arrange

        // Act

        // Assert
    }

    @Test
    public void IssSunExposure_Verify_CallSunExposureService(){
        // TODO Check if the SunExposureService is called once
        // Arrange

        // Act

        // Assert
    }
}
