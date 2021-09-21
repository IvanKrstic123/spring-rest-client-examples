package guru.springframework.springrestclientexamples.controllers;

import guru.springframework.springrestclientexamples.services.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
public class UserController {

    private final ApiService apiService;

    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping({"", "/", "/index"})
    public String index() {
        return "index";
    }

    @PostMapping("/users")
    public Mono<String> formPost(Model model, ServerWebExchange serverWebExchange) {

        return serverWebExchange.getFormData().map(value -> {
            Integer limit = new Integer(value.get("limit").get(0));

            log.debug("Received Limit value: " + limit);
            //default if null or zero
            if (limit == null || limit == 0) {
                log.debug("Setting limit to default of 10");
                limit = 10;
            }

            model.addAttribute("users", apiService.getUsersBlocking(limit));

            return "userslist";
        });

    }
}
