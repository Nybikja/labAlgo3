package com.company;

public class BananaTime {

    private int findLowerLimit(int[] piles, int hours) {
        int totalBananas = 0;
        for (int pile : piles)
            totalBananas += pile;
        return totalBananas / hours;
    }

    public int minEatingTime(int[] piles, int hours) {
        int biggestPile = findBiggestPile(piles);
        int smallestPile = findLowerLimit(piles, hours);


        while (smallestPile < biggestPile) {
            int speed = (smallestPile + biggestPile) / 2;
            if (doesSpeedSatisfyTimeLimit(piles, hours, speed))
                biggestPile = speed;
            else
                smallestPile = speed + 1;
        }
        return smallestPile;
    }

    private boolean doesSpeedSatisfyTimeLimit(int[] piles, int hoursToEat, int speed) {
        int realHours = 0;
        for (int pile : piles)
            realHours += (pile / speed) + (pile % speed == 0 ? 0 : 1);
        return realHours <= hoursToEat;
    }

    private int findBiggestPile(int[] piles) {
        int biggestPile = piles[0];
        for (int j = 1; j < piles.length; j++) {
            if (piles[j] > biggestPile) {
                biggestPile = piles[j];
            }
        }
        return biggestPile;
    }

    public static void main(String[] args) {
        int[] piles = {30, 11, 23, 4, 20};
        BananaTime bananaTime = new BananaTime();
        System.out.println(bananaTime.minEatingTime(piles, 5));

        int[] piles2 = {3,6,7,11};
        System.out.println(bananaTime.minEatingTime(piles2, 8));

        int[] piles3 = {30,11,23,4,20};
        System.out.println(bananaTime.minEatingTime(piles3, 6));


    }
}
