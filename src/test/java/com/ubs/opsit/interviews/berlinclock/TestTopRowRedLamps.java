package com.ubs.opsit.interviews.berlinclock;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestTopRowRedLamps extends BerlinClockCommon {

    @Test
    public void testTopRowRedLampsShouldHave4Lamps() {
        forEach0To24(hh -> assertThat(berlinClock.getTopRowRedLamps(parseToLocalTime(hh + ":00:00"))).hasSize(4));
    }

    @Test
    public void testTopRowRedLampsShouldSwitchedOffAllLamps() {
        assertThat(berlinClock.getTopRowRedLamps(convertTime("00:00:00"))).isEqualTo("OOOO");
    }

    @Test
    public void testTopRowRedLampsShouldSwitchedOnFirstLampAndSwitchedOffLast3Lamps() {
        assertThat(berlinClock.getTopRowRedLamps(convertTime("07:00:00"))).isEqualTo("ROOO");
    }

    @Test
    public void testTopRowRedLampsShouldSwitchedOnFirst2LampsAndSwitchedOffLast2Lamps() {
        assertThat(berlinClock.getTopRowRedLamps(convertTime("14:00:00"))).isEqualTo("RROO");
    }

    @Test
    public void testTopRowRedLampsShouldSwitchedOnFirst3LampsAndSwitchedOffLastOne() {
        assertThat(berlinClock.getTopRowRedLamps(convertTime("15:00:00"))).isEqualTo("RRRO");
    }

    @Test
    public void testTopRowRedLampsShouldSwitchedOnAllLamps() {
        assertThat(berlinClock.getTopRowRedLamps(convertTime("24:00:00"))).isEqualTo("RRRR");
    }
}
