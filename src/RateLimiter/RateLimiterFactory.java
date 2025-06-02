package RateLimiter;

public class RateLimiterFactory {
    public static RateLimiter createRateLimiter(String type, int maxRequest, long windowSizeMillis){
        return switch (type) {
            case "fixed" -> new FixedWindow(maxRequest,windowSizeMillis);
            case "slidingWindow" -> new SlidingWindowTimestamp(maxRequest,windowSizeMillis);
            case "tokenBucket" -> new TokenBucket(maxRequest, (1.0 * maxRequest/windowSizeMillis * 1000)); // refillRate -> token per second
            default -> throw new IllegalArgumentException("Unknown type");
        };
    }
}
