package com.vathevor.javalgo.hashtable;

/*
 * Sherlock considers a string to be valid if all characters of the string appear the same number of times.
 * It is also valid if he can remove just 1 character from the string,
 * and the remaining characters will occur the same number of times.
 *
 * Sample Input 0
 *      aabbcd
 * Sample Output 0
 *      NO
 * Explanation 0
 *      We would need to remove two characters, both c and d to make it valid.
 *      We are limited to removing only one character, so the input is invalid.
 *
 * Sample Input 1
 *      aabbccddeefghi
 * Sample Output 1
 *      NO
 * Explanation 1
 *      Frequency counts for the letters are as follows:
 *      {'a': 2, 'b': 2, 'c': 2, 'd': 2, 'e': 2, 'f': 1, 'g': 1, 'h': 1, 'i': 1}
 *
 * Sample Input 2
 *      abcdefghhgfedecba
 * Sample Output 2
 *      YES
 * Explanation 2
 *      All characters occur twice except for e which occurs 3 times.
 *      We can delete one instance of to have a valid string.
 */
public class SherlockValidString {

    static boolean isValid(String s) {
        return false;
    }
}
