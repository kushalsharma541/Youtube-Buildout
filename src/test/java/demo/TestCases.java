package demo;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.logging.Level;

import demo.utils.ExcelDataProvider;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;
import dev.failsafe.internal.util.Assert;

public class TestCases extends ExcelDataProvider { // Lets us read the data
        static ChromeDriver driver;

        /*
         * TODO: Write your tests here with testng @Test annotation.
         * Follow `testCase01` `testCase02`... format or what is provided in
         * instructions
         */
        @Test(alwaysRun = true, enabled = true)
        public static void testCase01() throws InterruptedException {
                System.out.println("Start the testCase01");
                driver.get("https://www.youtube.com/");

                Thread.sleep(10000);

                String URL = driver.getCurrentUrl();

                SoftAssert softAssert = new SoftAssert();

                softAssert.assertEquals(URL, "youtube.com");

                // WebElement sideBarElement =
                // driver.findElement(By.xpath("(//*[@id='guide-icon']/yt-icon-shape/icon-shape/div)[1]"));

                // Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                // wait.until(ExpectedConditions.elementToBeClickable(sideBarElement));

                // sideBarElement.click();

                Thread.sleep(10000);

                WebElement aboutElement = driver.findElement(By.xpath("//div[@id='guide-links-primary']//a[1]"));

                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aboutElement);

                Wait<WebDriver> wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

                wait1.until(ExpectedConditions.elementToBeClickable(aboutElement));

                // aboutElement.click();

                Wrappers.wrapperClick(driver, aboutElement);

                Thread.sleep(5000);

                String aboutText1 = driver.findElement(By.xpath("//section[@class ='ytabout__content']")).getText();

