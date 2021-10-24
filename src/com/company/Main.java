package com.company;

public class Main {

    private static int findMinValue(int[] piles, int hours) {
        int totalBananas = 0;
        for (int pile : piles)
            totalBananas += pile;
        return totalBananas / hours;
    }

    public static int minEatingTime(int[] piles, int hours) {
        int biggestPile = piles[0];

        for (int j = 1; j < piles.length; j++) {
            if (piles[j] > biggestPile) {
                biggestPile = piles[j];
            }
        }

        int smallestPile = findMinValue(piles, hours);
        while (smallestPile < biggestPile) {
            int speed = (smallestPile + biggestPile) / 2;
            if (speedSatisfyTime(piles, hours, speed))
                biggestPile = speed;
            else
                smallestPile = speed + 1;
        }
        return smallestPile;
    }

    private static boolean speedSatisfyTime(int[] piles, int hours, int speed) {
        int eatingTime = 0;
        for (int pile : piles)
            eatingTime += (pile / speed) + returnValue(pile, speed);
        return eatingTime <= hours;
    }

    private static int returnValue(int pile, int speed) {
        return pile % speed == 0 ? 0 : 1;
    }

    public static void main(String[] args) {
        int[] piles = {30, 11, 23, 4, 20};

        int f = Main.minEatingTime(piles, 5);
        System.out.println(f);

    }
}
