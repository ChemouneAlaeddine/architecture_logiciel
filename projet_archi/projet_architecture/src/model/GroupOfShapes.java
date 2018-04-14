package model;

import java.util.ArrayList;
//import java.util.Iterator;

public class GroupOfShapes implements IShape {

	ArrayList<IShape> shapes;
	//Iterator<Shape> itr = shapes.iterator(); 
	
	public void AddShape(IShape shape) {
		shapes.add(shape);
	}
	
	public void Remove(IShape shape) {
		shapes.remove(shape);
	}

}
