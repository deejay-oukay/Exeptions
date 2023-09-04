package dz2.task4;

import java.util.Scanner;

// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = "";
        while (line.isEmpty()) {
            try {
                System.out.print("Введите что-нибудь: ");
                line = in.nextLine();
            } catch (RuntimeException e) {
                System.out.println("Пустые строки вводить нельзя...");
            }
        }
        in.close();
    }

}
