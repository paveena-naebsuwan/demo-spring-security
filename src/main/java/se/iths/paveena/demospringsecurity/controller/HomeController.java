package se.iths.paveena.demospringsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String Home() {
        return "index";
    }

    @GetMapping("/ott/sent")
    public @ResponseBody String ottSent() {
        return "Ott skickat";
    }

}
