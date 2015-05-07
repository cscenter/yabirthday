package com.ya.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by olya on 07.05.15.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    public String defaultPage() {
        return "spring samples";
    }
}
