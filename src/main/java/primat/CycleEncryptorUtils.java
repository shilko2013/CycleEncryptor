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
                if (count < 1 || count > 511) {
                    outputStream.println("Количество информационных символов должно быть от 1 до 511.");
                    throw new IllegalArgumentException();
                }
                outputStream.println("Количество информационных символов введено.");
                return count;
            } catch (Exception e) {
                outputStream.println("Ошибка ввода, повторите ввод.");
                in.nextLine();
            }
        }
    }

    private static String readCombination(PrintStream outputStream, InputStream inputStream, int lenght) {
        Scanner in = new Scanner(inputStream);
        while (true) {
            try {
                outputStream.print("Введите комбинацию: ");
                String combination = in.next();
                if (combination.length() != lenght) {
                    outputStream.println("Неверная длина комбинации - ожидалось " + lenght + ".");
                    throw new IllegalArgumentException();
                }
                if (combination.chars()
                        .filter(code -> (char) code != '0' && (char) code != '1')
                        .count() != 0) {
                    outputStream.println("Комбинация может состоять только из нулей и едениц.");
                    throw new IllegalArgumentException();
                }
                outputStream.println("Комбинация введена.");
                return combination;
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
            String combination = readCombination(System.out, System.in, count);
            CycleEncryptor cycleEncryptor = new CycleEncryptor(count);
            try {
                System.out.println(cycleEncryptor.decode(combination));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }

    public static double log2(double arg) {
        return log(arg)/log(2);
    }
}
