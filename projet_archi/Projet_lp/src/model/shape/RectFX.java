package model.shape;

import controller.Controller;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;


public class RectFX implements MyRectangle {

    private Rectangle _rectangle;

    public RectFX(Rectangle rectangle){
        this._rectangle = rectangle;
    }

    @Override
    public Object getShape() {
        return _rectangle;
    }

    @Override
    public MyShape clone() {
    	RectFX s = null;
        try {
        	s = (RectFX) super.clone();
        	s._rectangle = (Rectangle) Controller.getInstance().getFactoryDragAndDrop().createRect(
        			this._rectangle.getX(), this._rectangle.getY(),
        			this._rectangle.getWidth(), this._rectangle.getHeight());
        }
        catch(CloneNotSupportedException error) {
        	error.printStackTrace(System.err);
        }
        return s;
    }

    @Override
    public void draw(Object root) {
    	if(root instanceof Group)
    		((Group) root).getChildren().addAll(this._rectangle);
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