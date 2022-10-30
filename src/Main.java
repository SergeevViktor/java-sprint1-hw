import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        int userInput;

        while (true) {
            printMenu();
            userInput = scanner.nextInt();
            if (userInput == 1) {
                System.out.println("За какой месяц Вы хотите ввести данные (от 0-(Январь) до 11 (Декабрь)) ?");
                int month = scanner.nextInt();
                if (month < 0 || month > 11) {
                    System.out.println("Команда не поддерживается. Выберете месяц в указанном диапозоне.");
                    continue;
                }
                System.out.println("За какой день Вы хотите ввести данные (от 1 до 30) ?");
                int day = scanner.nextInt();
                if (day < 1 || day > 30) {
                    System.out.println("Команда не поддерживается. Выберете день в указанном диапозоне.");
                    continue;
                }
                System.out.println("Количество шагов в " + day + "-й день:" + stepTracker.monthToData[month].days[day - 1]);
                System.out.println("Какое количество шагов Вы сделали за день?");
                int newStepPerDay = scanner.nextInt();
                if (newStepPerDay < 0) {
                    System.out.println("Нельзя указать отрицательное значение.");
                    continue;
                }
                stepTracker.newDataPerDay(day, month, newStepPerDay);
                System.out.println("Запись сохранена.");
                System.out.println("Количество шагов в " + day + "-й день:" + stepTracker.monthToData[month].days[day - 1]);

            } else if (userInput == 2) {
                System.out.println("Сводку за какой месяц Вы хотите посмотреть (от 0-(Январь) до 11 (Декабрь)) ?");
                int month = scanner.nextInt();
                if (month < 0 || month > 11) {
                    System.out.println("Команда не поддерживается. Выберете месяц в указанном диапозоне.");
                    continue;
                }
                System.out.println("Количество пройденый шагов:");
                stepTracker.stepsPerMonth(month);
                System.out.println("Максимальное пройденное количество шагов в месяце: " + stepTracker.maxStepsPerMonth(month));
                System.out.println("Общее количество шагов за месяц: " + stepTracker.amountStepsPerMonth(month));
                System.out.println("Среднее количество пройденных шагов за месяц: " + stepTracker.meanStepsPerMonth(month));
                System.out.println("Лучшая серия дней: " + stepTracker.theBestStreak(month));
                System.out.println("Пройденная дистанция (в км): " + stepTracker.distanceCovered(month, stepTracker));
                System.out.println("Количество сожжённых килокалорий: " + stepTracker.burnedKilocalories(month, stepTracker));

            } else if (userInput == 3) {
                System.out.println("Цель по количеству шагов в день: " + stepTracker.targetSteps);
                System.out.println("Введите новое значение: ");
                int target = scanner.nextInt();
                if (target < 0) {
                    System.out.println("Нельзя указать отрицательное значение.");
                    continue;
                }
                stepTracker.changeTargetSteps(target);
                System.out.println("Запись сохранена.");
                System.out.println("Новая цель " + stepTracker.targetSteps + " шагов.");

            } else if (userInput == 4) {
                break;
            } else {
                System.out.println("Такой команды нет.");
            }
        }
        System.out.println("Программа завершена");
    }
    private static void printMenu() {
        System.out.println("Что Вы хотите сделать?");
        System.out.println("1. Ввести количество шагов за определенный день.");
        System.out.println("2. Напечатать статистику за определенный месяц.");
        System.out.println("3. Изменить цель по количеству шагов в день.");
        System.out.println("4. Выйти из приложения.");
    }
}