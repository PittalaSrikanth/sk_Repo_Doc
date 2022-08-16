package com.silvercar.dealerwareandroid.TestRail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class TestRailManager {
    private TestRailManager() {
        
    }
    public static String testRunId = "68";
    public static String testRailUserName = "automation.testrail@dealerware.com";
    public static String testRailPassword = "";
    public static String railsEngineUrl = "https://dealerware.testrail.io/";
    public static final int TEST_CASE_PASSED_STATUS = 1;
    public static final int TEST_CASE_FAILED_STATUS = 5;
    


    public static void addResultForTestCase(String testCaseId, int status,
            String error) throws IOException, APIException {

        String testRunID = testRunId;

        APIClient client = new APIClient(railsEngineUrl);
        client.setUser(testRailUserName);
        client.setPassword(testRailPassword);
        Map data = new HashMap();
        data.put("status_id", status);
        data.put("comment", "Test Executed - Status updated automatically from Selenium test automation.");
        client.sendPost("add_result_for_case/" + testRunID + "/" + testCaseId + "", data);

    }

}
