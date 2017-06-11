/**
 * 
 */
package com.sentiment.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sentiment.objects.Post;

/**
 * @author Karthikeyan
 *
 */
public class PostService 
{
	public List<Post> getAllPosts()
	{
		Post post1 = new Post("1", "Hi", new Date().toString(), "Member", "Sad", "1.0");
		Post post2 = new Post("2", "Hello", new Date().toString(), "Member", "Anger", "1.0");
		List<Post> posts = new ArrayList<>();
		posts.add(post1);
		posts.add(post2);
		return posts;
		
	}
}
