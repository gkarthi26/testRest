/**
 * 
 */
package com.sentiment.clients;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneChatRequest;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.Utterance;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.UtterancesTone;
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
//		Client client = ClientBuilder.newClient();
//		List response = client
//				.target("http://localhost:8080/sentiment/webapi/posts")
//				.request()
//				.get(List.class);
//		System.out.println(response.size());
		
		Double d = 0.74485512131613136161313161613165132131313213999999999999999999999999999;
		System.out.println(d.toString());
		ToneAnalyzer service = new ToneAnalyzer("2016-05-19");
		service.setUsernameAndPassword("5700d94d-d584-4fb4-9fc3-7284e453f421", "uFvF4AGs6Vux");

		try {

		  List<Utterance> utterances = new ArrayList<>();

		  Utterance utterance = new Utterance.Builder().text("How can I ask you for a help?").user("agent").build();
		  utterances.add(utterance);

		  ToneChatRequest toneChatRequest = new ToneChatRequest.Builder()
		    .utterances(utterances).build();
		  UtterancesTone utterancesTone = service.getChatTone(toneChatRequest).execute();
		  System.out.println(utterancesTone);
		} catch (RuntimeException e) {
		  e.printStackTrace();
		}
	}

}
