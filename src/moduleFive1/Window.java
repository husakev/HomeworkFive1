package moduleFive1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Created by Евгений on 05.08.2017.
 */
/* Задание 1. Создать оконное приложение на JavaFX. Необходимо нарисовать снеговика
исходя из пожеланий пользователя. Снеговик состоит из кругов. Каждый последующий
круг находиться над предыдущим, касаясь его(!). Если круг будет налазить на другой
круг, либо между ними будетпробел - значит снеговик отрисован не верно. Радиусы
кругов рандомизированы. Цвета кругов должны быть рандомизированы. На голове снеговик
(верхний круг) из кругов должен быть отрисован нос и 2 глаза (меньше головы). Круги
на теле должны быть рандомизированы. Нет последовательности на уменьшение или
увеличение. Данные вводятся через консоль: кол-во кругов, мин. радиус круга, макс.
радиус круга */
public class Window extends Application {
    static double wind = 680;
    static Circle[] circle;

    public static void main(String... args) {
        launch(args);
    }

    public static Circle[] face(int parts) {
        Circle[] circleF = new Circle[parts];
        double radius = circle[circle.length - 1].getRadius();
        Color color = Color.color(Math.random(), Math.random(), Math.random());
        circleF[0] = new Circle(wind / 2,
                circle[circle.length - 1].getCenterY() + (radius / 3),
                5 + Math.random() * (radius / 3),
                Paint.valueOf(color.toString()));
        circleF[1] = new Circle((wind / 2) - (radius / 3),
                circle[circle.length - 1].getCenterY() - (radius / 3),
                3 + Math.random() * (radius / 5),
                Paint.valueOf(color.toString()));
        circleF[2] = new Circle((wind / 2) + (radius / 2),
                circle[circle.length - 1].getCenterY() - (radius / 3),
                3 + Math.random() * (radius / 5),
                Paint.valueOf(color.toString()));
        return circleF;
    }

    public static Circle[] circle(int count) {
        circle = new Circle[count];
        for (int i = 0; i < circle.length; i++) {
            double radius = Snowman.min + Math.random() * Snowman.max;
            Color color = Color.color(Math.random(), Math.random(), Math.random());
            if (i == 0) {
                circle[i] = new Circle(wind / 2, wind - radius - 39, radius,
                        Paint.valueOf(color.toString())); // -39 из-за того что 1 круг перекрывает
            }                                         // немного. Можете убрать и увидете
            else {
                circle[i] = new Circle(wind / 2,
                        circle[i - 1].getCenterY() - circle[i - 1].getRadius()
                                - radius, radius, Paint.valueOf(color.toString()));
            }
        }
        return circle;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Snowman");
        primaryStage.setWidth(wind);
        primaryStage.setHeight(wind);
        Pane pane = new Pane();
        pane.getChildren().addAll(circle(Snowman.count));
        pane.getChildren().addAll(face(3));
        Button button = new Button();
        Scene scene = new Scene(pane);
        button.setTranslateX(600);
        button.setTranslateY(600);
        button.setText("show");
        button.setOnMouseClicked(event -> {
            pane.getChildren().clear();
            pane.getChildren().addAll(circle(Snowman.count));
            pane.getChildren().addAll(face(3));
            pane.getChildren().addAll(button);
        });
        pane.getChildren().addAll(button);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}