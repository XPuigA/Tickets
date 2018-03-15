package com.tickets.rest.domain;

import java.util.ArrayList;
import java.util.HashSet;

public class Result<T> {

    private HashSet<T> exact = new HashSet<>();
    private HashSet<T> below = new HashSet<>();
    private HashSet<T> belowMargin = new HashSet<>();
    private HashSet<T> exactMargin = new HashSet<>();

    public HashSet<T> getExact() {
        return exact;
    }

    public HashSet<T> getBelow() {
        return below;
    }

    public HashSet<T> getBelowMargin() {
        return belowMargin;
    }

    public HashSet<T> getExactMargin() {
        return exactMargin;
    }

    public void addExact(T values) {
        exact.add(values);
    }

    public void addBelow(T values) {
        below.add(values);
    }

    public void addBelowMargin(T values) {
        belowMargin.add(values);
    }

    public void addExactMargin(T values) {
        exactMargin.add(values);
    }

    public void setExact(HashSet<T> exact) {
        this.exact = exact;
    }

    public void setBelow(HashSet<T> below) {
        this.below = below;
    }

    public void setBelowMargin(HashSet<T> belowMargin) {
        this.belowMargin = belowMargin;
    }

    public void setExactMargin(HashSet<T> exactMargin) {
        this.exactMargin = exactMargin;
    }
}
