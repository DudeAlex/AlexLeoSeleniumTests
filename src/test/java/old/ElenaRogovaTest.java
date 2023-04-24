package old;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Ignore
public class ElenaRogovaTest extends BaseTest {

    @Test
    public void testVerifySaleIcon() {
        List<WebElement> saleIcons = getDriver().findElements(By.xpath(".//span[text() = 'Sale!']"));
        for (WebElement webElement : saleIcons)
            Assert.assertTrue(webElement.isDisplayed());
    }

    @Test
    public void testValidate$SignUnderFeaturedProducts() {
        List<WebElement> featuredProductsPrices = getDriver().findElements(By.xpath(".//span[@class = 'woocommerce-Price-currencySymbol']"));
        for (WebElement webElement : featuredProductsPrices)
            Assert.assertEquals(webElement.getText(), "$");
    }

    @Test
    public void testVerifyPromoText() {
        WebElement promoText = getDriver().findElement(By.xpath(".//h3[@class = 'has-text-align-center has-white-color has-text-color has-medium-font-size']"));
        Assert.assertEquals(promoText.getText(), "25% OFF On all products");
    }

    @Test
    public void testVerifyLoginPageOpened() {
        WebElement accountButton = getDriver().findElement(By.linkText("Account"));
        accountButton.click();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://askomdch.com/account/");
        WebElement accountPageTitle = getDriver().findElement(By.xpath(".//h1[text() = 'Account']"));
        Assert.assertTrue(accountPageTitle.isDisplayed());
    }

    @Test
    public void testVerifyStorePageOpened() {
        WebElement storeButton = getDriver().findElement(By.linkText("Store"));
        storeButton.click();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://askomdch.com/store/");
        WebElement storePageTitle = getDriver().findElement(By.xpath(".//h1[text() = 'Store']"));
        Assert.assertTrue(storePageTitle.isDisplayed());
    }

    @Test
    public void testVerifyNumberOfFeaturedProducts() {
        List<WebElement> featuredProductsPrices = getDriver().findElements(By.xpath(".//ul[@class = 'products columns-5']/li"));
        Assert.assertEquals(featuredProductsPrices.size(), 5);
    }

    @Test
    public void testVerifySearchButtonColour() {
        WebElement menButton = getDriver().findElement(By.xpath(".//li[@id = 'menu-item-1228']//a[text() = 'Men']"));
        menButton.click();
        WebElement searchButton = getDriver().findElement(By.xpath(".//button[text() = 'Search']"));
        String colour = searchButton.getCssValue("background-color");
        Assert.assertEquals(colour, "rgba(49, 151, 214, 1)");
    }

    @Test
    public void testVerifyFindMoreButtonRedirectsToContactUs() {
        WebElement findMoreButton = getDriver().findElement(By.xpath(".//a[text() = 'Find More']"));
        findMoreButton.click();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://askomdch.com/contact-us/");
        WebElement contactUsPageTitle = getDriver().findElement(By.xpath(".//h1[text() = 'Contact Us']"));
        Assert.assertTrue(contactUsPageTitle.isDisplayed());
    }

    @Test
    public void testVerifyNumberOfWomenProducts() {
        WebElement womenButton = getDriver().findElement(By.xpath(".//li[@id = 'menu-item-1229']/a[text() = 'Women']"));
        womenButton.click();
        WebElement allProducts = getDriver().findElement(By.xpath(".//ul[@class = 'products columns-4']"));
        List<WebElement> productsList = allProducts.findElements(By.tagName("li"));

        Assert.assertEquals(productsList.size(), 7);
    }

    @Test
    public void testVerifySortByPriceLowToHigh() {
        WebElement shopNowButton = getDriver().findElement(By.xpath(".//a[@class = 'wp-block-button__link' and text() = 'Shop Now']"));
        shopNowButton.click();
        WebElement sortByDropDown = getDriver().findElement(By.xpath(".//select[@aria-label = 'Shop order']"));
        Select dropdown = new Select(sortByDropDown);
        dropdown.selectByVisibleText("Sort by price: low to high");
        WebElement pagination = getDriver().findElement(By.className("page-numbers"));
        List<Double> actualProductPrices = new ArrayList<>();

        while (true) {
            List<WebElement> nextPageIconList = getDriver().findElements(By.xpath(".//a[text() = '→']"));
            List<WebElement> products = getDriver().findElements(By.xpath(".//ul[@class = 'products columns-4']/li"));

            for (WebElement product : products) {
                List<WebElement> productPrices = product.findElements(By.tagName("bdi"));
                String textPrice;
                if (productPrices.size() > 1) {
                    textPrice = productPrices.get(1).getText().replace("$", "");
                } else {
                    textPrice = productPrices.get(0).getText().replace("$", "");
                }
                actualProductPrices.add(Double.parseDouble(textPrice));
            }

            if (!nextPageIconList.isEmpty()) {
                WebElement nextPagesIcon = pagination.findElement(By.linkText("→"));
                nextPagesIcon.click();
            } else break;
        }

        boolean pricesInAscendingOrder = true;
        for (int i = 1; i < actualProductPrices.size(); i++) {
            if (actualProductPrices.get(i) < actualProductPrices.get(i - 1)) {
                pricesInAscendingOrder = false;
                break;
            }
        }

        Assert.assertTrue(pricesInAscendingOrder);
    }

