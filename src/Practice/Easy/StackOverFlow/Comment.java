package Practice.Easy.StackOverFlow;

import java.util.Date;
import java.util.UUID;

public class Comment {
    private final int commentId;
    private final String content;
    private final User user;
    private final Date creationDate;

    public Comment(String content, User user){
        commentId = generateId();
        this.content = content;
        this.user = user;
        this.creationDate = new Date();
    }

    private int generateId(){
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }
}
