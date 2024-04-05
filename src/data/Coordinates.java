package data;

import interfaces.Validatable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Класс, описывающий координаты человека
 */
@XmlRootElement
public class Coordinates implements Validatable {

    private double x;
    private double y; //Значение поля должно быть больше -615

    /**
     * Конструктор Координат
     * @param x координата Х
     * @param y координата Y
     */
    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Пустой конструктор для парсинга
     */
    public Coordinates() {
    }

    /**
     * Геттер координат X для парсинга
     * @return координата Х
     */
    @XmlElement
    public double getX() {
        return x;
    }

    /**
     * Сеттер координат Х
     * @param x координата Х
     */

    public void setX(double x) {
        this.x = x;
    }

    /**
     * Гетер координат Y для парсинга
     * @return координата Y
     */

    @XmlElement
    public double getY() {
        return y;
    }

    /**
     * Сеттер координат Y
     * @param y координата Y
     */

    public void setY(double y) {
        this.y = y;
    }
    

    @Override
    public boolean validated() {
        return y > -615;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}