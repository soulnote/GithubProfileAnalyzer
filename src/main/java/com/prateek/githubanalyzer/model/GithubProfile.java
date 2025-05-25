package com.prateek.githubanalyzer.model;

import lombok.Data;

@Data
public class GithubProfile {
    private String username;
    private String fullName;
    private String avatarUrl;
    private String company;
    private String profileUrl;
    private int publicRepos;
    private String createdAt;
}
