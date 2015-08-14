package common.test.tool.dataset;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateAndTimes {

    public static final LocalDate ld_20150618 = LocalDate.of(2015, 6, 18);
    public static final LocalDate ld_20150807 = LocalDate.of(2015, 8, 7);
    public static final LocalTime lt_23073050 = LocalTime.of(23, 7, 30, 500000000);
    public static final LocalTime lt_12100000 = LocalTime.of(12, 10);
    public static final LocalDateTime ldt_20150618_23073050 = LocalDateTime.of(2015, 6, 18, 23, 7, 30, 500000000);
    public static final ZonedDateTime
        zdt_20150618_23073050 = ZonedDateTime.of(ldt_20150618_23073050, ZoneId.of("Asia/Tokyo"));
}
