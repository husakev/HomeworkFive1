package moduleFive1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import static moduleFive1.Star.*;
/* решение звезды нашел тут http://zetcode.com/gui/javafx/canvas/ просто немного переделал,
сам решить не смог(  */
/**
 * Created by Евгений on 01.09.2017.
 */
/* Создать оконное приложение на JavaFX
Необходимо отрисовать правильную пятиконечную звезду исходя из пожеланий пользователя
Данные вводятся через консоль:
X центра звезды
Y центра звезды
радиус звезды (расстояние от центра звезды до любого ее конца) */
public class WindowStar extends Application {
    public static Circle circle = new Circle(x, y, rad);

    public static void main(String... args) {

        launch(args);
    }
    public void start(Stage primaryStage) throws Exception  {

        Pane pane = new Pane();
        Canvas canvas = new Canvas(680, 680);


        pane.getChildren().add(canvas);

        Scene scene = new Scene(pane);
        GraphicsContext gc = canvas.getGraphicsContext2D();// я не понял что это такое
        drawStarShape(gc);

        primaryStage.setTitle("Star");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawStarShape(GraphicsContext gc) {
        double x = circle.getCenterX();
        double y = circle.getCenterY();
        double r = circle.getRadius();

        double xpoints[] = {x - r * 0.23, x, x + r * 0.23, x + r * 0.95, x + r * 0.36,
                x + r * 0.59, x, x - r * 0.59, x - r * 0.36, x - r * 0.95};
        double ypoints[] = {y - r * 0.31, y - r, y - r * 0.31, y - r * 0.31, y + r * 0.09,
                y + r * 0.75, y + r * 0.34, y + r * 0.75, y + r * 0.09, y - r * 0.31};
        gc.strokePolygon(xpoints, ypoints, xpoints.length); // не  понял что это
    }
//ох и намучался с точками
}
