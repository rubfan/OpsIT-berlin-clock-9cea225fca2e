package com.ubs.opsit.interviews.berlinclock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class BerlinClockCommon {
    private final String TIME_FORMAT = "HH:mm:ss";

    protected BerlinClock berlinClock = new BerlinClock();

    protected void forEach0To59(Consumer<String> consumer) {
        IntStream.range(0, 60).forEach(i -> consumer.accept(attachZeroPrefix(i)));
    }

    protected void forEach0To24(Consumer<String> consumer) {
        IntStream.rangeClosed(0, 24).forEach(i -> consumer.accept(attachZeroPrefix(i)));
    }

    protected LocalTime parseToLocalTime(String time) {
        return LocalTime.from(convertTime(time));
    }

    protected TemporalAccessor convertTime(String time) {
        return DateTimeFormatter.ofPattern(TIME_FORMAT).parse(time);
    }

    protected String attachZeroPrefix(int num) {
        return num <= 9 ? "0" + num : String.valueOf(num);
    }
}
