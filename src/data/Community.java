package data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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

    public List<Person> getPeople() {
        return people;
    }
}

