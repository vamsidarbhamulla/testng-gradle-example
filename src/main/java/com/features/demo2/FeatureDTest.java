package com.features.demo2;

import org.testng.annotations.Test;

public class FeatureDTest {

    @Test(groups = {"main"})
    public void testD1() {
        System.out.println("testD1 - " + Thread.currentThread());
    }

    @Test(groups = {"main"})
    public void testD2() {
        System.out.println("testD2 - " + Thread.currentThread());
    }

    @Test(groups = {"red", "main"})
    public void testD3() {
        System.out.println("testD3 - " + Thread.currentThread());
    }
}
