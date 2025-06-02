package DesignPatterns.Structrual.Decorator;

// base decorator is needed to allow chaining of multiple decorators and provide a common interface
//it is made abstract because it does not have any real behaviour and just a template, it forces subclasses to define specific behaviours
abstract class CoffeeDecorator implements Coffee{
    protected Coffee coffee;
    public CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }
}
