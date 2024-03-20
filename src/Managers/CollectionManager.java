package Managers;

import Builder.PersonBuilder;
import Exceptions.EmptyCollectionException;
import Exceptions.InvalidDataException;
import data.Color;
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

    public Person getPersonById(long id) {
        for (Person person : MyLittleCollection) {
            if (id == person.getId()) {
                return person;
            }
        }
        return null;
    }

    public void add(Person person) throws InvalidDataException {
        if (!(person.validated())) throw new InvalidDataException();
        if (idIdentifier(person)) {
            person.setId(person.generateId());
        }
        MyLittleCollection.add(person);
    }

    public void updateID(Long id) throws InvalidDataException, NoSuchElementException {
        Person oldPerson = getPersonById(id);
        if (oldPerson == null) {
            throw new NoSuchElementException("Такого человечка нет в коллекции, возможно вы ошиблись");
        }
        MyLittleCollection.remove(oldPerson);
        PersonBuilder person = new PersonBuilder();
        Person newPerson = person.create();
        newPerson.setId(id);
        MyLittleCollection.add(newPerson);
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

    public void getInfo() {
        System.out.println("Сохраняемый тип данных: " + Person.class +
                ", количество человек: " + MyLittleCollection.size() +
                ", дата инициализации:" + localdate);
    }

    public void removeElement(Person person) throws NoSuchElementException {
        if (MyLittleCollection.contains(person)) {
            MyLittleCollection.remove(person);
        } else {
            throw new NoSuchElementException();
        }
    }

    public void reorder() throws EmptyCollectionException {
        if (MyLittleCollection.isEmpty()) throw new EmptyCollectionException();
        Collections.reverse(MyLittleCollection);
        System.out.println("Коллекция перевернулась!");
    }

    public void shuffle() throws EmptyCollectionException {
        if (MyLittleCollection.isEmpty()) throw new EmptyCollectionException();
        Collections.shuffle(MyLittleCollection);
        System.out.println("Коллекция перемешалась!");
    }

    public void showData(Function<Person, Integer> mapper, boolean reversed) throws EmptyCollectionException {
        List<Integer> data = new ArrayList<>(MyLittleCollection.size());
        for (Person person : MyLittleCollection) {
            data.add(mapper.apply(person));
        }
        if (!reversed) {
            Collections.sort(data);
        } else {
            data.sort(Collections.reverseOrder());
        }
        System.out.println(data);
    }

    public void clear() {
        if (MyLittleCollection.isEmpty()) {
            System.err.println("Нельзя очистить то, что пусто. Давайте для начала внесем данные");
        } else {
            MyLittleCollection.clear();
            System.out.println("Коллекция очищена!");
        }
    }

    public void showHairColors() throws EmptyCollectionException {
        Class<Color> colorClass = Color.class;
        Color[] values = colorClass.getEnumConstants();
        List<String> existingHair = new ArrayList<>(MyLittleCollection.size());
        for (Person person : MyLittleCollection) {
            for (int i = 0; i < values.length; i++) {
                if (values[i].equals(person.getHairColor())) {
                    existingHair.add(i, (String.valueOf(person.getHairColor())));
                    break;
                }
            }
        }
        existingHair.sort(Collections.reverseOrder());
        System.out.println(existingHair);
    }

    public void save() {
        if (MyLittleCollection.isEmpty()) {
            System.err.println("Нельзя сохранить то, чего нет. Давайте что-нибудь создадим!");
        } else {
                FileManager.writeFile(MyLittleCollection);
        }
    }
    public void addToCollection(List<Person> people){
        MyLittleCollection.addAll(people);
    }
}


