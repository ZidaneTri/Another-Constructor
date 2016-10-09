package com.example.social;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/testpost")
public class TestController {

    @RequestMapping(method = RequestMethod.POST)
    public String session(@RequestBody Object somemap) {
        String map = "kekus";
        return map;
    }
}
