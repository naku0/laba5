package data;

import Exceptions.InvalidDataException;

import java.time.ZonedDateTime;
import java.util.Objects;

public class Person {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer height; //Поле не может быть null, Значение поля должно быть больше 0
    private String passportID; //Значение этого поля должно быть уникальным, Поле может быть null
    private Color hairColor; //Поле может быть null
    private Country nationality; //Поле не может быть null
    private Location location; //Поле не может быть null

    public Person(String name, Coordinates coordinates,
                  ZonedDateTime creationDate, Integer height,
                  Color hairColor, Country nationality, Location location) {
        this.id = generateId();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.height = height;
        this.passportID = String.valueOf(generatePassport());
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }

    public boolean validated() {
        return this.id > 0
                && this.passportID != null
                && !this.name.isEmpty()
                && this.coordinates != null && coordinates.validate()
                && this.height != null && this.height > 0
                && this.location != null && this.location.validate();
    }


    public long generateId() {
        long id;
        id = (long) (Math.random() * 1000);
        this.id = id;
        return id;
    }

    public long generatePassport() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\''+
        ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", height=" + height +
                ", passportID='" + passportID + '\'' +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                ", location=" + location +
                '}';
    }


}
