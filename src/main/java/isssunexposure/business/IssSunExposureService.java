package isssunexposure.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import isssunexposure.helpers.APIRequestHelper;
import isssunexposure.models.Satellite;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class IssSunExposureService implements IIssSunExposureService {

    private static final String HOSTISS = "https://api.wheretheiss.at";
    private static final String APIVERSION = "v1";
    private static final String APIPATH = "satellites";
    private static final String CONTENTTYPE = "application/json";

    /** Method to retrieve the sun exposure window history
     * @return success message
     */
    public String GetSunExposureWindowHistory(int satelliteId) throws Exception {
        // Get info from the satellite
        var satellite = GetCurrentSatelliteInfoById(satelliteId);

        return "ISSSatellite retrieved";
    }

    public Satellite GetCurrentSatelliteInfoById(int issId) throws Exception {

        // Format the url
        var issGetUrl = APIRequestHelper.GetUrl(HOSTISS, APIVERSION, APIPATH) + issId;
        // Call the API to retrieve the info of the ISS
        var issGetResponse = APIRequestHelper.SendGETRequest(issGetUrl, CONTENTTYPE);

        // Parse the response into a Satellite object
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(issGetResponse.body(), Satellite.class);
    }
}
