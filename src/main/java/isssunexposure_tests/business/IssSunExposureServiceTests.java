package isssunexposure_tests.business;

import io.quarkus.test.junit.QuarkusTest;
import isssunexposure.api.IssSunExposure;
import isssunexposure.business.IIssSunExposureService;
import isssunexposure.business.IssSunExposureService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class IssSunExposureServiceTests {

    private IIssSunExposureService issSunExposureService = new IssSunExposureService();

    @Test
    public void IssSunExposureService_GetCurrentSatelliteInfoById_VerifySatelliteRetrieved() throws Exception {
        // Arrange
        var satelliteId = 25544;

        // Act
            var iss = issSunExposureService.GetCurrentSatelliteInfoById(satelliteId);

        // Assert
        assertEquals(satelliteId, iss.id);
        assertEquals("iss", iss.name);
    }

    @Test
    public void IssSunExposureService_GetCurrentSatelliteInfoById_VerifySatelliteNotExisting_throwsException() {
        // Arrange
        var satelliteId = 24444;

        // Act
        try {
            var iss = issSunExposureService.GetCurrentSatelliteInfoById(satelliteId);
        }
        catch (Exception e){
            // Assert
            assertEquals("satellite not found", e.getMessage());
        }
    }
}
