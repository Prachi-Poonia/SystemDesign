package Practice.UrlShortener;

import java.time.LocalDateTime;

public class URL {
    private String longURL;
    private LocalDateTime expirationTime;

    public URL(String longURL, LocalDateTime expirationTime){
        this.longURL = longURL;
        this.expirationTime = expirationTime;
    }

    public String getLongURL(){
        return longURL;
    }

    public LocalDateTime getExpirationTime(){
        return expirationTime;
    }
}
