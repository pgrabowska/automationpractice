package com.automationpractice;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Main Page Middle Section Tests")
public class MainPageMiddleSectionTests {

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
    public void shouldDisplayHomePageSlider() {
        WebElement banner = driver.findElement(By.id("homepage-slider"));
        Assertions.assertTrue(banner.isDisplayed());
    }

    @Test
    public void shouldChangeMainImageOnSliderAfterThreeSeconds() {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement imageOne = driver.findElement(By.cssSelector("#homeslider > li:nth-child(3) > a > img"));
        wait.until(ExpectedConditions.visibilityOf(imageOne));
        Assertions.assertTrue(imageOne.isDisplayed());

        WebDriverWait waitTwo = new WebDriverWait(driver, 3);
        WebElement imageTwo = driver.findElement(By.cssSelector("#homeslider > li:nth-child(4) > a > img"));
        waitTwo.until(ExpectedConditions.visibilityOf(imageTwo));
        Assertions.assertTrue(imageTwo.isDisplayed());

        WebDriverWait waitThree = new WebDriverWait(driver, 3);
        WebElement imageThree = driver.findElement(By.cssSelector("#homeslider > li:nth-child(2) > a > img"));
        waitThree.until(ExpectedConditions.visibilityOf(imageThree));
        Assertions.assertTrue(imageThree.isDisplayed());
    }

    @Test
    public void shouldChangeMainImageOnSliderAfterClickingOnTheNextButton() throws InterruptedException {
        String image1 = "http://automationpractice.com/modules/homeslider/images/sample-2.jpg";
        String image2 = "http://automationpractice.com/modules/homeslider/images/sample-3.jpg";
        String image3 = "http://automationpractice.com/modules/homeslider/images/sample-1.jpg";

        WebElement nextSlideButton = driver.findElement(By.cssSelector("#homepage-slider > div > div.bx-controls.bx-has-controls-direction > div > a.bx-next"));

        nextSlideButton.click();
        WebElement imageOne = driver.findElement(By.cssSelector("#homeslider > li:nth-child(3) > a > img"));
        Assertions.assertTrue(imageOne.isDisplayed());
        Assertions.assertEquals(image1, imageOne.getAttribute("src"));

        nextSlideButton.click();
        WebElement imageTwo = driver.findElement(By.cssSelector("#homeslider > li:nth-child(4) > a > img"));
        Assertions.assertTrue(imageTwo.isDisplayed());
        Assertions.assertEquals(image2, imageTwo.getAttribute("src"));

        Thread.sleep(1000);
        nextSlideButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement imageThree = driver.findElement(By.cssSelector("#homeslider > li:nth-child(2) > a > img"));
        wait.until(ExpectedConditions.visibilityOf(imageThree));
        Assertions.assertTrue(imageThree.isDisplayed(), "Image sample-1 is not displayed");
        Assertions.assertEquals(image3, imageThree.getAttribute("src"));
    }

    @Test
    public void shouldChangeMainImageOnSliderAfterClickingOnThePreviousButton() throws InterruptedException {
        String image1 = "http://automationpractice.com/modules/homeslider/images/sample-2.jpg";
        String image2 = "http://automationpractice.com/modules/homeslider/images/sample-3.jpg";
        String image3 = "http://automationpractice.com/modules/homeslider/images/sample-1.jpg";
        WebElement previousSlideButton = driver.findElement(By.cssSelector("#homepage-slider > div > div.bx-controls.bx-has-controls-direction > div > a.bx-prev"));

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement imageOne = driver.findElement(By.cssSelector("#homeslider > li:nth-child(3) > a > img"));
        wait.until(ExpectedConditions.visibilityOf(imageOne));
        Assertions.assertTrue(imageOne.isDisplayed());
        Assertions.assertEquals(image1, imageOne.getAttribute("src"));

        Thread.sleep(1000);
        previousSlideButton.click();
        WebDriverWait waitFor = new WebDriverWait(driver, 10);
        WebElement imageThree = driver.findElement(By.cssSelector("#homeslider > li:nth-child(2) > a > img"));
        waitFor.until(ExpectedConditions.visibilityOf(imageThree));
        Assertions.assertTrue(imageThree.isDisplayed(), "Image sample-1 is not displayed");
        Assertions.assertEquals(image3, imageThree.getAttribute("src"));

        Thread.sleep(1000);
        previousSlideButton.click();
        WebDriverWait waitForElement = new WebDriverWait(driver, 10);
        WebElement imageTwo = driver.findElement(By.cssSelector("#homeslider > li:nth-child(4) > a > img"));
        waitForElement.until(ExpectedConditions.visibilityOf(imageTwo));
        Assertions.assertTrue(imageTwo.isDisplayed());
        Assertions.assertEquals(image2, imageTwo.getAttribute("src"));
    }

    @Test
    public void shouldDisplayTitleForFirstImageOnSlider() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement imageOne = driver.findElement(By.cssSelector("#homeslider > li:nth-child(3) > a > img"));
        wait.until(ExpectedConditions.visibilityOf(imageOne));
        WebElement title = driver.findElement(By.cssSelector("#homeslider > li:nth-child(3) > div > h2"));
        // example I
        //String title = "EXCEPTEUR\nOCCAECAT";
        //Assertions.assertEquals(title, title.getText(), "The title is incorrect");
        // example II
        String titleOne = "EXCEPTEUR OCCAECAT";
        Assertions.assertEquals(titleOne, title.getText().replaceAll("\n", " "), "The title is incorrect");
    }

    @Test
    public void shouldDisplayDescriptionForFirstImageOnSlider() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement imageOne = driver.findElement(By.cssSelector("#homeslider > li:nth-child(3) > a > img"));
        wait.until(ExpectedConditions.visibilityOf(imageOne));
        WebElement description = driver.findElement(By.cssSelector("#homeslider > li:nth-child(3) > div > p:nth-child(2)"));
        String descr = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tristique in tortor et dignissim. Quisque non tempor leo. Maecenas egestas sem elit";
        Assertions.assertEquals(descr, description.getText());
    }

    @Test
    public void shouldDisplayButtonShopNowForFirstImageOnSlider() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement imageOne = driver.findElement(By.cssSelector("#homeslider > li:nth-child(3) > a > img"));
        wait.until(ExpectedConditions.visibilityOf(imageOne));
        WebElement buttonLabel = driver.findElement(By.cssSelector("#homeslider > li:nth-child(3) > div > p:nth-child(3) > button"));
        String buttonName = "SHOP NOW !";
        Assertions.assertEquals(buttonName, buttonLabel.getText(), "Incorrect text on button was displayed");
        Assertions.assertTrue(buttonLabel.isDisplayed());
    }

    @Test
    public void shouldDisplayTitleForSecondImageOnSlider() {

    }

    @Test
    public void shouldDisplayDescriptionForSecondImageOnSlider() {

    }

    @Test
    public void shouldDisplayButtonShopNowForSecondImageOnSlider() {

    }

    @Test
    public void shouldDisplayTitleForThirdImageOnSlider() {

    }

    @Test
    public void shouldDisplayDescriptionForThirdImageOnSlider() {

    }

    @Test
    public void shouldDisplayButtonShopNowForThirdImageOnSlider() {

    }

    @Test
    public void shouldDisplay2BannersElement() {

    }

    @AfterAll
    public void afterAll() {
        driver.close();
    }
}
