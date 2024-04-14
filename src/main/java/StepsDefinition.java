import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class StepsDefinition {
    //Methods methods = new Methods();
    Locators locatori;
    AppiumDriver <MobileElement>driver;

    public StepsDefinition()
    {
        locatori=new Locators();
    }


    @Given("I open calculator")
    public void openCalculator() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("deviceName", "HUAWEI MediaPad M5");
        capabilities.setCapability("udid","8FX6R19308000251");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","9.0");
        capabilities.setCapability("appPackage","com.android.calculator2");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");

        URL url =new URL("http://127.0.0.1:4723/wd/hub/");

        driver=new AppiumDriver<MobileElement>(url,capabilities);
    }

    @When("I add {int} + {int}")
    public void adunare(int key1, int key2) {

        By keyLocator1 = locatori.key(key1);
        MobileElement tasta1 = driver.findElement(keyLocator1);
        By keyLocator2 = locatori.key(key2);
        MobileElement tasta2 = driver.findElement(keyLocator2);
        MobileElement tastaPlus = driver.findElement(By.id("com.android.calculator2:id/op_add"));
        MobileElement tastaEgal = driver.findElement(By.id("com.android.calculator2:id/eq"));
        tasta1.click();
        tastaPlus.click();
        tasta2.click();
        tastaEgal.click();
    }

    @When("I expect result to be {int}")
    public void result(int expectedResult) {

        int actualResult =Integer.parseInt(driver.findElement(By.id("com.android.calculator2:id/formula")).getText());
        //System.out.println("\n Actual result is "+actualResult);
        //System.out.println("\n Expected result is "+expectedResult);
        //if (expectedResult==actualResult)
        //   System.out.println("\n Rezultatul este corect");
        // else
        //    System.out.println("\n Rezultatul este incorect");
        if (expectedResult!=(actualResult)) throw new AssertionError("Rezultatul nu este corect");
    }


    @Then("I clear screen")
    public void clear() {
        driver.findElement(By.id("com.android.calculator2:id/op_clr")).click();
    }

    @And("I multiply {int} and {int}")
    public void multiply(int key3, int key4) {
        By keyLocator1=locatori.key(key3);
        MobileElement tasta1= driver.findElement(keyLocator1);
        By keyLocator2=locatori.key(key4);
        MobileElement tasta2=driver.findElement(keyLocator2);
        MobileElement tastaPlus= driver.findElement(By.id("com.android.calculator2:id/op_mul"));
        MobileElement tastaEgal= driver.findElement(By.id("com.android.calculator2:id/eq"));
        tasta1.click();
        tastaPlus.click();
        tasta2.click();
        tastaEgal.click();
        }
}

