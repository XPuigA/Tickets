package com.tickets.rest.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CombinatorTest {

    @Test
    void test1() {
        double[] tickets = new double[] {1, 1.5};
        double wanted = 3.0;
        double margin = 0;
        Result r = Combinator.combine(wanted, margin, tickets);
        Assertions.assertEquals(2, r.getExact().size());
        Assertions.assertEquals(4, r.getBelow().size());
        Assertions.assertEquals(0, r.getBelowMargin().size());
        Assertions.assertEquals(0, r.getExactMargin().size());
    }

    @Test
    void test2() {
        double[] tickets = new double[] {1, 1.5};
        double wanted = 3.0;
        double margin = 0.5;
        Result r = Combinator.combine(wanted, margin, tickets);
        Assertions.assertEquals(2, r.getExact().size());
        Assertions.assertEquals(4, r.getBelow().size());
        Assertions.assertEquals(0, r.getBelowMargin().size());
        Assertions.assertEquals(1, r.getExactMargin().size());
    }

    @Test
    void test3() {
        double[] tickets = new double[] {3, 1.5};
        double wanted = 1.0;
        double margin = 0;
        Result r = Combinator.combine(wanted, margin, tickets);
        Assertions.assertEquals(0, r.getExact().size());
        Assertions.assertEquals(0, r.getBelow().size());
        Assertions.assertEquals(0, r.getBelowMargin().size());
        Assertions.assertEquals(0, r.getExactMargin().size());
    }

    @Test
    void test4() {
        double[] tickets = new double[] {3, 1.5};
        double wanted = 1.0;
        double margin = 0.5;
        Result r = Combinator.combine(wanted, margin, tickets);
        Assertions.assertEquals(0, r.getExact().size());
        Assertions.assertEquals(0, r.getBelow().size());
        Assertions.assertEquals(0, r.getBelowMargin().size());
        Assertions.assertEquals(1, r.getExactMargin().size());
    }

    @Test
    void test5() {
        double[] tickets = new double[] {1.5};
        double wanted = 1.5;
        double margin = 0;
        Result r = Combinator.combine(wanted, margin, tickets);
        Assertions.assertEquals(1, r.getExact().size());
        Assertions.assertEquals(0, r.getBelow().size());
        Assertions.assertEquals(0, r.getBelowMargin().size());
        Assertions.assertEquals(0, r.getExactMargin().size());
    }
}
