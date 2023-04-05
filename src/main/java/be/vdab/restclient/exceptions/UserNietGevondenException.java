package be.vdab.restclient.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNietGevondenException extends RuntimeException {
    public UserNietGevondenException() {
        super("User niet gevonden");
    }
}
