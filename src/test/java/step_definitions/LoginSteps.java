package step_definitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.Login;

public class LoginSteps {
    AppiumDriver driver = Hooks.driver;

    @When("^user enters username \"(.+?)\" and password \"(.+?)\"$")
    public void userEntersUsernameAndPassword(String username, String password) {
        new Login(driver)
                .enterUserName(username)
                .enterPassword(password);
    }

    @And("^clicked on login button$")
    public void clickedOnLoginButton() {
        new Login(driver)
                .ClickedOnLogInButton();
    }

    @Then("^user should get an error message \"(.+?)\"$")
    public void userShouldGetAnErrorMessage(String errMsg) {
        new Login(driver)
                .unsuccessfulLogInErrorText(errMsg);
    }

    @Then("^user will see the product page with title \"(.+?)\"$")
    public void userWillSeeTheProductPageWithTitle(String title) {
        new Login(driver)
                .logInIsSuccessful(title);
    }


}
