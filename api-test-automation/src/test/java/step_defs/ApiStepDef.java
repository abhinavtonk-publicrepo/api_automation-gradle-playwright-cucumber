package step_defs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.PlaywrightApiUtil;

import java.util.HashMap;
import java.util.Map;

public class ApiStepDef {
    PlaywrightApiUtil apiUtil;
    @Before
    public void beforeScenario(){
        apiUtil = new PlaywrightApiUtil();
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");

        apiUtil.initializeAPIRequest("https://reqres.in/",headers);
    }

    @After
    public void afterScenario(){
    }

    @Given("User has made a GET call to {word} endpoint")
    public void getCallToEndPoint(String url) {
        apiUtil.fireGETApiRequest("api/users/2");
        System.out.println("Response Text = " + apiUtil.getResponseText());
        System.out.println("Response Status = " + apiUtil.getResponseStatus());
        System.out.println("Response Headers = " + apiUtil.getResponseHeaders());
    }

    @Then("User verifies that response is OK")
    public void verifyTitle(){
        apiUtil.assertResponseOk();
    }
}
