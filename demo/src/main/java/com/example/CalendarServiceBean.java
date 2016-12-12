package com.example;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CalendarServiceBean implements CalendarService {
	
	@Autowired
	private CalendarRepository calendarRepository;


	public Collection<Calendar> findAll() {
		Collection<Calendar> calendars = calendarRepository.findAll();

        return calendars;
	}

	public Calendar findOne(Long id) {
		
	  Calendar calendar = calendarRepository.findOne(id);

	   return calendar;
	}

	public Calendar create(Calendar calendar) {

		Calendar savedCalendar = calendarRepository.save(calendar);

        return savedCalendar;
	}

	public Calendar update(Calendar calendar) {
		Calendar calendarToUpdate = findOne(calendar.getId());
	        if (calendarToUpdate == null) {
	            // Cannot update Greeting that hasn't been persisted
	            return null;
	        }

	        calendarToUpdate.setName(calendar.getName());
	        Calendar updatedCalendar = calendarRepository.save(calendarToUpdate);

	        return updatedCalendar;
	}

	 public void delete(Long id) {

	 calendarRepository.delete(id);
		
	}
	
	

}
