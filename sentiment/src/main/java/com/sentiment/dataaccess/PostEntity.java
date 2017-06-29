package com.sentiment.dataaccess;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the post_test database table.
 * 
 */
@Entity
@Table(name="post_test")
@NamedQuery(name="PostEntity.findAll", query="SELECT p FROM PostEntity p ORDER BY p.postId DESC")
public class PostEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="POST_ID")
	private String postId;

	@Column(name="ASSOCIATED_TONE")
	private String associatedTone;

	@Column(name="ASSOCIATED_TONE_SCORE")
	private String associatedToneScore;

	@Column(name="POST_CREATED_TIME", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp postCreatedTime;

	@Column(name="POST_CREATOR_TYPE")
	private String postCreatorType;

	@Column(name="POST_TEXT")
	private String postText;

	public PostEntity() {
	}

	public String getPostId() {
		return this.postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getAssociatedTone() {
		return this.associatedTone;
	}

	public void setAssociatedTone(String associatedTone) {
		this.associatedTone = associatedTone;
	}

	public String getAssociatedToneScore() {
		return this.associatedToneScore;
	}

	public void setAssociatedToneScore(String associatedToneScore) {
		this.associatedToneScore = associatedToneScore;
	}

	public Timestamp getPostCreatedTime() {
		return this.postCreatedTime;
	}

	public void setPostCreatedTime(Timestamp postCreatedTime) {
		this.postCreatedTime = postCreatedTime;
	}

	public String getPostCreatorType() {
		return this.postCreatorType;
	}

	public void setPostCreatorType(String postCreatorType) {
		this.postCreatorType = postCreatorType;
	}

	public String getPostText() {
		return this.postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

}