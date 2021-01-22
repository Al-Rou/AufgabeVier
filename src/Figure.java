import javafx.scene.canvas.GraphicsContext;

public interface Figure {
    void repaint(GraphicsContext gc, double x, double y, double diameter);
    boolean containsPoint(double x, double y);
}
