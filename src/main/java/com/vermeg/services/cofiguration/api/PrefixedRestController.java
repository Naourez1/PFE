package com.vermeg.services.cofiguration.api;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Target({ TYPE })
@Retention(RUNTIME)
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public @interface PrefixedRestController {

}
