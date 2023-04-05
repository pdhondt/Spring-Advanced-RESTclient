package be.vdab.restclient.clients.jsonplaceholder;

import be.vdab.restclient.dto.User;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserClient {
    private final Requests requests;

    public UserClient(Requests requests) {
        this.requests = requests;
    }
    public Optional<User> findById(long id) {
        try {
            var response = requests.findById(id);
            var user = new User(response.id(), response.name(),
                    response.address().city());
            return Optional.of(user);
        } catch (WebClientResponseException.NotFound ex) {
            return Optional.empty();
        }
    }
    public List<User> findAll() {
        return Arrays.stream(requests.findAll())
                .map(userResponse -> new User(userResponse.id(), userResponse.name(),
                        userResponse.address().city()))
                .toList();
    }
}
