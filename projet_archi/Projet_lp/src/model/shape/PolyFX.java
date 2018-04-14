package model.shape;

import controller.Controller;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;


public class PolyFX implements MyPolygon {

    private Polygon _polygon;
    private double _space;

    public PolyFX(Polygon polygon){
       this._polygon = polygon;
       this._space = _polygon.getPoints().get(2) - _polygon.getPoints().get(0);
    }

    @Override
    public double get_space() {
		return _space;
	}

	@Override
    public MyShape clone() {
    	PolyFX s = null;
        try {
        	s = (PolyFX) super.clone();
        	double[] thisPoints = new double[this._polygon.getPoints().size()];
        	for(int i = 0; i < this._polygon.getPoints().size(); i++) {
        		thisPoints[i] = this._polygon.getPoints().get(i);
        	}
        	s._polygon = (Polygon) Controller.getInstance().getFactoryDragAndDrop().createPoly(
        			thisPoints);
        	
        }
        catch(CloneNotSupportedException error) {
        	error.printStackTrace(System.err);
        }
        return s;
    }

    @Override
    public void draw(Object root) {
    	if(root instanceof Group)
    		((Group) root).getChildren().addAll(this._polygon);
    }

    @Override
    public Object getShape() {
        return _polygon;
    }

    @Override
    public void add(MyShape g) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void remove(MyShape g) {
        throw new UnsupportedOperationException();

    }

    @Override
    public MyShape getChild(int i) {
        throw new UnsupportedOperationException();
    }

	@Override
	public boolean contains(MyShape s) {
		throw new UnsupportedOperationException();
	}

	@Override
	public MyShape whoContains(Object s) {
		if(s == this.getShape()) {
			return this;
		}
		return null;
	}
}