import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Expense {
    private String category;
    private double amount;

    public Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }
}

class Budget {
    private String category;
    private double limit;

    public Budget(String category, double limit) {
        this.category = category;
        this.limit = limit;
    }

    public String getCategory() {
        return category;
    }

    public double getLimit() {
        return limit;
    }
}

public class PersonalFinanceManager {
    private List<Expense> expenses;
    private List<Budget> budgets;

    public PersonalFinanceManager() {
        this.expenses = new ArrayList<>();
        this.budgets = new ArrayList<>();
    }

    public void addExpense(String category, double amount) {
        Expense expense = new Expense(category, amount);
        expenses.add(expense);
        System.out.println("Expense added: $" + amount + " in category " + category);
    }

    public void setBudget(String category, double limit) {
        Budget budget = new Budget(category, limit);
        budgets.add(budget);
        System.out.println("Budget set: $" + limit + " for category " + category);
    }

    public void analyzeExpenses() {
        System.out.println("\nExpense Analysis:");
        for (Expense expense : expenses) {
            System.out.println("Category: " + expense.getCategory() + ", Amount: $" + expense.getAmount());
        }

        System.out.println("\nBudget Analysis:");
        for (Budget budget : budgets) {
            double spent = calculateSpending(budget.getCategory());
            System.out.println("Category: " + budget.getCategory() + ", Limit: $" + budget.getLimit() + ", Spent: $" + spent);
        }
    }

    private double calculateSpending(String category) {
        double spent = 0;
        for (Expense expense : expenses) {
            if (expense.getCategory().equalsIgnoreCase(category)) {
                spent += expense.getAmount();
            }
        }
        return spent;
    }

    public static void main(String[] args) {
        PersonalFinanceManager financeManager = new PersonalFinanceManager();
        Scanner scanner = new Scanner(System.in);

        financeManager.setBudget("Groceries", 200);
        financeManager.setBudget("Entertainment", 100);

        financeManager.addExpense("Groceries", 150);
        financeManager.addExpense("Entertainment", 50);
        financeManager.addExpense("Groceries", 30);

        financeManager.analyzeExpenses();

        scanner.close();
    }
}
