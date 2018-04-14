package model;

import javafx.scene.shape.Rectangle;

public class CRectangle implements IShape {
	
	private Rectangle _rectangle;
	
	public CRectangle(Rectangle _rectangle) {
		this._rectangle = _rectangle;
	}

	
	@Override
	public IShape clone() {
		CRectangle s = null;
        try {
        	s = (CRectangle) super.clone();
        	/*s._rectangle = (Rectangle) Controller.getInstance().getFactoryDragAndDrop().createRect(
        			this._rectangle.getX(), this._rectangle.getY(),
        			this._rectangle.getWidth(), this._rectangle.getHeight());*/
        }
        catch(CloneNotSupportedException error) {
        	error.printStackTrace(System.err);
        }
        return s;
	}

	@Override
	public void draw(Object root) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addChild(IShape shape) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeChild(IShape shape) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IShape getChild(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
