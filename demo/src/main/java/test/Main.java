package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {
    public static void main(String[] args) {
       // Set path to your ChromeDriver
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        try {
            // 1. Open Greggs website
            driver.get("https://www.greggs.com/menu");
            
            // 2. (Optional) Accept cookies if prompted
            try {
                WebElement acceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
                acceptCookies.click();
            } catch (Exception e) {
                // Ignore if not present
            }
            
            // 3. Navigate to Menu section
            WebElement menuButton = driver.findElement(By.linkText("All"));
            menuButton.click();

            // 4. Wait for menu page to load and interact with an item (example)
            // Add your own waits as needed!
            Thread.sleep(2000); // Not recommended for production; use WebDriverWait instead

            // Example: Click on "Breakfast" category
            WebElement breakfastCategory = driver.findElement(By.partialLinkText("Breakfast"));
            breakfastCategory.click();

            // 5. Print out the names of the items in the Breakfast category
            for (WebElement item : driver.findElements(By.cssSelector(".product-card__title"))) {
                System.out.println(item.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}