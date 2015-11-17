/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.astek.controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author gduvinage
 */
@RunWith(MockitoJUnitRunner.class)
public class AuthenticationControllerTest {

    public AuthenticationControllerTest() {
    }

    @InjectMocks
    private AuthenticationController authenticationController;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void authenticateNotAuthorized() {
        ResponseEntity responseEntity = authenticationController.authenticate("user", "test");
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.UNAUTHORIZED);
    }

    @Test
    public void authenticateAuthorized() {
        ResponseEntity responseEntity = authenticationController.authenticate("user", "user");
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

}
