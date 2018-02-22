package com.automationpractice;


import com.automationpractice.pageobjects.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Main Page Feature Section Tests")
public class MainPageFeatureSectionTests {

    WebDriver driver;

    MainPage mainPage;

    @BeforeAll
    public void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        mainPage = new MainPage(driver);
    }

    @BeforeEach
    public void beforeEach() {
        mainPage.goTo();
        Assertions.assertTrue(mainPage.isAt());
    }

    @Test
    public void shouldDisplayPopularSection() {
        WebElement popularLink = mainPage.getPopularLink();
        Assertions.assertTrue(popularLink.isDisplayed());
        Assertions.assertEquals("POPULAR", popularLink.getText());
    }

    @Test
    public void shouldDisplayPopularAsADefaultSection() {
        Assertions.assertTrue(mainPage.isPopularLinkActive());
    }

    @Test
    public void shouldDisplaySevenItemsOnPopularSection() {
        mainPage.getPopularLink().click();
        List<WebElement> popularOffers = mainPage.getPopularOffers();
        Assertions.assertEquals(7, popularOffers.size());
    }

    @Test
    public void shouldDisplayImageForEachItem() {
        mainPage.getPopularLink().click();
        List<WebElement> popularImages = mainPage.getPopularImages();
        Assertions.assertEquals(7, popularImages.size());
    }

    @Test
    public void shouldDisplayTitleForFirsItemOnPopularSection() {
        mainPage.getPopularLink().click();
        String title = "Faded Short Sleeve T-shirts";
        Assertions.assertEquals(title, mainPage.getTitleForTheFirstImageOnPopularSection().getText(), "The title of image is incorrect");
    }

    @Test
    public void shouldDisplayPriceForFirsItemOnPopularSection() {
        mainPage.getPopularLink().click();
        Assertions.assertTrue(mainPage.getPriceForTheFirstItemOnPopularSection().isDisplayed());
        String price = "$16.51";
        Assertions.assertEquals(price, mainPage.getPriceForTheFirstItemOnPopularSection().getText());
    }

    @Test
    public void shouldDisplayQuickViewOnFirstPopularItemWhenMouseOver() throws InterruptedException {
        mainPage.getPopularLink().click();
        mainPage.hoverMouseOverFirstPopularElement();
        Thread.sleep(1000);
        Assertions.assertEquals(1, mainPage.getQuickViewLinks().size());
        Assertions.assertTrue(mainPage.getQuickViewLinkOnFirstPopularItem().isDisplayed());
        Assertions.assertEquals("Quick view", mainPage.getQuickViewLinkOnFirstPopularItem().getText());
    }

    @Test
    public void shouldDisplayAddToCartForFirsItemOnPopularSectionWhenMouseOver() throws InterruptedException {
        mainPage.getPopularLink().click();
        mainPage.hoverMouseOverFirstPopularElement();
        Assertions.assertTrue(mainPage.getButtonAddToCartFromFirstItemOnPopularSection().isDisplayed());
        String buttonAddToCart = "Add to cart";
        Assertions.assertEquals(buttonAddToCart, mainPage.getButtonAddToCartFromFirstItemOnPopularSection().getText());
    }

    @Test
    public void shouldDisplayMoreForFirstItemOnPopularSectionWhenMouseOver() {
        mainPage.getPopularLink().click();
        mainPage.hoverMouseOverFirstPopularElement();
        Assertions.assertTrue(mainPage.getButtonMoreForFirstItemOnPopularSection().isDisplayed());
        String buttonMore = "More";
        Assertions.assertEquals(buttonMore, mainPage.getButtonMoreForFirstItemOnPopularSection().getText());
    }

    @Test
    public void shouldDisplayPriceForFirstItemOnPopularSectionWhenMouseOver() {

    }

    @Test
    public void shouldDisplayPopupAfterClickingOnFirstItemOnPopularSection() {

    }

    @Test
    public void shouldDisplayMainImageOnViewSection() {

    }

    @Test
    public void shouldDisplayBoxOfImagesOnViewSection() {

    }

    @Test
    public void shouldDisplayOtherViewAfterClickingArrowLeftOnViewSection() {

    }

    @Test
    public void shouldDisplayNameForItemOnViewSection() {

    }

    @Test
    public void shouldDisplayReferenceForItemOnViewSection() {

    }

    @Test
    public void shouldDisplayConditionLabelOnItemViewSection() {

    }

    @Test
    public void shouldDisplayStatusOfConditionOnItemViewSection() {

    }

    @Test
    public void shouldDisplayDescriptionOnItemViewSection() {

    }

    @Test
    public void shouldDisplayFourButtonsSocialMediaOnItemView() {

    }

    @AfterAll
    public void afterAll() {
        driver.close();
    }
}