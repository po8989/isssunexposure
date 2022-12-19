package isssunexposure_tests.business;

import io.quarkus.test.junit.QuarkusTest;
import isssunexposure.business.EclipseCalculatorService;
import isssunexposure.business.IEclipseCalculatorService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class EclipseCalculatorTests {

    private static IEclipseCalculatorService eclipseCalculatorService;

    @BeforeAll
    public static void TestInitialise(){
        eclipseCalculatorService = new EclipseCalculatorService();
    }

    @Test
    public void IssSunExposureService_IsInEclipse_WithSatelliteAlignedWithSunInFrontOfEarth_IsNotInEclipse() {
        // Arrange
        double satelliteAltitude = 429.6210856783;
        double degSatelliteLatitude = 0;
        double degSatelliteLongitude = 0;
        double degSunLatitude = 0;
        double degSunLongitude = 0;

        // Act
        boolean isInEclipse = eclipseCalculatorService.IsInEclipse(satelliteAltitude,
                                                                    degSatelliteLatitude,
                                                                    degSatelliteLongitude,
                                                                    degSunLatitude,
                                                                    degSunLongitude);

        // Assert
        assertFalse(isInEclipse);
    }

    @Test
    public void IssSunExposureService_IsInEclipse_WithSatelliteBehindTheEarth_IsInEclipse() {
        // Arrange
        double satelliteAltitude = 429.6210856783;
        double degSatelliteLatitude = 0;
        double degSatelliteLongitude = 180;
        double degSunLatitude = 0;
        double degSunLongitude = 0;

        // Act
        boolean isInEclipse = eclipseCalculatorService.IsInEclipse(satelliteAltitude,
                degSatelliteLatitude,
                degSatelliteLongitude,
                degSunLatitude,
                degSunLongitude);

        // Assert
        assertTrue(isInEclipse);
    }

    @Test
    public void IssSunExposureService_IsInEclipse_WithSatelliteInDayLight_IsNotInEclipse() {
        // Arrange
        double satelliteAltitude = 415.81996814307;
        double degSatelliteLatitude = 28.705623917749;
        double degSatelliteLongitude = 39.454277963515;
        double degSunLatitude = -23.392402292346;
        double degSunLongitude = 7.5443516634093;

        // Act
        boolean isInEclipse = eclipseCalculatorService.IsInEclipse(satelliteAltitude,
                degSatelliteLatitude,
                degSatelliteLongitude,
                degSunLatitude,
                degSunLongitude);

        // Assert
        assertFalse(isInEclipse);
    }

    @Test
    public void IssSunExposureService_IsInEclipse_WithSatelliteInEclipse_IsInEclipse() {
        // Arrange
        double satelliteAltitude = 420.3211505945;
        double degSatelliteLatitude = -1.4873669884541;
        double degSatelliteLongitude = -65.657357650765;
        double degSunLatitude = -23.357440017038;
        double degSunLongitude = 51.273518102379;

        // Act
        boolean isInEclipse = eclipseCalculatorService.IsInEclipse(satelliteAltitude,
                degSatelliteLatitude,
                degSatelliteLongitude,
                degSunLatitude,
                degSunLongitude);

        // Assert
        assertTrue(isInEclipse);
    }
}
