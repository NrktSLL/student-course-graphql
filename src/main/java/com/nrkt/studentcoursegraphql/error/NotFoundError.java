package com.nrkt.studentcoursegraphql.error;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotFoundError extends RuntimeException {
    public NotFoundError(String message) {
        super(message);
        log.error(message);
    }
}
