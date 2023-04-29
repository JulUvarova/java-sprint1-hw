public class MonthData {
    // поля месяца
    int[] days = new int[30];

    // методы по статистике за месяц
    void printDaysAndStepsFromMonth() {
        System.out.println("За этот месяц вы прошли:");
        for (int i = 0; i < days.length; i++)
        //while (i < days.length);
        System.out.println("\t" + (i + 1) + " день: " + days[i]);
    }
    int sumStepsFromMonth() {
        int sum = 0;
        for (int i = 0; i < days.length; i++) {
            sum = sum + days[i];
        }
        return sum;
    }
    int maxSteps() {
        int max = days[0];
        for (int i = 0; i < days.length; i++) {
            if (days[i] > max) {
                max = days[i];
            }
        }
        return max;
    }
    int bestSeries(int goal) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goal) {
                if (++currentSeries > finalSeries){
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
        for (int i = 0; i < days.length; i++) {
            sum = sum + days[i];
        }
        int average = sum / 30;
        return average;
    }
}
