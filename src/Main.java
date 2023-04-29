import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет! Проследим активность?");
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu ();
            int command = scanner.nextInt();

            if (command == 1){
                stepTracker.addNewNumberStepsPerDay();
            } else if (command == 2){
                stepTracker.changeStepGoal();
            } else if (command == 3){
                stepTracker.printStatistic();
            } else if (command == 0){
                System.out.println("Выход");
                return;
            } else
                System.out.println("Такой команды пока не придумали =(");
        }
    }

    public static void printMenu(){
        System.out.println("Выберите команду: " +
                "\n\t 1 - ввести количество шагов за день;" +
                "\n\t 2 - изменить цель по шагам;" +
                "\n\t 3 - выдать статистику за месяц;" +
                "\n\t 0 - выйти из приложения.");
    }
}