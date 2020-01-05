package com.dheeraj.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;
    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world-bean")
    public  HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world-internationalized")
    public String helloInternationalized() {
        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
    }
}
