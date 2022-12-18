package isssunexposure.business;

import com.google.gson.Gson;
import isssunexposure.helpers.APIRequestHelper;
import isssunexposure.helpers.SatelliteParserHelper;
import isssunexposure.models.Satellite;

import javax.enterprise.context.ApplicationScoped;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class IssSunExposureService implements IIssSunExposureService {

    private static final String HOSTISS = "https://api.wheretheiss.at";
    private static final String APIVERSION = "v1";
    private static final String APIPATH = "satellites";
    private static final String CONTENTTYPE = "application/json";
    private static final String ISSCACHEKEY = "ISS";

    Map<String,String> cacheHashMap = new ConcurrentHashMap<String, String>();

    /** Method to retrieve the sun exposure window history
     * @return success message
     */
    public String GetSunExposureWindowHistory(int satelliteId) throws Exception {
        String satelliteValue = null;
        try {
            var issGetResponse = GetCurrentSatelliteInfoById(satelliteId);
            if (issGetResponse.statusCode() == 200) {
                satelliteValue = issGetResponse.body();
            }
        }
        catch(Exception e){
            if (cacheHashMap.containsKey(ISSCACHEKEY)) {
                satelliteValue = cacheHashMap.get(ISSCACHEKEY);
            }
        }

        if (satelliteValue != null) {
            Satellite satellite = SatelliteParserHelper.ParseSatelliteAsObject(satelliteValue);
            if (!cacheHashMap.containsKey(ISSCACHEKEY)) {
                cacheHashMap.put(ISSCACHEKEY, SatelliteParserHelper.ParseSatelliteAsString(satellite));
            }

            return new Gson().toJson(satellite);
        }

        return "No satellite found";
    }

    private HttpResponse<String> GetCurrentSatelliteInfoById(int issId) throws Exception {

        // Format the url
        var issGetUrl = APIRequestHelper.GetUrl(HOSTISS, APIVERSION, APIPATH) + issId;
        // Call the API to retrieve the info of the ISS
        return APIRequestHelper.SendGETRequest(issGetUrl, CONTENTTYPE);
    }
}
