package builder;

import data.Location;

import java.util.Scanner;

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
