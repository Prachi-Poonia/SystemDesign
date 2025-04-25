package DesignPatterns.Creational.SingletonPattern.NaiveSingleton;

public class ApplicationMultiThreaded {
    public static void main(String[] args){
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable{
        @Override
        public void run(){
            Singleton instance = Singleton.getInstance("FOO");
            System.out.println(instance.value);
        }
    }

    static class ThreadBar implements Runnable{
        @Override
        public void run(){
            Singleton instance = Singleton.getInstance("BAR");
            System.out.println(instance.value);
        }
    }
}
