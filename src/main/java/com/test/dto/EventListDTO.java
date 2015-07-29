package com.test.dto;



public class EventListDTO {
	
	String title;
	int eventstart;
	int eventend;
	
	
	public EventListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EventListDTO(String title, int eventstart, int eventend) {
		super();
		this.title = title;
		this.eventstart = eventstart;
		this.eventend = eventend;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getEventstart() {
		return eventstart;
	}
	public void setEventstart(int eventstart) {
		this.eventstart = eventstart;
	}
	public int getEventend() {
		return eventend;
	}
	public void setEventend(int eventend) {
		this.eventend = eventend;
	}
	@Override
	public String toString() {
		return "EventListDTO [title=" + title + ", eventstart=" + eventstart
				+ ", eventend=" + eventend + "]";
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
}
