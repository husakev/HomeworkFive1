package moduleFive1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import static moduleFive1.WindowSnowman.*;
/**
 * Created by Евгений on 29.08.2017.
 */
/*  Дополнительные задания
    Убрать ввод с консоли и заменить его на UI элементы (кнопки и поля для ввода)
    Добавить кнопку - покрасить все круги в красный. Она красит все ранее нарисованные круги
     в красный цвет.
    Добавить кнопку - Gradient. Она красит все круги начиная от нижнего к верхнему серыми
оттенками. К примеру нижний круг полностью черный, а каждый круг выше становиться более
светлым. И в конечном счете верхний круг снеговика должен быть светло серым. */
public class Additionali extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    public static Circle[] circleRgb(int count) {
        double rgb = 0.0;
        double sum = 0.9 / (count - 1);
        for (int i = 0; i < count; i++) {
            Color color = Color.color(rgb, rgb, rgb);
            rgb = sum + rgb;
            circle[i].setFill(Paint.valueOf(color.toString()));
        }
        return circle;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Snowman");
        Pane pane = new Pane();
        TextField count = new TextField();
        TextField min = new TextField();
        TextField max = new TextField();
        Button buttonNext = new Button("Next");
        Button buttonRed = new Button("Red");
        Button buttonGradient = new Button("Gradient");
        count.setLayoutX(5);
        count.setLayoutY(5);
        min.setLayoutX(5);
        min.setLayoutY(35);
        max.setLayoutX(5);
        max.setLayoutY(65);
        buttonNext.setTranslateX(500);
        buttonNext.setTranslateY(100);
        buttonRed.setTranslateX(500);
        buttonRed.setTranslateY(550);
        buttonGradient.setTranslateX(500);
        buttonGradient.setTranslateY(600);
        scene = new Scene(pane, wind, wind);
        javafx.scene.text.Text textCount = new javafx.scene.text.Text("- Введите " +
                "количество кругов, от 3  до 6");// я не понял как я это написал
        javafx.scene.text.Text textMin = new javafx.scene.text.Text("- Введите" +
                " минимальный радиус кругов, от 15  до 35");
        javafx.scene.text.Text textMax = new javafx.scene.text.Text("- Введите " +
                "максимальный радиус кругов, от 40  до 80");
        textCount.setX(160);
        textCount.setY(20);
        textMin.setX(160);
        textMin.setY(50);
        textMax.setX(160);
        textMax.setY(80);

        buttonNext.setOnAction((event) -> {
            pane.getChildren().clear();
            Snowman.count = Integer.parseInt(count.getText());
            Snowman.min = Integer.parseInt(min.getText());
            Snowman.max = Integer.parseInt(max.getText());
            pane.getChildren().addAll(circle(Snowman.count));

            pane.getChildren().addAll(WindowSnowman.face(3));
            pane.getChildren().addAll(buttonRed);
            pane.getChildren().addAll(buttonGradient);
            buttonRed.setOnAction(event1 -> {

                for (int i = 0; i < Snowman.count; i++) {
                    circle[i].setFill(Color.RED);
                }
            });
            buttonGradient.setOnAction(event1 -> {
                circleRgb(Snowman.count);
            });

            primaryStage.setScene(scene);
        });
        primaryStage.setScene(scene);
        pane.getChildren().addAll(count, min, max, textCount, textMin, textMax, buttonNext);
        primaryStage.show();

    }
}
