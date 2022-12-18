package isssunexposure.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import isssunexposure.models.Satellite;

public class SatelliteParserHelper {
    public static String ParseSatelliteAsString(Satellite satellite) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(satellite);
    }

    public static Satellite ParseSatelliteAsObject(String satellite) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(satellite, Satellite.class);
    }
}
