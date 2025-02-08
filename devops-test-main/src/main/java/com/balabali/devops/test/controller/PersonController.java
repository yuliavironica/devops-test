package com.balabali.devops.test.controller;

import com.balabali.devops.test.model.Request;
import com.balabali.devops.test.model.Response;
import com.balabali.devops.test.model.entity.PersonEntity;
import com.balabali.devops.test.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
@RequestMapping("/api/v1/person")
@Slf4j
public class PersonController {

    /**
     * Person Service
     */
    @Autowired
    final PersonService personService;

    /**
     * Person Controller Constructor
     *
     * @param personService file Service
     * @see PersonService
     */
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("")
    public ResponseEntity<Response> post(@RequestBody Request request) {
        return ResponseEntity.ok()
            .body(new Response("Success", true, new PersonEntity("Bayu", "Dwiyan", "Satria")));
    }
}
