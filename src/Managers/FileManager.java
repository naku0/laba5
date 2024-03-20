package Managers;

import data.Community;
import data.*;

import javax.xml.bind.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    static String filePath = System.getenv("XML_FILE_PATH");

    public static Community readFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("Файл не найден");
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                stringBuilder.append(line).append("\n");
            }
            if (stringBuilder.isEmpty()) {
                System.out.println("Похоже у вас еще нет объектов, давайте создадим парочку!");
            } else {
                JAXBContext context = JAXBContext.newInstance(Community.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                return (Community) unmarshaller.unmarshal(new StringReader(stringBuilder.toString()));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
        } catch (JAXBException e) {
            System.err.println("Что-то пошло не так при чтении из файла, попробуйте снова");
        }
        return null;
    }

    public static void writeFile(List<Person> collection) {
        File file = new File(filePath);
        try {
            if (filePath == null) {
                System.err.println("Переменная окружения XML_FILE_PATH не установлена");
                return;
            }
            if(!(file.length()==0)){
                clearFile();
            }
            Community community = new Community();
            for (Person person : collection) {
                community.addPersonToPeople(person);
                if (!community.getPeople().contains(person)) {
                    community.getPeople().add(person);
                }
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream
                    (new FileOutputStream(filePath, true));

            JAXBContext context = JAXBContext.newInstance(Person.class, Community.class);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mar.marshal(community, bufferedOutputStream);
            bufferedOutputStream.write(System.lineSeparator().getBytes());
            bufferedOutputStream.close();
            System.out.println("Данные успешно записаны в XML файл!");
        } catch (IOException | JAXBException e) {
            System.err.println("Что-то пошло не так при записи в файл, попробуйте снова");
        } catch (SecurityException e) {
            System.err.println("Недостаточно прав доступа для доступа к переменной окружения или файлу");
        }
    }
    public static void clearFile() {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write("");
            fileWriter.close();
        }catch (IOException e){
            System.err.println("При очистке файл произошла ошибка");
        }
    }
}
