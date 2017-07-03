package com.myapps.data;


/**
 * Created by bernatgomez on 3/7/17.
 */

public class RangeTime extends BaseModel {
    private static final String SEP = " - ";

    private int openingTime;
    private int closingTime;


    public RangeTime(int openingTime, int closingTime) {
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public int getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(int openingTime) {
        this.openingTime = openingTime;
    }

    public int getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(int closingTime) {
        this.closingTime = closingTime;
    }

    @Override
    public String toString() {
        super.toString();

        StringBuffer strb = new StringBuffer();

        strb.append(this.padTime(this.openingTime));
        strb.append(SEP);
        strb.append(this.padTime(this.closingTime));

        return strb.toString();
    }

    private String padTime(int val) {
        return val < 10? " " + val : "" + val;
    }
}
