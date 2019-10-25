package com.example.jooq.Controller;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

@Controller
@CrossOrigin
public class MyController {
    @Autowired
    DSLContext dsl;

    @RequestMapping(path = {"/index/{i}"})
    @ResponseBody
    public String index(@PathVariable("i") int i) {
        return null;
    }
    @RequestMapping(path = {"/free"})
    public String freemarket(Model m){
        m.addAttribute("data","bug");
        return "free";
    }
}
