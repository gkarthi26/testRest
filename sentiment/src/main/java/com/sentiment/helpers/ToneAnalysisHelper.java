/**
 * 
 */
package com.sentiment.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneChatRequest;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneScore;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.Utterance;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.UtteranceAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.UtterancesTone;
import com.sentiment.objects.Post;

/**
 * @author Karthikeyan
 *
 */
public class ToneAnalysisHelper 
{
	static ToneAnalyzer ToneAnalyzerservice;
	public static void AnalyzeTone(Post post) 
	{
		initializeToneAnalyzer();
		List<ToneScore> toneScores = getToneScores(post.getPostText());
		if(toneScores !=null && !toneScores.isEmpty())
		{
			ToneScore toneScore = getToneWhichHasHighestScore(toneScores);
			post.setAssociatedTone(toneScore.getName());
			post.setAssociatedToneScore(toneScore.getScore().toString());			
		}
	}
	private static List<ToneScore> getToneScores(String postText) 
	{
		List<ToneScore> toneScores = null;
		
		List<Utterance> utterances = new ArrayList<>();
		Utterance utterance = new Utterance.Builder().text(postText).user("customer").build();
		utterances.add(utterance);
		ToneChatRequest toneChatRequest = new ToneChatRequest.Builder().utterances(utterances).build();
		UtterancesTone utterancesTone = ToneAnalyzerservice.getChatTone(toneChatRequest).execute();
		System.out.println(utterancesTone);
		List<UtteranceAnalysis> utteranceAnalysisList = utterancesTone.getUtterancesTone();
		for(int i=0; i<utteranceAnalysisList.size(); i++)
		{
			if(postText.equals(utteranceAnalysisList.get(i).getText()))
			{
				toneScores = utteranceAnalysisList.get(i).getTones();
			}
		}
		return toneScores;
	}

	private static ToneScore getToneWhichHasHighestScore(List<ToneScore> toneScores) 
	{	
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
		return toneScores.get(0);
	}
	private static void initializeToneAnalyzer() 
	{
		ToneAnalyzerservice = new ToneAnalyzer("2016-05-19");
		ToneAnalyzerservice.setUsernameAndPassword("5700d94d-d584-4fb4-9fc3-7284e453f421", "uFvF4AGs6Vux");
	}

}
