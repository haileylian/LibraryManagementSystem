import com.algonquin.cst8288.assignment2.constants.Constants;
import com.algonquin.cst8288.assignment2.event.MovieNight;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for the MovieNight event.
 * This class contains unit tests to verify the behavior of the MovieNight class.
 */
public class MovieNightTest {

    /**
     * Tests the calculateAdmissionFee method of the MovieNight class.
     * Verifies that the admission fee is calculated correctly based on the constants.
     */
    @Test
    public void testCalculateAdmissionFee() {
        MovieNight movieNight = new MovieNight();
        double expectedFee = Constants.MOVIE_NIGHT_RATE * Constants.MOVIE_NIGHT_DURATION;
        assertEquals(expectedFee, movieNight.getAdmissionFees(), 0.01);
    }
}