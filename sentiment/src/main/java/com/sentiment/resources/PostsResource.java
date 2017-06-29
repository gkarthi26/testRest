package com.sentiment.resources;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;

import com.sentiment.objects.Post;
import com.sentiment.services.PostService;

@Path("posts")
public class PostsResource 
{
	PostService postService = new PostService();
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPosts() 
    {
		return Response.ok(new GenericEntity<List<Post>>(postService.getAllPosts()) {}).header("Access-Control-Allow-Origin", "*").build();
    }
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
	public Response createPost(Post postInput)
	{
		System.out.println("Inside createPost()");
		if(postInput != null && !StringUtils.isBlank(postInput.getPostText()))
		{
			System.out.println("Inside Post resource-Post input: "+postInput.getPostText());
			Post post = postService.createPost(postInput) ;
			return Response.ok(post).header("Access-Control-Allow-Origin", "*").build();
		}
		else
		{
			return Response.status(Status.BAD_REQUEST).header("Access-Control-Allow-Origin", "*").build();
		}
	}
}
