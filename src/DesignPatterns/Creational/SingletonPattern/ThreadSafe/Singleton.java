package DesignPatterns.Creational.SingletonPattern.ThreadSafe;

public final class Singleton { //class is marked final so that no other class can extend it and create another object of this class
    private static volatile Singleton instance; //volatile -> whenever any thread changes instance it should be visible to all other threads immediately
    public String value;

    private Singleton(String value){
        this.value = value;
    }

    public static Singleton getInstance(String value){
        //Multiple threads (program parts) can try to create the Singleton at the same time, First, we check if instance already exists (like checking if light is ON).
        //If yes, return it quickly (no locking).
        //If no, we lock (synchronized) so that only one thread creates the object.
        //After the object is created, everyone else just uses the created object without locking.
        //The approach taken here is called double-checked locking (DCL)
        Singleton result = instance; //result variable -> Accessing a local variable is faster than accessing a volatile field multiple times.
        if(result != null){
            return result;
        }
        synchronized (Singleton.class){ //synchronized prevents multiple threads from running the same piece of code at the same time
            if(instance == null){
                instance = new Singleton(value);
            }
            return instance;
        }
    }
}
