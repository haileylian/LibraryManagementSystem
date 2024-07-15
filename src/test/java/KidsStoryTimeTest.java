import com.algonquin.cst8288.assignment2.constants.Constants;
import com.algonquin.cst8288.assignment2.event.KidsStoryTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for the KidsStoryTime event.
 * This class contains unit tests to verify the behavior of the KidsStoryTime class.
 */
public class KidsStoryTimeTest {

    /**
     * Tests the calculateAdmissionFee method of the KidsStoryTime class.
     * Verifies that the admission fee is calculated correctly based on the constants.
     */
    @Test
    public void testCalculateAdmissionFee() {
        KidsStoryTime kidsStoryTime = new KidsStoryTime();
        kidsStoryTime.calculateAdmissionFee();
        double expectedFee = Constants.KIDS_STORYTIME_RATE * Constants.KIDS_STORYTIME_DURATION;
        assertEquals(expectedFee, kidsStoryTime.getAdmissionFees(), 0.01);
    }
}