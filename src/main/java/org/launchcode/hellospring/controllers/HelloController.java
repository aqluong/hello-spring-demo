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
////    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name, String language) {
        return createGreeting(name, language);
    }
//        return "Hello, " + name + "!";
//    }

    // Handles requests of the form /hello/LaunchCode
//    @GetMapping("{name}")
////    @ResponseBody
//    public String helloWithPathParam(@PathVariable String name) {
//        return "Hello, " + name + "!";
//    }


    // lives in the /hello/form
    @GetMapping("form")
//    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello'>" + // Request to /hello
                "<input type='text' name='name'>" +
                "<select name = 'language'>" +
                "<option value = 'English'>English</option>" +
                "<option value = 'French'>French</option>" +
                "<option value = 'Portuguese'>Portuguese</option>" +
                "<option value = 'Spanish'>Spanish</option>" +
                "<option value = 'Russian'>Russian</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public static String createGreeting(String name, String language) {
        if (language.equals("English")) {
            return "Hello " + name + "!";
        } else if (language.equals("French")) {
            return "Bonjour " + name + "!";
        } else if (language.equals("Portuguese")) {
            return "olá " + name + "!";
        } else if (language.equals("Spanish")) {
            return "Hola " + name + "!";
        } else {
            return "привет " + name + "!";
        }
    }
}