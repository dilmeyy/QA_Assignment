package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterTest {

    @Test
    public void testRegister() {
        // Initialize the WebDriver (Assuming you have the ChromeDriver executable in your PATH)
        WebDriver driver = new ChromeDriver();

        // Wait object to implicitly tell the script how long to wait until a certain element is visible or available to proceed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Maximize the window
        driver.manage().window().maximize();

        // Navigate to the registration URL
        driver.get("http://localhost/api-flora/api-flora/register.php");

        // Find the username, email, password, and confirm password input fields
        WebElement usernameField = driver.findElement(By.name("username")); // Assuming the input field name is 'username'
        WebElement emailField = driver.findElement(By.name("email")); // Assuming the input field name is 'email'
        WebElement passwordField = driver.findElement(By.name("password")); // Assuming the input field name is 'password'
        WebElement confirmPasswordField = driver.findElement(By.name("confirm_password")); // Assuming the input field name is 'confirm_password'

        // Entering sample registration details
        usernameField.sendKeys("testuser");
        emailField.sendKeys("testuser@example.com");
        passwordField.sendKeys("TestPassword123");
        confirmPasswordField.sendKeys("TestPassword123");

        // Find and click the register button
        WebElement registerButton = driver.findElement(By.name("register")); // Assuming the button name is 'register'
        registerButton.click();

        // Wait until the page is redirected after registration
        wait.until(ExpectedConditions.urlContains("dashboard")); // Assuming successful registration redirects to 'dashboard' page

        // Verify the registration by checking the presence of a logout button or a specific element in the dashboard
        try {
            WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("logout"))); // Assuming the logout button name is 'logout'
            System.out.println("Registration successful!");
        } catch (Exception e) {
            System.out.println("Registration failed!");
        }

        // Close the browser
        driver.quit();
    }
}


