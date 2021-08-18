package com.posts.service;

import java.util.List;

import com.posts.dto.Comment;

public interface CommentsRestService {
	
	public List<Comment> getCommentsByPostId(Long postId);
	public List<Comment> getCommentsById(Long id);
	public List<Comment> getByName(String name);
	public List<Comment> getByEmail(String email) ;
	public List<Comment> getByBody(String body) ;

}
