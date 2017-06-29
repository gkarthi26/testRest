/**
 * 
 */
package com.sentiment.clients;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneScore;
import com.sentiment.helpers.ToneScoreComparator;
import com.sentiment.objects.Post;
import com.sentiment.services.PostService;

/**
 * @author Karthikeyan
 *
 */
public class TestComparator {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		PostService postService = new PostService();
		
		List<ToneScore> toneScores = new ArrayList<>();
		ToneScore ts1 = new ToneScore();
		ts1.setId("sad");
		ts1.setScore(0.81258);
		toneScores.add(ts1);
		ToneScore ts2 = new ToneScore();
		ts2.setId("happy");
		ts2.setScore(0.644855);
		toneScores.add(ts2);
		ToneScore ts3 = new ToneScore();
		ts3.setId("frus");
		ts3.setScore(0.947095);
		toneScores.add(ts3);
		
	
		
		
		System.out.println("Before sort");
		for(ToneScore t:toneScores)
		{
			System.out.println(t.getScore());
		}
		Collections.sort(toneScores, new ToneScoreComparator());
		System.out.println("After sort");
		for(ToneScore t:toneScores)
		{
			System.out.println(t.getScore());
		}

	}

}
