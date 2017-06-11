package com.sentiment.resources;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sentiment.objects.Post;
import com.sentiment.services.PostService;

@Path("posts")
public class PostsResource 
{
	PostService postService = new PostService();
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getAllPosts() 
    {
		return postService.getAllPosts();    	
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public List<Post> createPost(Post post)
	{
		List<Post> posts = new ArrayList<>();
		posts = postService.getAllPosts();
		post.setPostId("3");
		post.setPostCreatedTime(new Date().toString());
		post.setPostCreatorType("Member");
		post.setAssociatedTone("TBD");
		post.setAssociatedToneScore("TBD");
		
		posts.add(post);
		return posts ;
	}
}
