package com.newad.realestate.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class EnvUtil {
    
    private static final String TIME_FORMAT = "dd MMM yyyy HH:mm";
    private static final String SHORT_TIME_FORMAT = "yyyy-MM-dd";
    private static final SimpleDateFormat FORMAT =
            new SimpleDateFormat(TIME_FORMAT);
    private static final SimpleDateFormat SHORT_FORMAT =
            new SimpleDateFormat(SHORT_TIME_FORMAT);
    private static final String TIMEZONE = "Australia/Melbourne";
    
    public static Calendar getCurrentLocalTime() {
        return Calendar.getInstance(Locale.ENGLISH);
    }
    
    public static String formatCalendar(Calendar time) {
        FORMAT.setTimeZone(TimeZone.getTimeZone(TIMEZONE));
        return FORMAT.format(time.getTime());
    }
    
    public static String formatCalendarShort(Calendar time) {
        SHORT_FORMAT.setTimeZone(TimeZone.getTimeZone(TIMEZONE));
        return SHORT_FORMAT.format(time.getTime());
    }

}
