package com.sentiment.objects;


public class ToneScore implements Comparable<ToneScore>
{

  private String id;

  private String name;

  private Double score;

  public String getId() {
	return id;
}



public void setId(String id) {
	this.id = id;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public Double getScore() {
	return score;
}



public void setScore(Double score) {
	this.score = score;
}



/**
   * Instantiates a new tone score.
   */
  public ToneScore() {

  }



@Override
public int compareTo(ToneScore compareToneScore) 
{
	return 0;
//	// TODO Auto-generated method stub
//	int compareScore = compareToneScore.getScore();
//	return compareScore;
}

}
