package com.vathevor.javalgo.hashtable;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Harold is a kidnapper who wrote a ransom note,
 * but now he is worried it will be traced back to him through his handwriting.
 * He found a magazine and wants to know if he can cut out whole words from it
 * and use them to create an untraceable replica of his ransom note.
 *
 * The words in his note are case-sensitive
 * and he must use only whole words available in the magazine.
 * He cannot use substrings or concatenation to create the words he needs.
 *
 * Given the words in the magazine and the words in the ransom note,
 * print Yes if he can replicate his ransom note exactly using whole words from the magazine;
 * otherwise, print No.
 *
 * For example, the note is "Attack at dawn".
 * The magazine contains only "attack at dawn".
 * The magazine has all the right words, but there's a case mismatch. The answer is No.
 */
public class RansomNote {

    static String checkMagazine(String magazine, String note) {
        return RansomNote.checkMagazine(magazine.split(" "), note.split(" "));
    }

    static String checkMagazine(String[] magazine, String[] note) {
        if (magazine.length < note.length) {
            return "No";
        }

        Map<String, Long> magazineWords = Arrays.stream(magazine)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> noteWords = Arrays.stream(note)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        if (!magazineWords.keySet().containsAll(noteWords.keySet())) {
            return "No";
        }

        boolean magazineDoesNotContainAllNecessaryWords = noteWords.entrySet().stream()
                .anyMatch(wordCount -> magazineWords.get(wordCount.getKey()) < wordCount.getValue());

        return magazineDoesNotContainAllNecessaryWords ? "No" : "Yes";
    }
}
