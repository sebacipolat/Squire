package com.cipolat.news.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by sebastian on 27/07/17.
 */

public class DateUtils {

    public static Date convetDateTimeZone(String inputDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", new Locale("es", "ES"));
        Date convertedDate = null;
        try {
            convertedDate = dateFormat.parse(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return convertedDate;
    }

    public static String convertDateToString(Date date) {
        String fecha = null;
        try {
            String month = (String) android.text.format.DateFormat.format("MMMM", date);
            String dayOfTheWeek = (String) android.text.format.DateFormat.format("EEEE", date);
            String numberday = (String) android.text.format.DateFormat.format("d", date);
            String year = (String) android.text.format.DateFormat.format("yyyy", date);

            if (!isToday(date)) {
                if (isThisYear(date))
                    fecha = Utils.firstCapital(dayOfTheWeek) + ", " + numberday + " de " + Utils.firstCapital(month);
                else
                    fecha = Utils.firstCapital(dayOfTheWeek) + ", " + numberday + " de " + Utils.firstCapital(month) + " " + year;
            } else
                fecha = "Hoy";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fecha;
    }

    public static String getFormalStringDate(String dateStr) {
        String fecha = null;
        SimpleDateFormat mask = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", new Locale("es", "ES"));
        Date date;
        try {
            date = mask.parse(dateStr);
            String month = (String) android.text.format.DateFormat.format("MMMM", date);
            String dayOfTheWeek = (String) android.text.format.DateFormat.format("EEEE", date);
            String numberday = (String) android.text.format.DateFormat.format("d", date);
            String year = (String) android.text.format.DateFormat.format("yyyy", date);

            if (!isToday(date)) {
                if (isThisYear(date))
                    fecha = dayOfTheWeek + ", " + numberday + " de " + month;
                else
                    fecha = dayOfTheWeek + ", " + numberday + " de " + month + " " + year;
            } else
                fecha = "Hoy";

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fecha.toUpperCase();
    }

    public static boolean isToday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (android.text.format.DateUtils.isToday(cal.getTimeInMillis())) {
            return true;
        } else
            return false;
    }

    public static boolean isThisYear(Date date) {
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal.setTime(date);
        boolean sameYear = cal.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
        return sameYear;
    }
}
