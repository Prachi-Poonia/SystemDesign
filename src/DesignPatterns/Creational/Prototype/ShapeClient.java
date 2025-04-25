package DesignPatterns.Creational.Prototype;

public class ShapeClient {
    private Shape shapePrototype;

    public ShapeClient(Shape shapePrototype){
        this.shapePrototype = shapePrototype;
    }
    public Shape construct(){
        return shapePrototype.clone();
    }
}
