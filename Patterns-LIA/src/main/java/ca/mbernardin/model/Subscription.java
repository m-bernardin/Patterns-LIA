package ca.mbernardin.model;

/**
 * Subscription
 */
public class Subscription {
    private int subscription_id;
    private int user_id;
    private int conference_id;
    private boolean is_on_waiting_list;
    public Subscription(int subscription_id,int user_id,int conference_id,boolean is_on_waiting_list){
	    this.subscription_id=subscription_id;
        this.user_id=user_id;
        this.conference_id=conference_id;
        this.is_on_waiting_list=is_on_waiting_list;
    }
}
