package com.features.demo;

import org.testng.annotations.Test;

public class FeatureCTest {

    @Test(groups = {"main"})
    public void testC1() {
        System.out.println("testC1 - " + Thread.currentThread());
        System.out.println("test env - " + System.getProperty("env"));
    }

    @Test(groups = {"main"})
    public void testC2() {
        System.out.println("testC2 - " + Thread.currentThread());
    }

    @Test(groups = {"main","blue"})
    public void testC3() {
        System.out.println("testC3 - " + Thread.currentThread());
    }
}
