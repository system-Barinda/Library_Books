package service;

import model.Fan;
import java.util.List;

public class FanService {

    public double calculateOverallAverage(List<Fan> fans) {
        double sum = 0;
        for (Fan f : fans) {
            sum += f.getAverageGoals();
        }
        return fans.size() == 0 ? 0 : sum / fans.size();
    }

    public Fan getHighestAverageFan(List<Fan> fans) {
        Fan topFan = null;
        double max = 0;

        for (Fan f : fans) {
            if (f.getAverageGoals() > max) {
                max = f.getAverageGoals();
                topFan = f;
            }
        }
        return topFan;
    }
}
