package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginTest {

    @Test
    public void testLogin() {
        // Initialize the WebDriver (Assuming you have the ChromeDriver executable in your PATH)
        WebDriver driver = new ChromeDriver();

        // Wait object to implicitly tell the script how long to wait until a certain element is visible or available to proceed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Maximize the window
        driver.manage().window().maximize();

        // Navigate to the login URL
        driver.get("http://localhost/api-flora/api-flora/login.php");

        // Find the username and password input fields and enter credentials
        WebElement usernameField = driver.findElement(By.name("username")); // Assuming the input field name is 'username'
        WebElement passwordField = driver.findElement(By.name("password")); // Assuming the input field name is 'password'

        // Entering sample credentials
        usernameField.sendKeys("para@gmail.com");
        passwordField.sendKeys("123");

        // Find and click the login button
        WebElement loginButton = driver.findElement(By.name("login")); // Assuming the button name is 'login'
        loginButton.click();

        // Wait until the page is redirected after login
        wait.until(ExpectedConditions.urlContains("dashboard")); // Assuming successful login redirects to 'dashboard' page

        // Verify the login by checking the presence of a logout button or a specific element in the dashboard
        try {
            WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("logout"))); // Assuming the logout button name is 'logout'
            System.out.println("Login successful!");
        } catch (Exception e) {
            System.out.println("Login failed!");
        }

        // Close the browser
        driver.quit();
    }
}