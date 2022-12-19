package isssunexposure_tests.business;

import io.quarkus.test.junit.QuarkusTest;
import isssunexposure.business.IIssSatelliteService;
import isssunexposure.business.IIssSunExposureService;
import isssunexposure.business.IssSatelliteService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@QuarkusTest
public class IssSunExposureServiceTests {

    @Mock
    private static IIssSatelliteService satelliteServiceMock;

    private IIssSunExposureService issSunExposureService;

    @BeforeAll
    public static void TestInitialise(){
        satelliteServiceMock = new IssSatelliteService();
    }

    @Test
    public void IssSunExposureService_GetSunExposureWindowHistory_VerifySatelliteNotExisting_throwsException() throws Exception {
        // TODO Find a way to Mock dependencies
        // Arrange

        // Act

        // Assert
    }

    @Test
    public void IssSunExposureService_GetSunExposureWindowHistory_VerifySatelliteExisting_VerifyData() throws Exception {
        // TODO Find a way to Mock dependencies
        // Arrange
        /*var satellite = new Satellite();
        satellite.id = 25544;
        satellite.name ="iss";
        issSunExposureService = new IssSunExposureService();
        when(satelliteServiceMock.GetSatelliteById(any(int.class))).thenReturn(satellite);

        // Act
        String history = issSunExposureService.GetSunExposureWindowHistory(25544);

        // Assert
        assertNotNull(history);
        var sunExposureHistory = SunExposureHistoryParserHelper.ParseSunExposureHistoryAsObject(history);
        assertNotNull(sunExposureHistory);
        assertEquals(2544, sunExposureHistory.id);
        assertEquals("iss", sunExposureHistory.name);
        assertEquals(2, sunExposureHistory.windowsHistory.size());
        assertEquals(1671303834, sunExposureHistory.windowsHistory.get(0).StartTime);
        assertEquals(1671362784, sunExposureHistory.windowsHistory.get(0).EndTime);
        assertEquals(1671199197, sunExposureHistory.windowsHistory.get(1).StartTime);
        assertEquals(1671362773, sunExposureHistory.windowsHistory.get(1).EndTime);*/
    }
}
