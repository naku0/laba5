package Builder;

import data.Coordinates;

public class CoordinateBuilder extends Builder {
    public Coordinates create() {
        return new Coordinates(
                doubleBuilder("Координата х: "), doubleBuilder("Координата у:")
        );
    }
}
