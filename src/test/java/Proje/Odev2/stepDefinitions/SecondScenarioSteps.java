package Proje.Odev2.stepDefinitions;

import Proje.Odev2.driverControl.driverControls;
import Proje.Odev2.driverControl.driverShutdown;
import Proje.Odev2.navigationUrl.Navigate;
import Proje.Odev2.pageObjects.*;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SecondScenarioSteps {
    WebDriver driver;
    N11Page n11;
    Navigate navigate;
    SearchPage sPage;
    BucketPage bPage;
    GuestUserPage gPage;
    PurchasePage pPage;
    public void setUp(String driverName,String env){
        driver= driverControls.driverControl(driver,driverName);
        System.out.printf("Environment %s\n",env);
        n11=new N11Page(driver);
        navigate=new Navigate(driver);
        sPage=new SearchPage(driver);
        bPage=new BucketPage(driver);
        gPage=new GuestUserPage(driver);
        pPage=new PurchasePage(driver);
    }

    @Given("I launch {} Browser and {} environment")
    public void ILaunchDesired_browserBrowserAndEnvEnvironment(String driverName,String env) {
    setUp(driverName,env);
    }

    @When("Go to  {string}")
    public void goTo(String urlN11HomePage) { navigate.openN11HomePage(urlN11HomePage);
    }

    @Then("The word {string} is searched in the search engine and it is seen that the searched word is corrected and the results come accordingly")
    public void theWordIsSearchedInTheSearchEngine(String word) {
        n11.searchWord(word);
    }

    @Then("From the results, the first and last product on the first page and the 5th product on the 3rd page are added to the cart")
    public void productAddedToTheCart() {
    sPage.handle();
    }

    @And("Go to bucket")
    public void goToBucket() {
        navigate.goBucket();
    }

    @Then("The cheapest product in the cart becomes 3")
    public void theCheapestProductInTheCartBecomes() {
        bPage.handle();
    }

    @And("Proceeds to the payment step as a guest user")
    public void proceedsToThePaymentStepAsGuestUser() {
        gPage.fillForm();
    }

    @Then("Attempt to purchase products with incorrect credit card information")
    public void attemptsToPurchaseProductsWithIncorrectCreditCardInformation() {
        pPage.purchase();
    }
    @After
    public void driverClose(){driver.quit();}
}
