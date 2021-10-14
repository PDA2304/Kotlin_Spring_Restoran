package com.example.pr7.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class UnitController {


    @GetMapping("/unit")
    fun unitGet():String
    {
        return "fragmentsCategory/unit"
    }
}