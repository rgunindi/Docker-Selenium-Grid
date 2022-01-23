package Proje.Odev1.stepDefinitions;

import Proje.Odev1.driverControl.driverControls;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import Proje.Odev1.navigationUrl.Navigate;
import Proje.Odev1.pageObjects.MagazaCommentPage;
import Proje.Odev1.pageObjects.MagazalarPage;
import Proje.Odev1.pageObjects.N11Page;
import Proje.Odev1.utilities.BufferedReadFile;
import Proje.Odev1.utilities.BufferedWriteFile;

public class FirstScenarioSteps {
    public WebDriver driver;
    N11Page n11;
    MagazalarPage mPage;
    BufferedWriteFile bFileWriter;
    BufferedReadFile bFileReader;
    MagazaCommentPage cPage;
    Navigate navigate;
    //Set Up Environments Required
    public void SetupEnv(String driverName,String env,String seleniumGrid) {
        driver=driverControls.driverControl(driver,driverName, seleniumGrid);
        System.out.printf("Environment %s\n",env);
        n11=new N11Page(driver);
        mPage=new MagazalarPage(driver);
        navigate=new Navigate(driver);
        bFileWriter=new BufferedWriteFile(driver);
        bFileReader=new BufferedReadFile();
        cPage =new MagazaCommentPage(driver);
    }

    @Given("I launch {} browser and {} environment {}")
    public void I_launch_desired_browser_and_target_environment(String driverName,String env,String seleniumGrid) {
      SetupEnv(driverName,env, seleniumGrid);
    }

    @When("Go to {string}")
    public void go_to_https_www_n11_com(String urlN11HomePage) {
    navigate.openN11HomePage(urlN11HomePage);
    }
    @When("Mağazalar|Mağazaları Gör from the header is selected")
    public void magazalari_gor() {
    n11.clickOnTumMagazalariGor();
    }
    @When("Click on Tüm Mağazalar button")
    public void click_on_tum_magazalar_button() {
    mPage.clickOnTumMagazalar();
    }

    @When("Tüm Mağazalar from A to Z are printed in an csv file")
    public void a_to_z_printed_file() {
    bFileWriter.printToFile();
    }

    @Then("The second store starting with the letter S is reads from the created file \\(csv) and the page of this store is taken")
    public void the_second_store_starting_with_the_letter_s_is_reads_from_the_created_file_csv_and_the_page_of_this_store_is_taken() {
        bFileReader.readFile();
    }

    @And("Go to the took store page")
    public void goToTheTookStorePage() {
    navigate.goToTheTookStorePage();
    }

    @Then("It is checked how many comments are made about the selected Store")
    public void It_is_checked_how_many_comments_are_made_about_the_selected_store() {
        cPage.checkedComment();
    }
    @After
    public void driverClose(){driver.quit();}
}
