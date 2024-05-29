package xkcd_homepage_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;


    @BeforeTest
    public void setUp()  {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        baseURL = "https://xkcd.com/";}




    @Test
    public void pictureTest() throws InterruptedException {
        driver.get(baseURL);

driver.findElement(By.xpath("//body/div[@id='middleContainer']/div[@id='comic']/img[1]")).isDisplayed();
Thread.sleep(3000);
driver.findElement(By.xpath("//body/div[@id='middleContainer']/ul[1]/li[2]/a[1]")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//body/div[@id='middleContainer']/div[@id='comic']/img[1]")).isDisplayed();

String FirstPicture = driver.findElement(By.xpath("//body/div[@id='middleContainer']/div[@id='comic']/img[1]")).getAttribute("src");
driver.findElement(By.xpath("//body/div[@id='middleContainer']/ul[1]/li[2]/a[1]")).click();
Thread.sleep(3000);

String SecondPicture = driver.findElement(By.xpath("//body/div[@id='middleContainer']/div[@id='comic']/img[1]")).getAttribute("src");
Thread.sleep(2000);
Assert.assertNotEquals(FirstPicture,SecondPicture);






    }


    @AfterTest
    public void endTest(){
        driver.quit(); }









}
