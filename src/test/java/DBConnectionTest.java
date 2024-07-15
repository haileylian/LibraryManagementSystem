import com.algonquin.cst8288.assignment2.database.DBConnection;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Test class for the DBConnection singleton.
 * This class contains unit tests to verify the singleton behavior of the DBConnection class.
 */
public class DBConnectionTest {

    /**
     * Tests the singleton behavior of the DBConnection class.
     * Verifies that multiple calls to getInstance return the same instance.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testSingleton() throws SQLException {
        DBConnection instance1 = DBConnection.getInstance();
        DBConnection instance2 = DBConnection.getInstance();
        assertSame(instance1, instance2);
    }
}