import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class FigureComposite implements Figure {
    private List<Figure> figureList = new ArrayList<>();
    public static int misclickCounter = 0;

    public List<Figure> getFigureList()
    {
        return figureList;
    }
    public void add(Figure figure)
    {
        figureList.add(figure);
    }
    @Override
    public void repaint(GraphicsContext gc, double x, double y, double diameter) {

    }

    @Override
    public boolean containsPoint(double x, double y) {
        return false;
    }
}
