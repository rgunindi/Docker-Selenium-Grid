package Proje.Odev3.stepDefinitions;

import Proje.Odev3.driverControl.driverControls;
import Proje.Odev3.driverControl.driverShutdown;
import Proje.Odev3.navigationUrl.Navigate;
import Proje.Odev3.pageObjects.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ThirdScenarioSteps {
    WebDriver driver;
    N11Page n11;
    Navigate navigate;
    SearchPage sPage;

    public void setUp(String driverName,String env,String seleniumGrid){
        driver= driverControls.driverControl(driver,driverName,seleniumGrid);
        System.out.printf("Environment %s\n",env);
        n11=new N11Page(driver);
        navigate=new Navigate(driver);
        sPage=new SearchPage(driver);
    }
    @Given("I launch {} Browser and {} Environment {}")
    public void iLaunchDesired_BrowserAndEnvironment(String driverName,String env,String seleniumGrid) {
        setUp(driverName,env,seleniumGrid);
    }

    @When("Go To {string}")
    public void goTo(String urlN11HomePage) { navigate.openN11HomePage(urlN11HomePage);
    }

    @Then("The word {string} is searched")
    public void theWordIsSearched(String word) { n11.searchWord(word);
    }

    @And("The second brand is selected from the filters on the product listing \\(result) screen")
    public void theSecondBrandIsSelectedFromTheFiltersOnTheProductListingResultScreen() { sPage.selectSecondBrand();
    }

    @Then("Incoming results are sorted by the number of comments")
    public void incomingResultsAreSortedByTheNumberOfComments() { sPage.sortingByComments();
    }

    @Then("Free shipping products are does list")
    public void freeShippingProductsAreDoesList() { sPage.freeShippingList();
        driverShutdown.driverClose(driver);
    }
}
