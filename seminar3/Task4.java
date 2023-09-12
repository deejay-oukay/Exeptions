package seminar3;

public class Task4 {

    private static int summator2000(String[][] matrix) throws MyArraySizeException, MyArrayDataException {
        // 1. Напишите метод, на вход которого подаётся двумерный строковый массив
        // размером 4х4. При подаче массива другого размера необходимо бросить
        // исключение MyArraySizeException.
        if ((matrix.length != matrix[0].length) || (matrix.length != 4))
            throw new MyArraySizeException(
                    "this matrix is " + matrix.length + "x" + matrix[0].length + ", should be 4x4");

        // 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int
        // и просуммировать. Если в каком-то элементе массива преобразование не удалось
        // (например, в ячейке лежит символ или текст вместо числа), должно быть брошено
        // исключение MyArrayDataException с детализацией, в какой именно ячейке лежат
        // неверныеданные.
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    sum += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("elem[%d][%d] is wrong: %s", i, j, matrix[i][j]));
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // 3. В методе main() вызвать полученный метод, обработать возможные исключения
        // MyArraySizeException и MyArrayDataException и вывести результат расчета
        // (сумму элементов, при условии что подали на вход корректный массив).
        String[][] array = { { "1", "2", "3", "4" },
                { "1", "2", "3", "4" },
                { "1", "2", "3", "4" },
                { "1", "2", "3", "4" } };

        String[][] array1 = { { "1", "2", "3", "4" },
                { "1", "2", "3", "4" },
                { "1", "2", "3", "4" },
                { "1", "2", "3", "4" },
                { "1", "2", "3", "4" } };

        String[][] array2 = { { "1", "2", "3", "4" },
                { "1", "2", "3", "4" },
                { "1", "2", "3", "4" },
                { "1", "2", "ihhi", "4" } };
        try {
            System.out.println(summator2000(array));
            System.out.println(summator2000(array2));
            System.out.println(summator2000(array1));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
    }
}
