package com.features;

import org.testng.annotations.Test;

public class FeatureETest {

    @Test(groups = {"test", "unit"})
    public void testE1() {
        System.out.println("testE1 - " + Thread.currentThread());
    }

    @Test(groups = {"test", "unit"})
    public void testE2() {
        System.out.println("testE2 - " + Thread.currentThread());
    }

    @Test(groups = {"test", "red", "int"})
    public void testE3() {
        System.out.println("testE3 - " + Thread.currentThread());
    }
}
