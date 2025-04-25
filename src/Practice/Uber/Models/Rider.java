package Practice.Uber.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rider {
    private UUID riderId;
    private String name;
    private String mobileNo;
    private Location location;
}
