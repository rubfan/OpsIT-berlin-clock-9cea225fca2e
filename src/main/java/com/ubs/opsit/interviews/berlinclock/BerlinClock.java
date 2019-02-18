package com.ubs.opsit.interviews.berlinclock;

import com.ubs.opsit.interviews.TimeConverter;

import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.StringJoiner;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BerlinClock implements TimeConverter {
    private final static String TIME_FORMAT = "HH:mm:ss";

    @Override
    public String convertTime(String aTime) {
        TemporalAccessor temporalAccessor = DateTimeFormatter.ofPattern(TIME_FORMAT).parse(aTime);
        LocalTime localTime = LocalTime.from(temporalAccessor);

        return new StringJoiner(System.lineSeparator())
                .add(getYellowLamp(localTime))
                .add(getTopRowRedLamps(temporalAccessor))
                .add(getLowerRowRedLamps(temporalAccessor))
                .add(getBottomRowYellowRedLamps(localTime))
                .add(getBottomRowYellowLamps(localTime))
                .toString();
    }

    /**
     * On the top of the clock there is a yellow lamp that blinks on/off every two seconds.
     */
    String getYellowLamp(LocalTime time) {
        return getLamps(Lamp.YELLOW, 1, 1 - time.getSecond() % 2);
    }

    /**
     * In the top row there are 4 red lamps. Every lamp represents 5 hours.
     */
    String getTopRowRedLamps(TemporalAccessor temporalAccessor) {
        return getLamps(Lamp.RED, 4, fetchHour(temporalAccessor) / 5);
    }

    /**
     * In the lower row of red lamps every lamp represents 1 hour .
     */
    String getLowerRowRedLamps(TemporalAccessor temporalAccessor) {
        return getLamps(Lamp.RED, 4, fetchHour(temporalAccessor) % 5);
    }

    /**
     * The first of bottom rows has 11 yellow and red lamps. Every lamp represents 5 minutes.
     * The 3rd, 6th and 9th lamp are red and indicate the first quarter, half and last quarter of an hour.
     * The other lamps are yellow.
     */
    String getBottomRowYellowRedLamps(LocalTime time) {
        return getLamps(i -> i % 3 == 0 ? Lamp.RED : Lamp.YELLOW, 11, time.getMinute() / 5);
    }

    /**
     * The second of bottom rows has 4 yellow lamps every lamp represents 1 minute.
     */
    String getBottomRowYellowLamps(LocalTime time) {
        return getLamps(Lamp.YELLOW, 4, time.getMinute() % 5);
    }

    /**
     * Common methods that gathers the lamps.
     */
    private String getLamps(Lamp lamp, int numberOfLamps, int turnedOnLamps) {
        return getLamps(i -> lamp, numberOfLamps, turnedOnLamps);
    }

    private String getLamps(IntFunction<Lamp> mapper, int numberOfLamps, int turnedOnLamps) {
        return IntStream.rangeClosed(1, numberOfLamps)
                .mapToObj(i -> turnedOnLamps >= i ? mapper.apply(i) : Lamp.OFF)
                .map(Lamp::toString)
                .collect(Collectors.joining());
    }

    /**
     * This method return hours in 00..24 format.
     */
    private int fetchHour(TemporalAccessor temporalAccessor) {
        Period period = temporalAccessor.query(DateTimeFormatter.parsedExcessDays());
        if (period.equals(Period.ofDays(1))) {
            return 24;
        }
        return LocalTime.from(temporalAccessor).getHour();
    }

}