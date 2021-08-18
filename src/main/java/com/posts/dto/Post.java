package com.posts.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Post {

	private Long id;
	
	private String title;
	private String body;
	private int commentCount;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonGetter("post_title")
	public String getTitle() {
		return title;
	}

	@JsonSetter("title")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonGetter("post_body")
	public String getBody() {
		return body;
	}

	@JsonSetter("body")
	public void setBody(String body) {
		this.body = body;
	}

	@JsonGetter("total_number_of_comments")
	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

}
