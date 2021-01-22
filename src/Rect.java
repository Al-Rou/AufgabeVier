import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.HashMap;

public class Rect implements Figure {
    HashMap<Double, Double> centerList = new HashMap<Double, Double>();

    public void setCenter(double x, double y) {
        centerList.put(Double.valueOf(x), Double.valueOf(y));
    }

    public Double getCenter(double x) {
        return centerList.get(Double.valueOf(x));
    }

    @Override
    public void repaint(GraphicsContext gc, double x, double y, double diameter) {
        gc.setFill(Color.RED);
        gc.fillRect(x, y, diameter/1.4, diameter/1.4);
    }

    @Override
    public boolean containsPoint(double x, double y) {
        for(Double dx: centerList.keySet())
        {
            if (Math.abs(Double.valueOf(x)-dx) < (10/1.4))
            {
                    if (Math.abs(Double.valueOf(y)-centerList.get(dx)) < (10/1.4))
                    {
                        return true;
                    }

                return false;
            }
        }
        return false;
    }
}
