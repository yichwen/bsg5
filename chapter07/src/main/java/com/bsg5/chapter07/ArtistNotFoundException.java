package com.bsg5.chapter07;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// this tells a Spring @Controller that
// this exception should map to a specific HTTP status code – in this case, it’s 404,
// corresponding to "not found", as the name clearly implies
// If we don’t set an explicit response status, the exceptions will be considered service errors, which corresponds to
// HTTP status 500
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ArtistNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -7888061245862993240L;

    public ArtistNotFoundException(String message) {
        super(message);
    }

    public ArtistNotFoundException(Exception e) {
        super(e);
    }

}
