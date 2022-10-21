import java.util.Scanner;
public class StepTracker {
    MonthData[] monthToData;
    int defaultTargetSteps = 10000;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    class MonthData {
        int[] days;
        int stepPerDay = 0;
        void stepsPerDay(int stepsPerDay, int day) {
            days = new int[30];
            for (int i = 0; i < days.length; i++) {
                if (day - 1 == days[i]) {
                    days[i] = stepsPerDay;
                }
            }
        }

       /* public void newDataPerDay(int day, int month) {
            System.out.println("Какое количество шагов Вы сделали за день?");
            int stepsPerDay = scanner.nextInt();
            System.out.println("Запись сохранена.");
            System.out.println("Количество шагов в " + day + "-й день:" + monthToData[month - 1].days[day - 1]);
        } */

        void stepsPerMonth() {
            int sum = 0;
            int maxSteps = 0;
            int streak = 1;
            int goalStreak = 0;
            System.out.println("Количество пройденый шагов:");
            for (int i = 0; i < days.length; i++) {
                System.out.println((i + 1) + " день: " + days[i]);
            }

            for (int i = 0; i < days.length; i++) {
                sum = sum + days[i];
            }
            System.out.println("Общее количество шагов за месяц: " + sum);

            for (int i = 0; i < days.length; i++) {
                if (maxSteps < days[i]) {
                    maxSteps = days[i];
                }
            }
            System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps);

            System.out.println("Среднее количество пройденных шагов за месяц: " + sum/30);

            Converter converter = new Converter();
            System.out.println("Дистанция пройденная (в км): " + converter.distance);

            System.out.println("Количество сожжённых килокалорий: " + converter.burnedKilocalories);

            for (int i = 0; i < days.length; i++) {
                while (days[i] >= defaultTargetSteps) {
                    if (days[i + 1] >= defaultTargetSteps) {
                        streak = streak + 1;
                    }
                }
            }
            if (goalStreak < streak) {
                goalStreak = streak;
            }
            System.out.println("Лучшая серия дней: " + goalStreak);
        }
    }
}