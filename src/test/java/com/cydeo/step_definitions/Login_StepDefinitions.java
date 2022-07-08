package com.cydeo.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepDefinitions {

    @Given("user is on library login page")
    public void user_is_on_library_login_page() {
        System.out.println("user is on library login page");
    }
    @When("user enter librarian username")
    public void user_enter_librarian_username() {
        System.out.println("user enter librarian username");
    }
    @When("user enter librarian password")
    public void user_enter_librarian_password() {
        System.out.println("user enter librarian password");
    }
    @Then("user can see dashboard")
    public void user_can_see_dashboard() {
        System.out.println("user can see dashboard");
    }

    @When("user enter student username")
    public void userEnterStudentUsername() {
        System.out.println("user enters student username");
    }

    @And("user enter student password")
    public void userEnterStudentPassword() {
        System.out.println("user enters student password");
    }
    @When("user enter admin username")
    public void userEnterAdminUsername() {
        System.out.println("user enter admin username");
    }

    @And("user enter admin password")
    public void userEnterAdminPassword() {
        System.out.println("user enter admin password");
    }
}
