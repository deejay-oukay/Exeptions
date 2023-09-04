package dz1.task3;

public class Answer {
    public int[] divArrays(int[] a, int[] b) {
        // Введите свое решение ниже
        if (a.length != b.length) {
            int[] c = new int[1];
            return c;
        }
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (b[i] == 0)
                new RuntimeException(i + "ый элемент массива. Нельзя делить " + a[i] + " на 0");
            c[i] = a[i] / b[i];
        }
        return c;
    }
}
