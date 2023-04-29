public class MonthData {
    // поля месяца
    int[] days = new int[30];

    // методы по статистике за месяц
    void printDaysAndStepsFromMonth() {
        System.out.println("За этот месяц вы прошли:");
            for (int i = 0; i < days.length; i++)
            System.out.println("\t" + (i + 1) + " день: " + days[i]);
    }
    int sumStepsFromMonth() {
        int sum = 0;
        for (int day : days) {
            sum = sum + day;
        }
        return sum;
    }
    int maxSteps() {
        int max = days[0];
        for (int day : days) {
            if (day > max) {
                max = day;
            }
        }
        return max;
    }
    int bestSeries(int goal) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int day : days) {
            if (day >= goal) {
                if (++currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
            } else {
                currentSeries = 0;
            }
        }
        return finalSeries;
    }
    int averageSteps() {
        int sum = 0;
        for (int day : days) {
            sum = sum + day;
        }
        return sum / 30;
    }
}
