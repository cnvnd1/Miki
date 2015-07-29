package com.test.dto.result;

import java.io.Serializable;
import java.util.Date;

import com.test.dto.EventListDTO;

public class EventListResultDTO implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String title;
	String start;
	String end;
	
	
	public EventListResultDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EventListResultDTO(EventListDTO dto){
		
		this.title = dto.getTitle();
		this.start = new Date(dto.getEventstart()).toString();
		this.end = new Date(dto.getEventend()).toString();
	}


	@Override
	public String toString() {
		return "EventListResultDTO [title=" + title + ", start=" + start
				+ ", end=" + end + "]";
	}
	
	
}
