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

    @AfterAll
    public void afterAll() {
        driver.close();
    }
}
