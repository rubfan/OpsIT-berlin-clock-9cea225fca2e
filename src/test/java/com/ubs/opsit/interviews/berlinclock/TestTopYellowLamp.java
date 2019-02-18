package com.ubs.opsit.interviews.berlinclock;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestTopYellowLamp extends BerlinClockCommon {

    @Test
    public void testYellowLampShouldHave1Lamp() {
        forEach0To59(ss -> assertThat(berlinClock.getYellowLamp(parseToLocalTime("00:00:" + ss))).hasSize(1));
    }

    @Test
    public void testYellowLampShouldSwitchedOn1thSecond() {
        assertThat(berlinClock.getYellowLamp(parseToLocalTime("00:00:00"))).isEqualTo("Y");
    }

    @Test
    public void testYellowLampShouldSwitchedOff2ndSecond() {
        assertThat(berlinClock.getYellowLamp(parseToLocalTime("00:00:01"))).isEqualTo("O");
    }

    @Test
    public void testYellowLampShouldSwitchedOff3rdSecond() {
        assertThat(berlinClock.getYellowLamp(parseToLocalTime("00:00:02"))).isEqualTo("Y");
    }

    @Test
    public void testYellowLampShouldSwitchedOff59thSecond() {
        assertThat(berlinClock.getYellowLamp(parseToLocalTime("00:00:59"))).isEqualTo("O");
    }
}
