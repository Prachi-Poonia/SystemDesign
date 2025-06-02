package DesignPatterns.Behavioural.Observer;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel {
    List<Observer> subscribers = new ArrayList<>();

    public void subscribe(Observer o){
        subscribers.add(o);
    }

    public void unsubscribe(Observer o){
        subscribers.remove(o);
    }

    public void uploadVideo(String title){
        System.out.println("New video uploaded " + title);
        updateSubscribers("New video: "+title);
    }

    private void updateSubscribers(String message){
        for(Observer o : subscribers){
            o.update(message);
        }
    }
}
