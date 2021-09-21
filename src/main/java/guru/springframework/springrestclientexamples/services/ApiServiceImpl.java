package guru.springframework.springrestclientexamples.services;


import guru.springframework.api.domain.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService{

    private RestTemplate restTemplate;

    private WebClient webClient;

    public ApiServiceImpl(RestTemplateBuilder builderBlocking, WebClient.Builder builderNonBlocking) {
        this.restTemplate = builderBlocking
                .rootUri("https://jsonplaceholder.typicode.com")
                .build();
        this.webClient = builderNonBlocking
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }

    //blocking - RestTemplate
    @Override
    public List<User> getUsersBlocking(Integer limit) {

        return restTemplate.exchange("/users?_limit=" + limit, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {})
                .getBody();
    }

    @Override
    public User getUserByIdBlocking(Integer id) {
        return restTemplate.getForObject("/users/{id}", User.class, id);    }


    //non blocking - WebClient
    @Override
    public Flux<User> getUsersNonBlocking(Integer limit) {
        return webClient.get().uri("/users?_limit=" + limit)
                .retrieve()
                .bodyToFlux(User.class);
    }

    public Mono<User> getUserByIdNonBlocking(int id) {
        return webClient.get().uri("/users/{id}", id)
                .retrieve()
                .bodyToMono(User.class);
    }


}
