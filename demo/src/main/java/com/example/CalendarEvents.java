package com.example;

import java.util.Date;
import java.util.List;

public class CalendarEvents {
	
	private Calendar calendar;
	public Calendar getCalendar() {
		return calendar;
	}
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getEvent_date() {
		return event_date;
	}
	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}
	public String getEvent_time() {
		return event_time;
	}
	public void setEvent_time(String event_time) {
		this.event_time = event_time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List getAttendee_list() {
		return attendee_list;
	}
	public void setAttendee_list(List attendee_list) {
		this.attendee_list = attendee_list;
	}
	public String getReminder_time() {
		return reminder_time;
	}
	public void setReminder_time(String reminder_time) {
		this.reminder_time = reminder_time;
	}
	private String title;
	private Date event_date;
	private String event_time;
	private String location;
	private List attendee_list;
	private String reminder_time;

}
