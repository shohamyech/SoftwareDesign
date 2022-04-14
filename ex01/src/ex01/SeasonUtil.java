package ex01;

import static java.util.Arrays.sort;

public class SeasonUtil {
    public static final Season[] SEASONS = Season.values();
    public static void sortSeasonable(Comparable[] seasonables) {
        sort(seasonables);
    }

    static String reportAll(Seasonable[] seasonables) {
        StringBuilder report = new StringBuilder();
        for (Seasonable i: seasonables)
            report.append(i.toString()).append("\n");
        return report.toString();
    }
}
