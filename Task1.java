// Реализуйте структуру телефонной книги с помощью HashMap, 
// учитывая, что один человек может иметь несколько телефонов.

package Homework5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();
        phoneBook.put("Nick", List.of("+1 (555) 123456", "+1 (555) 777666"));
        phoneBook.put("Kate", List.of("+1 (555) 001101", "+1 (555) 990990"));
        phoneBook.put("John", List.of("+1 (555) 011233"));
        phoneBook.put("Lucy", List.of("+1 (555) 808080"));
        menu(phoneBook);
    }

    public static String scanner() {
        Scanner sc = new Scanner(System.in);
        String scan = sc.nextLine();
        // sc.close(); ?
        return scan;
    }

    public static void find(Map<String, List<String>> phoneBook) {
        System.out.println("Введите имя: ");
        String name = scanner();
        System.out.println(phoneBook.get(name));
    }

    public static void allBook(Map<String, List<String>> phoneBook) {
        System.out.println(phoneBook);
    }

    public static Map<String, List<String>> add(Map<String, List<String>> phoneBook) {
        System.out.println("Для остановки введите команду: 'stop' ");
        System.out.println("Введите имя: ");
        String name = scanner();
        List<String> number = new ArrayList<>();
        while (true) {
            System.out.println("Введите номер: ");
            String phone = scanner();
            if (phone.equals("stop")) {
                break;
            } else {
                number.add(phone);
            }
        }
        phoneBook.put(name, number);
        return phoneBook;
    }

    public static Map<String, List<String>> menu(Map<String, List<String>> phoneBook) {
        System.out.println(
                "Введите команду из списка: find - найти контакт, add - добавить контакт, all - показать все контакты, exit - выйти");
        while (true) {
            String commands = scanner();
            if (commands.equals("exit")) {
                break;
            } else {
                switch (commands) {
                    case "find":
                        find(phoneBook);
                        break;
                    case "add":
                        add(phoneBook);
                        break;
                    case "all":
                        allBook(phoneBook);
                        break;
                    default:
                        break;
                }
            }
        }
        return phoneBook;
    }
}