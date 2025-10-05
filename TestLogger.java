package com.demoqa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogger implements ITestListener {
    private static final Logger logger = LogManager.getLogger(TestLogger.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("STARTING TEST: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("PASSED TEST: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("FAILED TEST: " + result.getName());
        logger.error("ERROR: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("SKIPPED TEST: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("TEST SUITE STARTED: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("TEST SUITE FINISHED: " + context.getName());
    }
}
