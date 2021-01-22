import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class View extends VBox {

    Button start;
    TextField diameter;
    //ListView<String> listView;
    Label result;
    Canvas canvas;
    GraphicsContext gc;
    int width = 640;
    int height = 480;
    FigureComposite figure = new FigureComposite();

    public View() {
        start = new Button("start");
        diameter = new TextField("Type here, what diameter you prefer!");
        //listView = new ListView<>();
        result = new Label("Figures: "+figure.getFigureList().size()+"\n"
        +"Missclicks: "+"\n"+"Time left: ");

        canvas = new Canvas(width, height);
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.GREENYELLOW);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        this.getChildren().addAll(start, diameter, result, canvas);
    }
    public void addHandler(Rect rect, Circle circle)
    {
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if(event.getButton() == MouseButton.PRIMARY)
            {
                if ((!rect.containsPoint(event.getX(), event.getY())) && (!circle.containsPoint(event.getX(), event.getY()))) {
                    rect.repaint(canvas.getGraphicsContext2D(), event.getX() - (10 / 1.4),
                            event.getY() - (10 / 1.4), 20);
                    figure.add(rect);
                    rect.setCenter(event.getX(), event.getY());
                    result.setText("Figures: " + figure.getFigureList().size() + "\n"
                            + "Missclicks: " +FigureComposite.misclickCounter+ "\n" + "Time left: ");
                }
                else
                {
                    FigureComposite.misclickCounter++;
                }
            }
            else if(event.getButton() == MouseButton.SECONDARY)
            {
                if ((!rect.containsPoint(event.getX(), event.getY())) && (!circle.containsPoint(event.getX(), event.getY()))) {
                    circle.repaint(canvas.getGraphicsContext2D(), event.getX() - (10 / 1.4),
                            event.getY() - (10 / 1.4), 20);
                    figure.add(circle);
                    circle.setCenter(event.getX(), event.getY());
                    result.setText("Figures: " + figure.getFigureList().size() + "\n"
                            + "Missclicks: " +FigureComposite.misclickCounter+ "\n" + "Time left: ");
                }
                else
                {
                    FigureComposite.misclickCounter++;
                }
            }
        });
    }

}
