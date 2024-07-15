package com.algonquin.cst8288.assignment2.database;

import com.algonquin.cst8288.assignment2.event.*;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import java.sql.*;

/**
 * Implements the database operations defined in the DBOperationsDAO interface.
 * Provides functionality to create, retrieve, update, and delete events in the database.
 */
public class DBOperations implements DBOperationsDAO {
	private Connection connection;
	private static LMSLogger logger = LMSLogger.getInstance();

	/**
	 * Constructs a new DBOperations object and establishes a database connection.
	 */
	public DBOperations() {
		try {
			this.connection = DBConnection.getInstance().getConnection();
		} catch (SQLException e) {
			logger.error("Failed to get database connection", e);
		}
	}

	/**
	 * Creates a new event in the database.
	 *
	 * @param event the event to create
	 * @throws SQLException if a database access error occurs
	 */
	@Override
	public void createEvent(Event event) throws SQLException {
		String query = "INSERT INTO events (event_name, event_description, event_activities, admission_fees) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, event.getEventName());
			stmt.setString(2, event.getEventDescription());
			stmt.setString(3, event.getEventActivities());
			stmt.setDouble(4, event.getAdmissionFees());
			stmt.executeUpdate();
			logger.info("Event created: " + event.getEventName());
		} catch (SQLException e) {
			logger.error("Failed to create event: " + event.getEventName(), e);
			throw e;
		}
	}

	/**
	 * Retrieves an event from the database based on the event ID.
	 *
	 * @param eventId the ID of the event to retrieve
	 * @return the retrieved event, or null if no event is found with the specified ID
	 * @throws SQLException if a database access error occurs
	 */
	@Override
	public Event retrieveEvent(int eventId) throws SQLException {
		String query = "SELECT * FROM events WHERE event_id = ?";
		Event event = null;

		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, eventId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// Create a generic Event object
				event = new Event() {
					@Override
					public void calculateAdmissionFee() {
					}
				};
				event.setEventID(rs.getInt("event_id"));
				event.setEventName(rs.getString("event_name"));
				event.setEventDescription(rs.getString("event_description"));
				event.setEventActivities(rs.getString("event_activities"));
				event.setAdmissionFees(rs.getDouble("admission_fees"));
				logger.info("Event retrieved: " + event.getEventName());
			} else {
				logger.warn("Event not found with ID: " + eventId);
			}
		} catch (SQLException e) {
			logger.error("Failed to retrieve event with ID: " + eventId, e);
			throw e;
		}
		return event;
	}

	/**
	 * Updates an existing event in the database.
	 *
	 * @param event the event to update
	 * @throws SQLException if a database access error occurs
	 */
	@Override
	public void updateEvent(Event event) throws SQLException {
		String query = "UPDATE events SET event_name = ?, event_description = ?, event_activities = ?, admission_fees = ? WHERE event_id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, event.getEventName());
			stmt.setString(2, event.getEventDescription());
			stmt.setString(3, event.getEventActivities());
			stmt.setDouble(4, event.getAdmissionFees());
			stmt.setInt(5, event.getEventID());
			stmt.executeUpdate();
			logger.info("Event updated: " + event.getEventName());
		} catch (SQLException e) {
			logger.error("Failed to update event: " + event.getEventName(), e);
			throw e;
		}
	}

	/**
	 * Deletes an event from the database based on the event ID.
	 *
	 * @param eventId the ID of the event to delete
	 * @throws SQLException if a database access error occurs
	 */
	@Override
	public void deleteEvent(int eventId) throws SQLException {
		String query = "DELETE FROM events WHERE event_id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, eventId);
			stmt.executeUpdate();
			logger.info("Event deleted with ID: " + eventId);
		} catch (SQLException e) {
			logger.error("Failed to delete event with ID: " + eventId, e);
			throw e;
		}
	}
}