package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;

/**
 * This class extends Event and represents a Kids Story Time event.
 * It sets the eventID, eventName, eventDescription, eventActivities, and calculates the admissionFees in the constructor.
 * It also provides an implementation for the calculateAdmissionFee() method from the Event class.
 */
public class KidsStoryTime extends Event {
    /**
     * Constructor for KidsStoryTime.
     * Sets the eventID, eventName, eventDescription, eventActivities, and calculates the admissionFees.
     */
    public KidsStoryTime() {
        this.setEventID(4);
        this.setEventName("Kids Story Time");
        this.setEventDescription("A fun event for children featuring storytelling");
        this.setEventActivities("Interactive storytelling, crafts, games");
        this.calculateAdmissionFee();
    }

    /**
     * Calculates the admission fee for a Kids Story Time event.
     * The admission fee is calculated as the product of the Kids Story Time rate and duration.
     */
    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = Constants.KIDS_STORYTIME_RATE * Constants.KIDS_STORYTIME_DURATION;
    }
}