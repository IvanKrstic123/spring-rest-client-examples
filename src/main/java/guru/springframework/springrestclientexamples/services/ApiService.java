package guru.springframework.springrestclientexamples.services;

import guru.springframework.api.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

public interface ApiService {


    List<User> getUsersBlocking(Integer limit);

    User getUserByIdBlocking(Integer id);

    Flux<User> getUsersNonBlocking(Integer limit);

    Mono<User> getUserByIdNonBlocking(int id);
}
