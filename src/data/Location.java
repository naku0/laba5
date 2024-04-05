package data;

import interfaces.Validatable;

import javax.xml.bind.annotation.*;

/**
 * Класс, описывающий локацию
 */
@XmlRootElement
public class Location implements Validatable {
    private long x;
    private int y;
    private Long z; //Поле не может быть null
    private String name; //Длина строки не должна быть больше 444, Поле может быть null

    /**
     * Конструктор локации
     * @param x координата x
     * @param y координата y
     * @param z координата z
     * @param name название локации
     */
    public Location(long x, int y, Long z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    /**
     * Пустой конструктор для парсинга
     */
    public Location() {
    }

    /**
     * Геттер координаты x для парсинга
     * @return координату x
     */
    @XmlElement
    public long getX() {
        return x;
    }

    /**
     * Сеттер координаты x для парсинга
     * @param x координата x
     */

    public void setX(long x) {
        this.x = x;
    }

    /**
     * Геттер координаты y для парсинга
     * @return координату y
     */

    @XmlElement
    public int getY() {
        return y;
    }

    /**
     * Сеттер координаты y для парсинга
     * @param y координата y
     */

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Геттер координаты z для парсинга
     * @return координату z
     */

    @XmlElement
    public Long getZ() {
        return z;
    }

    /**
     * Сеттер координаты z для парсинга
     * @param z координата z
     */
    public void setZ(Long z) {
        this.z = z;
    }

    /**
     * Геттер названия локации для парсинга
     * @return  название локации
     */
    @XmlElement(name = "location-name")
    public String getName() {
        return name;
    }

    /**
     * Сеттер названия локации для парсинга
     * @param name название локации
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Валидация полей
     * @return результат валидации
     */
    @Override
    public boolean validated() {
        return z != null && name.length() < 444;
    }

    @Override
    public String toString() {
        return "{" + +x + ";" + y + ";" + z + ";" + name + '}';
    }
}
