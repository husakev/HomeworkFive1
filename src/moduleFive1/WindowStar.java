package moduleFive1;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
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

        double xpoints[] = {//x - r * 0.23,
                265.5,
                //x,
                300,
                //x + r * 0.23,
                334.5,
                //x + r * 0.95,
                442.5,
                //x + r * 0.36,
                354,
                //x + r * 0.59,
                388.5,
                //x,
                300,
                //x - r * 0.59,
                211,
                //x - r * 0.36,
                246,
                //x - r * 0.95
                158};
        double ypoints[] = {//y - r * 0.31,
                254,
                //y - r,
                150,
                //y - r * 0.31,
                253.5,
                //y - r * 0.31,
                253.5,
                //y + r * 0.09,
                313.5,
                //y + r * 0.75,
                412.5,
                //y + r * 0.34,
                351,
                //y + r * 0.75,
                412.5,
                //y + r * 0.09,
                313.5,
                //y - r * 0.31
                253.5};
        gc.strokePolygon(xpoints, ypoints, xpoints.length);
    }

}
