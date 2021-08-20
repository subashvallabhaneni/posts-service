package com.posts.service;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.posts.dto.Comment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CommentsRestServiceImplTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	CommentsRestServiceImpl service = new CommentsRestServiceImpl();
	
	@Test
	void test_comments() {
		boolean actual = this.restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments/",
				Comment[].class).length>0;
		assertThat(actual);
	}
	
}
