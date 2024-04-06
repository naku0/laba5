package builder;

import data.Location;

import java.util.Scanner;

/**
 * Класс для создания Location
 */
public class LocationBuilder extends Builder{
    /**
     * Конструктор по умолчанию
     */
    public LocationBuilder() {
    }

    /**
     * Метод для создания Location
     * @return объект Location
     */
    public Location create() {
        return new Location(
                longBuilder(" координату х:"),
                intBuilder(" координату у:"),
                longBuilder(" координату z:"),
                stringBuilder("название локации:")
        );
    }
}
