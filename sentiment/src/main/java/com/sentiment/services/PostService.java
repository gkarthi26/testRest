/**
 * 
 */
package com.sentiment.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;

import com.sentiment.dataaccess.PostEntity;
import com.sentiment.helpers.ToneAnalysisHelper;
import com.sentiment.objects.Post;

/**
 * @author Karthikeyan
 *
 */
public class PostService 
{
	public List<Post> getAllPosts()
	{

	    List<Post> posts = new ArrayList<>();
	    List<PostEntity> postEntities;
	    
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "sentiment-persistent-unit" );
		EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
	    Query query = entitymanager.createNamedQuery("PostEntity.findAll");
	    postEntities = query.getResultList();
	    System.out.println("output post entities Size "+postEntities.size());
	    for(int i=0; i<postEntities.size(); i++)
	    {
	    	if(postEntities.get(i) != null)
	    	{
		    	Post post = new Post();
		    	post.setPostId(postEntities.get(i).getPostId());
		    	post.setPostText(postEntities.get(i).getPostText());
		    	if(postEntities.get(i).getPostCreatedTime() != null)
		    	{
			    	post.setPostCreatedTime(postEntities.get(i).getPostCreatedTime().toString());		    		
		    	}
		    	else
		    	{
		    		System.out.println("Culprit: "+postEntities.get(i).getPostId());
		    	}
		    	post.setPostCreatorType(postEntities.get(i).getPostCreatorType());
		    	post.setAssociatedTone(postEntities.get(i).getAssociatedTone());
		    	post.setAssociatedToneScore(postEntities.get(i).getAssociatedToneScore());
		//	    System.out.println("output posts  "+post);
			    posts.add(post);	    		
	    	}
	    }
		return posts;
		
	}
	public Post createPost(Post post)
	{
	    
	    PostEntity postEntity ;
	    if(post!=null && !StringUtils.isEmpty(post.getPostText()))
	    {
	    	ToneAnalysisHelper.AnalyzeTone(post);
	    	postEntity = new PostEntity();
		    postEntity.setPostText(post.getPostText());
		    if(StringUtils.isEmpty(post.getPostCreatorType()))
		    {
		    	post.setPostCreatorType("Member");		    	
		    }
			postEntity.setPostCreatorType(post.getPostCreatorType());
		    postEntity.setAssociatedTone(post.getAssociatedTone());
		    postEntity.setAssociatedToneScore(post.getAssociatedToneScore());
		    

			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("sentiment-persistent-unit");
			EntityManager entitymanager = emfactory.createEntityManager();
		    entitymanager.getTransaction().begin();
		    entitymanager.persist(postEntity);
		    if("frustrated".equalsIgnoreCase(post.getAssociatedTone()) || "sad".equalsIgnoreCase(post.getAssociatedTone()) )
		    {
		    	PostEntity automatedPostEntity = new PostEntity();
		    	String automatedPost = "Hello Mr.Steve. We apologize for the inconvenience and frustration you are experiencing with your claim. We will call you immediately to discuss this matter." ;
		    	automatedPostEntity.setPostText(automatedPost);
		    	automatedPostEntity.setPostCreatorType("Representative");
		    	automatedPostEntity.setAssociatedTone("polite");
		    	automatedPostEntity.setAssociatedToneScore("0.1");
		    	entitymanager.persist(automatedPostEntity);
		    }
		    entitymanager.getTransaction( ).commit( );
		    entitymanager.close( );
		    emfactory.close( );

		    post.setPostId(postEntity.getPostId());
		    System.out.println("After store.Posted time "+postEntity.getPostCreatedTime());
		    //To Do - Set the post created time in output
		    
	    } 
		
		return post;
		
	}
}
