package builder;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @param <T>
 */
public class BuilderOfEnum<T extends Enum<T>> extends Builder{
    private final T[] values;
    private final String name;
    private Scanner scanner;

    /**
     *
     * @param enumClass
     * @param name
     * @param scanner
     */
    public BuilderOfEnum(Class<T> enumClass, String name, Scanner scanner) {
        this.values = enumClass.getEnumConstants();
        this.name = name;
        this.scanner = scanner;
    }

    /**
     *
     * @return
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

