package com.example;

import java.util.Collection;

public interface CalendarService {
	
	Collection<Calendar> findAll();

	Calendar findOne(Long id);

	Calendar create(Calendar calendar);

	Calendar update(Calendar calendar);

    void delete(Long id);

}
