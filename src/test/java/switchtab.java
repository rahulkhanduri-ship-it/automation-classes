import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class switchtab {

    public static void main(String[] args) {

        // Mobile emulation
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Nexus 5");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Open AMP page
            driver.get(
                    "https://timesofindia.indiatimes.com/india/centre-asks-those-who-have-still-not-registered-their-waqf-properties-on-portal-to-hurry/amp_articleshow/125710467.cms"
            );

            driver.getCurrentUrl();
            System.out.println("Current URL: " + driver.getCurrentUrl());
//implement implicit wait for ad to load
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));


            //WebElement adElement = driver.findElement(By.xpath("//div[@class='ampv3-ad atf']//amp-ad[@type='doubleclick']"));
            WebElement adElement = driver.findElement(By.xpath("//div[@class='ampv3-ad atf']//amp-ad[@data-slot='/23037861279/TOI_AMP/TOI_AMP_INDIA/TOI_AMP_INDIA_AS/TOI_AMP_INDIA_AS_ATF']"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            adElement.click();
            driver.getCurrentUrl();
            System.out.println("Current URL: " + driver.getCurrentUrl());
//Facing an issue here many a times Ad is opening in the same window instead of new tab.



        } catch (Exception e) {
            System.out.println("❌ Error during ATF validation");
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}