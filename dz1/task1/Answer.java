package dz1.task1;

public class Answer {
    public static void arrayOutOfBoundsException() {
        // Напишите свое решение ниже
        int[] arr = { 1, 5, 4, 2, 3 };
        System.out.println(arr[5]);
    }

    public static void divisionByZero() {
        // Напишите свое решение ниже
        int a = 1;
        int b = 0;
        System.out.println(a / b);
    }

    public static void numberFormatException() {
        // Напишите свое решение ниже
        String str = "abc";
        int num = Integer.parseInt(str);
    }
}