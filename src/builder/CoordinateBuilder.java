package builder;

import data.Coordinates;

import java.util.Scanner;

public class CoordinateBuilder extends Builder {
    public Coordinates create() {
        return new Coordinates(
                doubleBuilder("Координата х: "), doubleBuilder("Координата у:")
        );
    }
}
