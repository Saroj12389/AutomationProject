package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class testlogin {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Step 1:
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }

    @Test
    public void bookAppointmentFlow() throws InterruptedException {
        Thread.sleep(2000);

        //Step 2:
        WebElement makeAppointmentBtn = driver.findElement(By.id("btn-make-appointment"));
        makeAppointmentBtn.click();
        Thread.sleep(1000);

        //Step 3:
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
        Thread.sleep(3000);

        //Step 4:
        driver.findElement(By.id("combo_facility")).sendKeys("Hongkong CURA Healthcare Center");
        driver.findElement(By.id("chk_hospotal_readmission")).click();
        driver.findElement(By.id("radio_program_medicaid")).click();
        driver.findElement(By.id("txt_visit_date")).sendKeys("12/06/2025");
        driver.findElement(By.id("txt_comment")).sendKeys("This is a test appointment.");
        driver.findElement(By.id("btn-book-appointment")).click();
        Thread.sleep(3000);
        
        //Step 5:
        driver.findElement(By.linkText("Go to Homepage")).click();
        Thread.sleep(1000);

        //Step 6:
        WebElement menuToggle = driver.findElement(By.id("menu-toggle"));
        menuToggle.click();
        Thread.sleep(1000);

        WebElement profileLink = driver.findElement(By.xpath("//a[contains(text(),'Profile')]"));
        profileLink.click();
        Thread.sleep(1000);

        WebElement logoutBtn = driver.findElement(By.xpath("//a[contains(@class, 'btn') and contains(@class, 'btn-default') and text()='Logout']"));
        logoutBtn.click();
        Thread.sleep(2000);
        
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

