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
                System.out.println("За какой день Вы хотите вывести данные (от 1 до 30) ?");
                int day = scanner.nextInt();
                System.out.println("Количество шагов в " + day + "-й день:" + stepTracker.monthToData[month - 1].days[day - 1]);
                    while(true) {
                        System.out.println("Хотите внести новые данные? (1. - Да / 2. - Нет)");
                        userInput = scanner.nextInt();
                        if (userInput == 1) {
                            newDataPerDay(month, day, scanner, stepTracker);
                        } else if (userInput == 0) {
                            break;
                        } else {
                            System.out.println("Команда не поддерживается.");
                        }
                    }
            } else if (userInput == 2) {
                System.out.println("Сводку за какой месяц Вы хотите посмотреть (от 1 до 12) ?");
                int month = scanner.nextInt();
                stepTracker.monthToData[month].stepsPerMonth();
            } else if (userInput == 3) {
                //метод по изменению цели по кол-ву шагов в день
            } else if (userInput == 0) {
                break; //выход
            } else {
                System.out.println("Такой команды нет.");
            }

            printMenu(); // печатаем меню ещЄ раз перед завершением предыдущего действи€
            userInput = scanner.nextInt(); // повторное считывание данных от пользовател€
        }
        System.out.println("Программа завершена");
    }

    private static void newDataPerDay(int month, int day, Scanner scanner, StepTracker stepTracker) {
        System.out.println("Какое количество шагов Вы сделали за день?");
        int stepsPerDay = scanner.nextInt();
        System.out.println("Запись сохранена.");
        System.out.println("Количество шагов в " + day + "-й день:" + stepTracker.monthToData[month - 1].days[day - 1]);
    }

    private static void printMenu() {
        System.out.println("Что Вы хотите сделать?");
        System.out.println("1. Вывести количество шагов за определенный день.");
        System.out.println("2. Напечатать статистику за определенный месяц.");
        System.out.println("3. Изменить цель по количеству шагов в день.");
        System.out.println("0. Выйти из приложения.");
    }
}