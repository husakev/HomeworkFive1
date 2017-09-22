package moduleFive1;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Created by Евгений on 01.09.2017.
 */
public class WindowStar extends Application {
    public static Circle circle = new Circle(300, 300, 150);

    public static void main(String... args) {

        launch(args);
    }

    public void start() throws Exception {
        start();
    }

    public void start(Stage primaryStage) throws Exception  {

        Pane root = new Pane();

        Canvas canvas = new Canvas(600, 600);


        root.getChildren().add(canvas);

        Scene scene = new Scene(root, 600, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawStarShape(gc);

        primaryStage.setTitle("Star");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawStarShape(GraphicsContext gc) {
        double x = circle.getCenterX();
        double y = circle.getCenterY();
        double r = circle.getRadius();

        double xpoints[] = {x - r * 0.23,
                x,
                x + r * 0.23,
                x + r * 0.95,
                x + r * 0.24,
                x + r * 0.81,
                x,
                x - r * 0.59,
                x - r * 0.24,
                x - r * 0.95};
        double ypoints[] = {y - circle.getRadius() *
                y - r,
                y - r * 0.31,
                y - r * 0.31,
                y + r * 0.07,
                y + r * 0.59,
                y + r * 0.4,
                y + r * 0.81,
                y + r * 0.07,
                y - r * 0.31};
        gc.strokePolygon(xpoints, ypoints, xpoints.length);
    }

}
