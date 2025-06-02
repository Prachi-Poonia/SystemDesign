package RateLimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenBucket implements RateLimiter{

    private final int capacity;
    private final double refillRate;
    private final Map<String,Integer> userToken = new ConcurrentHashMap<>();
    private final Map<String,Long> lastUserRefillTime = new ConcurrentHashMap<>();

    public TokenBucket(int capacity, double refillRate){
        this.capacity = capacity;
        this.refillRate = refillRate;
    }

    @Override
    public synchronized boolean allowRequest(String userId){
        long currentTime = System.currentTimeMillis();
        lastUserRefillTime.putIfAbsent(userId,currentTime);
        userToken.putIfAbsent(userId,capacity);
        long lastRefillTime = lastUserRefillTime.get(userId);
        long elapsedTime = (currentTime - lastRefillTime) / 1000;
        if(elapsedTime > 0){
            int newToken = Math.min(capacity, userToken.get(userId) + (int)(elapsedTime * refillRate));
            userToken.put(userId,newToken);
            lastUserRefillTime.put(userId,currentTime);
        }
        if(userToken.get(userId) > 0){
            userToken.put(userId, userToken.get(userId) - 1);
            return true;
        }
        return false;
    }

}
