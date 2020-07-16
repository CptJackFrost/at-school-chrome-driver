import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Avito {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.avito.ru/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#category option[value='99']")).click();
        driver.findElement(By.cssSelector("#search")).sendKeys("Принтер");
        driver.findElement(By.cssSelector("div[data-marker='search-form/region']")).click();



        //WebElement params = driver.findElement(By.cssSelector("._1dp226jcDt_jum2k1IGKC_"));
        //params.click();
        //driver.close();
        //driver.quit();



    }
}
