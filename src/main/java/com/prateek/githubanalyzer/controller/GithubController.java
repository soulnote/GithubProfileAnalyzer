package com.prateek.githubanalyzer.controller;

import com.prateek.githubanalyzer.model.GithubProfile;
import com.prateek.githubanalyzer.service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GithubController {

    @Autowired
    private GithubService githubService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/profile")
    public String getProfile(@RequestParam String username, Model model) {
        GithubProfile profile = githubService.fetchGithubProfile(username);
        model.addAttribute("profile", profile);
        return "profile";
    }
}
