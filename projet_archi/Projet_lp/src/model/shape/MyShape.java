package model.shape;


public interface MyShape extends Cloneable {
    MyShape clone();
    void draw(Object root);
    void add(MyShape g);
    void remove(MyShape g);
    MyShape getChild(int i);
    boolean contains(MyShape s);
    MyShape whoContains(Object s);
}