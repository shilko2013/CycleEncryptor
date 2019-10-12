package primat;

import java.io.*;
import java.util.Scanner;

import static java.lang.Math.log;

public class CycleEncryptorUtils {

    public static void printHeader(PrintStream printStream) {
        printStream.println("Программа для циклического кодирования.");
        printStream.println("Для начала работы");
    }

    private static int readCount(PrintStream outputStream, InputStream inputStream) {
        Scanner in = new Scanner(inputStream);
        while (true) {
            try {
                outputStream.print("Введите количество информационных символов: ");
                int count = in.nextInt();
                outputStream.println("Количество информационных символов введено.");
                return count;
            } catch (Exception e) {
                outputStream.println("Ошибка ввода, повторите ввод.");
                in.nextLine();
            }
        }
    }

    private static int readDistance(PrintStream outputStream, InputStream inputStream) {
        Scanner in = new Scanner(inputStream);
        while (true) {
            try {
                outputStream.print("Введите кодовое расстояние: ");
                int distance = in.nextInt();
                outputStream.println("Кодовое расстояние символов введено.");
                return distance;
            } catch (Exception e) {
                outputStream.println("Ошибка ввода, повторите ввод.");
                in.nextLine();
            }
        }
    }

    private static int readCombination(PrintStream outputStream, InputStream inputStream, int lenght) {
        Scanner in = new Scanner(inputStream);
        while (true) {
            try {
                outputStream.print("Введите комбинацию: ");
                String combination = in.next();
                if (combination.length() != lenght) {
                    outputStream.println("Неверная длина комбинации - ожидалось " + lenght + ".");
                    throw new IllegalArgumentException();
                }
                outputStream.println("Комбинация введена.");
                return Integer.parseInt(combination, 2);
            } catch (Exception e) {
                outputStream.println("Ошибка ввода, повторите ввод.");
                in.nextLine();
            }
        }
    }

    public static void main(String... args) {
        printHeader(System.out);
        while (true) {
            int count = readCount(System.out, System.in);
            int combination = readCombination(System.out, System.in, count);
            CycleEncryptor cycleEncryptor = new CycleEncryptor(count, readDistance(System.out, System.in));
            System.out.println(cycleEncryptor.decode(combination));
            System.out.println();
        }
    }

    public static double log2(double arg) {
        return log(arg)/log(2);
    }
}
