package guru.springframework.api.domain;

import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Getter
@Setter
public class UserData {

    private List<User> users;

    public UserData() {
        users = new ArrayList<>();
    }
}
