package Builder;

import Exceptions.InvalidDataException;
import data.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class PersonBuilder extends Builder {

    public Person create() {
        System.out.println("Время создать человека: ");
        return new Person(
                new NameBuilder().create(),
                new CoordinateBuilder().create(),
                new LocalDateTimeBuilder().create(),
                intBuilder(" рост"),
                new BuilderOfEnum<>(Color.class, "цвета").listen(),
                new BuilderOfEnum<>(Country.class, "национальности").listen(),
                new LocationBuilder().create()
        );
    }
}
