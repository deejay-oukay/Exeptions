package dz3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        inputData();
    }

    private static void errorCodes(int code, String moreInfo) {
        String[] codes = {
                "Недостаточное количество данных: %s вместо 6",
                "Излишнее количество данных: %s вместо 6",
                "Дата введена в формате, отличающемся от ДД.ММ.ГГГГ: %s",
                "Некорректное число при указании даты рождения: %s",
                "В номере телефона присутсвуют символы, не являющиеся цифрами: %s",
                "Слишком короткий номер телефона: %s",
                "Слишком длинный номер телефона: %s",
                "Зафиксирована попытка ЛГБТ-пропоганды. Указан пол %s вместо m или f",
                "Что-то пошло не так при записи в файл"
        };
        System.out.printf(codes[code] + "\n", moreInfo);
    }

    private static void errorCodes(int code) {
        errorCodes(code, "");
    }

    private static void inputData() {
        Scanner in = new Scanner(System.in);
        boolean need2stop = false;
        String[] data;
        while (!need2stop) {
            System.out.println(
                    "Введите через пробел Фамилию, Имя, Отчество, Дату рождения в формата ДД.ММ.ГГГГ, Номер телефона только из цифр, Пол (m или f). Для выхода введите 'exit'");
            data = in.nextLine().split(" ");
            if (data[0].equals("exit")) {
                need2stop = true;
                System.out.println("Всего доброго!");
            } else if (data.length < 6) {
                // Приложение должно проверить введенные данные по количеству. Если количество
                // не совпадает с требуемым, вернуть код ошибки, обработать его и показать
                // пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
                errorCodes(0, Integer.toString(data.length));
            } else if (data.length > 6) {
                errorCodes(1, Integer.toString(data.length));
            } else {
                // Приложение должно попытаться распарсить полученные значения и выделить из них
                // требуемые параметры. Если форматы данных не совпадают, нужно бросить
                // исключение, соответствующее типу проблемы. Можно использовать встроенные типы
                // java и создать свои. Исключение должно быть корректно обработано,
                // пользователю выведено сообщение с информацией, что именно неверно.
                String[] tempBD = data[3].split("\\.");
                if (tempBD.length != 3)
                    errorCodes(2, data[3]);
                else {
                    Integer[] birthday = new Integer[3];
                    for (int i = 0; i < tempBD.length; i++) {
                        try {
                            birthday[i] = Integer.parseInt(tempBD[i]);
                        } catch (NumberFormatException e) {
                            errorCodes(3, tempBD[i]);
                        }
                    }
                    try {
                        Double phone = Double.parseDouble(data[4]);
                        if (phone < 100)
                            errorCodes(5, Double.toString(phone));
                        else {
                            if (!data[5].equals("m") && (!data[5].equals("f")))
                                errorCodes(7, data[5]);
                            else {
                                // Если всё введено и обработано верно, должен создаться файл с названием,
                                // равным фамилии, в него в одну строку должны записаться полученные данные,
                                // вида
                                // <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
                                // Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
                                try (
                                        // Не забудьте закрыть соединение с файлом.
                                        FileWriter fw = new FileWriter(data[0], true);
                                        BufferedWriter bw = new BufferedWriter(fw)) {
                                    bw.write("<" + data[0] + "><" + data[1] + "><" + data[2] + "><"
                                            + Integer.toString(birthday[0]) + "." + Integer.toString(birthday[1]) + "."
                                            + Integer.toString(birthday[2]) + "." + "><" + Double.toString(phone)
                                            + "><" + data[5] + ">\n");
                                    System.out.println("Успешно сохранено...");
                                } catch (IOException e) {
                                    // При возникновении проблемы с чтением-записью в файл, исключение должно быть
                                    // корректно обработано, пользователь должен увидеть стектрейс ошибки.
                                    errorCodes(8);
                                    Thread.dumpStack();
                                }

                            }

                        }
                    } catch (NumberFormatException e) {
                        errorCodes(4, data[4]);
                    } catch (IndexOutOfBoundsException e) {
                        errorCodes(6, data[4]);
                    }
                }
            }

        }
        in.close();
    }
}
