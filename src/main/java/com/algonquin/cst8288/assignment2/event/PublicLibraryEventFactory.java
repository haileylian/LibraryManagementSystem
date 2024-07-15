package com.algonquin.cst8288.assignment2.event;

/**
 * Factory class for creating events specific to a public library.
 * This class implements the abstract method to create different types of public library events.
 */
public class PublicLibraryEventFactory extends EventFactory {

    /**
     * Creates an event based on the specified type for a public library.
     *
     * @param type the type of event to create
     * @return the created event, or null if the event type is not recognized
     */
    @Override
    public Event createEvent(EventType type) {
        switch (type) {
            case KIDS_STORY:
                return new KidsStoryTime();
            case MOVIE_NIGHT:
                return new MovieNight();
            default:
                return null;
        }
    }
}