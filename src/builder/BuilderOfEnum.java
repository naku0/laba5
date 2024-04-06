package builder;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Класс, реализующий билдер для перечислений
 * @param <T>
 */
public class BuilderOfEnum<T extends Enum<T>> extends Builder{

    private final T[] values;
    private final String name;
    private final Scanner scanner;

    /**
     *Конструктор билдера для перечислений
     * @param enumClass тип перечисления
     * @param name имя перечисления
     * @param scanner способ ввода
     */
    public BuilderOfEnum(Class<T> enumClass, String name, Scanner scanner) {
        this.values = enumClass.getEnumConstants();
        this.name = name;
        this.scanner = scanner;
    }

    /**
     * Метод, возвращающий перечисление
     * @return перечисление
     */
    public T listen() {
        while (true) {
            System.out.println("Доступные " + name + ":");
            System.out.print("[");
            for (int i = 0; i < values.length; i++) {
                System.out.print(values[i]);
                if (i < values.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");

            String userInput = scanner.nextLine().toUpperCase();
            T enumValue = null;
            try {
                enumValue = Enum.valueOf(values[0].getDeclaringClass(), userInput);
            } catch (IllegalArgumentException e) {
                try {
                    int index = Integer.parseInt(userInput);
                    if (index >= 1 && index <= values.length) {
                        enumValue = values[index - 1];
                    }
                } catch (NumberFormatException ex) {
                    System.err.println("Некорректный ввод!");
                }
            }
            if (enumValue != null) {
                System.out.println("Выбранное значение: " + enumValue);
                return enumValue;
            } else {
                System.err.println("Неверное значение :(");
            }
        }
    }
}

