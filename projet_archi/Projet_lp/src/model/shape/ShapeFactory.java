package model.shape;

public interface ShapeFactory {
	Object createRect(double x, double y, double width, double height);
	Object createPoly(double x, double y, double space);
	Object createPoly(double[] points);
}