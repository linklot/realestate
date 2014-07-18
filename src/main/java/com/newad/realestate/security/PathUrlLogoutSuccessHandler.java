package com.newad.realestate.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Service;

@Service
public class PathUrlLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    private final PathTokens tokens;

    @Autowired
    public PathUrlLogoutSuccessHandler(PathTokens pathTokens) {
        super();
        this.tokens = pathTokens;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        setDefaultTargetUrl(getTargetUrlFromPath(request));
        setAlwaysUseDefaultTargetUrl(true);
        handle(request, response, authentication);
    }

    private String getTargetUrlFromPath(HttpServletRequest request) {
        String refererUrl = request.getHeader("Referer");
        if (tokens.isTokenInPath(refererUrl)) {
//            return "/" + tokens.getTokenFromPath(refererUrl) + "_signin";
            return "/";
        }
        throw new PathTokenNotFoundException("Token not found in referer URL " + refererUrl + " when retrieving logoutUrl.");
    }

}
