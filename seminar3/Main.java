package seminar3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.management.RuntimeErrorException;

public class Main {
    public static void main(String[] args) {
        // try {
        // doSomething();
        // } catch (Exception e) {
        // System.out.println("catch some exeption");
        // }

        // Создайте класс Счетчик, у которого есть метод add(), увеличивающий
        // значение внутреннейint переменнойна 1.Сделайте так, чтобы с объектом
        // такого типа можно было работать в блоке try-with-resources. Нужно бросить
        // исключение, еслиработа с объектом типа счетчикбылане в ресурсномtry
        // и/или ресурс остался открыт.Подумайте какой тип исключения подойдет
        // лучше всего.
        // try (Counter count = new Counter()) {
        // count.add();
        // count.printCount();
        // } catch (Exception e) {
        // System.out.println("error");
        // }

        try {
            tryFile();
            nullArray();
            zeroDivider();
        } catch (EmptyArrayElementException e) {
            System.out.println(e);
        } catch (ZeroDivException e) {
            System.out.println(e);
        } catch (CantFindFileException e) {
            System.out.println(e);
        }

    }

    // Создайте метод doSomething(), который может быть источником одного из
    // типов checked exceptions (тело самогометода прописывать не обязательно).
    // Вызовите этот метод из main и обработайте в нем исключение, которое
    // вызвалметод doSomething().
    // private static void doSomething() throws Exception {
    // throw new Exception("something wrong");
    // };

    // 1. Создайте класс исключения, который будет выбрасываться при делении на 0.
    // Исключение должно отображать понятное для пользователя сообщение об ошибке.
    private static void zeroDivider() throws ZeroDivException {
        try {
            int a = 1 / 0;
        } catch (ArithmeticException e) {
            throw new ZeroDivException("can't divide by zero");
        }

    }

    // 2. Создайте класс исключений, которое будет возникать при обращении к пустому
    // элементу в массиве ссылочного типа. Исключение должно отображать понятное для
    // пользователя сообщениеоб ошибке
    private static void nullArray() throws EmptyArrayElementException {
        Integer[] arr = { 1, 2, null, 9, 23 };
        try {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
                arr[i]++;
            }
        } catch (NullPointerException e) {
            throw new EmptyArrayElementException("null element not valid");
        }
    }
    // 3. Создайте класс исключения, которое будет возникать при попытке открыть
    // несуществующий файл. Исключение должно отображать понятное для пользователя
    // сообщение об ошибке.

    private static void tryFile() throws CantFindFileException {
        try (FileReader fr = new FileReader("qwerty")) {
            fr.read();
            int a = 0;
        } catch (FileNotFoundException e) {
            throw new CantFindFileException("there is no such file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
