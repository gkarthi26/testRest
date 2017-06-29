/**
 * 
 */
package com.sentiment.helpers;

import java.util.Comparator;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneScore;
import com.sentiment.objects.Post;

/**
 * @author Karthikeyan
 *
 */
public class ToneScoreComparator implements Comparator<ToneScore> {



	@Override
	public int compare(ToneScore o1, ToneScore o2) {
		// TODO Auto-generated method stub
		try
		{
			return o2.getScore().compareTo(o1.getScore());			
		}
		catch(Exception e)
		{
			System.out.println("Exception in comparator: "+e.getMessage());
			return 0;
		}
	}

}
