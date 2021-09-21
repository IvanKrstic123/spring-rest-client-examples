package guru.springframework.api.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Geo implements Serializable {

    private Double lat;
    private Double lng;

}
