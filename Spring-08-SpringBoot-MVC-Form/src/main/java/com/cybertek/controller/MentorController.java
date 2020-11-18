package com.cybertek.controller;


import com.cybertek.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {
    @GetMapping("/register")
    public String showForm(Model model){

        model.addAttribute("mentor",new Mentor());
        List<String> batchList= Arrays.asList("B3","B4","B19","B34","B43","B1");
        model.addAttribute("batchList",batchList);

        return "mentor/mentor-register";
    }

    @PostMapping ("/confirm")
    public String submitForm(@ModelAttribute("mentor") Mentor mentor){

        System.out.println(mentor.toString());



        return "mentor/mentor-confirm";
    }
}
