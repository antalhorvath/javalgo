package com.vathevor.javalgo.general;

import java.util.Arrays;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/*
 * Given a time represented in the format "HH:MM",
 * form the next closest time by reusing the current digits.
 * There is no limit on how many times a digit can be reused.
 *
 * You may assume the given input string is always valid.
 * For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
 *
 * Example 1:
 *      Input: "19:34"
 *      Output: "19:39"
 *      Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39,
 *                   which occurs 5 minutes later.  It is not 19:33,
 *                   because this occurs 23 hours and 59 minutes later.
 *
 * Example 2:
 *      Input: "23:59"
 *      Output: "22:22"
 *      Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22.
 *                   It may be assumed that the returned time is next day's time
 *                   since it is smaller than the input time numerically.
 */
public class NextClosestTime {

    private static final int MINUTES_OF_HOUR = 60;
    private static final int MINUTES_OF_DAY = 24 * MINUTES_OF_HOUR;

    private static int[] getDigits(int timeInMinutes) {
        int hours = timeInMinutes / 60;
        int minutes = timeInMinutes % 60;
        return new int[]{hours / 10, hours % 10, minutes / 10, minutes % 10};
    }

    private static boolean consistsOfAllowedDigits(int number, Set<Integer> allowedDigits) {
        int[] digits = getDigits(number);
        for (int digit : digits) {
            if (!allowedDigits.contains(digit)) {
                return false;
            }
        }
        return true;
    }

    public String nextClosestTime(String time) {
        int hours = Integer.valueOf(time.substring(0, 2));
        int minutes = Integer.valueOf(time.substring(3));
        int now = hours * MINUTES_OF_HOUR + minutes;
        Set<Integer> allowedDigits = Arrays.stream(getDigits(now)).boxed().collect(toSet());

        int closestTime = now;
        while (true) {
            closestTime = (closestTime + 1) % MINUTES_OF_DAY;
            if (consistsOfAllowedDigits(closestTime, allowedDigits)) {
                return String.format("%02d:%02d", closestTime / MINUTES_OF_HOUR, closestTime % MINUTES_OF_HOUR);
            }
        }
    }
}
