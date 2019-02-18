package com.ubs.opsit.interviews.berlinclock;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestBottomRowYellowRedLamps extends BerlinClockCommon {

    @Test
    public void testBottomRowYellowRedLampsShouldHave4Lamps() {
        forEach0To59(mm -> assertThat(berlinClock.getBottomRowYellowRedLamps(parseToLocalTime("00:" + mm + ":00"))).hasSize(11));
    }

    @Test
    public void testBottomRowYellowRedLampsShouldSwitchedOffAllLamps() {
        assertThat(berlinClock.getBottomRowYellowRedLamps(parseToLocalTime("00:00:00"))).isEqualTo("OOOOOOOOOOO");
    }

    @Test
    public void testBottomRowYellowRedLampsShouldSwitchedOnFirst3LampAndSwitchedOffLast8Lamps3rdLampShouldBeRed() {
        assertThat(berlinClock.getBottomRowYellowRedLamps(parseToLocalTime("00:17:00"))).isEqualTo("YYROOOOOOOO");
    }

    @Test
    public void testBottomRowYellowRedLampsShouldSwitchedOnFirst7LampAndSwitchedOffLast4Lamps3rd6thLampsShouldBeRed() {
        assertThat(berlinClock.getBottomRowYellowRedLamps(parseToLocalTime("00:39:00"))).isEqualTo("YYRYYRYOOOO");
    }

    @Test
    public void testBottomRowYellowRedLampsShouldSwitchedOnAllLamps3rd6th9thLampsShouldBeRed() {
        assertThat(berlinClock.getBottomRowYellowRedLamps(parseToLocalTime("00:59:00"))).isEqualTo("YYRYYRYYRYY");
    }
}
