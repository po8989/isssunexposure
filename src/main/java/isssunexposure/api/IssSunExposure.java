package isssunexposure.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/iss")
public class IssSunExposure {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String GetHistory() {
        return "Test";
    }
}