package com.test.dto;



public class EventListDTO {
	
	String title;
	String eventstart;
	String eventend;
	
	
	
	
	public EventListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EventListDTO(String title, String eventstart, String eventend) {
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
	public String getEventstart() {
		return eventstart;
	}
	public void setEventstart(String eventstart) {
		this.eventstart = eventstart;
	}
	public String getEventend() {
		return eventend;
	}
	public void setEventend(String eventend) {
		this.eventend = eventend;
	}
	@Override
	public String toString() {
		return "EventListDTO [title=" + title + ", eventstart=" + eventstart
				+ ", eventend=" + eventend + "]";
	}
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
}
