package com.sentiment.dataaccess;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Widget {
	@Id
	@GeneratedValue(generator="system-uuid")
	private String prefId;
	private String id;
	private String widgetView;
	private String widgetType;
	private String userId;
	private String userRole;
	private Timestamp createdTs;
	
	public String getPrefId() {
		return prefId;
	}
	public void setPrefId(String prefId) {
		this.prefId = prefId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWidgetView() {
		return widgetView;
	}
	public void setWidgetView(String widgetView) {
		this.widgetView = widgetView;
	}
	public String getWidgetType() {
		return widgetType;
	}
	public void setWidgetType(String widgetType) {
		this.widgetType = widgetType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public Timestamp getCreatedTs() {
		return createdTs;
	}
	public void setCreatedTs(Timestamp createdTs) {
		this.createdTs = createdTs;
	}
}
