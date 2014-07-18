package com.newad.realestate.security;

import org.springframework.security.core.AuthenticationException;

public class PathTokenNotFoundException extends AuthenticationException {

    private static final long serialVersionUID = -3724947331222765302L;

    public PathTokenNotFoundException(String msg) {
        super(msg);
    }

    public PathTokenNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

}
