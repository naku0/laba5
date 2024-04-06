package builder;

import java.io.InputStream;
import java.time.LocalDateTime;

/**
 * Класс для обработки LocalDateTime
 */
public class LocalDateTimeBuilder {
    private final LocalDateTime dateTime = LocalDateTime.now();

    /**
     * Пустой конструктор для парсера
     */
    public LocalDateTimeBuilder() {
    }

    /**
     * Метод для создания LocalDateTime поля
     * @return LocalDateTime поле
     */
    public String create(){
        return dateTime.toString();
    }
}