                System.out.println("About text :- " + aboutText1);
        }

        @Test(alwaysRun = true, enabled = true)
        public static void testCase02() throws InterruptedException {
                System.out.println("Start the testCase02");
                driver.get("https://www.youtube.com/");

                Thread.sleep(10000);

                WebElement filmsElement = driver
                                .findElement(By.xpath("(//*[@id='items']/ytd-guide-entry-renderer[4])[1]"));

                // filmsElement.click();

                Wrappers.wrapperClick(driver, filmsElement);

                Thread.sleep(5000);

                // JavascriptExecutor js = (JavascriptExecutor) driver;
                // js.executeScript("window.scrollTo(document.body.scrollWidth, 0)");

                WebElement firstRight = driver.findElement(By.xpath(
                                "//*[@id='right-arrow']/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]"));

                for (int i = 0; i < 3; i++) {

                        if (firstRight.isEnabled()) {
                                // firstRight.click();
                                Wrappers.wrapperClick(driver, firstRight);
                        } else {

                                break; // Exit the loop if the button becomes disabled
                        }
                }

                Thread.sleep(10000);

                WebElement ratedElement = driver.findElement(By.xpath(
                                "//*[@id='items']/ytd-grid-movie-renderer[16]/ytd-badge-supported-renderer/div[2]/p"));

                String ratedText = ratedElement.getText();

                SoftAssert softAssert1 = new SoftAssert();

                softAssert1.assertTrue(ratedText.contains("A"), "Paragraph does not contain expected text");
                softAssert1.assertAll();

                WebElement movieGenre = driver
                                .findElement(By.xpath("//*[@id='items']/ytd-grid-movie-renderer[16]/a/span"));

                String moviegenreText = movieGenre.getText();
                // System.out.println(moviegenreText);
                SoftAssert softAssert2 = new SoftAssert();
                softAssert2.assertTrue(moviegenreText.contains("Comedy") || moviegenreText.contains("Animation"),
                                "Paragraph does not contain expected movie genre");
                softAssert2.assertAll();

                System.out.println("testcase02 has been completed successfully");
        }

        @Test(alwaysRun = true, enabled = true)
        public static void testCase03() throws InterruptedException {
                System.out.println("Start the testCase03");
                driver.get("https://www.youtube.com/");

                Thread.sleep(10000);

                WebElement musicElement = driver.findElement(By.xpath("//yt-formatted-string[text() = 'Music']"));

                // musicElement.click();

                Wrappers.wrapperClick(driver, musicElement);

                Thread.sleep(3000);

                WebElement rightElement1 = driver.findElement(By.xpath(
                                "(//*[@id='right-arrow']/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2])[1]"));

                for (int i = 0; i < 3; i++) {

                        if (rightElement1.isEnabled()) {
                                // rightElement1.click();
                                Wrappers.wrapperClick(driver, rightElement1);
                        } else {

                                break; // Exit the loop if the button becomes disabled
                        }
                }

                WebElement Musicheader = driver
                                .findElement(By.xpath("//*[@id='items']/ytd-compact-station-renderer[11]/div/a/h3"));

                String musicHeaderText = Musicheader.getText();

                System.out.println("Name of the playlist :" + musicHeaderText);

                WebElement tracksElement = driver.findElement(By.xpath("(//*[@id='video-count-text'])[1]"));

                String trackStringText = tracksElement.getText();

                SoftAssert softAssert3 = new SoftAssert();

                softAssert3.assertFalse(trackStringText.contains("50"), "It does not contains 50 tracks");

                softAssert3.assertAll();

                System.out.println("testcase03 has been completed successfully");

        }

        @Test(alwaysRun = true, enabled = true)
        public static void testCase04() throws InterruptedException {
                System.out.println("Start the testCase04");
                driver.get("https://www.youtube.com/");

                Thread.sleep(10000);

                WebElement newsElement = driver.findElement(By.xpath("//yt-formatted-string[text() = 'News']"));
                // newsElement.click();
                Wrappers.wrapperClick(driver, newsElement);
                Thread.sleep(4000);

                // WebElement latestNews = driver.findElement(By.xpath("//span[text() = 'Latest
                // news posts']"));

                // ((JavascriptExecutor)
                // driver).executeScript("arguments[0].scrollIntoView(true);", latestNews);

                // Thread.sleep(3000);

                WebElement latestnewsPost1Element = driver.findElement(
                                By.xpath("(//ytd-post-renderer[@class='style-scope ytd-rich-item-renderer'])[1]"));

                String latestNewsPost1Text = latestnewsPost1Element.getText();

                System.out.println("First latest news title and body : " + latestNewsPost1Text);

                // System.out.println("total likes count for first post :" + likesCount1 );

                Thread.sleep(5000);

                WebElement latestnewsPost2Element = driver.findElement(
                                By.xpath("(//ytd-post-renderer[@class='style-scope ytd-rich-item-renderer'])[2]"));

                String latestNewsPost2Text = latestnewsPost2Element.getText();

                System.out.println("Second latest news title and body : " + latestNewsPost2Text);

                Thread.sleep(5000);

                WebElement latestnewsPost3Element = driver.findElement(
                                By.xpath("(//ytd-post-renderer[@class='style-scope ytd-rich-item-renderer'])[3]"));

                String latestnewsPost3Text = latestnewsPost3Element.getText();

                System.out.println("Third latest news title and body : " + latestnewsPost3Text);

                WebElement likes1element = driver.findElement(By.xpath("(//span[@id ='vote-count-middle'])[1]"));

                Thread.sleep(3000);

                String likesCount1 = likes1element.getText();

                int likesCount1value = Integer.parseInt(likesCount1);

                System.out.println(likesCount1value);

                System.out.println("total count of the first post :" + likesCount1);

                WebElement likes21element = driver.findElement(By.xpath("(//span[@id ='vote-count-middle'])[2]"));

                Thread.sleep(3000);

                String likesCount2 = likes21element.getText();

                int likesCount2value = Integer.parseInt(likesCount1);

                System.out.println(likesCount2value);

                System.out.println("total count of the second post :" + likesCount2);

                Thread.sleep(3000);

                WebElement likes31element = driver.findElement(By.xpath("(//span[@id ='vote-count-middle'])[2]"));

                Thread.sleep(3000);

                String likesCount3 = likes31element.getText();

                int likesCount3value = Integer.parseInt(likesCount3);

                System.out.println(likesCount3value);

                System.out.println("total count of the third  post :" + likesCount3);

                Thread.sleep(3000);

                int finalTotalLikes = likesCount1value + likesCount2value + likesCount3value;

                System.out.println("Total final like on posts are :" + finalTotalLikes);

                System.out.println("Testcase04 has been completed succssfully");

        }

        // @Test(alwaysRun = false, enabled = false, dataProvider = "excelData", dataProviderClass = ExcelDataProvider.class)
        // public static void testCase05(String fileName) throws InterruptedException {
        //         System.out.println("Start the testCase05");
        //         driver.get("https://www.youtube.com/");

        //         // Total views counter
        //         int totalViews = 0;

        //         WebElement serachBoxElement = driver.findElement(By.xpath("//input[contains(@id = 'search')]"));

        //         Thread.sleep(10000);

        //         serachBoxElement.sendKeys(fileName);

        //         Actions actions = new Actions(driver);

        //         actions.sendKeys(Keys.ENTER).perform();

        //         Thread.sleep(10000);

        //         // Scroll down to load more videos
        //         JavascriptExecutor js = (JavascriptExecutor) driver;
        //         while (true) {
        //                 long initialHeight = (long) js.executeScript("return document.documentElement.scrollHeight");

        //                 js.executeScript("window.scrollTo(0, document.documentElement.scrollHeight);");

        //                 // Wait for some time to load more content
        //                 try {
        //                         Thread.sleep(2000); // Adjust sleep time as needed
        //                 } catch (InterruptedException e) {
        //                         e.printStackTrace();
        //                 }
        //                 long newHeight = (long) js.executeScript("return document.documentElement.scrollHeight");
        //                 if (newHeight == initialHeight) {
        //                         break;
        //                 }

        //                 List<WebElement> videoElements = driver.findElements(By.xpath(
        //                                 "//ytd-video-renderer[@class ='style-scope ytd-item-section-renderer']"));
        //                 int sumOfViews = 0;
        //                 for (WebElement video : videoElements) {
        //                         try {
        //                                 WebElement viewCountElement = video.findElement(By.xpath(
        //                                                 ".//span[@class ='inline-metadata-item style-scope ytd-video-meta-block']"));
        //                                 String viewCountText = viewCountElement.getText().replaceAll("[^0-9]", "");
        //                                 int views = Integer.parseInt(viewCountText);
        //                                 sumOfViews += views;
        //                         } catch (Exception e) {
        //                                 e.printStackTrace();
        //                         }

        //                         System.out.println("sum of views :" + sumOfViews);

        //                         // Calculate and accumulate views
        //                         int itemViews = sumOfViews;
        //                         totalViews += itemViews;

        //                         if (totalViews >= 100_000_000) {
        //                                 System.out.println("Reached 10 crore views threshold!");
        //                                 break;
        //                             }
        //                 }

        //         }
        // }

        /*
         * Do not change the provided methods unless necessary, they will help in
         * automation and assessment
         */
        @BeforeTest
        public void startBrowser() {
                System.setProperty("java.util.logging.config.file", "logging.properties");

                // NOT NEEDED FOR SELENIUM MANAGER
                // WebDriverManager.chromedriver().timeout(30).setup();

                ChromeOptions options = new ChromeOptions();
                LoggingPreferences logs = new LoggingPreferences();

                logs.enable(LogType.BROWSER, Level.ALL);
                logs.enable(LogType.DRIVER, Level.ALL);
                options.setCapability("goog:loggingPrefs", logs);
                options.addArguments("--remote-allow-origins=*");

                System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log");

                driver = new ChromeDriver(options);

                driver.manage().window().maximize();
        }

        @AfterTest
        public void endTest() {
                // driver.close();
                driver.quit();

        }
}