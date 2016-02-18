package com.podbox.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
class IndexController {

    @RequestMapping(method = GET, value = {"", "/"})
    String index() {
        return "index";
    }
}
