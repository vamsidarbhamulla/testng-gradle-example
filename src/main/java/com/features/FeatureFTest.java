package com.features;

import org.testng.annotations.Test;

public class FeatureFTest {

    @Test(groups = {"main"})
    public void testF1() {
        System.out.println("testF1 - " + Thread.currentThread());
    }

    @Test(groups = {"main"})
    public void testF2() {
        System.out.println("testF2 - " + Thread.currentThread());
    }

    @Test(groups = {"red", "main"})
    public void testF3() {
        System.out.println("testF3 - " + Thread.currentThread());
    }
}
