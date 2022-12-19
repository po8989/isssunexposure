package isssunexposure.api.gateways;

import isssunexposure.business.IIssSunExposureService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/iss")
public class IssSunExposureAPI {

    Logger logger = Logger.getLogger(IssSunExposureAPI.class.getName());
    @Inject
    private IIssSunExposureService issSunExposureService;

    /** Method of the API to retrieve the SunExposureHistory
     * @return The Sun exposure history as a JSON
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String GetISSSunExposureWindowHistory() throws Exception {
            try {
                int issId = 25544;
                return issSunExposureService.GetSunExposureWindowHistory(issId);
            }
            catch(Exception e){
                // Log the info
                logger.log(Level.SEVERE, e.getMessage());
                throw new Exception("The request is not valid");
            }
    }
}