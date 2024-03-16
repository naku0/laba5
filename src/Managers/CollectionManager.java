package Managers;

import Exceptions.EmptyCollectionException;
import Exceptions.InvalidDataException;
import data.Person;

import java.util.Vector;

public class CollectionManager {
    public CollectionManager() {

    }

    private final Vector<Person> MyLittleCollection = new Vector<>();

    public Vector<Person> getMyLittleCollection() {
        return MyLittleCollection;
    }

    public boolean idIdentifier(Person person) {
        for (Person value : MyLittleCollection) {
            if (person.getId() == value.getId()) {
                return false;
            }
        }
        return true;
    }

    public void add(Person person) throws InvalidDataException {
        if (!(person.validated())) throw new InvalidDataException();
        if(idIdentifier(person)){
            person.setId(person.generateId());
        }
        MyLittleCollection.add(person);
    }

    public void show() throws EmptyCollectionException {
        if (!MyLittleCollection.isEmpty()) {
            System.out.println("Содержимое коллекции:");
            for (Person i : MyLittleCollection) {
                {
                    System.out.println(i);
                }

            }
        } else {
            throw new EmptyCollectionException();
        }
    }
}


