import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                System.out.println("За какой месяц Вы хотите вывести данные (от 1 до 12) ?");
                int month = scanner.nextInt();
                while (true) {
                    if (month < 1 || month > 12) {
                        System.out.println("Команда не поддерживается. Выберете месяц в указанном диапозоне.");
                        month = scanner.nextInt();
                    } else {
                        break;
                    }
                }
                System.out.println("За какой день Вы хотите вывести данные (от 1 до 30) ?");
                int day = scanner.nextInt();
                    while (true) {
                        if (day < 1 || day > 30) {
                            System.out.println("Команда не поддерживается. Выберете день в указанном диапозоне.");
                            day = scanner.nextInt();
                        } else {
                            break;
                        }
                    }
                System.out.println("Количество шагов в " + day + "-й день:" + stepTracker.monthToData[month - 1].days[day - 1]);
                    while (true) {
                        System.out.println("Хотите внести новые данные? (1. - Да / 0. - Нет)");
                        int choice = scanner.nextInt();
                        if (choice == 1) {
                            System.out.println("Какое количество шагов Вы сделали за день?");
                            stepTracker.monthToData[month].newDataPerDay(day, month, scanner);
                            System.out.println("Запись сохранена.");
                            System.out.println("Количество шагов в " + day + "-й день:" + stepTracker.monthToData[month - 1].days[day - 1]);
                        } else if (choice == 0) {
                            break;
                        } else {
                            System.out.println("Команда не поддерживается.");
                        }
                    }
            } else if (userInput == 2) {
                System.out.println("Сводку за какой месяц Вы хотите посмотреть (от 1 до 12) ?");
                int month = scanner.nextInt();
                    while (true) {
                        if (month < 1 || month > 12) {
                            System.out.println("Команда не поддерживается. Выберете месяц в указанном диапозоне.");
                            month = scanner.nextInt();
                        } else {
                            break;
                        }
                    }
                System.out.println("Количество пройденый шагов:");
                    stepTracker.monthToData[month].stepsPerMonth();
                System.out.println("Максимальное пройденное количество шагов в месяце: " + stepTracker.monthToData[month].maxStepsPerMonth());
                System.out.println("Общее количество шагов за месяц: " + stepTracker.monthToData[month].amountStepsPerMonth());
                System.out.println("Среднее количество пройденных шагов за месяц: " + stepTracker.monthToData[month].meanStepsPerMonth());
                System.out.println("Лучшая серия дней: " + stepTracker.monthToData[month].theBestStreak());
                System.out.println("Пройденная дистанция (в км): " + stepTracker.monthToData[month].distanceCovered(month, stepTracker));
                System.out.println("Количество сожжённых килокалорий: " + stepTracker.monthToData[month].burnedKilocalories(month, stepTracker));
            } else if (userInput == 3) {
                System.out.println("Цель по количеству шагов в день: " + stepTracker.targetSteps);
                while (true) {
                    System.out.println("Хотите изменить цель? (1. Да / 0. Нет)");
                    int choice = scanner.nextInt();
                    if (choice == 1) {
                        stepTracker.changeTargetSteps(scanner);
                    } else if (choice == 0) {
                        break;
                    } else {
                        System.out.println("Команда не поддерживается.");
                    }
                }
            } else if (userInput == 0) {
                break;
            } else {
                System.out.println("Такой команды нет.");
            }

            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Что Вы хотите сделать?");
        System.out.println("1. Вывести количество шагов за определенный день.");
        System.out.println("2. Напечатать статистику за определенный месяц.");
        System.out.println("3. Изменить цель по количеству шагов в день.");
        System.out.println("0. Выйти из приложения.");
    }
}