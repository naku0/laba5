package data;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "people")
@XmlRootElement
public class Community {
    @XmlElementWrapper(name = "added-people", nillable = true)
    @XmlElement
    public List<Person> people = new ArrayList<>();

    public void addPersonToPeople(Person person) {
        people.add(person);
    }

    public List<Person> getPeople()throws NullPointerException{
        return people;
    }
}

