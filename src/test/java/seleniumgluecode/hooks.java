package seleniumgluecode;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import runner.browser_manager.DriverManager;
import runner.browser_manager.DriverType;
import runner.browser_manager.driverManagerFactory;

public class hooks {

    private static WebDriver driver;
    private static int numberCase = 0;
    private DriverManager driverManager;

    @Before
    public void setUp() {
        numberCase++;
        System.out.println("Se esta ejecutando el escenario de prueba numero " + numberCase);
        driverManager = driverManagerFactory.getManager(DriverType.FIREFOX);
        driver = driverManager.getDriver();
        driver.manage().window().maximize();
        driver.get("https://imalittletester.com/");
    }

    @After
    public void tearDown(cucumber.api.Scenario scenario) {
        System.out.println("El escenario de prueba numero " + numberCase + ", ha finalizado.");
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        driverManager.quitDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
