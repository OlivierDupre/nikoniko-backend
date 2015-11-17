/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.astek.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author gduvinage
 */
public class VoteController {

    public ResponseEntity save(String vote) {
        if (vote != null) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return null;
    }

}
