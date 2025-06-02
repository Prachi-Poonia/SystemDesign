package RateLimiter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowTimestamp implements RateLimiter{

    private final int maxRequests;
    private final long windowSizeMillis;
    private final Map<String, Deque<Long>> requests = new ConcurrentHashMap<>();

    public SlidingWindowTimestamp(int maxRequests, long windowSizeMillis){
        this.maxRequests = maxRequests;
        this.windowSizeMillis = windowSizeMillis;
    }

    @Override
    public synchronized boolean allowRequest(String userId){
        long currentTime = System.currentTimeMillis();
        requests.putIfAbsent(userId,new ArrayDeque<>());
        Deque<Long> timestamps = requests.get(userId);
        while(timestamps.size() > 0 && currentTime - timestamps.peek() >= windowSizeMillis){
            timestamps.pollFirst();
        }
        if(timestamps.size() < maxRequests){
            timestamps.add(currentTime);
            return true;
        }
        return false;
    }
}
