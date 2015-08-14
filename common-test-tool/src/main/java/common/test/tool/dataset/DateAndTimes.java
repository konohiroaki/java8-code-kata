package common.test.tool.dataset;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateAndTimes {

    public static final LocalDate LD_20150618 = LocalDate.of(2015, 6, 18);
    public static final LocalDate LD_20150807 = LocalDate.of(2015, 8, 7);
    public static final LocalTime LT_23073050 = LocalTime.of(23, 7, 30, 500000000);
    public static final LocalTime LT_12100000 = LocalTime.of(12, 10);
    public static final LocalDateTime LDT_20150618_23073050 = LocalDateTime.of(2015, 6, 18, 23, 7, 30, 500000000);
    public static final ZonedDateTime
        ZDT_20150618_23073050 = ZonedDateTime.of(LDT_20150618_23073050, ZoneId.of("Asia/Tokyo"));

    public static final Date OLD_DATE_20150618 = Date.valueOf("2015-06-18");
    public static final Timestamp OLD_TIMESTAMP_20150618_23073050 = Timestamp.valueOf("2015-06-18 23:07:30.5");
}
