package io.khasang.ba.controller;

import io.khasang.ba.Message;
import io.khasang.ba.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    private Message message;

    @Qualifier("myServiceImplementation")
    @Autowired
    private MyService myService;

    @RequestMapping("/")
    public String getHelloPage(Model model) {
        model.addAttribute("name", myService.getName());
        return "home";
    }

    @RequestMapping("/name/{name}")
    public String getName(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}
