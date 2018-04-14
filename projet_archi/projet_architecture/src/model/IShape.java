package model;

public interface IShape extends Cloneable{
	public IShape clone();
    public void draw(Object root);
    public void setColor(Color color);
    public void addChild(IShape shape);
  	public void removeChild(IShape shape);
    public IShape getChild(int i);
    //public boolean contains(IShape s);
    //public IShape whoContains(Object s);
}
