package com.posts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.posts.dto.Post;
import com.posts.service.PostRestService;

@RestController
public class PostRestController {

	@Autowired
	PostRestService service;

	@GetMapping("posts")
	public List<Post> getPosts() {
		return service.getPosts();
	}

}
