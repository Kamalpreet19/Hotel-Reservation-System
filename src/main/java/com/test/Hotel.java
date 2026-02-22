package com.test;

public class Hotel {
    String name;
    int weekDayRate;
    int weekEndRate;
    int rating;
    int rewardWeekDayRate;
    int rewardWeekEndRate;

    public Hotel(String name, int weekDayRate, int weekEndRate, int rating) {
        this(name, weekDayRate, weekEndRate, rating, weekDayRate, weekEndRate);
    }

    public Hotel(String name, int weekDayRate, int weekEndRate, int rating,
                 int rewardWeekDayRate, int rewardWeekEndRate) {
        this.name = name;
        this.weekDayRate = weekDayRate;
        this.weekEndRate = weekEndRate;
        this.rating = rating;
        this.rewardWeekDayRate = rewardWeekDayRate;
        this.rewardWeekEndRate = rewardWeekEndRate;
    }

    public int calculateCost(int[] dayTypes, boolean isRewardCustomer) {
        int total = 0;
        for (int day : dayTypes) {
            if (isRewardCustomer) {
                total += (day == 1) ? rewardWeekDayRate : rewardWeekEndRate;
            } else {
                total += (day == 1) ? weekDayRate : weekEndRate;
            }
        }
        return total;
    }
}