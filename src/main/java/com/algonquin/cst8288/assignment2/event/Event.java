package com.algonquin.cst8288.assignment2.event;

/**
 * This abstract class represents an event.
 * It includes properties such as eventID, eventName, eventDescription, eventActivities, and admissionFees.
 * It also includes an abstract method calculateAdmissionFee() which needs to be implemented by all subclasses.
 */
public abstract class Event {

	/** The unique identifier for the event */
	protected int eventID;

	/** The name of the event */
	protected String eventName;

	/** A description of the event */
	protected String eventDescription;

	/** Activities associated with the event */
	protected String eventActivities;

	/** The admission fees for the event */
	protected double admissionFees;

	/**
	 * Default constructor.
	 */
	public Event() {
		// Default constructor
	}

	/**
	 * Gets the event ID.
	 *
	 * @return the event ID
	 */
	public int getEventID() {
		return eventID;
	}

	/**
	 * Sets the event ID.
	 *
	 * @param eventID the event ID to set
	 */
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	/**
	 * Gets the name of the event.
	 *
	 * @return the event name
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * Sets the name of the event.
	 *
	 * @param eventName the event name to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * Gets the description of the event.
	 *
	 * @return the event description
	 */
	public String getEventDescription() {
		return eventDescription;
	}

	/**
	 * Sets the description of the event.
	 *
	 * @param eventDescription the event description to set
	 */
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	/**
	 * Gets the activities associated with the event.
	 *
	 * @return the event activities
	 */
	public String getEventActivities() {
		return eventActivities;
	}

	/**
	 * Sets the activities associated with the event.
	 *
	 * @param eventActivities the event activities to set
	 */
	public void setEventActivities(String eventActivities) {
		this.eventActivities = eventActivities;
	}

	/**
	 * Gets the admission fees for the event.
	 *
	 * @return the admission fees
	 */
	public double getAdmissionFees() {
		return admissionFees;
	}

	/**
	 * Sets the admission fees for the event.
	 *
	 * @param admissionFees the admission fees to set
	 */
	public void setAdmissionFees(double admissionFees) {
		this.admissionFees = admissionFees;
	}

	/**
	 * Abstract method to calculate the admission fee for the event.
	 * Each subclass must provide its own implementation.
	 */
	public abstract void calculateAdmissionFee();
}