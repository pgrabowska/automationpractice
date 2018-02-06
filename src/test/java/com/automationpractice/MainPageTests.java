package com.automationpractice;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.TestInstance.Lifecycle;

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
    public void shouldDisplayMainWebPage() {
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
    public void shouldDisplaySubpageContactUs() {
        WebElement contactUsLink = driver.findElement(By.linkText("Contact us"));
        contactUsLink.click();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=contact", driver.getCurrentUrl());
    }

    @Test
    public void shouldDisplayTextContactUs() {
        WebElement contactUsTest = driver.findElement(By.cssSelector("#contact-link > a"));
        Assertions.assertEquals("Contact us", contactUsTest.getText());
    }

    @Test
    public void shouldDisplaySubpageSignInWithTheTitle() {
        WebElement signInLink = driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a"));
        signInLink.click();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", driver.getCurrentUrl());
        Assertions.assertEquals("Login - My Store", driver.getTitle());
    }

    @Test
    public void shouldDisplaySubpageSignIn() {
        WebElement signInLink = driver.findElement(By.linkText("Sign in"));
        signInLink.click();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", driver.getCurrentUrl());
    }

    @Test
    public void shouldDisplayTextSignIn() {
        WebElement signInText = driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a"));
        Assertions.assertEquals("Sign in", signInText.getText());
    }

    @Test
    public void shouldDisplayLogoImage() {
        String logoImageSrc = "http://automationpractice.com/img/logo.jpg";
        WebElement logoImageElement = driver.findElement(By.cssSelector("#header_logo > a > img"));
        Assertions.assertTrue(logoImageElement.isDisplayed());
        Assertions.assertEquals(logoImageSrc, logoImageElement.getAttribute("src"), "Incorrect logo image was displayed");
    }

    @Test
    public void shouldRedirectToMainPageAfterClickingAtTheLogoImage() {
        WebElement logoImageElement = driver.findElement(By.cssSelector("#header_logo > a > img"));
        logoImageElement.click();
        Assertions.assertEquals("http://automationpractice.com/index.php", driver.getCurrentUrl());
    }

    @Test
    public void shouldDisplayTooltipOnLogoImage() {
        String logoTooltip = "My Store";
        WebElement logoImageTooltip = driver.findElement(By.cssSelector("#header_logo > a > img"));
        Assertions.assertEquals(logoTooltip, logoImageTooltip.getAttribute("alt"));
    }

    @Test
    public void shouldDisplaySearchSection() {
        WebElement searchboxSection = driver.findElement(By.id("searchbox"));
        Assertions.assertTrue(searchboxSection.isDisplayed());
    }

    @Test
    public void shouldDisplayPlaceholderOnSearchSection() {
        String placeholderText = "Search";
        WebElement placeholderSearch = driver.findElement(By.cssSelector("#search_query_top"));
        Assertions.assertEquals(placeholderText, placeholderSearch.getAttribute("placeholder"), "Incorrect placeholder was displayed on Search section");
    }

    @Test
    public void shouldDisplayButtonSearchOnSearchSection() {
        WebElement searchButton = driver.findElement(By.cssSelector("#searchbox > button"));
        Assertions.assertTrue(searchButton.isDisplayed());
    }

    @Test
    public void shouldDisplayShoppingCartSection() {
        WebElement shoppingCart = driver.findElement(By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div"));
        Assertions.assertTrue(shoppingCart.isDisplayed());
    }

    @Test
    public void shouldDisplayCorrectUrlForCartSection() {
        String shoppingCartLink = "http://automationpractice.com/index.php?controller=order";
        WebElement shoppingCartHref = driver.findElement(By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a"));
        Assertions.assertEquals(shoppingCartLink, shoppingCartHref.getAttribute("href"), "Shopping card section is not displayed correctly");

    }

    @Test
    public void shouldDisplayTooltipForCartSection() {
        String tooltipTitle = "View my shopping cart";
        WebElement tooltipText = driver.findElement(By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a"));
        Assertions.assertEquals(tooltipTitle, tooltipText.getAttribute("title"), "Incorrect tooltip was displayed on Shopping Cart section ");
    }

    @Test
    public void shouldDisplayCartSectionText() {
        String shoppingCartText = "Cart (empty)";
        WebElement shoppingCartSectionText = driver.findElement(By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a"));
        Assertions.assertEquals(shoppingCartText, shoppingCartSectionText.getText());
    }

    @Test
    public void shouldDisplayItemWomenInMainMenu() {
        WebElement menuContentW = driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(1) > a"));
        String elementMenuDresses = "WOMEN";
        Assertions.assertEquals(elementMenuDresses, menuContentW.getText());
    }

    @Test
    public void shouldDisplayTooltipWomenForWomenMenuItem() {
        WebElement tooltipContentW = driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(1) > a"));
        String tooltipMenuWomen = "Women";
        Assertions.assertEquals(tooltipMenuWomen, tooltipContentW.getAttribute("title"));
    }

    @Test
    public void shouldDisplayItemDressesInMainMenu() {
        WebElement menuContentD = driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a"));
        String elementMenuDresses = "DRESSES";
        Assertions.assertEquals(elementMenuDresses, menuContentD.getText());
    }

    @Test
    public void shouldDisplayTooltipDressesForDressesMenuItem() {
        WebElement tooltipContentD = driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a"));
        String tooltipMenuWomen = "Dresses";
        Assertions.assertEquals(tooltipMenuWomen, tooltipContentD.getAttribute("title"));
    }

    @Test
    public void shouldDisplayItemTshirtInMainMenu() {
        WebElement menuContentT = driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(3) > a"));
        String elementMenuTShirts = "T-SHIRTS";
        Assertions.assertEquals(elementMenuTShirts, menuContentT.getText());
    }

    @Test
    public void shouldDisplayTooltipTshirtForTshirtMenuItem() {
        WebElement tooltipContentT = driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(3) > a"));
        String tooltipMenuTShirts = "T-shirts";
        Assertions.assertEquals(tooltipMenuTShirts, tooltipContentT.getAttribute("title"));
    }

    @AfterAll
    public void afterAll() {
        driver.close();
    }
}
