import java.util.Scanner;

public class StepTracker {
// поля класса
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    MonthData monthData = new MonthData();
    Converter converter = new Converter();
    int goalByStepsPerDay = 10000;
    StepTracker(Scanner scan) { // непонятная хрень
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
// методы класса
    void changeStepGoal() { // меняем цель шагов
        System.out.println("Сейчас целевое значение " + goalByStepsPerDay + " шагов в день. \nСколько вы хотите установить?");
        goalByStepsPerDay = scanner.nextInt();
        System.out.println("Теперь ваша суточная цель - " + goalByStepsPerDay + " шагов.");
    }

    void addNewNumberStepsPerDay() { // сохраняем шаги за день в месяц
        System.out.println("Введите номер месяца:");
        int month = scanner.nextInt();
            if (month < 1 | month > 12) {
                System.out.println("Ошибка! Используйте диапазон от 1 до 12.");
                return;
            }
        System.out.println("Введите нужный день:");
        int day = scanner.nextInt();
            if (day < 1 | day > 30) {
                System.out.println("Ошибка! Используйте диапазон от 1 до 30.");
                return;
            }
        System.out.println("Введите количество пройденных шагов:");
        int steps = scanner.nextInt();
            if (steps < 1) {
                System.out.println("Ошибка! Количество пройденных шагов не должно быть меньше единицы.");
                return;
            }
        MonthData monthData = monthToData[month - 1]; // сохраняем // нарушение условий
        monthData.days[day - 1] = steps;

        System.out.println("За " + day + " день " + month + "-го месяца вы сделали " + steps + " шагов.");

    }

    void printStatistic() {// выводим статистику
        System.out.println("Введите номер месяца:");
        int currentMonth = scanner.nextInt();
            if (currentMonth < 1 | currentMonth > 12) {
                System.out.println("Ошибка! Используйте диапазон от 1 до 12.");
                return;
            }
        monthData = monthToData[currentMonth-1];
        monthData.printDaysAndStepsFromMonth();
        System.out.println("Сумма шагов за этот месяц - " + monthData.sumStepsFromMonth());
        System.out.println("Максимально пройденное количество шагов - " + monthData.maxSteps());
        System.out.println("Среднемесячное количество шагов - " + monthData.averageSteps());
        int steps = monthData.sumStepsFromMonth();
        System.out.println("Пройденных километров - " + converter.convertToKm(steps));
        System.out.println("Сожженных килокалорий - " + converter.convertStepsToKkal(steps));
        System.out.println("Лучшая серия (подряд идущие дни, достигшие целевого значения) - " + monthData.bestSeries(goalByStepsPerDay));
    }
}
