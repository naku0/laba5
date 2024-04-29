package builder;

/**
 * Класс для построения роста
 * */
public class HeightBuilder extends Builder{
    /**
     * Метод для проверки роста
     * @return рост
     * @throws IllegalArgumentException если рост не подходит под предполагаемое значение
     */
    public int create() throws IllegalArgumentException{
        while (true) {
            int height = intBuilder(" рост");
            if (height>0) {
                return height;
            } else {
                System.err.println("Рост не может быть отрицательным или равным нулю!");
            }
        }
    }
}
