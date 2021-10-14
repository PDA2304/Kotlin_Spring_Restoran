package com.example.pr7

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.convert.Jsr310Converters

@SpringBootApplication
class Pr7Application

fun main(args: Array<String>) {
    runApplication<Pr7Application>(*args)
}
