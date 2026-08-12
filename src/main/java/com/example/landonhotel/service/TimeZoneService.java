package com.example.landonhotel.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class TimeZoneService {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public String convertTime(ZonedDateTime sourceTime, ZoneId targetZone) {
        ZonedDateTime converted = sourceTime.withZoneSameInstant(targetZone);
        return converted.format(formatter);
    }

    public String getPresentationTimeMessage(ZonedDateTime presentationTime) {
        String easternTime = convertTime(presentationTime, ZoneId.of("America/New_York"));
        String mountainTime = convertTime(presentationTime, ZoneId.of("America/Denver"));
        String utcTime = convertTime(presentationTime, ZoneId.of("UTC"));

        return "The online, live presentation at the Landon Hotel will be held at "
                + easternTime + " ET, "
                + mountainTime + " MT, "
                + utcTime + " UTC. ";
    }
}
