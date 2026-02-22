package com.test;

public class Main {
    public static void main(String[] args) {
        HotelReservationService service = new HotelReservationService();


        service.addHotel(new Hotel("Lakewood", 110, 90, 3, 80, 80));
        service.addHotel(new Hotel("Bridgewood", 150, 50, 4, 110, 50));
        service.addHotel(new Hotel("Ridgewood", 220, 150, 5, 100, 40));

        int startDay = 1;
        int endDay = 2;
        String customerType = "reward";

        try {
            int[] dayTypes = Utils.getDayTypes(startDay, endDay);
            boolean isReward = Utils.isRewardCustomer(customerType);

            String result;
            if (isReward) {
                result = service.findCheapestHotelForRewardCustomer(dayTypes);
            } else {
                result = service.findBestRatedHotel(dayTypes);
            }

            System.out.println(result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}