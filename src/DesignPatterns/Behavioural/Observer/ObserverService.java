package DesignPatterns.Behavioural.Observer;

public class ObserverService {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();

        Observer alice = new Subscriber("Alice");
        Observer bob = new Subscriber("Bob");
        Observer charlie = new Subscriber("Charlie");

        // Subscribe users
        channel.subscribe(alice);
        channel.subscribe(bob);

        // First video upload
        channel.uploadVideo("Design Patterns in Java");

        // New subscriber joins
        channel.subscribe(charlie);

        // Second video upload
        channel.uploadVideo("Observer Pattern Explained");

        // Bob unsubscribes
        channel.unsubscribe(bob);

        // Third video upload
        channel.uploadVideo("Spring Boot Tutorial");
    }
}
