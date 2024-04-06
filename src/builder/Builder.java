package builder;

import commands.ExecuteScript;
import managers.CollectionManager;

import java.util.Scanner;

/**
 * Класс для построения объектов с помощью билдера
 */

public abstract class Builder {
    protected static Scanner scanner;

    /**
     * Конструктор для билдера, который переключает между вводом с консоли и считыванием из файла
     */
    public Builder() {
        scanner = (ExecuteScript.isFromFile) ? CollectionManager.reader : new Scanner(System.in);
    }

    /**
     * Стринг билдер для имени Человека
     * @param name стринговое значение
     * @return стринговое значение
     */

    public String stringBuilder(String name) {
        System.out.println("Введите " + name);
        name = scanner.nextLine();
        return name;
    }

    /**
     * Дабл билдер преобразующий стринг в дабл
     * @param string стринговое значение
     * @return дабл значение
     */

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

    /**
     * Инт билдер преобразующий стринг в инт
     * @param string стринговое значение
     * @return инт значение
     */
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

    /**
     * Лонг билдер преобразующий стринг в лонг
     * @param string стринговое значение
     * @return  лонговое значение
     */

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
