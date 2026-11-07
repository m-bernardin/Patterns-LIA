package ca.mbernardin.model;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 * Conference
 */
public class Conference{
    private int conference_id;
    private String title;
    private int capacity;
    // Theres a good chance this doesn't stay as sql.Date but I don't want to nor have time to decide what it should be at this time
    private Date start_date;
    private Date end_date;
    private String location;
    public Conference(int conference_id,String title,int capacity,Date start_date,Date end_date,String location){
        this.conference_id=conference_id;
        this.title=title;
        this.capacity=capacity;
        this.start_date=start_date;
        this.end_date=end_date;
        this.location=location;
    }
}
