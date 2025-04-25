package Practice.UrlShortener;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/url")
public class UrlController {
    private final UrlShortenerService urlShortenerService;

    public UrlController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping("/createURL")
    public String createURL(@RequestParam String longURL, @RequestParam(required = false) String customURL,
                            @RequestParam(required = false)Integer expiryDays){
        return urlShortenerService.encode(longURL,customURL,expiryDays);
    }

    @GetMapping("/retrieveUrl/{shortUrl}")
    public String retrieveUrl(@PathVariable String shortUrl){
        return urlShortenerService.decode(shortUrl);
    }

    @DeleteMapping("/deleteUrl/{shortUrl}")
    public ResponseEntity<String> deleteUrl(@PathVariable String shortUrl){
        boolean deleted = urlShortenerService.deleteUrl(shortUrl);
        return deleted ? ResponseEntity.ok("URL deleted successfully") : ResponseEntity.noContent().build();
    }
}
