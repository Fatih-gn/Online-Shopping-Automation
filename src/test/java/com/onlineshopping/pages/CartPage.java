package com.onlineshopping.pages;

import com.onlineshopping.utilities.Driver;
import com.onlineshopping.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartPage extends ReusableMethods {
    public CartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // used static variables to store data and use it next time in the class
    static List<String> allItemsPrices = new ArrayList<>();
    static List<String> rows = new ArrayList<>();
    static int indexOfLowestPrice;
    static int lowestPrice;
    public String removedItemAlertXPath = "//div[@role='alert']";

    @FindBy(xpath = "//table//tbody//td[@class='product-price']")
    public List<WebElement> itemsPrices;

    @FindBy(xpath = "//table//tbody//tr[@class='woocommerce-cart-form__cart-item cart_item']")
    public List<WebElement> itemsInCart;

    @FindBy(xpath = "//table//tbody//a[@class='remove']")
    public List<WebElement> removeItemFromCartButton;

    public int numberOfItemsInCart() {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        rows = getElementsText(itemsInCart);        // gets the list of the items rows
        int numberOfItemsInCart = rows.size();      // gets total number of items in cart
        System.out.println("Number of items in my cart = " + numberOfItemsInCart);
        return numberOfItemsInCart;
    }

    public void lowestPrice() {
        allItemsPrices = getElementsText(itemsPrices);      // gets the list of items prices as text
        List<Integer> allPricesValue = new ArrayList<>();       // stores the list of the items prices as Integer

        for (String s: allItemsPrices) {
            if (s.length() == 5) {
                allPricesValue.add(Integer. parseInt(s.substring(1,2)));    // gets only 2.number i.e: 9 from $9.00
            }
            else {
                allPricesValue.add(Integer. parseInt(s.substring(1,3)));}       // gets 2. and 3. numbers i.e: 12 from $12.00
        }

        lowestPrice = Collections.min(allPricesValue);      // gives the lowest value of the element
        System.out.println("lowestPrice = $" + lowestPrice);
        indexOfLowestPrice = allPricesValue.indexOf(lowestPrice);       // gives the index of the lowest static value of the element,
                                                                        // use it in the next removeLowestPriceItem() method
    }

    public void removeLowestPriceItem() {
        waitForClickability(removeItemFromCartButton.get(indexOfLowestPrice), 60);      // waits till the remove button is clickable for lowest price item
        clickWithJS(removeItemFromCartButton.get(indexOfLowestPrice));      // we need to click with JSExecuter to solve ElementClickInterceptedException
        waitForPresenceOfElement(By.xpath(removedItemAlertXPath), 90);      // waits the presence of "removed item's alert" before passing to the assertion step
    }
}
