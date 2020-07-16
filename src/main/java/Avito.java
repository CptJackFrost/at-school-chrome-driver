import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Avito {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        driver.get("https://www.avito.ru/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("#category option[value='99']")).click();

        driver.findElement(By.cssSelector("#search")).sendKeys("Принтер");

        driver.findElement(By.cssSelector("div[data-marker='search-form/region']")).click();

        driver.findElement(By.cssSelector("input[data-marker='popup-location/region/input']"))
                .sendKeys("Владивосток");

        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("li[data-marker='suggest(0)']")), "Владивосток"));
        driver.findElement(By.cssSelector("*[data-marker='suggest(0)']")).click();
        driver.findElement(By.cssSelector("button[data-marker='popup-location/save-button']")).click();



        //WebElement params = driver.findElement(By.cssSelector("._1dp226jcDt_jum2k1IGKC_"));
        //params.click();
        //driver.close();
        //driver.quit();



    }
}
