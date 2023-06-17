package utils;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.APIResponseAssertions;
import com.microsoft.playwright.options.RequestOptions;

import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PlaywrightApiUtil {
    APIRequestContext apiRequestContext = null;
    APIResponse apiResponse = null;
    public void initializeAPIRequest(String baseUrl, Map<String,String> headers){
        apiRequestContext = Playwright.create()
                .request()
                .newContext(new APIRequest.NewContextOptions()
                        .setBaseURL(baseUrl)
                        .setExtraHTTPHeaders(headers)
                );
    }

    public void fireGETApiRequest(String url){
        apiResponse = apiRequestContext.get(url);
    }

    public void firePOSTApiRequest(String url, String jsonStringPayload){
        apiResponse = apiRequestContext.post(url, RequestOptions.create().setData(jsonStringPayload));
    }

    public void firePOSTApiRequest(String url, Map<String, String> data){
        apiResponse = apiRequestContext.post(url, RequestOptions.create().setData(data));
    }

    public void assertResponseOk(){
        if(apiResponse == null){
            throw new Error("apiResponse is null, initializeAPIRequest and fire GET?POST request");
        }else{
            assertThat(apiResponse).isOK();
        }
    }

    public String getResponseText(){
        if(apiResponse == null){
            throw new Error("apiResponse is null, initializeAPIRequest and fire GET?POST request");
        }else{
            return apiResponse.text();
        }
    }

    public int getResponseStatus(){
        if(apiResponse == null){
            throw new Error("apiResponse is null, initializeAPIRequest and fire GET?POST request");
        }else{
            return apiResponse.status();
        }
    }

    public Map<String, String> getResponseHeaders(){
        if(apiResponse == null){
            throw new Error("apiResponse is null, initializeAPIRequest and fire GET?POST request");
        }else{
            return apiResponse.headers();
        }
    }
}