    @Test
    public void testVerifyNumberOnShoppingCart() {
        List<WebElement> featuredProducts = getDriver().findElements(By.xpath(".//ul[@class = 'products columns-5']/li"));

        for (int i = 0; i < featuredProducts.size() - 1; i++) {
            WebElement addToCartButton = featuredProducts.get(i).findElement(By.xpath("./div/a[text() = 'Add to cart']"));
            addToCartButton.click();
            WebElement viewCartButton = featuredProducts.get(i).findElement(By.xpath("./div/a[text() = 'View cart']"));
            new WebDriverWait(getDriver(), Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOf(viewCartButton));
        }
        WebElement cartCount = getDriver().findElement(By.xpath(".//div[@class = 'ast-cart-menu-wrap']/span"));

        Assert.assertEquals(Integer.valueOf(cartCount.getText().trim()), featuredProducts.size() - 1);
    }

    @Test
    public void testVerifyDiscountedPriceIsLessThanStandard() {
        WebElement accessoriesButton = getDriver().findElement(By.xpath(".//li[@id = 'menu-item-1230']/a[text() = 'Accessories']"));
        accessoriesButton.click();
        List<WebElement> bestSellers = getDriver().findElements(By.xpath(".//ul[@class = 'product_list_widget']/li"));
        for (WebElement element : bestSellers) {
            List<WebElement> priceList = element.findElements(By.tagName("bdi"));
            if (priceList.size() > 1) {
                Double[] pricesOfProduct = new Double[2];
                for (int i = 0; i < pricesOfProduct.length; i++) {
                pricesOfProduct[i] = Double.valueOf(priceList.get(i).getText().replace("$", ""));
            }
            Assert.assertTrue((pricesOfProduct[1] - pricesOfProduct[0]) < 0);
        }}
    }

    @Test
    public void testVerifyNumberOfProductsOver33$() {
        WebElement storeButton = getDriver().findElement(By.linkText("Store"));
        storeButton.click();
        List<WebElement> products = getDriver().findElements(By.xpath(".//ul[@class = 'products columns-4']/li"));
        for (WebElement product : products) {
            List<WebElement> productPrices = product.findElements(By.tagName("bdi"));
            double actualPrice;

            if (productPrices.size() > 1)
                actualPrice = Double.parseDouble(productPrices.get(1).getText().replace("$", ""));
            else actualPrice = Double.parseDouble(productPrices.get(0).getText().replace("$", ""));

            if (actualPrice > 33.0) {
                WebElement addToCartButton = product.findElement(By.xpath("./div/a[text() = 'Add to cart']"));
                addToCartButton.click();
                WebElement viewCartButton = product.findElement(By.xpath("./div/a[text() = 'View cart']"));
                new WebDriverWait(getDriver(), Duration.ofSeconds(3))
                        .until(ExpectedConditions.visibilityOf(viewCartButton));
            }
        }
        WebElement cartCount = getDriver().findElement(By.xpath(".//div[@class = 'ast-cart-menu-wrap']/span"));

        Assert.assertEquals(Integer.valueOf(cartCount.getText().trim()), 5);
    }

    @Test
    public void testVerifyItemsDeletedFromShoppingCart() {
        List<WebElement> featuredProducts = getDriver().findElements(By.xpath(".//ul[@class = 'products columns-5']/li"));
        for (WebElement product : featuredProducts) {
            List<WebElement> productPrices = product.findElements(By.tagName("bdi"));
            if (productPrices.size() > 1) {
                WebElement addToCartButton = product.findElement(By.xpath("./div/a[text() = 'Add to cart']"));
                addToCartButton.click();
                WebElement viewCartButton = product.findElement(By.xpath("./div/a[text() = 'View cart']"));
                new WebDriverWait(getDriver(), Duration.ofSeconds(3))
                        .until(ExpectedConditions.visibilityOf(viewCartButton));
            }
        }
        WebElement cartIcon = getDriver().findElement(By.className("count"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(cartIcon).build().perform();
        List<WebElement> productsInCart = getDriver().findElements(By.xpath(".//div[@id = 'ast-desktop-header']" +
                "//ul[@class = 'woocommerce-mini-cart cart_list product_list_widget ']/li"));
        for (WebElement product : productsInCart) {
            WebElement deleteButton = product.findElement(By.xpath("./a[text() = '×']"));
            new WebDriverWait(getDriver(), Duration.ofSeconds(3))
                    .until(ExpectedConditions.elementToBeClickable(deleteButton));
            deleteButton.click();
        }
        WebElement emptyCartMessage = getDriver().findElement(By.className("woocommerce-mini-cart__empty-message"));
        cartIcon = getDriver().findElement(By.className("count"));
        actions.moveToElement(cartIcon).build().perform();

        Assert.assertEquals(emptyCartMessage.getText(), "No products in the cart.");
    }
}