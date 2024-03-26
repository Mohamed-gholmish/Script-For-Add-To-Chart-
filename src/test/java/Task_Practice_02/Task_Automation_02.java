package Task_Practice_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class Task_Automation_02 {
    public static void main(String[] args) {
        // Set the system property for Chrome driver
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        // Array containing names of products needed
        String[] namesOfProductsNeeded = {"Cauliflower", "Beans", "Banana", "Beetroot"};

        // List to store all product elements
        List<WebElement> allProducts = driver.findElements(By.cssSelector("h4.product-name"));

        // Iterate through all products
        for (int i = 0; i < allProducts.size(); i++) {
            // Extract product name and trim extra spaces
            String productName = allProducts.get(i).getText().split("-")[0].trim();

            // Convert array to list for easy searching
            List<String> productList = Arrays.asList(namesOfProductsNeeded);

            if (productList.contains(productName)) {
                // Click on the corresponding 'Add to Cart' button
                driver.findElements(By.cssSelector(".product-action button")).get(i).click();
            }
        }

        driver.quit();
    }
}