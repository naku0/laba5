package Builder;

import data.Coordinates;
import data.Location;

public class LocationBuilder extends Builder{
    public Location create() {
        return new Location(
                longBuilder(" координату х:"),
                intBuilder(" координату у:"),
                longBuilder(" координату z:"),
                stringBuilder("название локации:")
        );
    }
}
