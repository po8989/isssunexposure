package isssunexposure.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import isssunexposure.models.Satellite;

public class SatelliteParserHelper {

    /** Method helper to parse a satellite object as a JSON string
     * @return The satellite as a JSON
     * @param satellite The satellite as a JSON
     */
    public static Satellite ParseSatelliteAsObject(String satellite) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(satellite, Satellite.class);
    }
}
