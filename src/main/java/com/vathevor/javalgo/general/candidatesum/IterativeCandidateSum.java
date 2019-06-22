package com.vathevor.javalgo.general.candidatesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;

/**
 * #medium
 * Given a distinct set of numbers (candidates) and a target number.
 * Find all unique combinations in numbers where the numbers sums to target.
 * The same repeated number may be chosen unlimited number of times.
 * The solution set must not contain duplicate combinations.
 */
public class IterativeCandidateSum implements CandidateSum {

    @Override
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<List<Integer>>> allSolutionsForTarget = new ArrayList<>();
        for (int currentTarget = 0; currentTarget <= target; currentTarget++) {
            List<List<Integer>> currentTargetSolutions = new ArrayList<>();
            for (int j = 0; j < candidates.length && candidates[j] <= currentTarget; j++) {
                int candidate = candidates[j];
                if (candidate == currentTarget) {
                    currentTargetSolutions.add(singletonList(candidate));
                } else {
                    int remaining = currentTarget - candidate;
                    List<List<Integer>> allPartialSolutions = allSolutionsForTarget.get(remaining);
                    for (List<Integer> partialSolution : allPartialSolutions) {
                        Integer lastElement = partialSolution.get(partialSolution.size() - 1);
                        if (lastElement <= candidate) {
                            List<Integer> newSolution = new ArrayList<>(partialSolution);
                            newSolution.add(candidate);
                            currentTargetSolutions.add(newSolution);
                        }
                    }
                }
            }
            allSolutionsForTarget.add(currentTarget, currentTargetSolutions);
        }
        return allSolutionsForTarget.get(target);
    }
}
