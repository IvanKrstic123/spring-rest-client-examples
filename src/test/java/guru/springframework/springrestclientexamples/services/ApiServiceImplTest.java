package guru.springframework.springrestclientexamples.services;

import guru.springframework.api.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
class ApiServiceImplTest {

    @Autowired
    private ApiService apiService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getUsersBlocking() {
        List<User> usersBlocking = apiService.getUsersBlocking(5);

        assertEquals(5, usersBlocking.size());
    }

    @Test
    void getUserByIdBlocking() {
        User userByIdBlocking = apiService.getUserByIdBlocking(9);

        assertEquals(9, userByIdBlocking.getId());
    }

    @Test
    void getUsersNonBlocking() {
        List<User> userList = apiService.getUsersNonBlocking(9).collectList().block();

        assertEquals(9, userList.size());
    }

    @Test
    void getUserByIdNonBlocking() {
        User userById = apiService.getUserByIdNonBlocking(4).block();

        assertEquals(4, userById.getId());
    }
}