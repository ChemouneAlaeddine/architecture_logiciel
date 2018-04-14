package model.shape;

import java.util.ArrayList;

public class ConcreteShapeGroup implements MyShape {
	
	private ArrayList<MyShape> _listShapeGroup;
	
	public ConcreteShapeGroup() {
		_listShapeGroup = new ArrayList<MyShape>();
	}

    @Override
    public MyShape clone() {
    	MyShape s = null;
        try {
        	s = (MyShape) super.clone();
        }
        catch(CloneNotSupportedException error) {
        	error.printStackTrace(System.err);
        }
        return s;
    }

    @Override
    public void draw(Object root) {
    	for(MyShape each : _listShapeGroup) {
    		each.draw(root);
    	}
    }

    @Override
    public void add(MyShape g) {
    	_listShapeGroup.add(g);
    }

    @Override
    public void remove(MyShape g) {
    	_listShapeGroup.remove(g);
    }

    @Override
    public MyShape getChild(int i) {
        return _listShapeGroup.get(i);
    }

	@Override
	public MyShape whoContains(Object s) {
		MyShape result = null;
		for(MyShape each : _listShapeGroup) {
    		if(each.whoContains(s) != null) {
    			return each.whoContains(s);
    		}
    	}
		return result;
	}

	@Override
	public boolean contains(MyShape s) {
		if(_listShapeGroup.contains(s)) {
			return true;
		}
		return false;
	}
}