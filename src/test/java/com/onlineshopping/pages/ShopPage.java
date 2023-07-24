package com.onlineshopping.pages;

import com.onlineshopping.utilities.Driver;
import com.onlineshopping.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class ShopPage extends ReusableMethods {
    public ShopPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String viewCartXPath = "//a[.='View cart']";

    @FindBy(xpath = "//a[.='Cart']")
    public WebElement cartLink;
    @FindBy(xpath = "//a[.='Add to cart']")
    public List<WebElement> addToCartList;

    @FindBy(xpath = "//a[.='View cart']")
    public List<WebElement> viewCartList;

    static WebElement selectedItem;

    public void addFourItems(){
        int allItemsSize = addToCartList.size(); // get all items that have "ADD TO CART" label
        Set<Integer> pickedNumbers = new HashSet<>(); // to access elements randomly use HashSet

        Random random = new Random();       // create random object to pick items randomly
        int count = 0;
        for (int i = 0; i < 4; i++) {
            while (pickedNumbers.size() < 4) {
                count = pickedNumbers.size();       // to avoid the duplication of random numbers specify the size
                int n = random.nextInt(allItemsSize-1) + 1;     // select an index randomly
                selectedItem = addToCartList.get(n);        // select an item that has index number n
                pickedNumbers.add(n);
                if (count != pickedNumbers.size()){     // to avoid duplication check if the randomly picked number increase the size selected before
                    clickWithJS(selectedItem);      // we need to click with JSExecuter to solve ElementClickInterceptedException
                    ReusableMethods.waitForPresenceOfElement(with(By.xpath(viewCartXPath)).above(selectedItem), 90);   // waits till presence of item's VIEW CART label by using relative locator
                    waitFor(1);
                }
            }
        }

        // To check every 5 seconds that we get 4 "VIEW CART" labels before passing to the next step
        for(int k = 0; k < 20 ; k++){
            if (viewCartList.size() != (count+1)){
                waitFor(5);
            }else{
                break;
            }
        }
    }
}

