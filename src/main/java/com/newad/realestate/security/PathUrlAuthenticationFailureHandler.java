package com.newad.realestate.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Service;

@Service
public class PathUrlAuthenticationFailureHandler extends
SimpleUrlAuthenticationFailureHandler {

    private final PathTokens tokens;

    @Autowired
    public PathUrlAuthenticationFailureHandler(PathTokens pathTokens) {
        super();
        this.tokens = pathTokens;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
        setDefaultFailureUrl(getFailureUrlFromPath(request));
        super.onAuthenticationFailure(request, response, exception);

    }

    private String getFailureUrlFromPath(HttpServletRequest request) {
        String refererUrl = request.getHeader("Referer");
        if (tokens.isTokenInPath(refererUrl)) {
            return "/" + tokens.getTokenFromPath(refererUrl) + "_signin?error=1";
        }
        throw new PathTokenNotFoundException("Token not found in referer URL " + refererUrl + " when retrieving failureUrl for login form");
    }

}
