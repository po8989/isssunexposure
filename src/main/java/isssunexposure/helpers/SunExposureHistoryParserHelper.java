package isssunexposure.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import isssunexposure.models.SunExposureHistoryList;

public class SunExposureHistoryParserHelper {

    /** Method helper to parse a list of Sun exposure objects as JSON string
     * @return The list of the sun exposure history as a JSON
     * @param historyList list of Sun exposure as an object
     */
    public static String ParseSunExposureHistoryAsString(SunExposureHistoryList historyList) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(historyList);
    }
}
