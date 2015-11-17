/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.astek.controller;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

/**
 *
 * @author gduvinage
 */
@RunWith(MockitoJUnitRunner.class)
public class VoteControllerTest {

    @InjectMocks
    private VoteController voteController;

    public VoteControllerTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class VoteController.
     */
    @Test
    public void testSave() {

        assertEquals(HttpStatus.OK, voteController.save("testsss").getStatusCode());

    }

}
