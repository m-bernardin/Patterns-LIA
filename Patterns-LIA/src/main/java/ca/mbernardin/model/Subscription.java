package ca.mbernardin.model;

import java.sql.Date;

/**
 * Subscription
 */
public class Subscription {
    private int subscription_id;
    private int user_id;
    private int conference_id;
    private boolean waitinglist_status;
    private Date waitinglist_position;
    public Subscription(int subscription_id,int user_id,int conference_id,boolean waitinglist_status,Date waitinglist_position){
	    this.subscription_id=subscription_id;
        this.user_id=user_id;
        this.conference_id=conference_id;
        this.waitinglist_status=waitinglist_status;
        this.waitinglist_position=waitinglist_position;
    }
}
