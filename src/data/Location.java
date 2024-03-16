package data;

public class Location {
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

    public boolean validate() {
        return z != null && name.length() < 444;
    }

    @Override
    public String toString() {
        return "{" + +x + ";" + y + ";" + z + ";" + name + '}';
    }
}
