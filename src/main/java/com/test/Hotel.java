package com.test;

public class Hotel {
    private String name;
    private int weekDayRate;
    private int weekEndRate;
    private int rating;


    Hotel(String name, int weekDayRate, int weekEndRate, int rating){
        this.name = name;
        this.weekDayRate = weekDayRate;
        this.weekEndRate = weekEndRate;
        this.rating=rating;
    }

    public String getName(){
        return name;
    }

    public int getWeekDayRate() {
        return weekDayRate;
    }

    public int getWeekEndRate() {
        return weekEndRate;
    }
    public int getRating(){
        return rating;
    }

    public int calculateTotalCost(int[] dayTypes) {

        int total = 0;
        for (int day : dayTypes) {
            if (day == 1)
                total += weekDayRate;
            else
                total += weekEndRate;
        }
        return total;
    }

}
