package isssunexposure.business;

public interface IEclipseCalculatorService {

    boolean IsInEclipse(double satelliteAltitude,
                     double degSatelliteLatitude,
                     double degSatelliteLongitude,
                     double degSunLatitude,
                     double degSunLongitude);
}
