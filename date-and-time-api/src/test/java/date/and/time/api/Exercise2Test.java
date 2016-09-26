package date.and.time.api;

import common.test.tool.annotation.Easy;
import common.test.tool.dataset.DateAndTimes;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalTime;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Exercise2Test {

    @Easy @Test
    public void localTimeOfHourToMinute() {
        /**
         * Create a {@link LocalTime} of 23:07 by using {@link LocalTime#of}
         */
        LocalTime localTime = null;

        assertThat(localTime.toString(), is("23:07"));
    }

    @Easy @Test
    public void localTimeOfHourToNanoSec() {
        /**
         * Create a {@link LocalTime} of 23:07:03.1 by using {@link LocalTime#of}
         */
        LocalTime localTime = null;

        assertThat(localTime.toString(), is("23:07:03.100"));
    }

    @Easy @Test
    public void localTimeParse() {
        /**
         * Create a {@link LocalTime} of 23:07:03.1 from String by using {@link LocalTime#parse}
         */
        LocalTime localTime = null;

        assertThat(localTime.toString(), is("23:07:03.100"));
    }

    @Easy @Test
    public void localTimeWith() {
        LocalTime lt = DateAndTimes.LT_23073050;

        /**
         * Create a {@link LocalTime} from {@link lt} with hour 21
         * by using {@link LocalTime#withHour} or {@link LocalTime#with}
         */
        LocalTime localTime = null;

        assertThat(localTime.getHour(), is(21));
        assertThat(localTime.getMinute(), is(lt.getMinute()));
        assertThat(localTime.getSecond(), is(lt.getSecond()));
    }

    @Easy @Test
    public void localTimePlus() {
        LocalTime lt = DateAndTimes.LT_23073050;

        /**
         * Create a {@link LocalTime} from {@link lt} with 30 minutes later
         * by using {@link LocalTime#plusMinutes} or {@link LocalTime#plus}
         */
        LocalTime localTime = null;

        assertThat(localTime.getHour(), is(lt.getHour()));
        assertThat(localTime.getMinute(), is(lt.getMinute() + 30));
        assertThat(localTime.getSecond(), is(lt.getSecond()));
    }

    @Easy @Test
    public void localTimeMinus() {
        LocalTime lt = DateAndTimes.LT_23073050;

        /**
         * Create a {@link LocalTime} from {@link lt} with 3 hours before
         * by using {@link LocalTime#minusHours} or {@link LocalTime#minus}
         */
        LocalTime localTime = null;

        assertThat(localTime.getHour(), is(lt.getHour() - 3));
        assertThat(localTime.getMinute(), is(lt.getMinute()));
        assertThat(localTime.getSecond(), is(lt.getSecond()));
    }


    @Easy @Test
    public void localTimeMinusDuration() {
        LocalTime lt = DateAndTimes.LT_23073050;

        /**
         * Define a {@link Duration} of 3 hours 30 minutes and 20.2 seconds
         * Create a {@link LocalTime} subtracting the duration from {@link lt} by using {@link LocalTime#minus}
         */
        Duration duration = null;
        LocalTime localTime = null;

        assertThat(localTime.getHour(), is(19));
        assertThat(localTime.getMinute(), is(37));
        assertThat(localTime.getSecond(), is(10));
        assertThat(localTime.getNano(), is(300000000));
        assertThat(duration.getSeconds(), is(12620L));
        assertThat(duration.getNano(), is(200000000));

    }

    @Easy @Test
    public void localDateIsBefore() {
        LocalTime lt = DateAndTimes.LT_23073050;
        LocalTime lt2 = DateAndTimes.LT_12100000;
        /**
         * Check whether {@link lt2} is before {@link lt} or not
         * by using {@link LocalTime#isAfter} or {@link LocalTime#isBefore}
         */
        boolean isBefore2307 = false;

        assertThat(isBefore2307, is(true));
    }

    @Easy @Test
    public void localTimeTruncatedTo() {
        LocalTime lt = DateAndTimes.LT_23073050;

        /**
         * Create a {@link LocalTime} from {@link lt} truncated to minutes by using {@link LocalTime#truncatedTo}
         */
        LocalTime localTime = null;

        assertThat(lt.toString(), is("23:07:30.500"));
        assertThat(localTime.toString(), is("23:07"));
    }
}
