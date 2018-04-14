package model.shape;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class ShapeFX implements ShapeFactory{
    @Override
    public Object createRect(double x, double y, double width, double height) {
    	Rectangle rectangle = new Rectangle(x, y, width, height);
        rectangle.setFill(Color.BLUE);
        return rectangle;
    }

    @Override
    public Object createPoly(double x, double y, double space) {
    	Polygon polygon = new Polygon(new double[] {
    			x, y, x+space, y-space,
    			x+space*2, y, x+(3*space/2), y+space,
    			x+(space/2), y+space
        });
        polygon.setFill(Color.BLUE);
        return polygon;
    }

	@Override
	public Object createPoly(double[] points) {
		Polygon polygon = new Polygon(points);
        polygon.setFill(Color.BLUE);
        return polygon;
	}
}