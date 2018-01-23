package edu.tjhsst.finalproject;

import android.util.Log;

import java.util.Calendar;
import java.util.Date;
/**
 * Created by 2019fahmad on 12/12/2017.
 */

public class Task implements Comparable<Task> {
        private String name;
        private int durationMins;
    private String subject;
    private Date due;


    public Task(String n, int m, String s, Date d)
    {
        name = n;
        durationMins = m;
        subject = s;
        due = d;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationMins() {
        return durationMins;
    }

    public void setDurationMins(int durationMins) {
        this.durationMins = durationMins;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    @Override
    public int compareTo(Task t) {




        int total1 = 0;
        int total2 = 0;
        int rating1 = SettingsActivity.map.get(subject);
        int rating2 = SettingsActivity.map.get(t.getSubject());
        //weight and add score based on subject preference, weighted below due date and duration ratio

        //need to get time until due date for each task, in minutes, need to divide that value by duration of the task in minutes, weight that ratio and add to total

        Date today = new Date();
        Date d1 = due;
        Date d2 = t.getDue();
        int duration1 = durationMins;
        int duration2 = t.getDurationMins();

        int m1 = (int)getDifference(today, d1);
        int m2 = (int)getDifference(today, d2);

        int r1 = duration1/m1;
        int r2 = duration2/m2;

        total1 += ((10*rating1) + (50*r1));
        total2 += ((10*rating2) + (50*r2));


        if(total1<total2)
            return 1;
        else if (total1>total2)
            return -1;
        else
            return 0;
    }
    public long getDifference(Date startDate, Date endDate) {
        //milliseconds
        long different = endDate.getTime() - startDate.getTime();

//        System.out.println("startDate : " + startDate);
//        System.out.println("endDate : "+ endDate);
//        System.out.println("different : " + different);

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;

//        System.out.printf(
//                "%d days, %d hours, %d minutes, %d seconds%n",
//                elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds);
//
//
        return (elapsedDays*60*24)+(elapsedHours*60)+elapsedMinutes;



    }
}

