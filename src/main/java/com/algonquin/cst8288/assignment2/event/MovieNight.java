package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;

/**
 * Represents a Movie Night event.
 * This class extends the Event class and provides specific details and behavior for a Movie Night event.
 */
public class MovieNight extends Event {

    /**
     * Constructs a new Movie Night event with predefined properties.
     */
    public MovieNight() {
        this.setEventID(3);
        this.setEventName("Movie Night");
        this.setEventDescription("A night of seeing a movie.");
        this.setEventActivities("Watching movies, discuss sessions!");
        this.calculateAdmissionFee();
    }

    /**
     * Calculates the admission fee for the Movie Night event.
     * The fee is calculated based on predefined constants.
     */
    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = Constants.MOVIE_NIGHT_RATE * Constants.MOVIE_NIGHT_DURATION;
    }
}