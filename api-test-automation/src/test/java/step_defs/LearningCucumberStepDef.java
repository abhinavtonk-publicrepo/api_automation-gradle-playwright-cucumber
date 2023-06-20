package step_defs;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.List;

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

    @When("User verifies following webelements")
    public void useOf1dDataTable(List<String> list1D) {
        for(String s : list1D){
            System.out.println("1D Data Table Elements = " + s);
        }
    }
    @When("User enters following details")
    public void useOf2dDataTable(List<List<String>> list2D) {
        for(int i =0;i<list2D.size();i++){
            for (int j=0;j<list2D.get(i).size();j++){
                System.out.print(" " + list2D.get(i).get(j) + " ");
            }
            System.out.println("");// TO introduce new line after each iteration of outer loop
        }
    }
    @Then("{string} verifies his {int}")
    public void scenarioOutlineExample(String user, int id) {
        System.out.println("User = "+ user);
        System.out.println("Id = "+ id);
    }
}
