import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainClass extends Application {

    public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void init() throws Exception
    {

    }
    @Override
    public void stop() throws Exception
    {

    }
    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Awesome Game!");

        View view = new View();
        Rect rect = new Rect();
        Circle circle = new Circle();
        //FigureComposite figure = new FigureComposite();
        view.addHandler(rect, circle);

        Scene scene = new Scene(view, 640, 581);
        stage.setScene(scene);
        stage.show();
    }
}
