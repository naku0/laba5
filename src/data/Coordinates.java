package data;

import interfaces.Validatable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Coordinates implements Validatable {
    private double x;
    private double y; //Значение поля должно быть больше -615

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {
    }

    @XmlElement
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @XmlElement
    public double getY() {
        return y;
    }

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