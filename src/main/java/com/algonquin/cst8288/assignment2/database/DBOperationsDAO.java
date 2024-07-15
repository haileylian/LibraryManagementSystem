package com.algonquin.cst8288.assignment2.database;

import com.algonquin.cst8288.assignment2.event.Event;
import java.sql.SQLException;

/**
 * Interface for database operations related to events.
 * This interface defines the basic CRUD
 * (Create, Retrieve, Update, Delete) operations for event data.
 */
public interface DBOperationsDAO {

    /**
     * Creates a new event in the database.
     *
     * @param event the event to create
     * @throws SQLException if a database access error occurs
     */
    void createEvent(Event event) throws SQLException;

    /**
     * Retrieves an event from the database based on the event ID.
     *
     * @param eventId the ID of the event to retrieve
     * @return the retrieved event
     * @throws SQLException if a database access error occurs
     */

    Event retrieveEvent(int eventId) throws SQLException;

    /**
     * Updates an existing event in the database.
     *
     * @param event the event to update
     * @throws SQLException if a database access error occurs
     */
    void updateEvent(Event event) throws SQLException;

    /**
     * Deletes an event from the database based on the event ID.
     *
     * @param eventId the ID of the event to delete
     * @throws SQLException if a database access error occurs
     */
    void deleteEvent(int eventId) throws SQLException;
}