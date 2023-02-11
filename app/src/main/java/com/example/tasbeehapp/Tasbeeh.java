package com.example.tasbeehapp;

public class Tasbeeh {
    private String tasbeeh;
    private int noOfTimesTasbeeh;

    public Tasbeeh(String tasbeeh, int noOfTimesTasbeeh) {
        this.tasbeeh = tasbeeh;
        this.noOfTimesTasbeeh = noOfTimesTasbeeh;
    }

    public String getTasbeeh() {
        return tasbeeh;
    }

    public void setTasbeeh(String tasbeeh) {
        this.tasbeeh = tasbeeh;
    }

    public int getNoOfTimesTasbeeh() {
        return noOfTimesTasbeeh;
    }

    public void setNoOfTimesTasbeeh(int noOfTimesTasbeeh) {
        this.noOfTimesTasbeeh = noOfTimesTasbeeh;
    }
}
