package com.features.demo;

import org.testng.annotations.Test;

public class FeatureBTest {

    @Test(groups = {"unit", "test"})
    public void testB1() {
        System.out.println("testB1 - " + Thread.currentThread());
    }

    @Test(groups = {"unit", "test"})
    public void testB2() {
        System.out.println("testB2 - " + Thread.currentThread());
    }

    @Test(groups = {"unit", "test", "int"})
    public void testB3() {
        System.out.println("testB3 - " + Thread.currentThread());
    }
}
