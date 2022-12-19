package isssunexposure.business;

import isssunexposure.models.Satellite;

public interface IIssSatelliteService {

    public Satellite GetSatelliteById(int id) throws Exception;

}
