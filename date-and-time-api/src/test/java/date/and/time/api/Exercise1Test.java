package date.and.time.api;

import common.test.tool.annotation.Easy;
import common.test.tool.dataset.DateAndTimes;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Exercise1Test {

    @Easy @Test
    public void localDateOf() {
        /**
         * Create a {@link LocalDate} of 2015-06-18 by using {@link LocalDate#of}
         */
        LocalDate localDate = LocalDate.of(2015, 6, 18);

        assertThat(localDate.toString(), is("2015-06-18"));
    }

    @Easy @Test
    public void localDateParse() {
        /**
         * Create a {@link LocalDate} of 2015-06-18 from String by using {@link LocalDate#parse}
         */
        LocalDate localDate = LocalDate.parse("2015-06-18");

        assertThat(localDate.toString(), is("2015-06-18"));
    }

    @Easy @Test
    public void localDateWith() {
        LocalDate ld = DateAndTimes.LD_20150618;

        /**
         * Create a {@link LocalDate} from {@link ld} with year 2015
         * by using {@link LocalDate#withYear} or {@link LocalDate#with}
         *
         * This makes no sense. {@link ld} is in 2015 why is it a test to make a new {@link LocalDate} in the same year?
         */
        LocalDate localDate = ld.withYear(2016);

        assertThat(localDate.getYear(), is(2016));
        assertThat(localDate.getMonth(), is(ld.getMonth()));
        assertThat(localDate.getDayOfMonth(), is(ld.getDayOfMonth()));
    }

    @Easy @Test
    public void localDateWithAdjuster() {
        LocalDate ld = DateAndTimes.LD_20150618;

        /**
         * Create a {@link LocalDate} from {@link ld} adjusted into first day of next year
         * by using {@link LocalDate#with} and {@link TemporalAdjusters#firstDayOfNextYear}
         */
        LocalDate localDate = ld.with(TemporalAdjusters.firstDayOfNextYear());

        assertThat(localDate.getYear(), is(ld.getYear() + 1));
        assertThat(localDate.getMonth(), is(Month.JANUARY));
        assertThat(localDate.getDayOfMonth(), is(1));
    }

    @Easy @Test
    public void localDatePlus() {
        LocalDate ld = DateAndTimes.LD_20150618;

        /**
         * Create a {@link LocalDate} from {@link ld} with 10 month later
         * by using {@link LocalDate#plusMonths} or {@link LocalDate#plus}
         */
        LocalDate localDate = ld.plusMonths(10);

        assertThat(localDate.getYear(), is(ld.getYear() + 1));
        assertThat(localDate.getMonth(), is(Month.APRIL));
        assertThat(localDate.getDayOfMonth(), is(ld.getDayOfMonth()));
    }

    @Easy @Test
    public void localDateMinus() {
        LocalDate ld = DateAndTimes.LD_20150618;

        /**
         * Create a {@link LocalDate} from {@link ld} with 10 days before
         * by using {@link LocalDate#minusDays} or {@link LocalDate#minus}
         */
        LocalDate localDate = ld.minusDays(10);

        assertThat(localDate.getYear(), is(ld.getYear()));
        assertThat(localDate.getMonth(), is(ld.getMonth()));
        assertThat(localDate.getDayOfMonth(), is(ld.getDayOfMonth() - 10));
    }


    @Easy @Test
    public void localDatePlusPeriod() {
        LocalDate ld = DateAndTimes.LD_20150618;

        /**
         * Define a {@link Period} of 1 year 2 month 3 days
         * Create a {@link LocalDate} adding the period to {@link ld} by using {@link LocalDate#plus}
         */
        Period period = Period.of(1, 2, 3);
        LocalDate localDate = ld.plus(period);

        assertThat(localDate.getYear(), is(ld.getYear() + 1));
        assertThat(period.getMonths(), is(2));
        assertThat(localDate.getDayOfMonth(), is(ld.getDayOfMonth() + 3));
    }

    @Easy @Test
    public void localDateIsAfter() {
        LocalDate ld = DateAndTimes.LD_20150618;
        LocalDate ld2 = DateAndTimes.LD_20150807;

        /**
         * Check whether {@link ld2} is after {@link ld} or not
         * by using {@link LocalDate#isAfter} or {@link LocalDate#isBefore}
         */
        boolean isAfter0618 = ld2.isAfter(ld);

        assertThat(isAfter0618, is(true));
    }

    @Easy @Test
    public void localDateUntil() {
        LocalDate ld = DateAndTimes.LD_20150618;
        LocalDate ld2 = DateAndTimes.LD_20150807;

        /**
         * Create a period from {@link ld} till {@link ld2}
         * by using {@link LocalDate#until}
         */
        Period period = ld.until(ld2);

        assertThat(period.getYears(), is(0));
        assertThat(period.getMonths(), is(1));
        assertThat(period.getDays(), is(20));
    }
}
