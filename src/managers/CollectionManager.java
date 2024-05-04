package managers;

import builder.PersonBuilder;
import data.Color;
import exceptions.*;
import data.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;

/**
 * Класс, хранящий и взаимодействующий с коллекцией
 */
public class CollectionManager {
    private final LocalDate localdate;

    public CollectionManager() {
        localdate = LocalDate.parse(LocalDate.now().toString());
    }

    private final Vector<Person> myLittleCollectionOfPeople = new Vector<>();


    /**
     * Метод, проверяющий уникальность id
     *
     * @param person объект, передаваемый в метод
     * @return true, если id уникальный, false, если нет
     */
    public boolean idIdentifier(Person person) {
        for (Person value : myLittleCollectionOfPeople) {
            if (person.getId() == value.getId()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Метод, показывающий сводку по командам
     */

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
                print_field_ascending_passport_id : вывести значения поля passportID всех элементов в порядке возрастания
                print_field_descending_height : вывести значения поля height всех элементов в порядке убывания
                print_field_descending_hair_color : вывести значения поля hairColor всех элементов в порядке убывания);
                """);
    }

    /**
     * Позволяет найти объект, id которого равен введенному
     *
     * @param id id, вводимый пользователем
     * @return объект, id которого равен введенному
     */
    public Person getPersonById(long id) {

        for (Person person : myLittleCollectionOfPeople) {
            if (id == person.getId()) {
                return person;
            }
        }
        return null;
    }

    /**
     * Метод, добавляющий новый элемент в коллекцию
     *
     * @param person объект, который будет добавлен в коллекцию
     * @throws InvalidDataException неверно введенные данные
     */
    public void add(Person person) throws InvalidDataException {
            if (!(person.validated())) throw new InvalidDataException();
            if (idIdentifier(person)) {
                person.setId(person.generateId());
            }
            myLittleCollectionOfPeople.add(person);
        Collections.sort(myLittleCollectionOfPeople);
    }

    /**
     * Метод, обновляющий элемент коллекции
     *
     * @param id id элемента
     * @throws InvalidDataException   неверно введенные данные
     * @throws NoSuchElementException отсутствие элемента в коллекции
     */
    public void updateID(Long id) throws InvalidDataException, NoSuchElementException {
        Collections.sort(myLittleCollectionOfPeople);
        Person oldPerson = getPersonById(id);
        if (oldPerson == null) {
            throw new NoSuchElementException("Такого человечка нет в коллекции, возможно вы ошиблись\n");
        }
        myLittleCollectionOfPeople.remove(oldPerson);
        PersonBuilder person = new PersonBuilder();
        Person newPerson = person.create();
        newPerson.setId(id);
        myLittleCollectionOfPeople.add(newPerson);
    }

    /**
     * Метод, выводящий содержимое коллекции
     *
     * @throws EmptyCollectionException отсутствие элементов в коллекции
     */
    public void show() throws EmptyCollectionException {

        if (!myLittleCollectionOfPeople.isEmpty()) {
            System.out.println("Содержимое коллекции:");
            for (Person i : myLittleCollectionOfPeople) {
                System.out.println(i);
            }
        } else {
            throw new EmptyCollectionException();
        }
    }

    /**
     * Получить информацию о коллекции
     */
    public void getInfo() {
        System.out.println("Сохраняемый тип данных: " + Person.class +
                ", количество человек: " + myLittleCollectionOfPeople.size() +
                ", дата инициализации:" + localdate);
        System.out.println("\n");

    }

    /**
     * Удалит элемент по его id
     *
     * @param person объект, который будет удален
     * @throws NoSuchElementException отсутствие элемента в коллекции
     */
    public void removeElement(Person person) throws NoSuchElementException {
        if (myLittleCollectionOfPeople.contains(person)) {
            myLittleCollectionOfPeople.remove(person);
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Отсортировать элементы коллекции в обратном порядке
     */
    public void reorder() throws EmptyCollectionException {
        if (myLittleCollectionOfPeople.isEmpty()) throw new EmptyCollectionException();
        Collections.reverse(myLittleCollectionOfPeople);
        System.out.println("Коллекция перевернулась!\n");
    }

    /**
     * Отсортировать элементы коллекции в случайном порядке
     */
    public void shuffle() throws EmptyCollectionException {
        if (myLittleCollectionOfPeople.isEmpty()) throw new EmptyCollectionException();
        Collections.shuffle(myLittleCollectionOfPeople);
        System.out.println("Коллекция перемешалась!\n");
    }

    /**
     * Показать количество элементов в коллекции по заданному критерию
     *
     * @param mapper   маппер который применится к каждому элементу коллекции
     * @param reversed показывать ли коллекцию в обратном порядке
     * @throws EmptyCollectionException отсутствие элементов в коллекции
     */
    public void showData(Function<Person, Integer> mapper, boolean reversed) throws EmptyCollectionException {
        Collections.sort(myLittleCollectionOfPeople);
        List<Integer> data = new ArrayList<>();
        for (Person person : myLittleCollectionOfPeople) {
            data.add(mapper.apply(person));
        }
        if (!reversed) {
            Collections.sort(data);
        } else {
            data.sort(Collections.reverseOrder());
        }
        System.out.println(data);
    }

    /**
     * Очистка коллекции
     */
    public void clear() {
        if (myLittleCollectionOfPeople.isEmpty()) {
            System.err.println("Нельзя очистить то, что пусто. Давайте для начала внесем данные\n");
        } else {
            myLittleCollectionOfPeople.clear();
            System.out.println("Коллекция очищена!\n");
        }
    }

    /**
     * Показать цвета волос
     * @throws EmptyCollectionException если коллекция пустая
     */
    public void showHairColors() throws EmptyCollectionException {
        Queue<Color> sortedUsedColors = new PriorityQueue<>(Collections.reverseOrder());
        myLittleCollectionOfPeople.forEach(e->sortedUsedColors.add(e.getHairColor()));
        System.out.println(sortedUsedColors);
    }

    /**
     * Сохранение коллекции в xml
     */
    public void save() {
        Collections.sort(myLittleCollectionOfPeople);
        try {
            if (myLittleCollectionOfPeople.isEmpty()) {
                System.err.println("Похоже у вас в коллекции ничего нет, если вы сохраните пустую коллекцию, то ваше прошлое сохранение уничтожится! Точно ли вы хотите этого?\n");
                System.out.println("y/n\n");
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    String answer = scanner.nextLine();
                    if (answer.equals("y")) {
                        FileManager.clearFile();
                        System.out.println("Сохранение перезаписано");
                        break;
                    } else if (answer.equals("n")) {
                        String filePath = System.getenv("FILE_PATH") + "example.xml";
                        myLittleCollectionOfPeople.addAll(FileManager.readFile(filePath).getPeople());
                        System.out.println("Сохранение восстановлено");
                        return;
                    } else {
                        System.err.println("Нет такого варианта ответа :(");
                    }
                }
            } else {
                FileManager.writeFile(myLittleCollectionOfPeople);
            }
        } catch (NullPointerException e) {
            System.out.println("Что-то пошло не так, попробуйте снова\n");
        } catch (WritePermissionDenied e){
            System.err.println("Не могу записать в файл:(");
        }catch (ReadPermissionDenied e){
            System.err.println("Не могу прочитать из файла:(");
        }
    }

    /**
     * Метод, добавляющий объекты из файла в коллекцию
     * @param people объекты из файла
     */
    public void addToCollection(List<Person> people) {
        if (checkId(people)) {
            myLittleCollectionOfPeople.addAll(people);
        } else {
            System.err.println("что-то не так с файлом, данные не подгрузились\n");
        }
    }

    /**
     * Метод, проверяющий на одинаковые id в коллекции
     * @param people коллекция людей
     * @return true, если все id уникальны, и false если нет
     */
    public boolean checkId(List<Person> people) {
        HashSet<Long> idCollection = new HashSet<>();
        if (people.size() != 1) {
            for (Person person : people) {
                if (!idCollection.contains(person.getId())) {
                    idCollection.add(person.getId());
                } else {
                    return false;
                }
            }
        }
        return true;

    }

    /**
     * Добавит новый элемент в коллекцию, если его поле минимально
     *
     * @param height рост человека, добавляемый в коллекцию
     */

    public void addIfMax(Integer height) throws InvalidDataException {
        if (myLittleCollectionOfPeople.get(myLittleCollectionOfPeople.size() - 1).getHeight() < height) {
            PersonBuilder newPerson = new PersonBuilder();
            Person person = newPerson.create();
            person.setHeight(height);
            add(person);
        } else {
            System.err.println("Элемент меньше максимального!\n");
        }
    }

    public static Scanner reader;

    /**
     * Сохраняем скрипт
     *
     * @param filePath        путь до скрипта
     * @param commandManager  Менеджер команд, где хранятся команды для скрипта
     * @param executedScripts выполненные скрипты
     */
    public void executeScript(String filePath, CommandManager commandManager, LinkedList<String> executedScripts) throws FileNotFoundException, RecursionException {
        executedScripts.add(filePath);
        File scriptFile = new File(filePath);
        if (!scriptFile.exists()) throw new FileNotFoundException();
        if (!scriptFile.canRead()) throw new IllegalArgumentException();
        try (Scanner scriptScanner = new Scanner(scriptFile)) {
            reader = scriptScanner;
            while (scriptScanner.hasNextLine()) {
                String commandToSplit = (scriptScanner.nextLine().trim() + " ").toLowerCase();
                String[] commandParts = commandToSplit.split(" ", 2);
                String commandName = commandParts[0];
                String args = (commandParts.length > 1) ? commandParts[1].trim() : "";
                if (commandName.equals("execute_script") && executedScripts.contains(args)) throw new RecursionException();
                commandManager.execute(commandName, args);
            }
            executedScripts.removeLast();
        } catch (NoSuchElementException e) {
            System.err.println("Некорректный ввод, что-то не так с файлом скрипта!\n");
        } catch (IllegalStateException e) {
            System.err.println("Чиним программу, можете продолжать работу\n");
        }
    }
}


