package data;

public class Coordinates {
    private double x;
    private double y; //Значение поля должно быть больше -615

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean validate() {
        return y > -615;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}