package com.advantageshopping.automation.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterNewUserStepDefinitions {

    public WebDriver driver;

    @Given("^that a web user want to register in advantage shopping online$")
    public void thatAWebUserWantToRegisterInAdvantageShoppingOnline() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.advantageonlineshopping.com/#/");
        Thread.sleep(2000);
        driver.navigate().refresh();
        WebDriverWait ewait = new WebDriverWait(driver, 2);
        ewait.until(ExpectedConditions.elementToBeClickable(By.id("menuUser")));
    }

    @When("^he fill all the requested fields$")
    public void heFillAllTheRequestedFields() throws InterruptedException {
        driver.findElement(By.id("menuUser")).click();

        WebDriverWait ewait = new WebDriverWait(driver, 2);
        ewait.until(ExpectedConditions.textToBePresentInElementLocated
                (By.xpath("//a[@translate = 'CREATE_NEW_ACCOUNT']"),"CREATE NEW ACCOUNT"));
        driver.findElement(By.xpath("//a[@translate ='CREATE_NEW_ACCOUNT']")).click();

        Thread.sleep(2000);
        driver.findElement(By.name("usernameRegisterPage")).sendKeys("Julianpiran1");
        driver.findElement(By.name("emailRegisterPage")).sendKeys("julian.piiran@hotmail.com");
        driver.findElement(By.name("passwordRegisterPage")).sendKeys("Pass1");
        driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("Pass1");
        driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Julian");
        driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Piranquive");
        driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("3008930838");

        driver.findElement(By.name("countryListboxRegisterPage")).click();

        //Select allOptions = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
        //List<WebElement> options = allOptions.getAllSelectedOptions();
        //Object[] options1 = driver.findElements(By.name("countryListboxRegisterPage")).toArray();
        //int size = options.size();

        double random = (int) (Math.random() * 235) +1;

        for (int i = 1;i<=random;){
            if(i!=236){
                driver.findElement(By.name("countryListboxRegisterPage")).sendKeys(Keys.DOWN);
                i++;
            }else {
                Thread.sleep(2000);
                driver.findElement(By.name("countryListboxRegisterPage")).sendKeys(Keys.ENTER);
                break;
            }
        }
        driver.findElement(By.name("cityRegisterPage")).sendKeys("Medellin");


        driver.findElement(By.name("addressRegisterPage")).sendKeys("calle 19 #54-15");
        driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("Antioquia");
        driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("50035");
        driver.findElement(By.name("allowOffersPromotion")).click();
        driver.findElement(By.name("i_agree")).click();

        driver.findElement(By.id("register_btnundefined")).click();


    }

    @Then("^he should see him username in the homepage$")
    public void heShouldSeeHimUsernameInTheHomepage() {
        //Assert.assertTrue(driver.findElement(By.xpath("//span[@data-ng-show = 'userCookie.response' and @class = 'hi-user containMiniTitle ng-binding']")).isDisplayed());
        //assertEquals("Julianpiran",driver.findElement(By));
    }
}


