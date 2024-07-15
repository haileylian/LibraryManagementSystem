package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;

/**
 * Represents a workshop event.
 * This class extends the Event class and provides specific details and behavior for a workshop.
 */
public class Workshop extends Event {

    /**
     * Constructs a new Workshop event with predefined properties.
     */
    public Workshop() {
        this.setEventID(2);
        this.setEventName("Workshop");
        this.setEventDescription("An intensive session focusing on a specific subject or skill.");
        this.setEventActivities("Hands-on activities, expert lectures, group discussions");
        this.calculateAdmissionFee();
    }

    /**
     * Calculates the admission fee for the workshop.
     * The fee is calculated based on predefined constants.
     */
    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = Constants.WORKSHOP_RATE * Constants.WORKSHOP_DURATION;
    }
}