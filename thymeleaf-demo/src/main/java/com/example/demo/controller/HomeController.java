package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.*;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("title", "Welcome to Thymeleaf - 09.08.2026");
        model.addAttribute("message", "This text comes from the controller.");

        return "index";
    }

    @PostMapping("/submit")
    public String submit(
            @RequestParam String name, @RequestParam String email,
            Model model) {

        User u = new User();
        u.setName(name);
        u.setEmail(email);
        model.addAttribute("name", name);

        model.addAttribute("user", u);
 

        return "result";
    }

    @GetMapping("/users")
    public String users(Model model) {

        List<String> users = List.of("Alice", "Bob", "Charlie");

        model.addAttribute("users", users);

        return "users";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/form")
    public String save(@ModelAttribute User user) {
        System.out.println(user.getName());
        return "result";
    }



}