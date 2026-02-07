import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ampadverificationposition {

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

            // XPaths
            By ampAdXpath = By.xpath("//amp-ad[contains(@data-slot,'TOI_AMP_INDIA_AS_ATF')]");
            By leadImageXpath = By.xpath("(//div[@class='lead-image'])[1]");

            // Wait for both elements
            wait.until(ExpectedConditions.presenceOfElementLocated(ampAdXpath));
            wait.until(ExpectedConditions.presenceOfElementLocated(leadImageXpath));

            List<WebElement> ampAds = driver.findElements(ampAdXpath);
            List<WebElement> leadImages = driver.findElements(leadImageXpath);

            if (ampAds.isEmpty() || leadImages.isEmpty()) {
                System.out.println("❌ Required elements not found");
                return;
            }

            WebElement ampAd = ampAds.get(0);
            WebElement leadImage = leadImages.get(0);

            int ampAdY = ampAd.getLocation().getY();
            int leadImageY = leadImage.getLocation().getY();

            System.out.println("📍 AMP Ad Y Position      : " + ampAdY);
            System.out.println("📍 Lead Image Y Position : " + leadImageY);

            // ===== ATF Validation =====
            if (ampAdY < leadImageY) {
                System.out.println("✅ ATF PASS: AMP Ad is ABOVE the Lead Image");
            } else {
                System.out.println("❌ ATF FAIL: AMP Ad is NOT above the Lead Image");
            }

        } catch (Exception e) {
            System.out.println("❌ Error during ATF validation");
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}