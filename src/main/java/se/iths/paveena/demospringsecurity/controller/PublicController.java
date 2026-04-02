package se.iths.paveena.demospringsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class PublicController {

    @GetMapping
    public String publicPage() {
        return "public";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/authenticated")
    public String authenticatedPage() {
        return "authenticated";
    }
}
