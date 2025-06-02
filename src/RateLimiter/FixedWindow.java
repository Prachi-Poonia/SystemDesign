package RateLimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FixedWindow implements RateLimiter{
    private final int maxRequests;
    private final Map<String,Integer> userRequestCount = new ConcurrentHashMap<>();
    private final long windowSizeMillis;
    private volatile long windowStart;

    public FixedWindow(int maxRequests, long windowSizeMillis){
        this.windowSizeMillis = windowSizeMillis;
        this.maxRequests = maxRequests;
        this.windowStart = System.currentTimeMillis();
    }


    @Override
    public synchronized boolean allowRequest(String userId){
        long currentTime = System.currentTimeMillis();
        // If the current time exceeds the window, reset the window and all user counts
        if(currentTime - windowStart >= windowSizeMillis){
            userRequestCount.clear();
            windowStart = currentTime;
        }
        userRequestCount.put(userId, userRequestCount.getOrDefault(userId,0)+1);
        if(userRequestCount.get(userId) <= maxRequests){
            return true;
        }
        return false;
    }
}
