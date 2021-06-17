package com.example.oauth2.config.security;

import com.example.oauth2.config.security.oauth2.AuthorizationCodeTokenResponseClient;
import com.example.oauth2.config.security.oauth2.CustomOAuth2UserService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableWebSecurity
public class OAuth2LoginSecurityConfig {

    @Bean
    @Order(10)
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new WebSecurityConfigurerAdapter() {

            @Override
            protected void configure(HttpSecurity http) throws Exception {
                super.configure(http);
                http.oauth2Login().defaultSuccessUrl("/base", true);
                // http.oauth2Login().defaultSuccessUrl("/base")
                //         .tokenEndpoint().accessTokenResponseClient(new AuthorizationCodeTokenResponseClient());
                // http.oauth2Login().userInfoEndpoint().userService(new CustomOAuth2UserService());
//                http.oauth2Client().authorizationCodeGrant().accessTokenResponseClient(new AuthorizationCodeTokenResponseClient());
                http.formLogin().defaultSuccessUrl("/base").successForwardUrl("/base");
            };
        };
    }

//    @Configuration()
//    static class OAuth2WebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
//            http.oauth2Login(Customizer.withDefaults());
//            http.oauth2Client().authorizationCodeGrant().accessTokenResponseClient(new AuthorizationCodeTokenResponseClient());;
//        }
//
//    }

}
