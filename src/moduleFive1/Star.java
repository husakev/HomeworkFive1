package moduleFive1;

import java.util.Scanner;

/**
 * Created by Евгений on 24.09.2017.
 */

public class Star {
    static int x, y, rad, num;

    public static void main(String[] args) {
        System.out.println("Введите радиус звезды, от 100 до 340");
        rad = scanner();
        while (rad < 100 || rad > 340) {
            System.out.println("Вы ввели не допустимое значение радиуса, введите радиус " +
                    "звезды, от 100 до 340");
            rad = scanner();
        }
        System.out.println("Введите x центра звезды, от радиуса звезды до 340");
        x = scanner();
        while (x < rad || x > 340) {
            System.out.println("Вы ввели не допустимое значение x центра звезды, введите " +
                    "x центра звезды, от радиуса звезды до 340");
            x = scanner();
        }
        System.out.println("Введите y центра звезды, от радиуса  до 340");
        y = scanner();
        while (y < rad || y > 340) {
            System.out.println("Вы ввели не допустимое значение y центра звезды введите " +
                    "y центра звезды, от радиуса  до 340");
            y = scanner();
        }
        WindowStar.main();
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
