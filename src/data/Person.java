package data;

import Exceptions.InvalidDataException;
import Interfaces.Validatable;

import javax.xml.validation.Validator;
import java.time.ZonedDateTime;
import java.util.Objects;

public class Person implements Validatable {
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

    @Override
    public boolean validated() {
        return this.id > 0
                && this.passportID != null
                && !this.name.isEmpty()
                && this.coordinates != null && coordinates.validated()
                && this.height != null && this.height > 0
                && this.location != null && this.location.validated();
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

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return Objects.equals(id,person.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, height, passportID, hairColor, nationality, location);
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
