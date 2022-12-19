package isssunexposure.business;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EclipseCalculatorService implements IEclipseCalculatorService {
    private static final double DISTANCE_EARTH_SUN = 149597670.7;
    private static final double EARTH_RADIUS = 6371;
    private static final double CRITICAL_ECLIPSE_ANGLE = Math.atan((EARTH_RADIUS) / DISTANCE_EARTH_SUN);

    /**Method to verify that the satellite is in the shadow of the earth based on sun position
     * @param satelliteAltitude The altitude of the satellite
     * @param degSatelliteLatitude The latitude of the satellite in degrees
     * @param degSatelliteLongitude The longitude of the satellite in degrees
     * @param degSunLatitude The Latitude of the sun in degrees
     * @param degSunLongitude The longitude of the sun in degrees
     * @return If is in eclipse or not
     * @implNote see documentation : <a href="https://en.wikipedia.org/wiki/Spherical_coordinate_system">Spherical coordinate system Wikipedia</a>
     */
    public boolean IsInEclipse(double satelliteAltitude,
                     double degSatelliteLatitude,
                     double degSatelliteLongitude,
                     double degSunLatitude,
                     double degSunLongitude) {
        // Convert degrees to radians
        double radSunLatitude = Math.toRadians(degSunLatitude);
        double radSunLongitude = Math.toRadians(degSunLongitude);

        // Rotate the sun to arrive into a flat plan (0,0)
        double radSatelliteLatitude = Math.toRadians(degSatelliteLatitude) - radSunLatitude;
        double radSatelliteLongitude = Math.toRadians(degSatelliteLongitude) - radSunLongitude;

        // Transformation Cartesian coordinate system
        double radSatelliteCoLatitude = Math.PI / 2 - radSatelliteLatitude;
        double xSatellite = satelliteAltitude * Math.cos(radSatelliteLongitude) * Math.sin(radSatelliteCoLatitude) - DISTANCE_EARTH_SUN;
        double ySatellite = satelliteAltitude * Math.sin(radSatelliteLongitude) * Math.sin(radSatelliteCoLatitude);
        double zSatellite = satelliteAltitude * Math.cos(radSatelliteCoLatitude);
        // Transformation in 3D on a graph based on the sun
        double rSatellite = Math.sqrt(Math.pow(xSatellite, 2) +
                Math.pow(ySatellite, 2) +
                Math.pow(zSatellite, 2));

        double phiSatellite = Math.PI / 2 - Math.acos(zSatellite / rSatellite);
        double thetaSatellite = Math.atan(ySatellite / rSatellite);

        // Check if alpha is higher than the one of the shadow + that the distance sun satellite is higher than distance sun earth
        return rSatellite > (EARTH_RADIUS/Math.asin(CRITICAL_ECLIPSE_ANGLE)) && (phiSatellite < CRITICAL_ECLIPSE_ANGLE) && thetaSatellite < CRITICAL_ECLIPSE_ANGLE;
    }
}
