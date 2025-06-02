package RateLimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiterService {
    Map<String,RateLimiter> userMap = new ConcurrentHashMap<>();

    public void registerUser(String userId, String type, int maxRequests, long windowSizeMillis){
        userMap.put(userId, RateLimiterFactory.createRateLimiter(type,maxRequests,windowSizeMillis));
    }

    public boolean allowRequest(String userId){
        RateLimiter rateLimiter = userMap.get(userId);
        return rateLimiter.allowRequest(userId);
    }
}
