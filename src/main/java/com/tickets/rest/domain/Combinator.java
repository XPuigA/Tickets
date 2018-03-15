package com.tickets.rest.domain;

import java.util.ArrayList;

public class Combinator {

    public static Result<ArrayList<Double>> combine(double wantedValue, double margin, double[] allowedTickets) {
        return solve(wantedValue, margin, allowedTickets, allowedTickets.length);
    }

    private static Result<ArrayList<Double>> solve(double target, double margin, double candidates[], int sz) {
        int[] index = new int[10000];
        index[0] = 0;
        Result<ArrayList<Double>> result = new Result<>();
        solve(target, target + margin, 0, candidates, sz, index, 0, result);
        return result;
    }

    private static void solve(double target, double targetWithmargin, double sum, double candidates[], int sz, int index[], int n, Result<ArrayList<Double>> result) {
        if (sum == target)
            storeResult(candidates, index, n, ResultType.EXACT, result);
        else if (sum < target)
            storeResult(candidates, index, n, ResultType.BELOW, result);
        else if (sum < targetWithmargin)
            storeResult(candidates, index, n, ResultType.BELOW_MARGIN, result);
        else if (sum == targetWithmargin)
            storeResult(candidates, index, n, ResultType.EXACT_MARGIN, result);
        else if (sum > target)
            return;
        for (int i = index[n]; i < sz; i++) {
            index[n + 1] = i;
            solve(target, targetWithmargin, sum + candidates[i], candidates, sz, index, n + 1, result);
        }
    }

    private static void storeResult(double candidates[], int index[], int n, ResultType resultType, Result<ArrayList<Double>> result) {
        if (n == 0) return;

        ArrayList<Double> a = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            a.add(candidates[index[i]]);
        }
        switch(resultType) {
            case EXACT:
                result.addExact(a);
                break;
            case BELOW:
                result.addBelow(a);
                break;
            case BELOW_MARGIN:
                result.addBelowMargin(a);
                break;
            case EXACT_MARGIN:
                result.addExactMargin(a);
                break;
        }
    }
}

