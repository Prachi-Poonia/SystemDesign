package DesignPatterns.Creational.Prototype;

public class Circle implements Shape{
    private String color;

    public Circle(String color){
        this.color = color;
    }

    @Override
    public Shape clone(){
        return new Circle(this.color);
    }

    @Override
    public void draw(){
        System.out.println("You drew a circle of color :" + color);
    }
}
