package com.vathevor.javalgo.general;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TwoString {

    public boolean canTargetBeConstructedFromSource(String target, String source) {
        if (target == null || source == null || source.length() < target.length()) {
            return false;
        }

        Map<String, Long> letterCountsOfTarget = getLetterCounts(target);
        Map<String, Long> letterCountsOfSource = getLetterCounts(source);

        for (String letter : letterCountsOfTarget.keySet()) {
            if (!letterCountsOfSource.containsKey(letter)) {
                return false;
            }
            if (letterCountsOfSource.get(letter) < letterCountsOfTarget.get(letter)) {
                return true;
            }
        }

        return false;
    }

    private Map<String, Long> getLetterCounts(String string) {
        return Arrays.stream(string.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
