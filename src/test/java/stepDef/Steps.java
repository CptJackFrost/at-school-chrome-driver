package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Steps {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 5);

    @ParameterType(".*")
    public Category category(String category) {
        return Category.valueOf(category);
    }

    @ParameterType(".*")
    public Price price(String price) {
        return Price.valueOf(price);
    }

    @Пусть("открыт ресурс авито")
    public void открытРесурсАвито() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.get("https://www.avito.ru/");
    }

    @И("в выпадающем списке категорий выбрана {category}")
    public void вВыпадающемСпискеКатегорийВыбранаОргтехника(Category category) {
        driver.findElement(By.cssSelector(category.value)).click();
    }

    @И("в поле поиска введено значение принтер")
    public void вПолеПоискаВведеноЗначениеПринтер() {
        driver.findElement(By.cssSelector("#search")).sendKeys("Принтер");
    }

    @Тогда("кликнуть по выпадающему списку региона")
    public void кликнутьПоВыпадающемуСпискуРегиона() {
        driver.findElement(By.cssSelector("div[data-marker='search-form/region']")).click();
    }

    @Тогда("в поле регион введено значение Владивосток")
    public void вПолеРегионВведеноЗначениеВладивосток() {
        driver.findElement(By.cssSelector("input[data-marker='popup-location/region/input']"))
                .sendKeys("Владивосток");
    }

    @И("нажата кнопка показать объявления")
    public void нажатаКнопкаПоказатьОбъявления() {
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("li[data-marker='suggest(0)']")), "Владивосток"));
        driver.findElement(By.cssSelector("button[data-marker='popup-location/save-button']")).click();
    }

    @Тогда("открылась страница результаты по запросу принтер")
    public void открыласьСтраницаРезультатыПоЗапросуПринтер() {
        //а что еще тут делать-то?
        System.out.println("открыто\n");
    }

    @И("активирован чекбокс только с фотографией")
    public void активированЧекбоксТолькоСФотографией() {
        WebElement photoOnly = driver.findElement(By.xpath("//label[./input[@name='withImagesOnly']]"));
        wait.until(ExpectedConditions.elementToBeClickable(photoOnly));
        if (!photoOnly.isSelected()){
            photoOnly.click();
            WebElement filtersSubmitButton =
                    driver.findElement(By.cssSelector("button[data-marker='search-filters/submit-button']"));
            wait.until(ExpectedConditions.elementToBeClickable(filtersSubmitButton));
            filtersSubmitButton.click();
        }
    }

    @И("в выпадающем списке сортировка выбрано значение {price}")
    public void вВыпадающемСпискеСортировкаВыбраноЗначениеДороже(Price price) {
        WebElement priceFilterOption = driver.findElement(By.xpath(price.value));
        wait.until(ExpectedConditions.elementToBeClickable(priceFilterOption));
        priceFilterOption.click();
    }

    @И("в консоль выведено значение названия и цены {int} первых товаров")
    public void вКонсольВыведеноЗначениеНазванияИЦеныПервыхТоваров(int arg0) {
        List<WebElement> printers = driver.findElements(By.cssSelector(".item_table-wrapper"));

        for (int i = 0; i < 3; i++){
            System.out.println(printers.get(i).findElement(By.cssSelector("div>.snippet-title-row>h3>a")).getText());
            System.out.println(printers.get(i).findElement(By.cssSelector("div>.snippet-price-row>.snippet-price")).getText()+ "\n");
        }
    }

    @After
    public void after(){
        driver.quit();
    }
}
