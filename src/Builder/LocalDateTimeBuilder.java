package Builder;

import java.time.LocalDateTime;

public class LocalDateTimeBuilder {
    private final LocalDateTime dateTime = LocalDateTime.now();
    public LocalDateTimeBuilder() {
    }
    public String create(){
        return dateTime.toString();
    }
}
