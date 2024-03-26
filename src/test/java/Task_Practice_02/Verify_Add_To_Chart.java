package Task_Practice_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Verify_Add_To_Chart {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Set<String> productsNeeded = getNeededProducts();
        List<WebElement> allProducts = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < allProducts.size(); i++) {
            String productName = allProducts.get(i).getText().split("-")[0].trim();
            if (productsNeeded.contains(productName)) {
              WebElement elementToAdded = driver.findElements(By.cssSelector(".product-action button")).get(i);
//              wait.until(d -> {
//                   elementToAdded.isEnabled();
//                  return true;
//              });
                wait.until(ExpectedConditions.elementToBeClickable(elementToAdded));
                elementToAdded.click();
            }
        }

        driver.quit();
    }

    private static Set<String> getNeededProducts() {
        Set<String> productsNeeded = new HashSet<>();
        productsNeeded.add("Cauliflower");
        productsNeeded.add("Beans");
        productsNeeded.add("Banana");
        productsNeeded.add("Beetroot");
        return productsNeeded;
    }
}