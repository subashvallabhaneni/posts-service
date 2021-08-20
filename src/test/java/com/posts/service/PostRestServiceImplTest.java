package com.posts.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

import com.posts.dto.Post;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PostRestServiceImplTest{
	
	@Autowired
	private TestRestTemplate restTemplate;
	 

	
	@Test
	void test_posts() {
		boolean actual = this.restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts",
				Post[].class).length>0;
		assertThat(actual);
		
	}

}
