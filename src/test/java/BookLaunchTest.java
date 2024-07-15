

import com.algonquin.cst8288.assignment2.constants.Constants;
import com.algonquin.cst8288.assignment2.event.BookLaunch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for the BookLaunch event.
 * This class contains unit tests to verify the behavior of the BookLaunch class.
 */
public class BookLaunchTest {

    /**
     * Tests the calculateAdmissionFee method of the BookLaunch class.
     * Verifies that the admission fee is calculated correctly based on the constants.
     */
    @Test
    public void testCalculateAdmissionFee() {
        BookLaunch bookLaunch = new BookLaunch();
        bookLaunch.calculateAdmissionFee();
        double expectedFee = Constants.BOOK_LAUNCE_RATE * Constants.BOOK_LAUNCH_DURATION;
        assertEquals(expectedFee, bookLaunch.getAdmissionFees(), 0.01);
    }
}