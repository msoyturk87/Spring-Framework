package com.cybertek.controller;

import com.cybertek.enums.Gender;
import com.cybertek.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class  MentorController {

    @GetMapping("/mentor-list")
    public String showTable(Model model){

        List<Mentor> mentorList=new ArrayList<>();
        mentorList.add(new Mentor("Mike","Smith",45, Gender.MALE));
        mentorList.add(new Mentor("Tom","Smith",45, Gender.MALE));
        mentorList.add(new Mentor("George","Smith",3, Gender.MALE));
        mentorList.add(new Mentor("Abdul","Smith",45, Gender.MALE));
        mentorList.add(new Mentor("Rezzak","Smith",23, Gender.MALE));

        model.addAttribute("mentors",mentorList);


        return "mentor/mentor-list";
    }
}
