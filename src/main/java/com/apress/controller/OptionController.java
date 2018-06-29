package com.apress.controller;

import com.apress.domain.Option;
import com.apress.repository.OptionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class OptionController {

    @Inject
    private OptionRepository optionRepository;

    @RequestMapping(value="/options", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Option>> getAllOptions(){
        Iterable<Option> allOptions = optionRepository.findAll();
        return new ResponseEntity<>(allOptions, HttpStatus.OK);
    }

    @RequestMapping(value="/option", method= RequestMethod.POST)
    public ResponseEntity<Option>createOption(@RequestBody Option option){
        option = optionRepository.save(option);
        return new ResponseEntity<Option>(option, HttpStatus.CREATED);
    }

}
