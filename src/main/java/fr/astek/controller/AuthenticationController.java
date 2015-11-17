package fr.astek.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gduvinage
 */
public class AuthenticationController {

    public AuthenticationController() {

    }

    @RequestMapping(method = GET, value = "/authenticate")
    public ResponseEntity authenticate(String login, String password) {
        if (login.equals("user") && password.equals("user")) {
            return new ResponseEntity(HttpStatus.OK);

        }

        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }

}
