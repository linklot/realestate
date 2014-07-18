package com.newad.realestate.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Service;

@Service
public class PathLoginAuthenticationEntryPoint extends
    LoginUrlAuthenticationEntryPoint {

    private final PathTokens tokens;

    @Autowired
    public PathLoginAuthenticationEntryPoint(PathTokens pathTokens) {
        super("/");
        this.tokens = pathTokens;
    }

    @Override
    protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) {
        return getLoginUrlFromPath(request);
    }

    private String getLoginUrlFromPath(HttpServletRequest request) {
        String requestUrl = request.getRequestURI();
        if (tokens.isTokenInPath(requestUrl)) {
            return "/" + tokens.getTokenFromPath(requestUrl) + "_signin";
        }
        throw new PathTokenNotFoundException("Token not found in request URL " + requestUrl + " when retrieving LoginUrl for login form");
    }

}
