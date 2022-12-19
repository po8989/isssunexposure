package isssunexposure.models;

import java.util.ArrayList;
import java.util.List;

public class SunExposureHistoryList {
    public SunExposureHistoryList(){
        windowsHistory = new ArrayList<SunExposureHistory>();
    }
    public int id;
    public String name;
    public List<SunExposureHistory> windowsHistory;
}
