package DesignPatterns.Creational.Prototype;

public class ShapeService {
    public static void main(String[] args){
        Shape circlePrototype = new Circle("red");
        ShapeClient client = new ShapeClient(circlePrototype);
        circlePrototype.clone();
        Shape shape = client.construct();
        shape.draw();
    }
}
