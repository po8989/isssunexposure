package isssunexposure_tests.business;

import io.quarkus.test.junit.QuarkusTest;
import isssunexposure.business.IIssSunExposureService;
import isssunexposure.business.IssSunExposureService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class IssSunExposureServiceTests {

    private static IIssSunExposureService issSunExposureService;

    @BeforeAll
    public static void TestInitialise(){
        issSunExposureService = new IssSunExposureService();
    }

    @Test
    public void IssSunExposureService_GetSunExposureWindowHistory_VerifySatelliteNotExisting_throwsException() throws Exception {
        // TODO Find a way to Mock dependencies
        // Arrange

        // Act

        // Assert
    }
}
