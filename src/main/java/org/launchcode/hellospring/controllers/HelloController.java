package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Anthony
 */
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//
//    }

    // lives at /hello/goodbye
    @GetMapping("goodbye")
//    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode
//    @GetMapping("hello")
//    @PostMapping("hello")

    // now live at /hello/hello
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
//    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }
// lives at /hello/form
    @GetMapping("form")
//    @ResponseBody
    public String helloForm(){
        return"<html>" +
                "<body>" +
                "<form action = 'hello' method='post'>" + // submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
