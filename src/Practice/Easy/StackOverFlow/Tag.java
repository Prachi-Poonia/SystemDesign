package Practice.Easy.StackOverFlow;

import lombok.Data;

import java.util.UUID;

@Data
public class Tag {
    private final UUID id;
    private final String name;

    public Tag(String name){
        this.id = UUID.randomUUID();
        this.name = name;
    }
}
