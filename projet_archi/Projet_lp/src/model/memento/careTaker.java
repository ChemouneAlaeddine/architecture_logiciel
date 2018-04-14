package model.memento;

import java.util.ArrayList;
import java.util.List;

public class careTaker {
    private List<Memento> _mementoList = new ArrayList<Memento>();

    public void add(Memento shapeList){
        _mementoList.add(shapeList);
    }

    public Memento get(int index){
        return _mementoList.get(index);
    }
}