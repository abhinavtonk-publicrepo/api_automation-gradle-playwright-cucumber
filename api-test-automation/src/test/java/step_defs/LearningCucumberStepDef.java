package step_defs;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;

public class LearningCucumberStepDef {
    @Given("User {} the application")
    public void applicationLaunch(String anyMatch) {
        System.out.println("User "+ anyMatch + " the application");
    }

    @When("User {string} the button")
    public void clicksButton(String stringMatch) {
        System.out.println("User "+ stringMatch + " the button");//Output=> User clicks the button
    }

    @When("User {word} the checkbox") // difference between {word} and {string} is that word-->replaces only one word...whereas {string} can replace word or a sentence also
    public void checksCheckbox(String wordMatch) {
        System.out.println("User "+ wordMatch + " the checkbox"); //Output=> User "checks" the checkbox
    }

    /*@ParameterType("He|She")
    public Gender gender(String gender){
        return new Gender(gender);
    }
    @When("{gender} clicks the button")
    public void heOrSheClicksButton(Gender gender) {
        System.out.println(gender + " clicks the button");//Output=> User clicks the button
    }*/


    @Given("User has launched new app")
    @When("User navigates to new app")
    @Then("User verifies new app")
    public void multipleAnnotationOverSingleMethod() {
        System.out.println("Multiple Annotation over single method");
    }
}
