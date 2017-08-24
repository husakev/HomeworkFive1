package moduleFive1;

import java.util.Scanner;

/**
 * Created by Евгений on 16.08.2017.
 */
public class Snowman {
    static int count, min, max, num;

    public static void main(String[] args) {
        System.out.println("Введите количествохорошо кругов, от 3  до 6");
        count = scanner();
        while (count > 6 || count < 3) {
            System.out.println("Вы ввели не допустимое значение количества кругов, введите " +
                    "количествохорошо кругов, от 3  до 7");
            count = scanner();
        }
        System.out.println("Введите минимальный радиус кругов, от 15  до 40");
        min = scanner();
        while (min > 40 || min < 15) {
            System.out.println("Вы ввели не допустимое значение минимального радиуса " +
                    "кругов, введите мин радиус кругов, от 15  до 40");
            min = scanner();
        }
        System.out.println("Введите максимальный радиус кругов, от 40  до 80");
        max = scanner();
        while (max > 80 || max < 40) {
            System.out.println("Вы ввели не допустимое значение максимального радиуса " +
                    "кругов, введите максимальный радиус кругов, от 40  до 80");
            max = scanner();
        }
        Window.main();
    }

    public static int scanner() {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            num = s.nextInt();
            break;
        }
        return num;
    }
}