import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ampadverification {
    public static void main(String[] args) {


        // Set path to ChromeDriver
        System.setProperty("webdriver.chrome.driver",
                "//Users//rahul.khanduri//Documents//Eclipse//chromedriver");

        // ----- Mobile emulation setup -----
        Map<String, String> mobileEmulation = new HashMap<>();
        // Any valid DevTools device name: "Nexus 5", "iPhone 6", etc.
        mobileEmulation.put("deviceName", "Nexus 5");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        // Initialise the webdriver with mobile emulation
        WebDriver driver = new ChromeDriver(chromeOptions);

        // Optional: Maximize is not required for emulation, but it won't hurt
        driver.manage().window().maximize();

        driver.get("https://timesofindia.indiatimes.com/india/centre-asks-those-who-have-still-not-registered-their-waqf-properties-on-portal-to-hurry/amp_articleshow/125710467.cms");

        // XPath for AMP Ad
        By ampAdXpath = By.xpath("//amp-ad[contains(@data-slot,'TOI_AMP_INDIA_AS_ATF')]");



        // Check if AMP Ad is present
        List<WebElement> ampAds = driver.findElements(ampAdXpath);

        // Find the element
        WebElement ampAd = driver.findElement(ampAdXpath);

// Read attributes
        String height = ampAd.getAttribute("height");
        String width  = ampAd.getAttribute("width");

// Print them
        System.out.println("height = " + height);
        System.out.println("width  = " + width);


      //  By ampAdXpath1 = By.xpath("//div[@class='myClass']");
        WebElement ampImg = driver.findElement(
                By.xpath("//amp-img[contains(@src,'waqf.jpg')]"));

// Get the src attribute value
        String srcValue = ampImg.getAttribute("src");

// Print it
        System.out.println("amp-img src = " + srcValue);



        if (!ampAds.isEmpty()) {
            System.out.println("✅ AMP Ad is present on the page");
        } else {
            System.out.println("❌ AMP Ad is NOT present on the page");
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
