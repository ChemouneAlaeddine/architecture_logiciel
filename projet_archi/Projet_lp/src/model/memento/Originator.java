package model.memento;

import model.shape.MyShape;

import java.util.ArrayList;

public class Originator {
    private ArrayList<MyShape> _shapeList;


    public void setList(ArrayList <MyShape> shapeList) {
        this._shapeList = shapeList;
    }

    public ArrayList<MyShape> getList() {
        return _shapeList;
    }

    public Memento saveStateToMemento() {
        return new Memento(_shapeList);
    }

    public void getStateFromMemento(Memento memento) {
        _shapeList = memento.getList();
    }
}