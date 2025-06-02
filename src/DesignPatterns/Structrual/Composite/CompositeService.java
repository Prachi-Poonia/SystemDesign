package DesignPatterns.Structrual.Composite;

public class CompositeService {
    public static void main(String[] args){
        Folder root = new Folder("Root");
        File file1 = new File("file1");
        File file2 = new File("file2");
        Folder subFolder = new Folder("subFolder");

        subFolder.add(file2);
        root.add(file1);
        root.add(subFolder);

        root.showDetails();
    }
}
