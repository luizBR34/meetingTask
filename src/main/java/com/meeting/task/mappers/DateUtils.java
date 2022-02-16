package com.meeting.task.mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static Date parseDate(String dateStr) throws ParseException {

        dateStr = dateStr.replace('/', '-');
        Date theDate = dateFormat.parse(dateStr);

        return theDate;
    }
}
