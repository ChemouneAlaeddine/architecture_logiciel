package model.memento;

import model.shape.MyShape;

import java.util.ArrayList;

public class Memento {
    private ArrayList<MyShape> _shapeList;

    public ArrayList<MyShape> getList() {
        return _shapeList;
    }


    @SuppressWarnings("unchecked")
	public Memento(ArrayList<MyShape> shapeList) {
        this._shapeList = (ArrayList<MyShape>) shapeList.clone();
    }
}