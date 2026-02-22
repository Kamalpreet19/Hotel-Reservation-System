package com.test;

public class Hotel {
    private String name;
    private int weekDayRate;
    private int weekEndRate;
    private int rating;

    private int rewardWeekDayRate;
    private int rewardWeekEndRate;


    Hotel(String name, int weekDayRate, int weekEndRate, int rating){
        this.name = name;
        this.weekDayRate = weekDayRate;
        this.weekEndRate = weekEndRate;
        this.rating = rating;
        this.rewardWeekDayRate = weekDayRate; // default to normal rates
        this.rewardWeekEndRate = weekEndRate;
    }


    Hotel(String name, int weekDayRate, int weekEndRate, int rating,
          int rewardWeekDayRate, int rewardWeekEndRate){
        this.name = name;
        this.weekDayRate = weekDayRate;
        this.weekEndRate = weekEndRate;
        this.rating = rating;
        this.rewardWeekDayRate = rewardWeekDayRate;
        this.rewardWeekEndRate = rewardWeekEndRate;
    }

    public String getName() { return name; }
    public int getWeekDayRate() { return weekDayRate; }
    public int getWeekEndRate() { return weekEndRate; }
    public int getRating() { return rating; }
    public int getRewardWeekDayRate() { return rewardWeekDayRate; }
    public int getRewardWeekEndRate() { return rewardWeekEndRate; }

    public int calculateTotalCost(int[] dayTypes) {
        int total = 0;
        for (int day : dayTypes) {
            total += (day == 1) ? weekDayRate : weekEndRate;
        }
        return total;
    }

    public int calculateRewardCost(int[] dayTypes) {
        int total = 0;
        for (int day : dayTypes) {
            total += (day == 1) ? rewardWeekDayRate : rewardWeekEndRate;
        }
        return total;
    }
}