package com.automationpractice.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MainPage {

    public static final String PAGE_TITLE = "My Store";
    public static final String PAGE_URL = "http://automationpractice.com";

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        this.driver.get(PAGE_URL);
    }

    public boolean isAt() {
        return driver.getTitle().equals(PAGE_TITLE);
    }

    public WebElement getPopularLink() {
        //driver.findElement(By.id("#home-page-tabs")).findElement(By.cssSelector("li:nth-child(1)"));
        return driver.findElement(By.cssSelector("#home-page-tabs > li:nth-child(1)"));
    }

    public boolean isPopularLinkActive() {
        String classAttribute = getPopularLink().getAttribute("class");
        return classAttribute.equals("active");
    }

    public List<WebElement> getPopularOffers() {
        return driver.findElements(By.cssSelector("#homefeatured > li"));
    }

    public List<WebElement> getPopularImages() {
        return driver.findElements(By.cssSelector("#homefeatured > li > div > div.left-block > div"));
    }

    public WebElement getTitleForTheFirstImageOnPopularSection() {
        return driver.findElement(By.cssSelector("#homefeatured > li > div > div.right-block > h5 > a"));
    }

    public WebElement getPriceForTheFirstItemOnPopularSection() {
        //return driver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.content_price > span"));
        return driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[1]/span"));
    }

    public void hoverMouseOverFirstPopularElement() {
        Actions actions = new Actions(driver);
        WebElement elements = driver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.left-block"));
        actions.moveToElement(elements).build().perform();
    }

    public List<WebElement> getQuickViewLinks() {
        List<WebElement> quickViewLinks = driver.findElements(By.linkText("Quick view"));
        return quickViewLinks;
    }

    public WebElement getQuickViewLinkOnFirstPopularItem(){
        return driver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.left-block > div > a.quick-view > span"));
    }

    public WebElement getButtonAddToCartFromFirstItemOnPopularSection() {
        return driver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span"));
    }

    public WebElement getButtonMoreForFirstItemOnPopularSection() {
        return driver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line.hovered > div > div.right-block > div.button-container > a.button.lnk_view.btn.btn-default > span"));
    }
}