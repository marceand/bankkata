import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Marcel on 1/5/2017.
 */
public class ClockShould {

    @Test
    public void return_today_date_in_dd_MM_yyyy_format() throws Exception{

        Clock clock = new TestableClock();
        String date = clock.todayAsString();

        assertThat(date,is("24/04/2015"));
    }

    private class TestableClock extends Clock {
        @Override
        protected LocalDate today() {
            return LocalDate.of(2015,4,24);
        }
    }
}