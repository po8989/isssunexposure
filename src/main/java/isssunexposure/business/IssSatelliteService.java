package isssunexposure.business;

import isssunexposure.helpers.APIRequestHelper;
import isssunexposure.helpers.SatelliteParserHelper;
import isssunexposure.models.Satellite;

import javax.enterprise.context.ApplicationScoped;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class IssSatelliteService implements IIssSatelliteService {

    private static final String HOST_ISS = "https://api.wheretheiss.at";
    private static final String API_VERSION = "v1";
    private static final String API_PATH = "satellites";
    private static final String CONTENT_TYPE = "application/json";
    private static final String ISS_CACHE_KEY = "ISS";

    /* Use to restrict the access of the ISS API every 20 seconds */
    private long _lastCallInSeconds;

    Logger logger = Logger.getLogger(IssSatelliteService.class.getName());

    private Map<String,String> cacheHashMap = new ConcurrentHashMap<String, String>();

    /** Method to retrieve the satellite
     * @return The satellite json as an object Satellite
     * @param satelliteId The satellite id
     */
    public Satellite GetSatelliteById(int satelliteId) throws Exception{
        // Call the method to retrieve the satellite JSON as a string
        String satelliteJSON = GetSatelliteJSON(satelliteId);

        if (satelliteJSON != null){
            // Store the new value in the cache
            if (!cacheHashMap.containsKey(ISS_CACHE_KEY)) {
                cacheHashMap.put(ISS_CACHE_KEY, satelliteJSON);
            }
            return SatelliteParserHelper.ParseSatelliteAsObject(satelliteJSON);
        }

        // Return the satellite cached if exists
        if (cacheHashMap.containsKey(ISS_CACHE_KEY))
            return SatelliteParserHelper.ParseSatelliteAsObject(cacheHashMap.get(ISS_CACHE_KEY));
        return null;
    }

    /** Method to retrieve the satellite JSON
     * @return The response of the call to the API
     * @param satelliteId The id of the ISS
     */
    private String GetSatelliteJSON(int satelliteId) {
        try {
            // Get current time in seconds
            var currentDate = new Date();
            var currentDateInSeconds = currentDate.getTime() / 1000;
            // Restrict to call the API every 20 seconds only
            if (_lastCallInSeconds + 20 < currentDateInSeconds)
            {
                // Call the ISS API to retrieve info
                var issGetResponse = GetCurrentSatelliteInfoById(satelliteId);
                if (issGetResponse.statusCode() == 200) {
                    _lastCallInSeconds = currentDate.getTime() / 1000;
                    return issGetResponse.body();
                }
            }
        }
        catch(Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            // In case of failure get the satellite stored in the cache
            if (cacheHashMap.containsKey(ISS_CACHE_KEY)) {
                return cacheHashMap.get(ISS_CACHE_KEY);
            }
        }
        return null;
    }

    /** Method to retrieve the satellite
     * @return The response of the call to the API
     * @param issId The id of the ISS
     */
    private HttpResponse<String> GetCurrentSatelliteInfoById(int issId) throws Exception {
        // Format the url
        var issGetUrl = APIRequestHelper.GetUrl(HOST_ISS, API_VERSION, API_PATH) + issId;
        // Call the API to retrieve the info of the ISS
        return APIRequestHelper.SendGETRequest(issGetUrl, CONTENT_TYPE);
    }
}
