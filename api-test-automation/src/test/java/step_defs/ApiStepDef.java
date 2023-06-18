package step_defs;

import com.google.gson.JsonArray;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.minidev.json.JSONArray;
import utils.JsonUtil;
import utils.PlaywrightApiUtil;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ApiStepDef {
    PlaywrightApiUtil apiUtil;
    JsonUtil jsonUtil;
    Map<String, String> headers;
    @Before
    public void beforeScenario(){
        apiUtil = new PlaywrightApiUtil();
        jsonUtil = new JsonUtil();
    }

    @After
    public void afterScenario(){
    }

    @Given("User has initialized the API Request for {string} url")
    public void initializeAPIRequest(String url) {
        headers = new HashMap<>();
        headers.put("Accept", "application/json");
        apiUtil.initializeAPIRequest(url,headers);
    }

    @When("User makes a GET call to {word} endpoint")
    public void getCallToEndPoint(String url) {
        apiUtil.fireGETApiRequest("api/unknown");
        getResponseDetails();

        // Getting particular json attribute using Json path
        LinkedHashMap mp = (LinkedHashMap) jsonUtil.getJsonAttributeValue(apiUtil.getResponseText(),"data[0]");
        JSONArray arr = (JSONArray) jsonUtil.getJsonAttributeValue(apiUtil.getResponseText(),"data");
        System.out.println("JsonArray ==" + arr.toJSONString());
        System.out.println("Json Attribute = " + jsonUtil.getJsonAttributeValue(apiUtil.getResponseText(),"data[0].name"));
        System.out.println("Json Attribute datatype = " + jsonUtil.getJsonAttributeValue(apiUtil.getResponseText(),"data[0].id").getClass());
    }

    @When("User makes a POST call to {word} endpoint")
    public void postCallToEndPoint(String url) {
        // 1st Way
        //String payload = generatePostPayloadUsingHashMapAndStringifyIt();

        // 2nd Way
        Map<String,String> payload = generatePostPayloadUsingHashMap();

        apiUtil.firePOSTApiRequest("api/unknown",payload);
        getResponseDetails();
    }

    @Then("User verifies that response is OK")
    public void verifyTitle(){
        apiUtil.assertResponseOk();
    }

    //----------------private methods of class-----------------------------------
    private void getResponseDetails() {
        System.out.println("Response Text = " + apiUtil.getResponseText());
        System.out.println("Response Status = " + apiUtil.getResponseStatus());
        System.out.println("Response Headers = " + apiUtil.getResponseHeaders());
    }

    private String generatePostPayloadUsingHashMapAndStringifyIt() {
        Map<String, String> map = new HashMap<>();
        map.put("name","morpheus");
        map.put("job","leader");
        return map.toString();
    }

    private Map<String, String> generatePostPayloadUsingHashMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name","morpheus");
        map.put("job","leader");
        return map;
    }
}
