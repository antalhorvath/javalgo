package com.vathevor.javalgo.dp.candidatesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;

public class IterativeCandidateSum implements CandidateSum {

    @Override
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<List<Integer>>> allSolutionsForTarget = new ArrayList<>();
        for (int currentTarget = 0; currentTarget <= target; currentTarget++) {
            List<List<Integer>> currentTargetSolutions = new ArrayList<>();
            for (int candidate : candidates) {
                if (currentTarget < candidate) {
                    break;
                }
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
