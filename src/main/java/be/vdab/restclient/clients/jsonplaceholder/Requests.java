package be.vdab.restclient.clients.jsonplaceholder;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface Requests {
    @GetExchange("{id}")
    UserResponse findById(@PathVariable long id);
    @GetExchange
    UserResponse[] findAll();
}
