package ca.mbernardin.service;

import ca.mbernardin.model.Conference;
import ca.mbernardin.model.Subscription;

import java.util.Date;

public class SubscriptionRow {
    private final Subscription subscription;
    private final Conference conference;

    public SubscriptionRow(Subscription subscription, Conference conference) {
        this.subscription = subscription;
        this.conference = conference;
    }

    public int getConferenceId() {
        return conference.getConferenceId();
    }
    public String getConference() {
        return conference.getTitle();
    }
    public Date getStartDate() {
        return conference.getStartDate();
    }
    public Date getEndDate() {
        return conference.getEndDate();
    }
    public String getStatus() {
        if(subscription.isWaitinglist_status()) {
            return "Waitlisted";
        }
        else {
            return "Confirmed";
        }
    }
    Subscription getSubscription() {
        return subscription;
    }

}
