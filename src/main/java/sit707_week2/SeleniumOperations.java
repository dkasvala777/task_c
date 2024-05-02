package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void officeworks_registration_page(String url) {
        // Step 1: Locate chrome driver folder in the local drive.
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");

        // Step 2: Use above chrome driver to open up a chromium browser.
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();

        System.out.println("Driver info: " + driver);

        sleep(2);

        // Load a webpage in chromium browser.
        driver.get(url);

        // Find first input field which is firstname
        WebElement firstNameInput = driver.findElement(By.id("firstname"));
        System.out.println("Found element: " + firstNameInput);
        firstNameInput.sendKeys("Dhruv");

        WebElement lastNameInput = driver.findElement(By.id("lastname"));
        System.out.println("Found element: " + lastNameInput);
        lastNameInput.sendKeys("Kaswala");

        WebElement phoneNumberInput = driver.findElement(By.id("phoneNumber"));
        System.out.println("Found element: " + phoneNumberInput);
        phoneNumberInput.sendKeys("0413118977");

        WebElement emailInput = driver.findElement(By.id("email"));
        System.out.println("Found element: " + emailInput);
        emailInput.sendKeys("s223676061@deakin.edu.au");

        WebElement passwordInput = driver.findElement(By.id("password"));
        System.out.println("Found element: " + passwordInput);
        passwordInput.sendKeys("Deakinuniversity@123");

        WebElement confirmPasswordInput = driver.findElement(By.id("confirmPassword"));
        System.out.println("Found element: " + confirmPasswordInput);
        confirmPasswordInput.sendKeys("Deakinuniversity123");

        // Locate the Create account button relative to the Email input field
        WebElement createAccountButton = driver.findElement(By.xpath("//input[@id='email']/following::button[contains(text(),'Create account')]"));
        System.out.println("Found element: " + createAccountButton);
        createAccountButton.click();

        // Take screenshot after submitting the form
        takeScreenshot(driver, "registration_page");

        // Sleep a while
        sleep(2);

        // close chrome driver
        driver.close();
    }

    // Method to take screenshot
    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            // Convert WebDriver instance to TakesScreenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;

            // Capture screenshot as File
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

            // Define destination file path and copy the screenshot file
            File destinationFile = new File(fileName + ".png");
            FileUtils.copyFile(sourceFile, destinationFile);

            // Print success message
            System.out.println("Screenshot taken and saved as '" + fileName + ".png'");
        } catch (Exception e) {
            // Print error message
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
    }
}
