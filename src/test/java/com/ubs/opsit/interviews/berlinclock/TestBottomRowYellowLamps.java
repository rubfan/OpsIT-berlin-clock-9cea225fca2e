package com.ubs.opsit.interviews.berlinclock;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestBottomRowYellowLamps extends BerlinClockCommon {

    @Test
    public void testBottomRowYellowLampsShouldHave4Lamps() {
        forEach0To59(mm -> assertThat(berlinClock.getBottomRowYellowLamps(parseToLocalTime("00:" + mm + ":00"))).hasSize(4));
    }

    @Test
    public void testBottomRowYellowLampsShouldSwitchedOffAllLamps() {
        assertThat(berlinClock.getBottomRowYellowLamps(parseToLocalTime("00:00:00"))).isEqualTo("OOOO");
    }

    @Test
    public void test1CaseBottomRowYellowLampsShouldSwitchedOnFirstLampAndSwitchedOffLast3Lamps() {
        assertThat(berlinClock.getBottomRowYellowLamps(parseToLocalTime("00:01:00"))).isEqualTo("YOOO");
    }

    @Test
    public void test2CaseBottomRowYellowLampsShouldSwitchedOnFirstLampAndSwitchedOffLast3Lamps() {
        assertThat(berlinClock.getBottomRowYellowLamps(parseToLocalTime("00:06:00"))).isEqualTo("YOOO");
    }

    @Test
    public void test1CaseBottomRowYellowLampsShouldSwitchedOnFirst2LampsAndSwitchedOffLast2Lamps() {
        assertThat(berlinClock.getBottomRowYellowLamps(parseToLocalTime("00:07:00"))).isEqualTo("YYOO");
    }

    @Test
    public void test2CaseBottomRowYellowLampsShouldSwitchedOnFirst2LampsAndSwitchedOffLast2Lamps() {
        assertThat(berlinClock.getBottomRowYellowLamps(parseToLocalTime("00:12:00"))).isEqualTo("YYOO");
    }

    @Test
    public void testBottomRowYellowLampsShouldSwitchedOnFirst3LampsAndSwitchedOffLastOne() {
        assertThat(berlinClock.getBottomRowYellowLamps(parseToLocalTime("00:13:00"))).isEqualTo("YYYO");
    }

    @Test
    public void test1CaseBottomRowYellowLampsShouldSwitchedOnAllLamps() {
        assertThat(berlinClock.getBottomRowYellowLamps(parseToLocalTime("00:34:00"))).isEqualTo("YYYY");
    }

    @Test
    public void test2CaseBottomRowYellowLampsShouldSwitchedOnAllLamps() {
        assertThat(berlinClock.getBottomRowYellowLamps(parseToLocalTime("00:59:00"))).isEqualTo("YYYY");
    }
}
