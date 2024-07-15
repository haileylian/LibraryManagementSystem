import com.algonquin.cst8288.assignment2.constants.Constants;
import com.algonquin.cst8288.assignment2.event.Workshop;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for the Workshop event.
 * This class contains unit tests to verify the behavior of the Workshop class.
 */
public class WorkshopTest {

    /**
     * Tests the calculateAdmissionFee method of the Workshop class.
     * Verifies that the admission fee is calculated correctly based on the constants.
     */
    @Test
    public void testCalculateAdmissionFee() {
        Workshop workshop = new Workshop();
        workshop.calculateAdmissionFee();
        double expectedFee = Constants.WORKSHOP_RATE * Constants.WORKSHOP_DURATION;
        assertEquals(expectedFee, workshop.getAdmissionFees(), 0.01);
    }
}