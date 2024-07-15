package com.algonquin.cst8288.assignment2.event;

/**
 * Abstract factory class for creating events.
 * This class provides a method to create different types of events.
 */
public abstract class EventFactory {

    /**
     * Creates an event based on the specified type.
     *
     * @param type the type of event to create
     * @return the created event
     */
    public abstract Event createEvent(EventType type);
}