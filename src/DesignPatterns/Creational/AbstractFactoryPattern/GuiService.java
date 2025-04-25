package DesignPatterns.Creational.AbstractFactoryPattern;

import java.util.Scanner;

public class GuiService {
    private static Application configureApplication(String sys){
        Application app;
        GuiFactory factory = null;
        if(sys.equals("MacOS")){
            factory = new MacOSFactory();
        }
        else if (sys.equals("Windows")){
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        return app;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String sys = scn.nextLine();
        Application app = configureApplication(sys);
        app.paint();
    }
}
