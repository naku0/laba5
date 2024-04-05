package builder;

import commands.ExecuteScript;
import managers.CollectionManager;

import java.util.Scanner;


public abstract class Builder {
    protected static Scanner scanner;

    public Builder() {
        scanner = (ExecuteScript.isFromFile) ? CollectionManager.reader : new Scanner(System.in);
    }

    public String stringBuilder(String name) {
        System.out.println("Введите " + name);
        name = scanner.nextLine();
        return name;
    }

    public double doubleBuilder(String string) {
        while (true) {
            System.out.println("Введите " + string);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Это число не типа 'double', давайте повторим ввод!");
            }
        }
    }

    public int intBuilder(String string) {
        while (true) {
            System.out.println("Введите" + string);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Это число не типа 'int', давайте повторим ввод!");
            }
        }
    }

    public long longBuilder(String string) {
        while (true) {
            System.out.println("Введите" + string);
            try {
                return Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Это число не типа 'long', давайте повторим ввод!");
            }
        }
    }
}
