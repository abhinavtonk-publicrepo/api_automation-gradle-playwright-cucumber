package step_defs;

import com.google.gson.JsonArray;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.minidev.json.JSONArray;
import utils.JsonUtil;
import utils.PlaywrightApiUtil;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ApiStepDef {
    PlaywrightApiUtil apiUtil;
    JsonUtil jsonUtil;
    @Before
    public void beforeScenario(){
        apiUtil = new PlaywrightApiUtil();
        jsonUtil = new JsonUtil();
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");

        apiUtil.initializeAPIRequest("https://reqres.in/",headers);
    }

    @After
    public void afterScenario(){
    }

    @Given("User has made a GET call to {word} endpoint")
    public void getCallToEndPoint(String url) {
        apiUtil.fireGETApiRequest("api/unknown");
        System.out.println("Response Text = " + apiUtil.getResponseText());
        System.out.println("Response Status = " + apiUtil.getResponseStatus());
        System.out.println("Response Headers = " + apiUtil.getResponseHeaders());

        // Getting particular json attribute using Json path
        LinkedHashMap mp = (LinkedHashMap) jsonUtil.getJsonAttributeValue(apiUtil.getResponseText(),"data[0]");
        JSONArray arr = (JSONArray) jsonUtil.getJsonAttributeValue(apiUtil.getResponseText(),"data");
        System.out.println("JsonArray ==" + arr.toJSONString());
        System.out.println("Json Attribute = " + jsonUtil.getJsonAttributeValue(apiUtil.getResponseText(),"data[0].name"));
        System.out.println("Json Attribute datatype = " + jsonUtil.getJsonAttributeValue(apiUtil.getResponseText(),"data[0].id").getClass());
    }

    @Then("User verifies that response is OK")
    public void verifyTitle(){
        apiUtil.assertResponseOk();
    }
}
