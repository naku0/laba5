package Builder;

import java.util.Scanner;

public class BuilderOfEnum<T extends Enum<T>> {
    private final T[] values;
    private final Scanner scanner = new Scanner(System.in);
    private final String name;

    public BuilderOfEnum(Class<T> enumClass, String name) {
        this.values = enumClass.getEnumConstants();
        this.name = name;
    }

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
                    System.out.println("Некорректный ввод!");
                }
            }
            if (enumValue != null) {
                System.out.println("Выбранное значение: " + enumValue);
                return enumValue;
            } else {
                System.out.println("Неверное значение :(");
            }
        }
    }
}

