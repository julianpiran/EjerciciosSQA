import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrom.driver","chrome.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/newtours/");

        //Espera Implicita no se recomienda
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Espera Explicita (1er tipo) no se recomienda
        //Thread.sleep(2000);

        //Espera Explicita (2do tipo)
        WebDriverWait ewait = new WebDriverWait(driver,5);
        ewait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("REGISTER"))));

        //Espera Explicita (3er tipo Fluent Wait)
        /*Wait <WebDriver> fluentWait = new FluentWait<WebDriver>(driver).
                withTimeout(10, TimeUnit.SECONDS).
                pollingEvery(2,TimeUnit.SECONDS).ignoring(NoSuchElementException);
        WebElement text = fluentWait.until(new Function<WebDriver,WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.linkText("REGISTER"));
            }
        });*/

        driver.findElement(By.linkText("REGISTER")).click();
        driver.findElement(By.name("firstName")).sendKeys("Julian");
        driver.findElement(By.name("lastName")).sendKeys("Piranquive");
        driver.findElement(By.name("phone")).sendKeys("3008930837");
        driver.findElement(By.id("userName")).sendKeys("julian.piiran@hotmail.com");
        driver.findElement(By.name("address1")).sendKeys("Calle 19 #59-17");
        driver.findElement(By.name("city")).sendKeys("Medellin");
        driver.findElement(By.name("state")).sendKeys("Antioquia");
        driver.findElement(By.name("postalCode")).sendKeys("5535");
        driver.findElement(By.name("country")).click();
        driver.findElement(new By.ByXPath("//option[@value=\"COLOMBIA\"]")).click();
        driver.findElement(By.id("email")).sendKeys("julian.piiran@hotmail.com");
        driver.findElement(By.name("password")).sendKeys("Piiran789");
        driver.findElement(By.name("confirmPassword")).sendKeys("Piiran789");

        //File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(scrFile, new File("D:\\Cursos\\CursoSelenium\\screenshot.png"));

        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), "jpg", new File("D:\\Cursos\\CursoSQA\\CursoSelenium\\screenshotFull.png"));

        //WebElement element = driver.findElement(By.xpath("//img [@src='images/logo.gif']"));
        //Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver,element);
        //ImageIO.write(screenshot.getImage(), "jpg", new File("D:\\Cursos\\CursoSQA\\CursoSelenium\\screenshotElement.png"));

        /*WebElement element = driver.findElement(By.xpath("//img [@src='images/logo.gif']"));
        Screenshot logoElementScreenshot = new AShot().takeScreenshot(driver, element);
        BufferedImage expectedImage = ImageIO.read(new File("D:\\Cursos\\CursoSelenium\\screenshot1.jpg"));
        BufferedImage actualImage = logoElementScreenshot.getImage();

        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);

        if (diff.hasDiff() == true) {
            System.out.println("Images are same");

        } else {
            System.out.println("Images are different");
        }*/

        driver.findElement(By.name("submit")).click();

    }
}
