package Managers;

import Builder.PersonBuilder;
import Exceptions.EmptyCollectionException;
import Exceptions.InvalidDataException;
import MainClasses.Input;
import data.Color;
import data.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;

public class CollectionManager {
    private final LocalDate localdate;

    public CollectionManager() {
        localdate = LocalDate.parse(LocalDate.now().toString());
    }

    private final Vector<Person> MyLittleCollectionOfPeople = new Vector<>();

    public boolean idIdentifier(Person person) {
        for (Person value : MyLittleCollectionOfPeople) {
            if (person.getId() == value.getId()) {
                return false;
            }
        }
        return true;
    }

    public void help() {
        System.out.println("""
                help : вывести справку по доступным командам
                info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                add {element} : добавить новый элемент в коллекцию
                update id {element} : обновить значение элемента коллекции, id которого равен заданному
                remove_by_id id : удалить элемент из коллекции по его id
                clear : очистить коллекцию
                save : сохранить коллекцию в файл
                execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
                exit : завершить программу (без сохранения в файл)
                add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
                shuffle : перемешать элементы коллекции в случайном порядке
                reorder : отсортировать коллекцию в порядке, обратном нынешнему
                print_field_ascending_passport_i_d : вывести значения поля passportID всех элементов в порядке возрастания
                print_field_descending_height : вывести значения поля height всех элементов в порядке убывания
                print_field_descending_hair_color : вывести значения поля hairColor всех элементов в порядке убывания);""");
    }

    public Person getPersonById(long id) {
        for (Person person : MyLittleCollectionOfPeople) {
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
        MyLittleCollectionOfPeople.add(person);
        Collections.sort(MyLittleCollectionOfPeople);
    }

    public void updateID(Long id) throws InvalidDataException, NoSuchElementException {
        Person oldPerson = getPersonById(id);
        if (oldPerson == null) {
            throw new NoSuchElementException("Такого человечка нет в коллекции, возможно вы ошиблись");
        }
        MyLittleCollectionOfPeople.remove(oldPerson);
        PersonBuilder person = new PersonBuilder();
        Person newPerson = person.create();
        newPerson.setId(id);
        MyLittleCollectionOfPeople.add(newPerson);
    }


    public void show() throws EmptyCollectionException {
        if (!MyLittleCollectionOfPeople.isEmpty()) {
            System.out.println("Содержимое коллекции:");
            for (Person i : MyLittleCollectionOfPeople) {
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
                ", количество человек: " + MyLittleCollectionOfPeople.size() +
                ", дата инициализации:" + localdate);
    }

    public void removeElement(Person person) throws NoSuchElementException {
        if (MyLittleCollectionOfPeople.contains(person)) {
            MyLittleCollectionOfPeople.remove(person);
        } else {
            throw new NoSuchElementException();
        }
    }

    public void reorder() throws EmptyCollectionException {
        if (MyLittleCollectionOfPeople.isEmpty()) throw new EmptyCollectionException();
        Collections.reverse(MyLittleCollectionOfPeople);
        System.out.println("Коллекция перевернулась!");
    }

    public void shuffle() throws EmptyCollectionException {
        if (MyLittleCollectionOfPeople.isEmpty()) throw new EmptyCollectionException();
        Collections.shuffle(MyLittleCollectionOfPeople);
        System.out.println("Коллекция перемешалась!");
    }

    public void showData(Function<Person, Integer> mapper, boolean reversed) throws EmptyCollectionException {
        List<Integer> data = new ArrayList<>(MyLittleCollectionOfPeople.size());
        for (Person person : MyLittleCollectionOfPeople) {
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
        if (MyLittleCollectionOfPeople.isEmpty()) {
            System.err.println("Нельзя очистить то, что пусто. Давайте для начала внесем данные");
        } else {
            MyLittleCollectionOfPeople.clear();
            System.out.println("Коллекция очищена!");
        }
    }

    public void showHairColors() throws EmptyCollectionException {
        Class<Color> colorClass = Color.class;
        Color[] values = colorClass.getEnumConstants();
        List<String> existingHair = new ArrayList<>(MyLittleCollectionOfPeople.size());
        for (Person person : MyLittleCollectionOfPeople) {
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
        if (MyLittleCollectionOfPeople.isEmpty()) {
            System.err.println("Похоже у вас в коллекции ничего нет, если вы сохраните пустую коллекцию, то ваше прошлое сохранение уничтожится! Точно ли вы хотите этого?");
            System.out.println("y/n");
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String answer = scanner.nextLine();
                if (answer.equals("y")) {
                    FileManager.clearFile();
                    System.out.println("Сохранение перезаписано");
                    break;
                } else if (answer.equals("n")) {
                    String filePath = System.getenv("FILE_PATH") + "example.xml";
                    MyLittleCollectionOfPeople.addAll(FileManager.readFile(filePath).getPeople());
                    System.out.println("Сохранение восстановлено");
                    return;
                } else {
                    System.err.println("Нет такого варианта ответа :(");
                }
            }
        } else {
            FileManager.writeFile(MyLittleCollectionOfPeople);
        }

    }

    public void addToCollection(List<Person> people) {
        MyLittleCollectionOfPeople.addAll(people);
    }

    public void addIfMax(Long id) {
        Collections.sort(MyLittleCollectionOfPeople);
        if (MyLittleCollectionOfPeople.get(MyLittleCollectionOfPeople.size() - 1).getId() < id) {
            PersonBuilder newPerson = new PersonBuilder();
            Person person = newPerson.create();
            person.setId(id);
            MyLittleCollectionOfPeople.add(person);
        } else {
            System.err.println("Элемент меньше максимального!");
        }
    }
    public void executeScript(String filePath, CommandManager commandManager) {
        try (Scanner scriptScanner = new Scanner(new File(filePath))) {
            while (scriptScanner.hasNextLine()) {
                String commandToSplit = (scriptScanner.nextLine().trim() + " ").toLowerCase();
                String[] commandParts = commandToSplit.split(" ", 2);
                String commandName = commandParts[0];
                String args = (commandParts.length > 1) ? commandParts[1] : "";

                commandManager.execute(commandName, args);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл скрипта не найден: " + filePath);
        } catch (NoSuchElementException e) {
            System.err.println("Ошибка чтения файла скрипта: " + filePath);
        }
    }
}


