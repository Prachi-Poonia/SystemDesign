package DesignPatterns.Structrual.Composite;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent{
    private final String name;
    private final List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name){
        this.name = name;
    }

    public void add(FileSystemComponent component){
        components.add(component);
    }

    @Override
    public void showDetails(){
        System.out.println("Folder: " + name);
        for(FileSystemComponent c : components){
            c.showDetails();
        }
    }
}
