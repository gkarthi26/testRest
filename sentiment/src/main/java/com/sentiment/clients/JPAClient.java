/**
 * 
 */
package com.sentiment.clients;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sentiment.dataaccess.PostEntity;

/**
 * @author Karthikeyan
 *
 */
public class JPAClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "sentiment-persistent-unit" );
		EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
	    PostEntity postEntity = new PostEntity();
	    postEntity.setPostText("Hi");
	    postEntity.setPostCreatorType("Member");
	    postEntity.setAssociatedTone("Frustrated");
	    entitymanager.persist(postEntity);
	    entitymanager.flush();
	    System.out.println("Time "+postEntity.getPostCreatedTime());
//	    List posts;
//	    Query query = entitymanager.createNamedQuery("PostEntity.findAll");
//	    posts = query.getResultList();
//	    System.out.println("Size "+posts.size());
	    
	    
	    
	    entitymanager.getTransaction( ).commit( );
	    System.out.println("Time "+postEntity.getPostCreatedTime());
	    entitymanager.close( );
	    System.out.println("Time "+postEntity.getPostCreatedTime());
	    emfactory.close( );

	    System.out.println("Time "+postEntity.getPostId());
	}

}
