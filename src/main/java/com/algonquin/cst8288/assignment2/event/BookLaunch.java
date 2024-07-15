package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;

/**
 * Represents a book launch event.
 * This class extends the Event class and provides specific details and behavior for a book launch.
 */
public class BookLaunch extends Event {

    /**
     * Constructs a new Book Launch event with predefined properties.
     */
    public BookLaunch() {
        this.setEventID(1);
        this.setEventName("Book Launch");
        this.setEventDescription("A ceremony celebrating the release of a new book.");
        this.setEventActivities("Author reading, Q&A session, book signing.");
        this.calculateAdmissionFee();
    }

    /**
     * Calculates the admission fee for the book launch.
     * The fee is calculated based on predefined constants.
     */
    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = Constants.BOOK_LAUNCE_RATE * Constants.BOOK_LAUNCH_DURATION;
    }
}