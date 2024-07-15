import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

/**
 * Test class for the LMSLogger singleton.
 * This class contains unit tests to verify the singleton behavior of the LMSLogger class.
 */
public class LMSLoggerTest {

    /**
     * Tests the singleton behavior of the LMSLogger class.
     * Verifies that multiple calls to getInstance return the same instance and that the instance is not null.
     */
    @Test
    public void testSingletonInstance() {
        LMSLogger logger1 = LMSLogger.getInstance();
        LMSLogger logger2 = LMSLogger.getInstance();

        assertNotNull(logger1);
        assertNotNull(logger2);
        assertSame(logger1, logger2);
    }
}