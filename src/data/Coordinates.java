package data;

import Interfaces.Validatable;

public class Coordinates implements Validatable {
    private double x;
    private double y; //Значение поля должно быть больше -615

    public Coordinates(double x, double y) {
        this.x = x;
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