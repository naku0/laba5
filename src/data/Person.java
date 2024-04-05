package data;

import interfaces.Validatable;

import javax.xml.bind.annotation.*;
import java.util.Objects;

/**
 * Класс, описывающий человека
 */
public class Person implements Validatable, Comparable<Person> {

    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private String creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer height; //Поле не может быть null, Значение поля должно быть больше 0
    private String passportID; //Значение этого поля должно быть уникальным, Поле может быть null
    private Color hairColor; //Поле может быть null
    private Country nationality; //Поле не может быть null
    private Location location; //Поле не может быть null

    public Person(String name, Coordinates coordinates,
                  String creationDate, Integer height,
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

    /**
     * Метод, для парсера
     */
    public Person() {
    }

    /**
     * Валидатор данных для Person
     * @return true, если данные валидны, false, если нет
     */
    @Override
    public boolean validated() {
        return this.id > 0
                && this.passportID != null
                && !this.name.isEmpty()
                && this.coordinates != null && coordinates.validated()
                && this.height != null && this.height > 0
                && this.location != null && this.location.validated();
    }


    /**
     * Метод, генерирующий id для Person
     * @return id
     */
    public long generateId() {
        long id;
        id = (long) (Math.random() * 1000);
        this.id = id;
        return id;
    }

    /**
     * Метод, генерирующий passportID для Person
     * @return passportID
     */
    public long generatePassport() {
        return Objects.hash(id);
    }

    /**
     * Геттер id для парсера
     * @return id
     */
    @XmlElement
    public long getId() {
        return id;
    }

    /**
     * Сеттер id для парсера
     * @param id id возвращаемого объекта
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Геттер имени для парсера
     * @return имя
     */
    @XmlElement(name = "person-name")
    public String getName() {
        return name;
    }

    /**
     * Сеттер имени для парсера
     * @param name имя возвращаемого объекта
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Геттер координат для парсера
     * @return координаты
     */
    @XmlElement
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Сеттер координат для парсера
     * @param coordinates координаты возвращаемого объекта
     */

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Геттер даты создания для парсера
     * @return дата создания
     */
    @XmlElement
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * Сеттер даты создания для парсера
     * @param creationDate дата создания возвращаемого объекта
     */

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Геттер роста человека для парсера
     * @return рост человека
     */

    @XmlElement
    public Integer getHeight() {
        return height;
    }

    /**
     * Сеттер роста человека для парсера
     * @param height рост человека
     */

    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * Геттер id паспорта для парсера
     * @return id паспорта
     */
    @XmlElement
    public String getPassportID() {
        return passportID;
    }

    /**
     * Сеттер id паспорта для парсера
     * @param passportID id паспорта
     */
    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    /**
     * Геттер цвета волос человека для парсера
     * @return цвет волос человека
     */
    @XmlElement
    public Color getHairColor() {
        return hairColor;
    }

    /**
     * Сеттер цвета волос человека для парсера
     * @param hairColor цвет волос человека
     */

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * Возвращает страну, где проживает человек
     * @return страна проживания
     */
    @XmlElement
    public Country getNationality() {
        return nationality;
    }

    /**
     * Указывает страну, где проживает человек
     * @param nationality страна проживания
     */

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    /**
     * Устанавливает местоположение человека
     * @return местоположение
     */

    @XmlElement
    public Location getLocation() {
        return location;
    }

    /**
     * Задает местоположение человека
     * @param location местоположение
     */

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, height, passportID, hairColor, nationality, location);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", height=" + height +
                ", passportID='" + passportID + '\'' +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                ", location=" + location +
                '}';
    }


    @Override
    public int compareTo(Person other) {
        return Long.compare(this.height, other.height);
    }
}
