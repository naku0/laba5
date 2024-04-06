package builder;

import data.*;

import java.io.InputStream;
import java.util.Scanner;
/**
 * Класс для создания Person
 */
public class PersonBuilder extends Builder {
    public Person create() {
        System.out.println("Время создать человека: ");
        return new Person(
                new NameBuilder().create(),
                new CoordinateBuilder().create(),
                new LocalDateTimeBuilder().create(),
                intBuilder(" рост"),
                new BuilderOfEnum<>(Color.class, "цвета", Builder.scanner).listen(),
                new BuilderOfEnum<>(Country.class, "национальности", Builder.scanner).listen(),
                new LocationBuilder().create()
        );
    }
}
