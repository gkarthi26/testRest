/**
 * 
 */
package com.sentiment.clients;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sentiment.objects.Post;

/**
 * @author Karthikeyan
 *
 */
public class RestClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Client client = ClientBuilder.newClient();
		List response = client
				.target("http://localhost:8080/sentiment/webapi/posts")
				.request()
				.get(List.class);
		System.out.println(response.size());

	}

}
