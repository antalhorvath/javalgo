package com.vathevor.javalgo.general.candidatesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursiveCandidateSum implements CandidateSum {

    @Override
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }


    private void backtrack(List<List<Integer>> result,
                           List<Integer> currentSolution,
                           int[] candidates,
                           int remaining,
                           int currentTarget) {
        if (remaining < 0) {
            return;
        }
        if (remaining == 0) {
            result.add(new ArrayList<>(currentSolution));
        } else {
            for (int i = currentTarget; i < candidates.length; i++) {
                int candidate = candidates[i];
                if (currentTarget < i) {
                    if (candidate == candidates[i - 1]) continue;
                }
                if (remaining < candidate) {
                    break;
                }
                currentSolution.add(candidate);
                backtrack(result, currentSolution, candidates, remaining - candidate, i);
                currentSolution.remove(currentSolution.size() - 1);
            }
        }
    }
}
