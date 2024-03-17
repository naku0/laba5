package Managers;

import Exceptions.EmptyCollectionException;
import Exceptions.InvalidDataException;
import data.Person;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;

public class CollectionManager {
    private final LocalDate localdate;
    public CollectionManager() {
        localdate = LocalDate.parse(LocalDate.now().toString());
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
    public Person getPersonById(int id){
        for (Person person : MyLittleCollection){
            if (id == person.getId()){
                return person;
            }
        }
        return null;
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
    public void getInfo(){
        System.out.println("Сохраняемый тип данных: " + Person.class +
                ", количество человек: " + MyLittleCollection.size() +
                ", дата инициализации:" + localdate);
    }
    public void removeElement(Person person) throws NoSuchElementException{
        if(MyLittleCollection.contains(person)){
            MyLittleCollection.remove(person);
        }else{
            throw new NoSuchElementException();
        }
    }
    public void showData(Function<Person,Integer> mapper){
        List<Integer> data = new ArrayList<>(MyLittleCollection.size());
        for(Person person: MyLittleCollection){
            data.add(mapper.apply(person));
        }
        Collections.sort(data);
        System.out.println(data);
    }
}


