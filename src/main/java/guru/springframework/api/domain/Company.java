package guru.springframework.springrestclientexamples.api.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Company implements Serializable {

    private String name;
    private String catchPhrase;
    private String bs;

}
