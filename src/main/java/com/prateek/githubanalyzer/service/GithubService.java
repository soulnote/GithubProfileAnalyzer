package com.prateek.githubanalyzer.service;

import com.prateek.githubanalyzer.model.GithubProfile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class GithubService {

    private final RestTemplate restTemplate = new RestTemplate();

    @SuppressWarnings("null")
	public GithubProfile fetchGithubProfile(String username) {
        String url = UriComponentsBuilder
                .fromHttpUrl("https://api.github.com/users/" + username)
                .toUriString();

        @SuppressWarnings("unchecked")
		Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        GithubProfile profile = new GithubProfile();
        profile.setUsername((String) response.get("login"));
        profile.setFullName((String) response.get("name"));
        profile.setAvatarUrl((String) response.get("avatar_url"));
        profile.setCompany((String) response.get("company"));
        profile.setProfileUrl((String) response.get("html_url"));
        profile.setPublicRepos((Integer) response.get("public_repos"));
        profile.setCreatedAt(((String) response.get("created_at")).split("T")[0]);

        return profile;
    }
}
