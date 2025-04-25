package DesignPatterns.Creational.SingletonPattern.NaiveSingleton;

public class Singleton {
    private static Singleton instance;
    public String value;

    private Singleton(String value){
        //slow initialization : faking a situation where the constructor is slow, helps test if your implementation is truly thread-safe under concurrent access
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static Singleton getInstance(String value){
        if(instance == null){
            instance = new Singleton(value);
        }
        return instance;
    }

}
