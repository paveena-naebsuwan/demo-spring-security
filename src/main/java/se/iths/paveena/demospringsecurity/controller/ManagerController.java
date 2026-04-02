package se.iths.paveena.demospringsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @GetMapping
    @PreAuthorize("hasAnyRole('MANAGER','ADMIN')")
    public String dashboard() {
        return "manager";
    }
}
