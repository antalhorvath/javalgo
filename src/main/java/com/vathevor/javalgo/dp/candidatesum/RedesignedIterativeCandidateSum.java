package com.vathevor.javalgo.dp.candidatesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toCollection;

/**
 * #medium
 * Given a distinct set of numbers (candidates) and a sum number.
 * Find all unique combinations in numbers where the numbers sums to sum.
 * The same repeated number may be chosen unlimited number of times.
 * The solution set must not contain duplicate combinations.
 */
public class RedesignedIterativeCandidateSum implements CandidateSum {

    private static class SumProblem {
        private int sum;
        private List<List<Integer>> combinations;

        SumProblem(int sum) {
            this.sum = sum;
            this.combinations = new ArrayList<>();
        }

        void addCombination(List<Integer> combination) {
            combinations.add(combination);
        }
    }

    private static class SumProblemSolver {

        private int[] candidates;
        private List<SumProblem> subProblems;

        SumProblemSolver(int[] candidates, int target) {
            this.candidates = candidates;
            Arrays.sort(this.candidates);
            subProblems = IntStream.rangeClosed(0, target)
                    .mapToObj(SumProblem::new)
                    .collect(toCollection(ArrayList::new));
        }

        List<List<Integer>> getSolution() {
            for (SumProblem problem : subProblems) {
                solveProblem(problem);
            }
            return subProblems.get(subProblems.size() - 1).combinations;
        }

        private void solveProblem(SumProblem problem) {
            for (int candidate : candidates) {
                int remaining = problem.sum - candidate;
                if (remaining < 0) {
                    break;
                }
                if (remaining == 0) {
                    problem.addCombination(singletonList(candidate));
                } else {
                    SumProblem relatedSubProblem = subProblems.get(remaining);
                    for (List<Integer> baseCombination : relatedSubProblem.combinations) {
                        Integer lastElement = baseCombination.get(baseCombination.size() - 1);
                        if (lastElement <= candidate) {
                            List<Integer> combination = new ArrayList<>(baseCombination);
                            combination.add(candidate);
                            problem.addCombination(combination);
                        }
                    }

                }
            }
        }
    }

    @Override
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return new SumProblemSolver(candidates, target).getSolution();
    }
}
