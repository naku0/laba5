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
    public void add(Person person) throws InvalidDataException {
        if(!(person.validated())) throw new InvalidDataException();
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


