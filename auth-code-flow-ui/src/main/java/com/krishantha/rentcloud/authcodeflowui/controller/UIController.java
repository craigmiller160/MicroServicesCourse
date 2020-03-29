package com.krishantha.rentcloud.authcodeflowui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {

    @GetMapping("/")
    public String loadUI() {
        return "home";
    }

}
