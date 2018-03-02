package com.automationpractice;

import com.automationpractice.pageobjects.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
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
        List<WebElement> popularImages = mainPage.getPopularOffers();
        Assertions.assertEquals(7, popularImages.size());
    }

    @Test
    public void shouldDisplayFirstImageOnPopularSection() {
        mainPage.getPopularLink().click();
        String defaultLink = "http://automationpractice.com/img/p/1/1-home_default.jpg";
        String src = mainPage.getPopularImage().get(0).getAttribute("src");
        //Assertions.assertTrue(src.equals("http://automationpractice.com/img/p/1/1-home_default.jpg"));
        Assertions.assertEquals("http://automationpractice.com/img/p/1/1-home_default.jpg", src, "Image is not ...");
        Assertions.assertEquals(defaultLink, mainPage.getPopularOffers().get(0).findElement(By.className("replace-2x")).getAttribute("src"));
    }

    @Test
    public void shouldDisplayTitleForFirstItemOnPopularSection() {
        mainPage.getPopularLink().click();
        Assertions.assertEquals("Faded Short Sleeve T-shirts", mainPage.getTitleForTheFirstImageOnPopularSection().getText(), "The title of image is incorrect");
    }

    @Test
    public void shouldDisplayPriceForFirstItemOnPopularSection() {
        mainPage.getPopularLink().click();
        Assertions.assertTrue(mainPage.getPriceForTheFirstItemOnPopularSection().isDisplayed());
        Assertions.assertEquals("$16.51", mainPage.getPriceForTheFirstItemOnPopularSection().getText());
    }

    // second possibility for checking price
    @Test
    public void shouldDisplayPrice() {
        mainPage.getPopularLink().click();
        String price = mainPage.getPriceForItemsOnPopularSection().get(0).findElement(By.className("price")).getText();
        Assertions.assertEquals("$16.51", price);
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
    public void shouldDisplayAddToCartForFirstItemOnPopularSectionWhenMouseOver() {
        mainPage.getPopularLink().click();
        mainPage.hoverMouseOverFirstPopularElement();
        Assertions.assertTrue(mainPage.getButtonAddToCartFromFirstItemOnPopularSection().isDisplayed());
        Assertions.assertEquals("Add to cart", mainPage.getButtonAddToCartFromFirstItemOnPopularSection().getText());
    }

    @Test
    public void shouldDisplayMoreForFirstItemOnPopularSectionWhenMouseOver() {
        mainPage.getPopularLink().click();
        mainPage.hoverMouseOverFirstPopularElement();
        Assertions.assertTrue(mainPage.getButtonMoreForFirstItemOnPopularSection().isDisplayed());
        Assertions.assertEquals("More", mainPage.getButtonMoreForFirstItemOnPopularSection().getText());
    }

    @Test
    public void shouldDisplayPriceForFirstItemOnPopularSectionWhenMouseOver() {
        mainPage.getPopularLink().click();
        mainPage.hoverMouseOverFirstPopularElement();
        Assertions.assertTrue(mainPage.getPriceFromFirstItemWhenMouseOver().isDisplayed());
        Assertions.assertEquals("$16.51", mainPage.getPriceFromFirstItemWhenMouseOver().getText());
    }

    @Test
    public void shouldDisplayTitleForSecondItemOnPopularSection() {
        mainPage.getPopularLink().click();
        String defaultLink = "http://automationpractice.com/img/p/7/7-home_default.jpg";
        Assertions.assertEquals(defaultLink, mainPage.getPopularOffers().get(1).findElement(By.className("replace-2x")).getAttribute("src"));
    }

    @Test
    public void shouldDisplayPriceForSecondItemOnPopularSection() {
        mainPage.getPopularLink().click();
        String price = mainPage.getPriceForItemsOnPopularSection().get(1).findElement(By.className("price")).getText();
        Assertions.assertEquals("$27.00", price);
    }

    @Test
    public void shouldDisplayQuickViewOnSecondPopularItemWhenMouseOver() {
        mainPage.getPopularLink().click();
        mainPage.hoverMouseOverSecondPopularElement();
        Assertions.assertEquals(1, mainPage.getQuickViewLinks().size());
        Assertions.assertTrue(mainPage.getQuickViewLinkOnSecondPopularItem().isDisplayed());
        Assertions.assertEquals("Quick view", mainPage.getQuickViewLinkOnSecondPopularItem().getText());
    }

    @Test
    public void shouldDisplayAddToCartForSecondItemOnPopularSectionWhenMouseOver() {
        mainPage.getPopularLink().click();
        mainPage.hoverMouseOverSecondPopularElement();
        Assertions.assertTrue(mainPage.getButtonAddToCartOnSecondPopularItem().isDisplayed());
        Assertions.assertEquals("Add to cart", mainPage.getButtonAddToCartOnSecondPopularItem().getText());
    }

    @Test
    public void shouldDisplayMoreForSecondItemOnPopularSectionWhenMouseOver() {
        mainPage.getPopularLink().click();
        mainPage.hoverMouseOverSecondPopularElement();
        Assertions.assertTrue(mainPage.getButtonMoreForSecondItemOnPopularSection().isDisplayed(), "Button 'More' is not displayed");
        Assertions.assertEquals("More", mainPage.getButtonMoreForSecondItemOnPopularSection().getText());
    }

    @Test
    public void shouldDisplayPriceForSecondItemOnPopularSectionWhenMouseOver() {
        mainPage.getPopularLink().click();
        String price = mainPage.getPriceForItemsOnPopularSection().get(1).findElement(By.className("price")).getText();
        Assertions.assertEquals("$27.00", price);
    }

    @Test
    public void shouldDisplayTitleForLastItemOnPopularSection() {
        mainPage.getPopularLink().click();
        Assertions.assertEquals("Printed Chiffon Dress", mainPage.getTitleForTheLastImageOnPopularSection().getText(), "The title of image is incorrect");
    }

    @Test
    public void shouldDisplayPriceForLastItemOnPopularSection() {
        mainPage.getPopularLink().click();
        String newPrice = mainPage.getPriceForTheLastItemOnPopularSection().findElement(By.className("price")).getText();
        Assertions.assertEquals("$16.40", newPrice);
    }

    @Test
    public void shouldDisplayOldPriceForLastItemOnPopularSection() {
        mainPage.getPopularLink().click();
        String newPrice = mainPage.getPriceForTheLastItemOnPopularSection().findElement(By.className("old-price")).getText();
        Assertions.assertEquals("$20.50", newPrice);
    }

    @Test
    public void shouldDisplayPercentReductionPriceForLastItemOnPopularSection() {
        mainPage.getPopularLink().click();
        String newPrice = mainPage.getPriceForTheLastItemOnPopularSection().findElement(By.className("price-percent-reduction")).getText();
        Assertions.assertEquals("-20%", newPrice);
    }

    @Test
    public void shouldDisplayQuickViewOnLastPopularItemWhenMouseOver() {
        mainPage.getPopularLink().click();
        mainPage.hoverMouseOverLastPopularElement();
        Assertions.assertEquals(1, mainPage.getQuickViewLinks().size());
        Assertions.assertTrue(mainPage.getQuickViewLinkOnLastPopularItem().isDisplayed());
        Assertions.assertEquals("Quick view", mainPage.getQuickViewLinkOnLastPopularItem().getText());
    }

    @Test
    public void shouldDisplayAddToCartForLastItemOnPopularSectionWhenMouseOver() {
        mainPage.getPopularLink().click();
        mainPage.hoverMouseOverLastPopularElement();
        Assertions.assertTrue(mainPage.getButtonAddToCartOnLastPopularItem().isDisplayed());
        Assertions.assertEquals("Add to cart", mainPage.getButtonAddToCartOnLastPopularItem().getText());
    }

    @Test
    public void shouldDisplayMoreForLastItemOnPopularSectionWhenMouseOver() {
        mainPage.getPopularLink().click();
        mainPage.hoverMouseOverLastPopularElement();
        Assertions.assertTrue(mainPage.getButtonMoreForLastItemOnPopularSection().isDisplayed(), "Button 'More' is not displayed");
        Assertions.assertEquals("More", mainPage.getButtonMoreForLastItemOnPopularSection().getText());
    }

    @Test
    public void shouldDisplayPriceForLastItemOnPopularSectionWhenMouseOver() {
        mainPage.getPopularLink().click();
        mainPage.hoverMouseOverLastPopularElement();
        String price = mainPage.getPriceForLastItemWhenMouseOver().getText();
        Assertions.assertEquals("$16.40 $20.50 -20%", price);
    }

    @Test
    public void shouldDisplayBestSellersSectionAsActiveAfterClickingOnLink() {
        mainPage.getBestSellersLink().click();
        Assertions.assertTrue(mainPage.isBestSellersLinkActive());
    }

    @Test
    public void shouldDisplayBestSellersSection() {
        WebElement bestSellersLink = mainPage.getBestSellersLink();
        Assertions.assertTrue(bestSellersLink.isDisplayed());
        Assertions.assertEquals("BEST SELLERS", bestSellersLink.getText());
    }

    @Test
    public void shouldDisplaySevenItemsOnBestSellersSection() {
        mainPage.getBestSellersLink().click();
        List<WebElement> bestSellersOffers = mainPage.getBestSellersOffers();
        Assertions.assertEquals(7, bestSellersOffers.size());
    }

    @Test
    public void shouldDisplayImageForEachItemOnBestSellersSection() {
        mainPage.getBestSellersLink().click();
        List<WebElement> bestSellersImages = mainPage.getBestSellersOffers();
        Assertions.assertEquals(7, bestSellersImages.size());
    }

    @AfterAll
    public void afterAll() {
        driver.close();
    }
}