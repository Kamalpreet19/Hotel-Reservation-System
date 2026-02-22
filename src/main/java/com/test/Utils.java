package com.test;

public class Utils {


        public static int[] getDayTypes(int startDay, int endDay) throws Exception {
            if (startDay > endDay) throw new Exception("Start day cannot be after end day");

            int length = endDay - startDay + 1;
            int[] dayTypes = new int[length];

            for (int i = 0; i < length; i++) {
                int currentDay = startDay + i;
                if (currentDay == 6 || currentDay == 7) dayTypes[i] = 0;
                else dayTypes[i] = 1;
            }
            return dayTypes;
        }

        public static boolean isRewardCustomer(String type) throws Exception {
            if (!type.equalsIgnoreCase("regular") && !type.equalsIgnoreCase("reward")) {
                throw new Exception("Customer type must be 'regular' or 'reward'");
            }
            return type.equalsIgnoreCase("reward");
        }
    }

