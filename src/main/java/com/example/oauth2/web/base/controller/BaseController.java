package com.example.oauth2.web.base.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("base")
public class BaseController {

    @RequestMapping()
    public String base() {
        return "This is base abc";
    }

    @RequestMapping("user")
    public Authentication user() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
    @RequestMapping("abc")
    public String baseabc() {
        return "This is base abc";
    }

}
