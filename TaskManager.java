import java.util.ArrayList;
import java.util.Scanner;


public class TaskManager {

    private static final ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    markTaskAsCompleted(scanner);
                    break;
                case 3:
                    viewTasks();
                    break;
                case 4:
                    System.out.println("Exiting Task Manager. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Task Manager");
        System.out.println("1. Add Task");
        System.out.println("2. Mark Task as Completed");
        System.out.println("3. View Tasks");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter the task: ");
        String task = scanner.next();
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    private static void markTaskAsCompleted(Scanner scanner) {
        System.out.print("Enter the task index to mark as completed: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid task index.");
        }
    }
//test 
    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
