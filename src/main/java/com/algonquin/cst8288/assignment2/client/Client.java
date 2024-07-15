package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.database.DBOperations;
import com.algonquin.cst8288.assignment2.database.DBConnection;
import com.algonquin.cst8288.assignment2.event.*;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;

import java.sql.SQLException;

/**
 * Client class to demonstrate the use of the application.
 * This class initializes the database connection, creates events using the Factory Pattern,
 * and performs CRUD operations on the events.
 */
public class Client {

	/**
	 * The main method of the application.
	 * It performs the following operations:
	 * - Connects to the database
	 * - Creates events using the Factory Pattern
	 * - Adds the events to the database
	 * - Updates an event
	 * - Deletes an event
	 * - Closes the database connection and the logger
	 *
	 * @param args the command-line arguments
	 */
	public static void main(String[] args) {
		LMSLogger logger = LMSLogger.getInstance();
		DBConnection dbConnection = null;

		try {
			dbConnection = DBConnection.getInstance();
			if (dbConnection.getConnection() == null) {
				logger.error("Database connection failed.");
				return;
			}
			logger.info("Database connection successful.");

			DBOperations dbOps = new DBOperations();
			EventFactory academicLibraryFactory = new AcademicLibraryEventFactory();
			EventFactory publicLibraryFactory = new PublicLibraryEventFactory();

			Event[] events = {
					academicLibraryFactory.createEvent(EventType.WORKSHOP),
					academicLibraryFactory.createEvent(EventType.BOOK_LAUNCH),
					publicLibraryFactory.createEvent(EventType.MOVIE_NIGHT),
					publicLibraryFactory.createEvent(EventType.KIDS_STORY)
			};

			for (Event event : events) {
				dbOps.createEvent(event);
			}
			logger.info("Events created and added to the database.");

			Event workshop = events[1];
			workshop.setEventName("Updated Workshop");
			workshop.setEventDescription("Updated description");
			workshop.setEventActivities("Updated activities");
			workshop.calculateAdmissionFee();
			dbOps.updateEvent(workshop);
			logger.info("Event updated: " + workshop.getEventName());

			Event movieNight = events[2];
			Event retrievedEvent = dbOps.retrieveEvent(movieNight.getEventID());
			if (retrievedEvent != null) {
				System.out.println("Retrieved Event Details:");
				System.out.println("ID: " + retrievedEvent.getEventID());
				System.out.println("Name: " + retrievedEvent.getEventName());
				System.out.println("Description: " + retrievedEvent.getEventDescription());
				System.out.println("Activities: " + retrievedEvent.getEventActivities());
				System.out.println("Admission Fees: " + retrievedEvent.getAdmissionFees());
			} else {
				System.out.println("No event found with ID: " + movieNight.getEventID());
			}

			Event bookLaunch = events[3];
			dbOps.deleteEvent(bookLaunch.getEventID());
			logger.info("Event deleted: " + bookLaunch.getEventName());

			logger.info("Events updated and deleted in the database.");
		} catch (SQLException e) {
			logger.error("Database error occurred", e);
		} catch (Exception e) {
			logger.error("An unexpected error occurred", e);
		} finally {
			logger.info("Application ended");
			if (dbConnection != null) {
				dbConnection.close();
			}
			logger.close();
		}
	}
}