package com.ubs.opsit.interviews.berlinclock;

import org.junit.Test;

import java.time.format.DateTimeParseException;
import java.util.StringJoiner;

import static org.assertj.core.api.Assertions.assertThat;

public class TestBerlinClock extends BerlinClockCommon {

    @Test(expected = DateTimeParseException.class)
    public void test1CaseBerlinClockTimeShouldWorkWithHHmmssFormatSeparatedByColon() {
        berlinClock.convertTime("1:22:33");
    }

    @Test(expected = DateTimeParseException.class)
    public void test2CaseBerlinClockTimeShouldWorkWithHHmmssFormatSeparatedByColon() {
        berlinClock.convertTime("001:22:33");
    }

    @Test(expected = DateTimeParseException.class)
    public void test3CaseBerlinClockTimeShouldWorkWithHHmmssFormatSeparatedByColon() {
        berlinClock.convertTime("01:22:033");
    }

    @Test(expected = DateTimeParseException.class)
    public void test4CaseBerlinClockTimeShouldWorkWithHHmmssFormatSeparatedByColon() {
        berlinClock.convertTime("11/22/33");
    }

    @Test
    public void testBerlinClockTimeLengthShouldBe28() {
        for (int i = 0; i < 24; i++) {
            String hh = attachZeroPrefix(i);
            forEach0To59(mm ->
                forEach0To59(ss ->
                    assertThat(berlinClock.convertTime(hh + ":" + mm + ":" + ss)).hasSize(28)));
        }
    }

    @Test
    public void test2CaseBerlinClockTimeLengthShouldBe28() {
        assertThat(berlinClock.convertTime("24:00:00")).hasSize(28);
    }

    @Test(expected = DateTimeParseException.class)
    public void testCase1BerlinClockShouldOnlyWorkOnlyWith24HourRange() {
        berlinClock.convertTime("24:11:22");
    }

    @Test(expected = DateTimeParseException.class)
    public void testCase2BerlinClockShouldOnlyWorkOnlyWith24HourRange() {
        berlinClock.convertTime("25:00:00");
    }

    @Test(expected = DateTimeParseException.class)
    public void testCase3BerlinClockShouldOnlyWorkOnlyWith24HourRange() {
        berlinClock.convertTime("-1:00:00");
    }

    @Test(expected = DateTimeParseException.class)
    public void testCase1BerlinClockShouldOnlyWorkOnlyWith59MinuteRange() {
        berlinClock.convertTime("11:60:00");
    }

    @Test(expected = DateTimeParseException.class)
    public void testCase2BerlinClockShouldOnlyWorkOnlyWith59MinuteRange() {
        berlinClock.convertTime("11:1234:00");
    }

    @Test(expected = DateTimeParseException.class)
    public void testCase3BerlinClockShouldOnlyWorkOnlyWith59MinuteRange() {
        berlinClock.convertTime("22:-33:00");
    }

    @Test(expected = DateTimeParseException.class)
    public void testCase1BerlinClockShouldOnlyWorkOnlyWith59SecondRange() {
        berlinClock.convertTime("05:44:65");
    }

    @Test(expected = DateTimeParseException.class)
    public void testCase2BerlinClockShouldOnlyWorkOnlyWith59SecondRange() {
        berlinClock.convertTime("05:44:-22");
    }

    @Test
    public void testBerlinClockTimeShouldReturnAllLampsSwitchedOff() {
        assertThat(berlinClock.convertTime("00:00:01")).isEqualTo(new StringJoiner(System.lineSeparator())
            .add("O")
            .add("OOOO")
            .add("OOOO")
            .add("OOOOOOOOOOO")
            .add("OOOO")
            .toString()
        );
    }

    @Test
    public void test1CaseBerlinClockTimeShouldReturnCorrectTime() {
        assertThat(berlinClock.convertTime("00:00:00")).isEqualTo(new StringJoiner(System.lineSeparator())
            .add("Y")
            .add("OOOO")
            .add("OOOO")
            .add("OOOOOOOOOOO")
            .add("OOOO")
            .toString()
        );
    }

    @Test
    public void test2CaseBerlinClockTimeShouldReturnCorrectTime() {
        assertThat(berlinClock.convertTime("24:00:00")).isEqualTo(new StringJoiner(System.lineSeparator())
            .add("Y")
            .add("RRRR")
            .add("RRRR")
            .add("OOOOOOOOOOO")
            .add("OOOO")
            .toString()
        );
    }

    @Test
    public void test3CaseBerlinClockTimeShouldReturnCorrectTime() {
        assertThat(berlinClock.convertTime("00:59:01")).isEqualTo(new StringJoiner(System.lineSeparator())
            .add("O")
            .add("OOOO")
            .add("OOOO")
            .add("YYRYYRYYRYY")
            .add("YYYY")
            .toString()
        );
    }

    @Test
    public void test4CaseBerlinClockTimeShouldReturnCorrectTime() {
        assertThat(berlinClock.convertTime("23:59:59")).isEqualTo(new StringJoiner(System.lineSeparator())
            .add("O")
            .add("RRRR")
            .add("RRRO")
            .add("YYRYYRYYRYY")
            .add("YYYY")
            .toString()
        );
    }
}
