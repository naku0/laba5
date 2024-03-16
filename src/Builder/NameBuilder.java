package Builder;
public class NameBuilder extends Builder {
    public String create() throws IllegalArgumentException{
        while (true) {
            String name = stringBuilder("имя");
            if (!(name.isEmpty())) {
                return name;
            } else {
                System.err.println("Дайте ему имя, пожалуйста :(");
            }

        }
    }

}
