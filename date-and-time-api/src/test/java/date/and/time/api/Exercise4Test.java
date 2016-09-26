package date.and.time.api;

import common.test.tool.annotation.Easy;
import common.test.tool.dataset.DateAndTimes;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Exercise4Test {

    @Easy @Test
    public void zonedDateTimeOf() {
        /**
         * Create a {@link ZonedDateTime} with time of 2015-07-10 2:14:25.000 as Japan Standard Time
         * by using {@link ZonedDateTime#of} and {@link ZoneId#of}
         */
        ZonedDateTime zonedDateTime = null;

        assertThat(zonedDateTime.toString(), is("2015-07-10T02:14:25+09:00[Asia/Tokyo]"));
    }

    @Easy @Test
    public void zonedDateTimeParse() {
        /**
         * Create a {@link ZonedDateTime} with time of 2015-06-18 23:07:25.000 as Japan Standard Time
         * by using {@link ZonedDateTime#parse}
         */
        ZonedDateTime zonedDateTime = null;

        assertThat(zonedDateTime.toString(), is("2015-06-18T23:07:25+09:00[Asia/Tokyo]"));
    }

    @Easy @Test
    public void zonedDateTimeFormat() {
        ZonedDateTime zdt = DateAndTimes.ZDT_20150618_23073050;

        /**
         * Format {@link zdt} to a {@link String} as "2015_06_18_23_07_30_JST"
         * by using {@link ZonedDateTime#format}
         */
        String strZdt = null;

        assertThat(strZdt, is("2015_06_18_23_07_30_JST"));
    }

    @Easy @Test
    public void toPST() {
        LocalDateTime ldt = DateAndTimes.LDT_20150618_23073050;

        /**
         * Create a {@link ZonedDateTime} from {@link ldt} with Pacific Standard Time
         */
        ZonedDateTime zonedDateTime = null;

        assertThat(zonedDateTime.toLocalDateTime(), is(ldt));
        assertThat(zonedDateTime.getZone().toString(), is("America/Los_Angeles"));
    }

    @Easy @Test
    public void sameInstantAs() {
        ZonedDateTime zdt = DateAndTimes.ZDT_20150618_23073050;

        /**
         * Create a {@link ZonedDateTime} same instant as {@link zdt} with Pacific Standard Time
         * by using {@link ZonedDateTime#withZoneSameInstant}
         */
        ZonedDateTime zonedDateTime = null;

        assertThat(zonedDateTime.toString(), is("2015-06-18T07:07:30.500-07:00[America/Los_Angeles]"));
    }

    @Easy @Test
    public void sameLocalAs() {
        ZonedDateTime zdt = DateAndTimes.ZDT_20150618_23073050;

        /**
         * Create a {@link ZonedDateTime} same local time as {@link zdt} with Pacific Standard Time
         * by using {@link ZonedDateTime#withZoneSameLocal}
         */
        ZonedDateTime zonedDateTime = null;

        assertThat(zonedDateTime.toString(), is("2015-06-18T23:07:30.500-07:00[America/Los_Angeles]"));
    }
}
