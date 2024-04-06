package builder;

import data.Coordinates;

import java.util.Scanner;

/**
 * Класс для построения объекта Coordinates
 */
public class CoordinateBuilder extends Builder {
    /**
     * Метод для построения объекта Coordinates
     * @return объект Coordinates
     */
    public Coordinates create() {
        return new Coordinates(
                doubleBuilder("Координата х: "), doubleBuilder("Координата у:")
        );
    }
}
