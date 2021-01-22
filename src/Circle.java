import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.HashMap;

public class Circle implements Figure {
    HashMap<Double, Double> centerList = new HashMap<Double, Double>();

    public void setCenter(double x, double y) {
        centerList.put(Double.valueOf(x), Double.valueOf(y));
    }

    public Double getCenter(double x) {
        return centerList.get(Double.valueOf(x));
    }

    @Override
    public void repaint(GraphicsContext gc, double x, double y, double diameter) {
        gc.setFill(Color.BLUE);
        gc.fillOval(x, y, diameter, diameter);

    }

    @Override
    public boolean containsPoint(double x, double y) {
        for(Double dx: centerList.keySet()) {
            if (Math.sqrt(Math.pow(Double.valueOf(x) - dx, 2) + Math.pow(Double.valueOf(y) - centerList.get(dx), 2)) < 10) {
                return true;
            }
        }
        return false;
    }
}
