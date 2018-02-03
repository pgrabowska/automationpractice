package com.automationpractice;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.TestInstance.*;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Main Page Tests")
public class MainPageTests {

    WebDriver driver;

    @BeforeAll
    public void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeEach
    public void beforeEach() {
        driver.get("http://automationpractice.com");
    }

    @Test
    public void shouldDisplayedMainWebPage() {
        Assertions.assertEquals("My Store", driver.getTitle());
    }

    @Test
    @DisplayName("Should display Correct Banner Image")
    public void shouldDisplayCorrectBannerImage() {
        String bannerImageSrc = "http://automationpractice.com/modules/blockbanner/img/sale70.png";
        WebElement bannerImageElement = driver.findElement(By.cssSelector("#header > div.banner > div > div > a > img"));
        Assertions.assertTrue(bannerImageElement.isDisplayed());
        Assertions.assertEquals(bannerImageSrc, bannerImageElement.getAttribute("src"), "Incorrect banner image was displayed");
    }

    @Test
    public void shouldRedirectToMainPageAfterClickingOnBannerImage() {
        WebElement bannerImageElement = driver.findElement(By.cssSelector("#header > div.banner > div > div > a > img"));
        bannerImageElement.click();
        Assertions.assertEquals("http://automationpractice.com/index.php", driver.getCurrentUrl());
    }

    @Test
    public void shouldDisplayTextCallUsNowAndPhoneNumberInContactUsSection() {
        WebElement callUsElement = driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > span"));
        Assertions.assertEquals("Call us now: 0123-456-789", callUsElement.getText());
    }

    @Test
    public void shouldDisplaySubpageContactUsWithTitle() {
        WebElement contactUsLink = driver.findElement(By.id("contact-link"));
        contactUsLink.click();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=contact", driver.getCurrentUrl());
        Assertions.assertEquals("Contact us - My Store", driver.getTitle());
    }

    @Test
    public void shouldDisplaySubpageContactUs(){
        WebElement contactUsLink = driver.findElement(By.linkText("Contact us"));
        contactUsLink.click();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=contact", driver.getCurrentUrl());
    }

    @Test
    public void shouldDisplayTextContactUs(){
        WebElement contactUsTest = driver.findElement(By.cssSelector("#contact-link > a"));
        Assertions.assertEquals("Contact us", contactUsTest.getText());
    }

    @Test
    public void shouldDisplaySubpageSignInWithTheTitle(){
        WebElement signInLink = driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a"));
        signInLink.click();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", driver.getCurrentUrl());
        Assertions.assertEquals("Login - My Store", driver.getTitle());
    }

    @Test
    public void shouldDisplaySubpageSignIn(){
        WebElement signInLink = driver.findElement(By.linkText("Sign in"));
        signInLink.click();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", driver.getCurrentUrl());
    }

    @Test
    public void shouldDisplayTextSignIn(){
        WebElement signInText = driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a"));
        Assertions.assertEquals("Sign in", signInText.getText());
    }

    @Test
    public void shouldDisplayLogoImage(){

    }


    @AfterAll
    public void afterAll() {
        driver.close();
    }
}
