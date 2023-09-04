package seminar2.task3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
        String path = "seminar2\\task3\\data.txt";
        writeFile(changeLetter(readFile(path)), path);

    }

    public static List<String[]> readFile(String path) {
        List<String[]> result = new ArrayList<String[]>();
        try {
            BufferedReader file = new BufferedReader(new FileReader(path));
            String line = "";
            while ((line = file.readLine()) != null) {
                String[] temp = line.split("=");
                if (!(temp[1].equals("?")) && (!isNumeric(temp[1]))) {
                    throw new RuntimeException("Некорректные данные: " + line);
                }
                result.add(temp);
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static List<String[]> changeLetter(List<String[]> data) {
        for (String[] line : data) {
            if (line[1].equals("?"))
                line[1] = String.valueOf(line[0].length());
        }
        return data;
    }

    public static void writeFile(List<String[]> data, String path) {
        try {
            BufferedWriter file = new BufferedWriter(new FileWriter(path));
            for (String[] line : data) {
                file.write(line[0] + "=" + line[1]);
                file.newLine();
            }
            file.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
