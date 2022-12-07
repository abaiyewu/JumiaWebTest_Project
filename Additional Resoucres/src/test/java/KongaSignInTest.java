import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaSignInTest {


    private WebDriver driver;


    @BeforeTest
    public void start() throws InterruptedException {

        //locate my chromedriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        //STEP 1. Open my Chrome Browser
        driver = new ChromeDriver();
        //STEP 2. Input the URL for the project
        driver.get("https://jumia.com.ng");
        //Test 1.
        if (driver.getCurrentUrl().contains("https://jumia.com.ng"))
            //pass
            System.out.println("Correct Webpage");
        else
            System.out.println("Wrong Webpage");

        Thread.sleep(5000);
        //STEP 3. Maximize Chrome Browser Page
        driver.manage().window().maximize();

        //Test 2.

        //STEP 4. Click on the Account Button
        driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/label")).click();
        String expectedPageUrl = "https://www.jumia.com.ng/";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //pass
            System.out.println("Correct Webpage");
        else
            //fail
            System.out.println("Wrong Web Page");


        Thread.sleep(5000);

        //STEP 5. Click on SignIn Button
        driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/div/div/div/a")).click();
    }

    @Test (priority = 0)
    public void getTitle() throws InterruptedException {

        String expectedPageTitle = "Jumia";
        String actualPageTitle = driver.getCurrentUrl();
        if (actualPageTitle.contains(expectedPageTitle))
            //pass
            System.out.println("Correct Title Page");
        else
            //fail
            System.out.println("Wrong Title Page");


        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void validSignIn() throws InterruptedException {
        //STEP 1. Input User Email Address in Email Address Field
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2]/label/input")).sendKeys("syncinterweb@gmail.com");
        // Click Continue Button
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();
        //STEP 2. Input User Password in Password Field
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/label/input")).sendKeys("cleanserve");
        //STEP 3. Click on Login Button
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[4]/div/button/span[3]")).click();
        //STEP 4. Click on Account Button
        driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/label")).click();
        //STEP 5. Click Logout Button
        driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/div/div/form/button")).click();

        //Test 3.
        String expectedPageUrl ="https://www.jumia.com.ng/";
        String actualPageUrl = driver.getCurrentUrl();
        if(driver.getCurrentUrl().contains("https://www.jumia.com.ng/"))
            //pass
            System.out.println("Correct User Account Page");
        else
            //fail
            System.out.println("Wrong User Account Page");
        //Wait Mode
        Thread.sleep(8000);
    }



    @Test (priority = 2)
    public void incorrectEmail() throws InterruptedException {
        //STEP 1. Reload Homepage www.jumia.com.ng
        driver.get("https://jumia.com.ng");
        //STEP 2. Click on the Account Button
        driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/label")).click();
        //STEP 3. Duration to wait before next action
        Thread.sleep(5000);
        //STEP 5. Click on SignIn Button
        driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/div/div/div/a")).click();
        //STEP 6. Input User Email Address in Email Address Field
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2]/label/input")).sendKeys("haykay@gmail.com");
        //STEP 7.Click Continue Button
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();
        //STEP 6. Input User Password in Password Field
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/label/input")).sendKeys("cleanserve");
        //STEP 7. Click on Login Button
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[4]/div/button/span[3]")).click();

        //Test 4

        String expectedPageUrl = "https://www.jumia.com.ng/";
        String actualPageUrl = driver.getCurrentUrl();
        if (driver.getCurrentUrl().contains("https://www.jumia.com.ng/"))
            //pass
            System.out.println("Correct User Account Page");
        else
            //fail
            System.out.println("Wrong User Account Page");

        //Duration to wait before next action
        Thread.sleep(8000);

    }

    @Test (priority = 3)
    public void incorrectPassword() throws InterruptedException {
        //STEP 1. Reload Homepage www.jumia.com.ng
        driver.get("https://jumia.com.ng");
        //STEP 2. Click on the Account Button
        driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/label")).click();
        //Duration to wait before next action
        Thread.sleep(5000);
        //STEP 3. Click on SignIn Button
        driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/div/div/div/a")).click();
        //STEP 4. Input User Email Address in Email Address Field
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2]/label/input")).sendKeys("syncinterweb@gmail.com");
        // Click Continue Button
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();
        //STEP 5. Input User Password in Password Field
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/label/input")).sendKeys("cleanser");
        //STEP 6. Click on Login Button
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[4]/div/button/span[3]")).click();

        //Test 5

        String expectedPageUrl = "https://www.jumia.com.ng/";
        String actualPageUrl = driver.getCurrentUrl();
        if (driver.getCurrentUrl().contains("https://www.jumia.com.ng/"))
            //pass
            System.out.println("Correct User Account Page");
        else
            //fail
            System.out.println("Wrong User Account Page");

        //Duration to wait before next action
        Thread.sleep(8000);

    }
        @Test (priority = 4)
        public void blankFields() throws InterruptedException {
            //STEP 1. Reload Homepage www.jumia.com.ng
            driver.get("https://jumia.com.ng");
            //STEP 2. Click on the Account Button
            driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/label")).click();
            //Duration to wait before next action
            Thread.sleep(5000);
            //STEP 3. Click on SignIn Button
            driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/div/div/div/a")).click();
            //STEP 4. Input User Email Address in Email Address Field
            driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2]/label/input")).sendKeys("");
            //STEP 5. Click Continue Button
            driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();

            //Test 6

            String expectedPageUrl ="https://www.jumia.com.ng/";
            String actualPageUrl = driver.getCurrentUrl();
            if(driver.getCurrentUrl().contains("https://www.jumia.com.ng/"))
                //pass
                System.out.println("Email Field cannot be blank");
            else
                //fail
                System.out.println("Input Password");

            //Wait Mode
            Thread.sleep(8000);
    }



    @Test (priority = 4)
    public void confirmSignIn() throws InterruptedException {
        //STEP 1. Input User Email Address in Email Address Field
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2]/label/input")).sendKeys("syncinterweb@gmail.com");
        //STEP 2 Click Continue Button
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();
        //STEP 3. Input User Password in Password Field
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/label/input")).sendKeys("cleanserve");
        //STEP 4. Click on Login Button
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[4]/div/button/span[3]")).click();
        //STEP 5. Click on Account Button
        driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/label")).click();

        //STEP 6. Click Logout Button
        driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/div/div/form/button")).click();

        //Test 7
        String expectedPageUrl ="https://www.jumia.com.ng/";
        String actualPageUrl = driver.getCurrentUrl();
        if(driver.getCurrentUrl().contains("https://www.jumia.com.ng/"))
            //pass
            System.out.println("Correct User Account Page");
        else
            //fail
            System.out.println("Wrong User Account Page");
        //Wait Mode
        Thread.sleep(8000);
    }




    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
    //Locate where my chromedriver is

}
