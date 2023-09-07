package com.example.demo.controller

import com.example.demo.service.CountThisService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

import java.util.regex.Pattern

@RestController
class CountThisController {

    private final CountThisService countThisService

    CountThisController(CountThisService countThisService){
        this.countThisService = countThisService
    }

    @PostMapping("/count-word")
    HashMap<String, List<List<Serializable>>> countWord(@RequestBody HashMap<String,String> map){
        String word = map.values().first()
        if(!Pattern.matches("[a-zA-Z]*", word))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST)

        ["countWord" : countThisService.countWord(word)]

    }

}
