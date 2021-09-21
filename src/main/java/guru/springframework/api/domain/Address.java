package guru.springframework.api.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Address implements Serializable {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

}
