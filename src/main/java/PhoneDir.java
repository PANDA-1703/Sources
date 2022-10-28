import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneDir {

    HashMap<String, String> phoneBook = new HashMap<String, String>();
    static Scanner terminal = new Scanner(System.in);

    //addPhone - добавить номер
    public void addPhone(){
        System.out.println("Введите номер телефона(формата dd-dd-dd): ");
        String phoneNumber = terminal.next();
        while(!validationPhone(phoneNumber)){
            System.out.println("Неверный ввод.\nПовторите:");
            phoneNumber = terminal.next();
        }
        System.out.println("Введите имя: ");
        String name = terminal.next();
        while(!validationName(name)){
            System.out.println("Неверный ввод.\nПовторите: ");
            name = terminal.next();
        }
        phoneBook.put(phoneNumber, name);
    }

    //validationPhone - номер в формате dd-dd-dd
    public boolean validationPhone(String phoneNumber){
        return Pattern.matches("\\d{2}-\\d{2}-\\d{2}", phoneNumber);
    }
    //validationName - имя начинается с буквы и max длина 15 символов
    public boolean validationName(String name) { // проверка имени
        return Pattern.matches("^[a-zA-Z].{0,14}$", name);
    }

    //delPhone - удалить номер
    public void delPhone(){
        System.out.println("Введите номер, который хотите удалить: ");
        String phoneNumber = terminal.next();
        while(!validationPhone(phoneNumber)){
            System.out.println("Неверный ввод.\nПовторите:");
            phoneNumber = terminal.next();
        }
        if(!phoneBook.isEmpty()){
            phoneBook.remove(phoneNumber);
            System.out.println("Успешно!");
        }else{
            System.out.println("Ошибка!");
        }
    }

    //findPhone - найти запись
    public void findPhone(){
        System.out.println("Введите номер, который хотите найти в справочнике: ");
        String phoneNumber = terminal.next();
        if(phoneBook.containsKey(phoneNumber)){
            System.out.println("Найдено:\n" + "Name: " + phoneBook.get(phoneNumber) + ", Phone: " + phoneNumber);
        }else{
            System.out.println("Запись не найдена!");
        }
    }

    //listPhone - вывод списка справочника
    public void listPhone(){
        System.out.println("Телефонный справочник: ");
        for (Map.Entry entry : phoneBook.entrySet()) {
            System.out.println("Телефон: " + entry.getKey() + " Имя: " + entry.getValue());
        }
    }

    //exit - выйти
    public void exit(){
        exit();
    }

    public void inputSwitch(String input){
        switch (input){
            case ("add"):
                addPhone();
                break;
            case ("del"):
                delPhone();
                break;
            case ("find"):
                findPhone();
                break;
            case ("list"):
                listPhone();
                break;
            case ("exit"):
                exit();
                break;
        }
    }

    public void launch() {
        System.out.println("Доступные действия:\n" +
                "add - Добавить номер\n" +
                "del - Удалить номер\n" +
                "find - Найти запись по номеру\n" +
                "list - Вывести весь список номеров\n" +
                "exit - Выйти");
        String input = " ";
        while (input != "exit") {
            System.out.println("Введите дейстие: ");
            input = terminal.next();
            inputSwitch(input);
        }
    }


    public static void main(String[] args){
            PhoneDir phone = new PhoneDir();
            phone.launch();
    }
}
