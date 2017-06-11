package com.sentiment.objects;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Karthikeyan
 *
 */
@XmlRootElement
public class Post implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7772672898836054559L;
	
	
	private String postId;
	private String postText;
	private String postCreatedTime;
	private String postCreatorType;
	private String associatedTone;
	private String associatedToneScore;
	
	public Post() 
	{
	}
	
	public Post(String postId, String postText, String postCreatedTime, String postCreatorType, String associatedTone,
			String associatedToneScore) {
		super();
		this.postId = postId;
		this.postText = postText;
		this.postCreatedTime = postCreatedTime;
		this.postCreatorType = postCreatorType;
		this.associatedTone = associatedTone;
		this.associatedToneScore = associatedToneScore;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public String getPostCreatedTime() {
		return postCreatedTime;
	}

	public void setPostCreatedTime(String postCreatedTime) {
		this.postCreatedTime = postCreatedTime;
	}

	public String getPostCreatorType() {
		return postCreatorType;
	}

	public void setPostCreatorType(String postCreatorType) {
		this.postCreatorType = postCreatorType;
	}

	public String getAssociatedTone() {
		return associatedTone;
	}

	public void setAssociatedTone(String associatedTone) {
		this.associatedTone = associatedTone;
	}

	public String getAssociatedToneScore() {
		return associatedToneScore;
	}

	public void setAssociatedToneScore(String associatedToneScore) {
		this.associatedToneScore = associatedToneScore;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 
	
}

