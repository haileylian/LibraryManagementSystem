package com.algonquin.cst8288.assignment2.event;

/**
 * Factory class for creating events specific to an academic library.
 * This class implements the abstract method to create different types of academic library events.
 */
public class AcademicLibraryEventFactory extends EventFactory {

    /**
     * Creates an event based on the specified type for an academic library.
     *
     * @param type the type of event to create
     * @return the created event, or null if the event type is not recognized
     */
    @Override
    public Event createEvent(EventType type) {
        switch (type) {
            case WORKSHOP:
                return new Workshop();
            case BOOK_LAUNCH:
                return new BookLaunch();
            default:
                return null;
        }
    }
}