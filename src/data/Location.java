package data;

import Interfaces.Validatable;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Location implements Validatable {
    private long x;
    private int y;
    private Long z; //Поле не может быть null
    private String name; //Длина строки не должна быть больше 444, Поле может быть null

    public Location(long x, int y, Long z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public Location() {
    }

    @XmlElement
    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    @XmlElement
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @XmlElement
    public Long getZ() {
        return z;
    }

    public void setZ(Long z) {
        this.z = z;
    }

    @XmlElement(name = "location-name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean validated() {
        return z != null && name.length() < 444;
    }

    @Override
    public String toString() {
        return "{" + +x + ";" + y + ";" + z + ";" + name + '}';
    }
}
