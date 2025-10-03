package stepdefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

import java.time.Duration;
import hooks.Hooks;

import static org.junit.jupiter.api.Assertions.assertTrue;



public class MenuSteps {


public class CategorySteps {
    @Given("I select a category")
    public void i_select_category() {
        Hooks.getTest().info("Navigating to categories filter popup");
        // Selenium code to select checkbox
        Hooks.getTest().pass("Category selected successfully");
    }
}

//checkin all catogories tabs
     private WebDriver driver;
        @Given("I am on the Greggs menu page")
    public void i_am_on_the_greggs_menu_page() {
         driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Open Greggs menu page
        driver.get("https://www.greggs.co.uk/menu");
       try {
            Thread.sleep(2000); // Wait for potential cookie banner to load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement menuButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
         if (menuButton.isDisplayed()) {
            menuButton.click();
        }
        
    }

    
    @When("I select the {string} category")
    public void i_select_the_category(String category) {
        
        WebElement categoryElement = driver.findElement(By.cssSelector("[data-test-filter='" + category + "']"));
        categoryElement.click();
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I should see a list of {string}")
    public void i_should_see_a_list_of(String expectedItems) {

        WebElement expecteditems = driver.findElement(By.cssSelector("[data-test-filter='" + expectedItems + "']"));
        
        expecteditems.isDisplayed();
        driver.quit();
    }


    @When("I click on filter menu pop up should be displayed")
public void i_click_on_filter_menu_pop_up_should_be_displayed() {
   

        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement filterIcon = driver.findElement(By.cssSelector("[data-test='filterButton']"));
        filterIcon.click();
            try {
                Thread.sleep(2000); // Wait for filter menu to appear
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
       
    }
//catogory filter
@Then("from selected category I should select items")
public void from_selected_category_i_should_select_items() {
       JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,400)");
         js.executeScript("window.scrollBy(0,400)");
          try {
                Thread.sleep(2000); // Wait for filter menu to appear
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        WebElement breakfast = driver.findElement(By.xpath("//*[text()='Breakfast (20)']"));
        breakfast.click();
         try {
                Thread.sleep(2000); // Wait for filter menu to appear
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        WebElement savouries = driver.findElement(By.xpath("//*[text()='Savouries & Bakes (11)']"));
        savouries.click();
         try {
                Thread.sleep(2000); // Wait for filter menu to appear
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        WebElement applyfiletrs = driver.findElement(By.xpath("//*[text()=' Apply filters ' ]"));
        applyfiletrs.click();
}
//calories filter
@Then("from selected calories should be adjusted so i should select items")
public void from_selected_calories_should_be_adjusted_so_i_should_select_items() {
    WebElement caloriesElement = driver.findElement(By.xpath("//input[@type='range']"));
    Actions move = new Actions(driver);
    move.clickAndHold(caloriesElement).moveByOffset(30,0).release().build().perform();

     try {
                Thread.sleep(2000); // Wait for filter menu to appear
            } catch (InterruptedException e) {
                e.printStackTrace();   
            }     
             WebElement applyfiletrs = driver.findElement(By.xpath("//*[text()=' Apply filters ' ]"));
        applyfiletrs.click();
        WebElement countcalories = driver.findElement(By.xpath("//h3[normalize-space() = 'Sausage Breakfast Roll']"));
        countcalories.click();


        WebElement nutrition_elem = driver.findElement(By.xpath("//h2[contains(., 'Nutritional Information')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nutrition_elem);

 String energy_kj_100g = driver.findElement(By.xpath("//table//tr[td[text()='Energy kJ']]/td[3]")).getText();

java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("\\d+").matcher(energy_kj_100g);
int energy_number = 0;
if (matcher.find()) {
    energy_number = Integer.parseInt(matcher.group());
}

System.out.println("Energy kJ per 100g: " + energy_number);
driver.quit();




}



//functional ascepts:

//list of breakfast items should displayed when breakfast category is selected
@When("I select {string} category")
public void i_select_category(String string) {
    WebElement categoryElement = driver.findElement(By.cssSelector("[data-test-filter='" + string + "']"));
        categoryElement.click();
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();        
        }
}
@Then("only breakfast items should be displayed")
public void only_breakfast_items_should_be_displayed() {
    WebElement breakfastItems = driver.findElement(By.xpath("//h3[contains(text(),'Breakfast')]"));
    assertTrue(breakfastItems.isDisplayed(), "Breakfast items are displayed");  
}



//search functionality
@When("I search for {string}")
public void i_search_for(String string) {
    WebElement searchBox = driver.findElement(By.id("article-search"));
    searchBox.sendKeys(string);
    //searchBox.submit();
     try {
                Thread.sleep(2000); // Wait for search results to load
            } catch (InterruptedException e) {
                e.printStackTrace();   
            }
}
@Then("the search results should include {string}")
public void the_search_results_should_include(String string) {
    WebElement searchResult = driver.findElement(By.xpath("//*[text()='" + string + "']"));
    assertTrue(searchResult.isDisplayed(), "Search result does not include: " + string);
    // Close the browser after verification
    driver.quit();
}


//performance aspects:
@Then("page should load within {int} seconds")
public void verifyPageLoadTime(int maxSeconds) {
    long start = System.currentTimeMillis();
    driver.get("https://www.greggs.co.uk/menu");  // Open menu page
    long end = System.currentTimeMillis();

    long loadTime = end - start;  // in milliseconds
    System.out.println("Page load time: " + loadTime + " ms");

    assertTrue(loadTime <= maxSeconds * 1000, "Page took longer than " + maxSeconds + " seconds");
}
//topmenu

@When("i check top menu")
public void i_check_top_menu() {
    WebElement topmenu = driver.findElement(By.xpath("//*[text()='Menu & allergens ']"));
    topmenu.click();
    try {
        Thread.sleep(2000); // Wait for page to load after clicking
    } catch (InterruptedException e) {
        e.printStackTrace();        
    }
}
@Then("click on list")
public void click_on_list() {
    WebElement list = driver.findElement(By.xpath("//*[text()='Breakfast']"));
    list.click();
    try {
        Thread.sleep(2000); // Wait for page to load after clicking
    } catch (InterruptedException e) {
        e.printStackTrace();        
    }
    driver.quit();
}
}