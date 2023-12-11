package matviishyn_LB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Клас matviishyn_LB - створення та запис матриці з двома різними символами у файл.
 *  @param args
 *  @throws FileNotFoundException Виняток, який виникає, якщо файл "MyFile.txt" не знайдено або не створено.
 */
public class matviishyn_LB {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int nRows = getMatrixSize(in);
        char[][] arr = new char[nRows][nRows];
        String filler1 = getFillerSymbol("перший", in);
        String filler2 = getFillerSymbol("другий", in);
        writeMatrixToFile(nRows, arr, filler1, filler2);
        printMatrixToConsole(nRows, arr);
    }

    /**
     * Метод для створення та запису матриці у файл
     *
     * @param nRows   Розмір матриці.
     * @param arr     Двовимірний масив матриці.
     * @param filler1 Перший символ-заповнювач.
     * @param filler2 Другий символ-заповнювач.
     * @throws FileNotFoundException Виняток, який виникає, якщо файл "MyFile.txt" не знайдено або не створено.
     */
    public static void writeMatrixToFile(int nRows, char[][] arr, String filler1, String filler2) throws FileNotFoundException {
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nRows; j++) {
                char filler = (i % 2 == 0) ? filler1.charAt(0) : filler2.charAt(0);
                arr[i][j] = filler;
                fout.print(arr[i][j] + " ");
            }

            fout.println();
        }

        fout.close();
    }
    
    
    /**
     * Метод для виведення матриці в консоль.
     *
     * @param nRows Розмір матриці.
     * @param arr   Двовимірний масив матриці.
     */
    public static void printMatrixToConsole(int nRows, char[][] arr) {
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nRows; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Метод для отримання розміру квадратної матриці.
     *
     * @return Розмір квадратної матриці.
     */
    public static int getMatrixSize(Scanner in) {
        int nRows;
        do {
            nRows = readIntegerInput("Введіть розмір матриці: ", in);
            in.nextLine(); 
        } while (nRows <= 0);
        return nRows;
    }

    /**
     * Метод для отримання символу-заповнювача.
     *
     * @param order Номер символу-заповнювача (перший або другий).
     * @return Символ-заповнювач.
     */
    public static String getFillerSymbol(String order, Scanner in) {
        String filler;
        do {
            filler = readStringInput("Введіть " + order + " символ-заповнювач (лише один символ): ", in);
        } while (filler.length() != 1);
        return filler;
    }

    /**
     * Метод для зчитування цілого числа з клавіатури.
     *
     * @param prompt Повідомлення, яке виводиться перед введенням.
     * @return Введене ціле число.
     */
    public static int readIntegerInput(String message, Scanner in) {
        System.out.print(message);
        while (!in.hasNextInt()) {
            System.out.print("Будь ласка, введіть коректне ціле число: ");
            in.nextLine();
        }
        return in.nextInt();
    }

    /**
     * Метод для зчитування рядка з клавіатури.
     *
     * @param message Повідомлення, яке виводиться перед введенням.
     * @return Введений рядок.
     */
    public static String readStringInput(String message, Scanner in) {
        System.out.print(message);
        return in.nextLine();
    }
}
//219 176