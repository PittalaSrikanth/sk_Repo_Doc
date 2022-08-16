package com.silvercar.dealerwareandroid.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Properties;
import org.apache.commons.lang.RandomStringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiUtility {
    String clientToken = null;

    public ApiUtility() throws IOException {
        String propertyFileName = "/src/main/java/com/silvercar/dealerwareandroid/propertyfiles/Base.properties";
        FileInputStream baseProperties = new FileInputStream(System.getProperty("user.dir") + propertyFileName);
        Properties basePropertiesValue = new Properties();
        basePropertiesValue.load(baseProperties);
        RestAssured.baseURI = (String) basePropertiesValue.get("apiUrl");
        clientToken = (String) basePropertiesValue.get("clientToken");
    }

    public String signIn(String userMail, String userPassword) throws ParseException {
        RequestSpecification request = RestAssured.given();
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Api-Version", "3");
        request.headers(headers);
        request.body("{\"user\":{\"email\":\"" + userMail + "\",\"password\":\"" + userPassword + "\"}}");
        Response response = request.post("/sessions");
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(response.body().asString());
        String authToken = (String) jsonObject.get("auth_token");
        return authToken;
    }

    public HashMap<String, String> getCompanyDetails(String companyName, String authToken) throws ParseException {
        RequestSpecification request = RestAssured.given();
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Api-Version", "3");
        headers.put("Authorization", authToken);
        request.headers(headers);
        Response res = request.get("/companies");
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = null;
        HashMap<String, String> companyData = new HashMap<String, String>();
        JSONArray jsarr = (JSONArray) jsonParser.parse(res.getBody().asString());
        for (int i = 0; i < jsarr.size(); i++) {
            jsonObject = (JSONObject) jsarr.get(i);
            if (jsonObject.get("name").equals(companyName)) {
                companyData.put("id", String.valueOf(jsonObject.get("id")));
                companyData.put("token", (String) jsonObject.get("token"));
                break;
            }
        }
        return companyData;
    }

    public HashMap<String, String> getLocationDetails(String authToken, HashMap<String, String> companyData,
            String locationName) throws ParseException {
        RequestSpecification request = RestAssured.given();
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Api-Version", "3");
        headers.put("Authorization", authToken);
        headers.put("Company-Authorization", companyData.get("token"));
        request.headers(headers);
        Response res = request.get("/locations");
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = null;
        HashMap<String, String> locationData = new HashMap<String, String>();
        JSONArray jsarr = (JSONArray) jsonParser.parse(res.getBody().asString());
        for (int i = 0; i < jsarr.size(); i++) {
            jsonObject = (JSONObject) jsarr.get(i);
            if (jsonObject.get("name").equals(locationName)) {
                locationData.put("id", String.valueOf(jsonObject.get("id")));
                break;
            }
        }
        return locationData;
    }

    public Response createCar(String authToken, String locId, String vin) {
        String license = RandomStringUtils.randomAlphanumeric(5) + "lp1";
        String tollTagNumber = "ALF" + RandomStringUtils.randomNumeric(7) + "A";
        String stock = String.valueOf(RandomStringUtils.randomNumeric(6));
        RequestSpecification request = RestAssured.given();
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Api-Version", "3");
        headers.put("Authorization", authToken);
        headers.put("Content-Type", "application/json");
        request.headers(headers);
        String body = "{\n" + "  \"vin\": \"" + vin + "\",\n" + "  \"license\": \"" + license + "\",\n"
                + "  \"license_state\": \"TX\",\n" + "  \"toll_tag_number\": \"" + tollTagNumber + "\",\n"
                + "  \"toll_tag_verified\": true,\n" + "  \"mileage\": 100,\n" + "  \"has_gps\": true,\n"
                + "  \"active\": true,\n" + "  \"stock_number\": \"" + stock + "\",\n" + "  \"trim_id\": 3767,\n"
                + "  \"available_date\": \"" + LocalDateTime.now().minusDays(10) + "\"\n" + "}";
        request.body(body);
        Response response = request.post("/locations/" + locId + "/cars");
        System.out.println(response.getStatusCode());
        return response;
    }

    public Response createCustomer(String authToken, String locId) {
        RequestSpecification request = RestAssured.given();
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Api-Version", "3");
        headers.put("Authorization", authToken);
        headers.put("Content-Type", "application/json");
        request.headers(headers);
        String firstName = "wall" + RandomStringUtils.randomNumeric(5);
        String lastName = "test" + RandomStringUtils.randomNumeric(5);
        String email = "wall.test+" + RandomStringUtils.randomNumeric(5) + "@silvercar.com";
        String body = "{\"first_name\":\"" + firstName + "\",\"last_name\":\"" + lastName
                + " \",\"phone_number\":\"(234) 565-4322\",\"email\":\"" + email + "\"}";
        request.body(body);
        Response res = request.post("/locations/" + locId + "/customers");
        return res;
    }

    public Response addDriverLicense(String authToken, String locId, String customerId) {
        RequestSpecification request = RestAssured.given();
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Api-Version", "3");
        headers.put("Authorization", authToken);
        headers.put("Content-Type", "application/json");
        request.headers(headers);
        String drivingLicense = "DLI" + RandomStringUtils.randomNumeric(6);

        String dlBody = "{\"country\":\"US\"," + "\"number\":\"" + drivingLicense + "\"," + "\"verified\":true,"
                + "\"date_of_birth\":\"1983-05-08\"," + "\"expiration\":\"2027-05-08\"," + "\"line1\":\"steet 2\","
                + "\"city\":\"alska\"," + "\"state\":\"AL\"," + "\"zip\":\"57202\"," + "\"name\":\"CustFN52988\"" + "}";
        request.body(dlBody);
        Response res = request.post("/locations/" + locId + "/customers/" + customerId + "/drivers_license");
        return res;
    }

    public Response addCreditCard(String authToken, String locId, String customerId) {
        RequestSpecification request = RestAssured.given();
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Api-Version", "3");
        headers.put("Authorization", authToken);
        headers.put("Content-Type", "application/json");
        request.headers(headers);
        String ccBody = "{\"nonce\":\"fake-valid-nonce\",\n" + " \"Postalcode\":\"78701\",\n"
                + " \"cardholder_name\":\"CustFN52988 \",\n" + " \"verified\":\"true\"}";
        request.body(ccBody);
        Response res = request.post("/locations/" + locId + "/customers/" + customerId + "/credit_card");
        return res;
    }

    public Response addInsurence(String authToken, String locId, String customerId) {
        RequestSpecification request = RestAssured.given();
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Api-Version", "3");
        headers.put("Authorization", authToken);
        headers.put("Content-Type", "application/json");
        request.headers(headers);
        request.body("{\n" + "\"image\":\"https://dw-iw-qa-assets.s3.amazonaws.com/dealerware-logo.png\",\n"
                + "\"expires_on\" : \"2034-05-01\"\n" + "}");
        Response res = request.post("/locations/" + locId + "/customers/" + customerId + "/assets/insurances");
        return res;
    }

    public void contactlessContract(String authorization, String compToken, String version, String contractID) {
        RequestSpecification request = RestAssured.given();
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", authorization);
        headers.put("Company-Authorization", compToken);
        headers.put("Api-Version", "4");
        headers.put("App-Name", "Dealerware");
        headers.put("Platform", "Android");
        headers.put("App-Version", version);
        headers.put("User-Agent", "Android-playstore");
        request.headers(headers);
        request.body("{\n" + "\"image\": \"https://dw-iw-qa-assets.s3.amazonaws.com/dealerware-logo.png\"\n" + "}");
        Response res = request.post("/contracts/contactless/" + contractID.trim() + "/signatures");
        System.out.println(res.getStatusCode());
    }
    
    public Response getAdditionalDrivers(String contractId, String authCode, String locationId) throws ParseException {
         RequestSpecification request = RestAssured.given();
         HashMap<String, String> headers = new HashMap<>();
         headers.put("Content-Type", "application/json");
         headers.put("Authorization", authCode);
         headers.put("Api-Version", "4");
         request.headers(headers);
         Response res = request.get("/admin/dealerships/" + locationId + "/contracts/manifest/search?q=" 
              + contractId.trim() + "");
         JSONParser jsonParser = new JSONParser();
         JSONObject jsonObject = (JSONObject) ((JSONArray) jsonParser.parse(res.asString())).get(0);
        String id = jsonObject.get("id").toString();
        res = request.get("/admin/contracts/" + id.trim() + "/drivers");
        return res;
    }
    
    public void additionalDriverSignature(String driverId, String authorization) {
        
         RequestSpecification request = RestAssured.given();
         HashMap<String, String> headers = new HashMap<>();
         headers.put("Content-Type", "application/json");
         headers.put("Authorization", authorization);
         headers.put("Api-Version", "4");
         request.headers(headers);
         request.body("{\n" + "\"image\": \"data:image/jpeg;base64,/9j/4AAQSkZJRgABAQEASABIAAD"
                 + "//gATQ3JlYXRlZCB3aXRoIEdJTVD/2wBDAAEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEB"
                 + "AQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQH/2wBDAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQ"
                 + "EBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQH/wAARCAABAAEDAREAAhEBA"
                 + "xEB/8QAFAABAAAAAAAAAAAAAAAAAAAAC//EABQQAQAAAAAAAAAAAAAAAAAAAAD/xAAUAQEAAAAAAAAAAA"
                 + "AAAAAAAAAA/8QAFBEBAAAAAAAAAAAAAAAAAAAAAP/aAAwDAQACEQMRAD8AP/B//9k=\"\n" + "}");
         Response res = request.post("/admin/drivers/" + driverId + "/signature");
    }
}