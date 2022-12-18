package isssunexposure.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import isssunexposure.helpers.APIRequestHelper;
import isssunexposure.models.Satellite;

import javax.enterprise.context.ApplicationScoped;


public interface IIssSunExposureService {

    public String GetSunExposureWindowHistory() throws Exception;
}
