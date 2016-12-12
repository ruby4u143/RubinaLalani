package com.example;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
 
@RestController
public class CalendarRestController {
 
    @Autowired
    private CalendarService calendarService;

    @RequestMapping(
            value = "/api/calendars",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Calendar>> getCalendars() {

        Collection<Calendar> calendars = calendarService.findAll();

        return new ResponseEntity<Collection<Calendar>>(calendars,
                HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/calendars/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Calendar> getCalendar(@PathVariable("id") Long id) {

        Calendar calendar = calendarService.findOne(id);
        if (calendar == null) {
            return new ResponseEntity<Calendar>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Calendar>(calendar, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/calendars",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Calendar> createCalendar(
            @RequestBody Calendar calendar) {

        Calendar savedCalendar = calendarService.create(calendar);

        return new ResponseEntity<Calendar>(savedCalendar, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/api/calendars/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Calendar> updateCalendar(
            @RequestBody Calendar calendar) {

        Calendar updatedCalendar = calendarService.update(calendar);
        if (updatedCalendar == null) {
            return new ResponseEntity<Calendar>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Calendar>(updatedCalendar, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/calendars/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<Calendar> deleteCalendar(@PathVariable("id") Long id,
            @RequestBody Calendar calendar) {

    	calendarService.delete(id);

        return new ResponseEntity<Calendar>(HttpStatus.NO_CONTENT);
    }

   
}
