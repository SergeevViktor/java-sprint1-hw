public class StepTracker {
    int targetSteps = 10000;
    Converter converter = new Converter();

    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void changeTargetSteps(int target) {
        targetSteps = target;
    }

    void newDataPerDay(int day, int month, int newStepPerDay) {
        monthToData[month].days[day - 1] = newStepPerDay;
    }

    void stepsPerMonth(int month) {
        for (int i = 0; i < monthToData[month].days.length; i++) {
            if (i == 29) {
                System.out.println((i + 1) + " день: " + monthToData[month].days[i]);
            } else {
                System.out.print((i + 1) + " день: " + monthToData[month].days[i] + ", ");
            }
        }
    }

    int maxStepsPerMonth(int month) {
        int maxSteps = 0;
        for (int i = 0; i < monthToData[month].days.length; i++) {
            if (maxSteps < monthToData[month].days[i]) {
                maxSteps = monthToData[month].days[i];
            }
        }
        return maxSteps;
    }

    public int amountStepsPerMonth(int month) {
        int sum = 0;
        for (int i = 0; i < monthToData[month].days.length; i++) {
            sum = sum + monthToData[month].days[i];
        }
        return sum;
    }

    double meanStepsPerMonth(int month) {
        return (double) amountStepsPerMonth(month) / monthToData[month].days.length;
    }

    int theBestStreak(int month) {
        int streak = 0;
        int goalStreak = 0;
        for (int i = 0; i < monthToData[month].days.length; i++) {
            if (monthToData[month].days[i] >= targetSteps) {
                streak = streak + 1;
                if (goalStreak < streak) {
                    goalStreak = streak;
                }
            } else {
                streak = 0;
            }
        }
        return goalStreak;
    }

    double distanceCovered(int month, StepTracker stepTracker) {
        return converter.calculationDistance(month, stepTracker);
    }

    double burnedKilocalories(int month, StepTracker stepTracker) {
        return converter.calculationKilocalories(month, stepTracker);
    }
}
// if (monthToData[month].days[i] != monthToData[month].days[monthToData[month].days.length - 1]) {
// if (monthToData[month].days[i + 1] >= targetSteps) {