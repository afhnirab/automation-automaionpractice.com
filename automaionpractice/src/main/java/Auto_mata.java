import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.*;

import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Auto_mata {
    public static void main(String[] args) {
        String email1 = "nirab" + getRandom(100000, 1000000) + "@gmail.com";
        String password1 = "hellfire";

        String email2 = "nirab" + getRandom(100000, 1000000) + "@gmail.com";
        String password2 = "coldfire";

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));

        register(driver, email1, password1);
//        register(driver, email2, password2);
//
        login(driver,email1, password1);

    }

    public static String getRandom(int min, int max){
        return Integer.toString(ThreadLocalRandom.current().nextInt(min, max + 1));
    }

    public static void register(ChromeDriver driver, String email, String password){
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email_create")).sendKeys(email);
        driver.findElement(By.id("SubmitCreate")).click();

        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("nirab");
        driver.findElement(By.id("customer_lastname")).sendKeys("ali");
        driver.findElement(By.id("passwd")).sendKeys(password);

        WebElement selectDays = driver.findElement(By.id("days"));
        Select selectObj1 = new Select(selectDays);
        selectObj1.selectByValue("6");
        WebElement selectMonth = driver.findElement(By.id("months"));
        Select selectObj2 = new Select(selectMonth);
        selectObj2.selectByValue("5");
        WebElement selectYear = driver.findElement(By.id("years"));
        Select selectObj3 = new Select(selectYear);
        selectObj3.selectByValue("1998");

        driver.findElement(By.id("company")).sendKeys("demoCompany");
        driver.findElement(By.id("address1")).sendKeys("demoAddress");
        driver.findElement(By.id("city")).sendKeys("demoCity");

        WebElement selectCity = driver.findElement(By.id("id_state"));
        Select selectObj4 = new Select(selectCity);
        selectObj4.selectByValue("7");

        driver.findElement(By.id("postcode")).sendKeys("35454");
        driver.findElement(By.id("phone_mobile")).sendKeys("136462465");
        driver.findElement(By.id("submitAccount")).click();
        driver.findElement(By.className("logout")).click();
    }

    public static void login(ChromeDriver driver, String email, String password){
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();

//        Actions action = new Actions(driver);
//        WebElement we = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
//        action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a"))).click().build().perform();
        String yoyo = "//*[@title='Casual Dresses']";
        driver.get(driver.findElement(By.xpath(yoyo)).getAttribute("href"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.className("product-container"));
        action.moveToElement(we).moveToElement(driver.findElement(By.className("ajax_add_to_cart_button"))).click().build().perform();

        String tshirt = "//*[@title='T-shirts']";
        driver.get(driver.findElement(By.xpath(tshirt)).getAttribute("href"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));

        driver.findElement(By.id("layered_id_attribute_group_14")).click();

        Actions action1 = new Actions(driver);
        WebElement we1 = driver.findElement(By.className("product-container"));
        action1.moveToElement(we1).moveToElement(driver.findElement(By.id("color_2"))).click().build().perform();

        driver.findElement(By.id("add_to_cart")).click();

        String proceed = "//*[@title='Proceed to checkout']";
        driver.get(driver.findElement(By.xpath(proceed)).getAttribute("href"));

        driver.findElement(By.className("standard-checkout")).click();
        driver.findElement(By.name("processAddress")).click();
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.className("standard-checkout")).click();

        driver.findElement(By.className("cheque")).click();
        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();

        driver.findElement(By.className("logout")).click();
    }
}
