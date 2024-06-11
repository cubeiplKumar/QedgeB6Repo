package com.github.chrishantha.sample.allocations;

import com.beust.jcommander.Parameter;
import com.github.chrishantha.sample.base.SampleApplication;

public class AllocationsApplication implements SampleApplication {

    @Parameter(names = "--max", description = "Max Numbers")
    private long max = 10_000_000L;

    private boolean isPrime(Long n) {
        //check if n is a multiple of 2
        if (n % 2 == 0) return false;
        //if not, then just check the odds
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
#feature202 changes by Developer Shilpa in Oct 2023
 private class OddThread extends Thread {

        public OddThread() {
            super("Odd-Thread");
        }

        @Override
        public void run() {
            for (int i = 0; i < count; i++) {
                if (!isEven(i)) {
                    printNumber(i);
                }
            }
        }
    }


    private void printNumber(int i) {
        System.out.format("Thread: %s, Number: %d%n", Thread.currentThread().getName(), i);
    }

    private synchronized boolean isEven(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i % 2 == 0;
    }
#end of feature202
    @Override
    public void start() {
        Long primeCount = 0L;
        for (long i = 0; i < max; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }
        System.out.format("Found %d prime numbers%n", primeCount);
    }

    @Override
    public String toString() {
        return "AllocationsApplication{" +
                "max=" + max +
                '}';
    }
}