package dz2.task1;

import java.util.Scanner;

// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
public class main {
    public static void main(String[] args) {
        System.out.println("Было успешно введено число: " + enterNumber());
    }

    private static float enterNumber() {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите дробное число: ");
                return (Float.parseFloat(in.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println("Ошибка при вводе числа. Повторите попытку...");
            }
        }
    }

}
