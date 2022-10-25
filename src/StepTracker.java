import java.util.Scanner;
public class StepTracker {
    int targetSteps = 10000;
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void changeTargetSteps(Scanner scanner) {
        System.out.println("Введите новое значение: ");
        int target = scanner.nextInt();
        while (true) {
            if (target < 0) {
                System.out.println("Нельзя указать отрицательное значение. Повторите попытку:");
                target = scanner.nextInt();
            } else {
                targetSteps = target;
                break;
            }
        }
        System.out.println("Запись сохранена.");
        System.out.println("Новая цель " + targetSteps + " шагов.");
    }

    class MonthData {
        int[] days = new int[30];
        Converter converter = new Converter();
        void newDataPerDay(int day, int month, Scanner scanner) {
            int newStepPerDay = scanner.nextInt();
            while (true) {
                if (newStepPerDay < 0) {
                    System.out.println("Нельзя указать отрицательное значение. Повторите попытку:");
                    newStepPerDay = scanner.nextInt();
                } else {
                    monthToData[month - 1].days[day - 1] = newStepPerDay;
                    days[day - 1] = monthToData[month - 1].days[day - 1];
                    break;
                }
            }
        }

        void stepsPerMonth() {
            for (int i = 0; i < days.length; i++) {
                System.out.println((i + 1) + " день: " + days[i]);
            }
        }

        int maxStepsPerMonth() {
            int maxSteps = 0;
            for (int i = 0; i < days.length; i++) {
                if (maxSteps < days[i]) {
                    maxSteps = days[i];
                }
            }
            return maxSteps;
        }

        public double amountStepsPerMonth() {
            double sum = 0.0;
            for (int i = 0; i < days.length; i++) {
                sum = sum + days[i];
            }
            return sum;
        }

        double meanStepsPerMonth() {
            return amountStepsPerMonth() / days.length;
        }

        int theBestStreak() {
            int streak = 1;
            int goalStreak = 0;
            for (int i = 0; i < days.length; i++) {
                while (days[i] >= targetSteps) {
                    if (days[i + 1] >= targetSteps) {
                        streak = streak + 1;
                    } else if (goalStreak < streak) {
                        goalStreak = streak;
                    } else {
                        streak = 1;
                    }
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
}