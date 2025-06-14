package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class login {

    WebDriver saroj;

    @BeforeClass
    public void setUp() {
        saroj = new ChromeDriver();
        saroj.manage().window().maximize();
        saroj.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void loginTest() throws InterruptedException {
        WebElement usernameField = saroj.findElement(By.id("username"));
        WebElement passwordField = saroj.findElement(By.id("password"));

        String username = "student";
        String password = "Password123";

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        Thread.sleep(3000);
        saroj.findElement(By.id("submit")).click();
        Thread.sleep(2000);

        if (saroj.getCurrentUrl().contains("logged-in-successfully")) {
            System.out.println("Login successful.");
            Thread.sleep(2000);
            WebElement logoutLink = saroj.findElement(By.linkText("Log out"));
            logoutLink.click();
            System.out.println("Logout successful.");
        } else {
            WebElement errorMsg = saroj.findElement(By.id("error"));
            System.out.println("Login failed! " + errorMsg.getText());
        }
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        saroj.quit();
        System.out.println("The entire browser closed.");
    }
}
