package com.ubs.opsit.interviews.berlinclock;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestLowerRowRedLamps extends BerlinClockCommon {

    @Test
    public void testLowerRowRedLampsShouldHave4Lamps() {
        forEach0To24(hh -> assertThat(berlinClock.getLowerRowRedLamps(parseToLocalTime(hh + ":00:00"))).hasSize(4));
    }

    @Test
    public void test1CaseLowerRowRedLampsShouldSwitchedOffAllLamps() {
        assertThat(berlinClock.getLowerRowRedLamps(convertTime("00:00:00"))).isEqualTo("OOOO");
    }

    @Test
    public void test2CaseLowerRowRedLampsShouldSwitchedOffAllLamps() {
        assertThat(berlinClock.getLowerRowRedLamps(convertTime("15:00:00"))).isEqualTo("OOOO");
    }

    @Test
    public void test3CaseLowerRowRedLampsShouldSwitchedOffAllLamps() {
        assertThat(berlinClock.getLowerRowRedLamps(convertTime("20:00:00"))).isEqualTo("OOOO");
    }

    @Test
    public void test1CaseLowerRowRedLampsShouldSwitchedOnFirst1LampAndSwitchedOffLast3Lamps() {
        assertThat(berlinClock.getLowerRowRedLamps(convertTime("01:00:00"))).isEqualTo("ROOO");
    }

    @Test
    public void test2CaseLowerRowRedLampsShouldSwitchedOnFirst1LampAndSwitchedOffLast3Lamps() {
        assertThat(berlinClock.getLowerRowRedLamps(convertTime("06:00:00"))).isEqualTo("ROOO");
    }

    @Test
    public void test1CaseLowerRowRedLampsShouldSwitchedOnFirst2LampAndSwitchedOffLast2Lamps() {
        assertThat(berlinClock.getLowerRowRedLamps(convertTime("07:00:00"))).isEqualTo("RROO");
    }

    @Test
    public void test2CaseLowerRowRedLampsShouldSwitchedOnFirst2LampAndSwitchedOffLast2Lamps() {
        assertThat(berlinClock.getLowerRowRedLamps(convertTime("12:00:00"))).isEqualTo("RROO");
    }

    @Test
    public void test1CaseLowerRowRedLampsShouldSwitchedOnFirst3LampAndSwitchedOffLast1Lamps() {
        assertThat(berlinClock.getLowerRowRedLamps(convertTime("03:00:00"))).isEqualTo("RRRO");
    }

    @Test
    public void test2CaseLowerRowRedLampsShouldSwitchedOnFirst3LampAndSwitchedOffLast1Lamps() {
        assertThat(berlinClock.getLowerRowRedLamps(convertTime("08:00:00"))).isEqualTo("RRRO");
    }

    @Test
    public void test1CaseLowerRowRedLampsShouldSwitchedOnAllLamps() {
        assertThat(berlinClock.getLowerRowRedLamps(convertTime("14:00:00"))).isEqualTo("RRRR");
    }

    @Test
    public void test2CaseLowerRowRedLampsShouldSwitchedOnAllLamps() {
        assertThat(berlinClock.getLowerRowRedLamps(convertTime("24:00:00"))).isEqualTo("RRRR");
    }
}
