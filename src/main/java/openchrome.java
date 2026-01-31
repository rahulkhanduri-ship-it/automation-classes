import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class openchrome {
    public static void main(String[] args) {
        System.out.println("Hello World");

        // Selenium Manager auto-handles ChromeDriver
        System.setProperty("webdriver.chrome.driver","//Users//rahul.khanduri//Documents//Eclipse//chromedriver");
        WebDriver driver = new ChromeDriver();

        // Optional: Maximize window and navigate
        driver.manage().window().maximize();
        driver.get("https://navbharattimes.indiatimes.com/");

        // Keep browser open briefly; add wait in real tests
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
