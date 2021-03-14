package com.sxteng.javabase.test;

import java.util.Date;

public class TimePeriod {

    private Date beginTime;
    private Date endTime;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
