package com.test.entity.user;

public class UserPostWriteDTO {
	
	String userId;
	String title;
	String content;
	String postType;
	String tags;
	String mTime;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPostType() {
		return postType;
	}
	public void setPostType(String postType) {
		this.postType = postType;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getmTime() {
		return mTime;
	}
	public void setmTime(String mTime) {
		this.mTime = mTime;
	}
	public UserPostWriteDTO(String userId, String title, String content,
			String postType, String tags, String mTime) {
		super();
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.postType = postType;
		this.tags = tags;
		this.mTime = mTime;
	}
	public UserPostWriteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserPostWriteDTO [userId=" + userId + ", title=" + title
				+ ", content=" + content + ", postType=" + postType + ", tags="
				+ tags + ", mTime=" + mTime + "]";
	}
	
	
	
}
