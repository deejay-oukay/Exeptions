package dz1.task2;

public class Answer {
    public int[] subArrays(int[] a, int[] b) {
        // Введите свое решение ниже
        if (a.length != b.length) {
            int[] c = new int[1];
            return c;
        }
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] - b[i];
        }
        return c;
    }
}