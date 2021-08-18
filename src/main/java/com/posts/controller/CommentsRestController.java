package com.posts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.posts.dto.Comment;
import com.posts.service.CommentsRestService;

@RestController
@RequestMapping("comments")
public class CommentsRestController {
	
	@Autowired
	CommentsRestService service;
	
	@GetMapping("postId/{postId}")
	public List<Comment> getCommentsByPostId(@PathVariable Long postId) {	
		return service.getCommentsByPostId(postId);
	}
	
	@GetMapping("commentId/{id}")
	public List<Comment> getCommentsById(@PathVariable Long id) {
		return service.getCommentsById(id);
	}
	
	@GetMapping("name/{name}")
	public List<Comment> getByName(@PathVariable String name) {
		return service.getByName(name);
	}
	
	@GetMapping("email/{email}")
	public List<Comment> getByEmail(@PathVariable String email) {
		return service.getByEmail(email);
	}

	@GetMapping("body/{body}")
	public List<Comment> getByBody(@PathVariable String body) {
		return service.getByBody(body);
	}

}
