package com.onlineshopping.step_definitions;

import com.onlineshopping.pages.CartPage;
import com.onlineshopping.pages.ShopPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class OnlineShoppingStepDefs{
    ShopPage shopPage = new ShopPage();
    CartPage cartPage = new CartPage();

    @Given("I add four random items to my cart")
    public void i_add_four_random_items_to_my_cart() {
        System.out.println("I am in the Shop page");
        shopPage.addFourItems();
    }
    @When("I view my cart")
    public void i_view_my_cart() {
        shopPage.cartLink.click();
        System.out.println("I am in the My Cart page");
    }
    @Then("I find total four items listed in my cart")
    public void i_find_total_four_items_listed_in_my_cart() {
        Assert.assertEquals("Verify the my cart list as expected",4,cartPage.numberOfItemsInCart());
    }
    @When("I search for lowest price item")
    public void i_search_for_lowest_price_item() {
        cartPage.lowestPrice();
    }
    @When("I am able to remove the lowest price item from my cart")
    public void i_am_able_to_remove_the_lowest_price_item_from_my_cart() {
        cartPage.removeLowestPriceItem();
    }
    @Then("I am able to verify three items in my cart")
    public void i_am_able_to_verify_three_items_in_my_cart() {
        Assert.assertEquals("Verify the my cart list as expected",3,cartPage.numberOfItemsInCart());
    }
}
