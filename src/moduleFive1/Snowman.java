package moduleFive1;

import java.util.Scanner;

/**
 * Created by Евгений on 16.08.2017.
 */
public class Snowman {
    static int count, min, max, num;

    public static void main(String[] args) {
        System.out.println("Введите количество кругов, от 3  до 6");
        count = scanner();
        while (count > 6 || count < 3) {
            System.out.println("Вы ввели не допустимое значение количества кругов, введите " +
                    "количествохорошо кругов, от 3  до 7");
            count = scanner();
        }
        System.out.println("Введите минимальный радиус кругов, от 15  до 35");
        min = scanner();
        while (min > 35 || min < 15) {
            System.out.println("Вы ввели не допустимое значение минимального радиуса " +
                    "кругов, введите мин радиус кругов, от 15  до 45");
            min = scanner(); // если максимальное значение минимального и минимальное значение
        } // максимального 40 с делать, после ввола минимального значения 40, в максимальное
        System.out.println("Введите максимальный радиус кругов, от 40  до 80"); // значение
        max = scanner(); // можно хоть буквы вбивать работать будет. очень странно, можете
        while (max > 80 || max < 40) { // попробовать
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