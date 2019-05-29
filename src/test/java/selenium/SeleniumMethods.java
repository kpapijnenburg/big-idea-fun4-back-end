package selenium;

import fitnessapp.config.SeleniumConfig;
import org.openqa.selenium.By;

public class SeleniumMethods {
    private SeleniumConfig config;
    private String url = "http://localhost:8080";

    public SeleniumMethods() {
        this.config = config = new SeleniumConfig();
        config.getDriver().get(url);
    }

    public void closeWindow(){
        this.config.getDriver().close();
    }

    public boolean isLoginHeaderAvailable(){
        return this.config.getDriver()
                .findElement(By.cssSelector("#app > div > main > div > div > div > div > form > h1"))
                .isDisplayed();
    }

}
