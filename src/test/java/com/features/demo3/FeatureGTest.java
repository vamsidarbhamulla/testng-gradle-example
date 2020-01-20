package com.features.demo3;

import org.testng.annotations.Test;

public class FeatureGTest {

    @Test(groups = {"unit", "int", "test"})
    public void testG1() {
        System.out.println("testG1 - " + Thread.currentThread());
    }

    @Test(groups = {"unit", "int", "test"})
    public void testG2() {
        System.out.println("testG2 - " + Thread.currentThread());
    }

    @Test(groups = {"test"})
    public void testG3() {
        System.out.println("testG3 - " + Thread.currentThread());
    }
}
