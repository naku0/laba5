package builder;

import java.util.Scanner;

/**
 * Класс для создания имени
 */
public class NameBuilder extends Builder {
    /**
     * Метод для создания имени
     * @return имя
     * @throws IllegalArgumentException если имя пустое
     */
    public String create() throws IllegalArgumentException{
        while (true) {
            String name = stringBuilder("имя");
            if (!(name.isEmpty())) {
                return name;
            } else {
                System.err.println("Дайте ему имя, пожалуйста :(");
            }

        }
    }

}
