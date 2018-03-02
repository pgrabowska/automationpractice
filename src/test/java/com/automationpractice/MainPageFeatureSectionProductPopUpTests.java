package com.automationpractice;


import com.automationpractice.pageobjects.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Main Page Feature Section Product Box PopUp Tests")
public class MainPageFeatureSectionProductPopUpTests {

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

    // this test will be in new class
    @Test
    public void shouldDisplayPopupAfterClickingOnFirstItemOnPopularSection() {
        mainPage.getPopularLink().click();
        mainPage.hoverMouseOverFirstPopularElement();
        mainPage.getQuickViewLinkOnFirstPopularItem().click();
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

