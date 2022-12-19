package isssunexposure.business;

import isssunexposure.helpers.SunExposureHistoryParserHelper;
import isssunexposure.models.Satellite;
import isssunexposure.models.SunExposureHistory;
import isssunexposure.models.SunExposureHistoryList;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.logging.Logger;

@ApplicationScoped
public class IssSunExposureService implements IIssSunExposureService {

    private static final String HOST_ISS = "https://api.wheretheiss.at";
    private static final String API_VERSION = "v1";
    private static final String API_PATH = "satellites";
    private static final String CONTENT_TYPE = "application/json";

    Logger logger = Logger.getLogger(IssSunExposureService.class.getName());

    @Inject
    private IIssSatelliteService issSatelliteService;

    /** Method to retrieve the sun exposure windows History
     * @return The satellite json as a String
     * @param satelliteId The satellite id
     */
    public String GetSunExposureWindowHistory(int satelliteId) throws Exception{
        var satellite = issSatelliteService.GetSatelliteById(satelliteId);

        // Verify that the satellite is exposed to the sun
        if (satellite != null){

        }

        SunExposureHistoryList hardcodedHistoryList = getDummySunExposureHistoryList(satellite);

        // Return the list of windowsHistory as a JSON string
        return SunExposureHistoryParserHelper.ParseSunExposureHistoryAsString(hardcodedHistoryList);
    }

    /** Method to retrieve the hardcoded list of sun exposure history
     * @return The list of the sun exposure history
     */
    private static SunExposureHistoryList getDummySunExposureHistoryList(Satellite satellite) {
        // TODO POB Remove Hardcoded values and retrieve windowsHistory
        // Return hardcoded values
        var hardcodedHistoryList = new SunExposureHistoryList();
        var sunExposureHistoryNovember = new SunExposureHistory();
        sunExposureHistoryNovember.StartTime = 1671303834;
        sunExposureHistoryNovember.EndTime = 1671362784;
        var sunExposureHistoryDecember = new SunExposureHistory();
        sunExposureHistoryDecember.StartTime = 1671199197;
        sunExposureHistoryDecember.EndTime = 1671362773;
        hardcodedHistoryList.windowsHistory.add(sunExposureHistoryNovember);
        hardcodedHistoryList.windowsHistory.add(sunExposureHistoryDecember);
        return hardcodedHistoryList;
    }
}
