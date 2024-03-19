package Managers;

import Exceptions.EmptyCollectionException;
import data.Person;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import java.io.*;
import java.util.Collection;
import java.util.Scanner;

public class FileManager {

    public static void readFile(String filePath) {
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line); // обработка прочитанных данных
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
        }
    }

    public static void writeToXmlFile(Collection<Person> object, Person person) {
        String filePath = System.getenv("XML_FILE_PATH");
        try {
            if (filePath == null) {
                System.err.println("Переменная окружения XML_FILE_PATH не установлена");
                return;
            }
            if (object.isEmpty()) throw new EmptyCollectionException();
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Marshaller mar= context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(person, new File(filePath));
            System.out.println("Данные успешно записаны в XML файл!");
        } catch (JAXBException e) {
            System.err.println("Что-то пошло не так при записи в файл, попробуйте снова" );
        } catch (SecurityException e) {
            System.err.println("Недостаточно прав доступа для доступа к переменной окружения или файлу");
        } catch (EmptyCollectionException e) {
            System.err.println("Нельзя сохранить то, чего нет. Давайте что-нибудь создадим!");
        }
    }
}
