package com.posts.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.posts.dto.Comment;
import com.posts.dto.Post;

@Service
public class PostRestServiceImpl implements PostRestService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${posts.url}")
	private String postUrl;

	@Value("${comments.url}")
	private String commentsUrl;

	@Override
	public List<Post> getPosts() {
		ResponseEntity<Post[]> posts = restTemplate.getForEntity(postUrl, Post[].class);
		HashMap<Long, Integer> processComments = processComments();
		List<Post> postList = Arrays.asList(posts.getBody());

		postList.stream().forEach(p -> p.setCommentCount(processComments.get(p.getId())));
		postList = postList.stream().sorted(Comparator.comparing(Post::getCommentCount).reversed())
				.collect(Collectors.toList());
		return postList;
	}

	public HashMap<Long, Integer> processComments() {

		HashMap<Long, Integer> map = new HashMap<>();

		ResponseEntity<Comment[]> entity = restTemplate.getForEntity(commentsUrl, Comment[].class);
		List<Comment> comments = Arrays.asList(entity.getBody());

		for (Comment comm : comments) {
			if (map.containsKey(comm.getPostId())) {
				map.replace(comm.getPostId(), map.get(comm.getPostId()) + 1);
			} else {
				map.put(comm.getPostId(), 1);
			}
		}

		return map;

	}

}
