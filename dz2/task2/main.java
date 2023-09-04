package dz2.task2;
// Если необходимо, исправьте данный код (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)

public class main {
    public static void main(String[] args) {
        // см. комментарии в методе someMethod()
    }

    private void someMethod() {
        try {
            // если d всегда равно 0, то дальнейший код особого смысла не имеет, т.к. без
            // каких-либо условий всегда будет ошибка из-за деления на 0
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (NumberFormatException e) {
            // по названию массива не стоит судить о типе данных его элементов :-)
            System.out.println("Для строки не применимы арифметические операции: " + e);
        } catch (IndexOutOfBoundsException e) {
            // длина массива нам неизвестна, но известен индекс элемента, к которому будет
            // (точнее не будет) попытка обращения
            System.out.println("Элемент с индексом 8 в массиве отсутсвует: " + e);
        } catch (ArithmeticException e) {
            // здесь либо правим комментарий к ошибке, либо выше делаем условие с проверкой
            // на то, не ноль ли в делители
            System.out.println("Catching exception: " + e);
        }

    }
}
