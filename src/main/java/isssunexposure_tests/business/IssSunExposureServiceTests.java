package isssunexposure_tests.business;

import io.quarkus.test.junit.QuarkusTest;
import isssunexposure.business.IIssSunExposureService;
import isssunexposure.business.IssSunExposureService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class IssSunExposureServiceTests {

    private IIssSunExposureService issSunExposureService = new IssSunExposureService();

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
}
