package Practice.Easy.StackOverFlow;

import lombok.Data;

@Data
public class Vote {
    private final User user;
    private final int value;

    public Vote(User user, int value) {
        this.user = user;
        this.value = value;
    }
}
