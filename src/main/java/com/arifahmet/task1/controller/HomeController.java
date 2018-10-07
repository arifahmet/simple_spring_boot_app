package com.arifahmet.task1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class HomeController {
    @RequestMapping("/")
    public RedirectView  index() {
        return new RedirectView("/swagger-ui.html");
    }
}
