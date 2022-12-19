package isssunexposure_tests.business;

import io.quarkus.test.junit.QuarkusTest;
import isssunexposure.business.IIssSatelliteService;
import isssunexposure.business.IssSatelliteService;
import isssunexposure.models.Satellite;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@QuarkusTest
public class IssSatelliteServiceTests {

    private static IIssSatelliteService issSatelliteService;

    @BeforeAll
    public static void TestInitialise()
    {
        issSatelliteService = new IssSatelliteService();
    }

    @Test
    public void IssSunExposureService_GetSatelliteById_VerifySatelliteRetrieved() throws Exception {
        // Arrange
        var satelliteId = 25544;

        // Act
        var iss = issSatelliteService.GetSatelliteById(satelliteId);

        // Assert
        assertEquals(satelliteId, iss.id);
        assertEquals("iss", iss.name);
    }

    @Test
    public void IssSunExposureService_GetSunExposureWindowHistory_VerifySatelliteNotExisting() throws Exception {
        // Arrange
        var satelliteId = 999999;

        // Act
        Satellite iss = issSatelliteService.GetSatelliteById(satelliteId);
        // TODO Find a way to assert equals null
        // Assert
        assertNull(iss);
    }

    @Test
    public void IssSunExposureService_GetSatelliteById_VerifySatelliteAddedToCache() {
        // TODO Find a way to expose private methods
        // Arrange

        // Act

        // Assert
    }

    @Test
    public void IssSunExposureService_GetSatelliteById_WithAPIDown_GetSatelliteFromCache() {
        // TODO Find a way to expose private methods
        // Arrange

        // Act

        // Assert
    }

    @Test
    public void IssSunExposureService_GetSatelliteById_WithACallDoneLessThan20SecondsAgo_DoNotCallISSAPI() {
        // TODO Find a way to expose private methods
        // Arrange

        // Act

        // Assert
    }

    @Test
    public void IssSunExposureService_GetSatelliteById_WithACallDoneMoreThan20SecondsAgo_CallISSAPI() {
        // TODO Find a way to expose private methods
        // Arrange

        // Act

        // Assert
    }
}
