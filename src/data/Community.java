package data;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Класс для хранения списка людей
 */
@XmlType(name = "people")
@XmlRootElement
public class Community {
    @XmlElementWrapper(name = "added-people", nillable = true)
    @XmlElement
    public List<Person> people = new ArrayList<>();
/**
 * Метод для добавления людей в список
 */
    public void addPersonToPeople(Person person) {
        people.add(person);
    }

    /**
     * метод для получения списка людей
     * @return список людей
     * @throws NullPointerException если список пуст
     */
    public List<Person> getPeople()throws NullPointerException{
        return people;
    }
}

