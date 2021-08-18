package com.posts.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.posts.dto.Comment;
import com.posts.exception.IdNotFoundException;

@RestController
public class CommentsRestServiceImpl implements CommentsRestService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${comments.url}")
	private String commentsUrl;
	
	@Override
	public List<Comment> getCommentsByPostId(Long postId) {
				
		List<Comment> commentsForPostId = getComments().stream()
		.filter( comment -> comment.getPostId() == postId)
		.collect(Collectors.toList());
		
		if (commentsForPostId.size() == 0) {
			throw new IdNotFoundException("PostId not found - "+postId);
		}
		
		return commentsForPostId;
	}

	@Override
	public List<Comment> getCommentsById(Long id) {

		List<Comment> commentsForId = getComments().stream()
		.filter( comment -> comment.getId().equals(id))
		.collect(Collectors.toList());
			
		if (commentsForId.size() == 0) {
			throw new IdNotFoundException("Id not found - "+id);
		}
		return commentsForId;
	}

	@Override
	public List<Comment> getByName(String name) {
		
		List<Comment> commentsForName = getComments().stream()
		.filter( comment -> comment.getName().contains(name))
		.collect(Collectors.toList());
		
		if (commentsForName.size() == 0) {
			throw new IdNotFoundException("Name not found - "+name);
		}	
		return commentsForName;
	}

	@Override
	public List<Comment> getByEmail(String email) {		

		List<Comment> commentsForEmail = getComments().stream()
		.filter( comment -> comment.getEmail().equalsIgnoreCase(email))
		.collect(Collectors.toList());
		
		if (commentsForEmail.size() == 0) {
			throw new IdNotFoundException("Email not found - "+email);
		}	
		return commentsForEmail;
	}
	
	@Override
	public List<Comment> getByBody(String body) {
		
		List<Comment> commentsForBody = getComments().stream()
		.filter( comment -> comment.getBody().contains(body))
		.collect(Collectors.toList());
		
		if (commentsForBody.size() == 0) {
			throw new IdNotFoundException("Body not found - "+body);
		}	
		return commentsForBody;
	}
	
	public List<Comment> getComments() {
		ResponseEntity<Comment[]> entity = restTemplate.getForEntity(commentsUrl, Comment[].class);
		List<Comment> comments =  Arrays.asList(entity.getBody());

		return comments;
	}

}
