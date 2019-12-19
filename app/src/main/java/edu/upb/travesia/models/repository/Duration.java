package edu.upb.travesia.models.repository;

import com.google.gson.annotations.Expose;

public class Duration {

    @Expose
    private String start;

    @Expose
    private String end;

    @Expose
    private String days;

    public Duration(String start, String end, String days) {
        this.start = start;
        this.end = end;
        this.days = days;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
}
