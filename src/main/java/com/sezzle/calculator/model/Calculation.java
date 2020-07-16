package com.sezzle.calculator.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calculation {

    private Double mValue1;
    private Double mValue2;
    private String mOperator;
    private Double mAnswer;
    private Date mTimestamp;

    public Double getmValue1() {
        return mValue1;
    }

    public void setmValue1(Double mValue1) {
        this.mValue1 = mValue1;
    }

    public Double getmValue2() {
        return mValue2;
    }

    public void setmValue2(Double mValue2) {
        this.mValue2 = mValue2;
    }

    public void setmTimestamp(Date mTimestamp) {
        this.mTimestamp = mTimestamp;
    }

    public void setmOperator(String mOperator) {
        this.mOperator = mOperator;
    }

    public Double getmAnswer() {
        return mAnswer;
    }

    public void setmAnswer(Double mAnswer) {
        this.mAnswer = mAnswer;
    }

    public String getmOperator() {
        return mOperator;
    }

    public Date getmTimestamp() {
        return mTimestamp;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return "" + mValue1 + " " + mOperator + " " + mValue2 + " = " + mAnswer + "  @  " + df.format(mTimestamp);
    }
}
