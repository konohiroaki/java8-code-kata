package date.and.time.api;

import common.test.tool.annotation.Easy;
import common.test.tool.dataset.DateAndTimes;

import org.junit.Test;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Though old Date APIs are not recommended to use with Java8 Date and Time APIs, there could be some cases that you
 * need to do so. Thus you should know how to convert bidirectionally.
 */
public class Exercise5Test {

    @Easy @Test
    public void localDateTime2Timestamp() {
        LocalDateTime ldt = DateAndTimes.LDT_20150618_23073050;

        /**
         * Create a {@link java.sql.Timestamp} from {@link ldt}
         */
        Timestamp timestamp = Timestamp.valueOf(ldt);

        assertThat(timestamp.toString(), is("2015-06-18 23:07:30.5"));
    }

    @Easy @Test
    public void localDate2date() {
        LocalDate ld = DateAndTimes.LD_20150618;

        /**
         * Create a {@link java.sql.Date} from {@link ld}
         */
        Date date = Date.valueOf(ld);

        assertThat(date.toString(), is("2015-06-18"));
    }

    @Easy @Test
    public void timestamp2LocalDateTime() {
        Timestamp timestamp = DateAndTimes.OLD_TIMESTAMP_20150618_23073050;

        /**
         * Create a {@link LocalDateTime} from {@link timestamp}
         */
        LocalDateTime localDateTime = timestamp.toLocalDateTime();

        assertThat(localDateTime.toString(), is("2015-06-18T23:07:30.500"));
    }

    @Easy @Test
    public void date2LocalDate() {
        Date date = DateAndTimes.OLD_DATE_20150618;

        /**
         * Create a {@link LocalDate} from {@link date}
         */
        LocalDate localDate = date.toLocalDate();

        assertThat(localDate.toString(), is("2015-06-18"));
    }
}
