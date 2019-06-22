package com.vathevor.javalgo.dp.candidatesum;

import java.util.List;

/**
 * #medium
 * Given a distinct set of numbers (candidates) and a sum number.
 * Find all unique combinations in numbers where the numbers sums to sum.
 * The same repeated number may be chosen unlimited number of times.
 * The solution set must not contain duplicate combinations.
 */
public interface CandidateSum {

    List<List<Integer>> combinationSum(int[] candidates, int target);
}
