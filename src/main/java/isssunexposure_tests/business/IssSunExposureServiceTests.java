package isssunexposure_tests.business;

import io.quarkus.test.junit.QuarkusTest;
import isssunexposure.business.IIssSunExposureService;
import isssunexposure.business.IssSunExposureService;
import isssunexposure.helpers.SatelliteParserHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class IssSunExposureServiceTests {

    private IIssSunExposureService issSunExposureService = new IssSunExposureService();

    @Test
    public void IssSunExposureService_GetSunExposureWindowHistory_VerifySatelliteRetrieved() throws Exception {
        // Arrange
        var satelliteId = 25544;

        // Act
        var iss = issSunExposureService.GetSunExposureWindowHistory(satelliteId);
        var satellite = SatelliteParserHelper.ParseSatelliteAsObject(iss);

        // Assert
        assertEquals(satelliteId, satellite.id);
        assertEquals("iss", satellite.name);
    }

    @Test
    public void IssSunExposureService_GetSunExposureWindowHistory_VerifySatelliteNotExisting_throwsException() {
        // Arrange
        var satelliteId = 999999;

        // Act
        try {
            var iss = issSunExposureService.GetSunExposureWindowHistory(satelliteId);

            // Assert
            Assertions.assertEquals("No satellite found", iss);
        }
        catch (Exception e){
        }
    }

    @Test
    public void IssSunExposureService_GetSunExposureWindowHistory_VerifySatelliteAddedToCache() {
        // Arrange

        // Act

        // Assert
    }

    @Test
    public void IssSunExposureService_GetSunExposureWindowHistory_WithAPIDown_GetSatelliteFromCache() {
        // Arrange

        // Act

        // Assert
    }
}
