package Practice.UrlShortener;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class UrlShortenerService {
    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int BASE = 62;
    private static final int DEFAULT_EXPIRY_TIME = 7;
    private final Map<String, URL> urlMap = new HashMap<>();
    private final Map<String, String> reverseMap = new HashMap<>();
    private long idCounter = 1;

    public String encode(String longUrl, String customURL, Integer expiryDays) {
        if (reverseMap.containsKey(longUrl)) {
            return reverseMap.get(longUrl);
        }
        String shortUrl;
        if(customURL != null && !urlMap.containsKey(customURL)){
            shortUrl = customURL;
        }
        else{
            shortUrl = toBase62(idCounter);
        }

        int days = (expiryDays != null) ? expiryDays : DEFAULT_EXPIRY_TIME;
        LocalDateTime expiryTime = LocalDateTime.now().plusDays(days);

        urlMap.put(shortUrl, new URL(longUrl,expiryTime));
        reverseMap.put(longUrl, shortUrl);
        idCounter++;

        return shortUrl;
    }

    public String decode(String shortUrl) {
        URL URL = urlMap.get(shortUrl);
        if(URL == null || URL.getExpirationTime().isBefore(LocalDateTime.now())){
            urlMap.remove(shortUrl);
            return "URL not found or expired";
        }
        return URL.getLongURL();
    }

    public boolean deleteUrl(String shortUrl) {
        if (urlMap.containsKey(shortUrl)) {
            URL longUrl = urlMap.remove(shortUrl);
            reverseMap.remove(longUrl.getLongURL());
            return true;
        }
        return false;
    }

    private String toBase62(long deci) {
        StringBuilder hashStr = new StringBuilder();
        while (deci > 0) {
            int index = (int) (deci % BASE);
            hashStr.insert(0, BASE62.charAt(index));
            deci /= BASE;
        }
        return hashStr.toString();
    }
}
