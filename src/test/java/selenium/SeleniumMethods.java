package selenium;

import fitnessapp.config.SeleniumConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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


    public void login() {
        WebElement email = config.getDriver().findElement(By.id("email-field"));
        WebElement password = config.getDriver().findElement(By.id("password-field"));
        email.sendKeys("harry@test.nl");
        password.sendKeys("test");

        config.getDriver().findElement(By.id("login-form-button")).click();
    }

    public boolean isLoginHeaderAvailable(){
        return this.config.getDriver()
                .findElement(By.cssSelector("#app > div > main > div > div > div > div > form > h1"))
                .isDisplayed();
    }


    public boolean logoutButtonVisible() {
        return this.config.getDriver()
                .findElement(By.id("logout-button"))
                .isDisplayed();
    }

    public boolean newWorkoutButtonAvailable(){
       return this.config.getDriver()
                .findElement(By.id("open-workout-modal"))
                .isDisplayed();
    }

    public void openNewWorkOutModal(){
        this.config.getDriver()
                .findElement(By.id("open-workout-modal"))
                .click();
    }

    public boolean isNameFieldPresent() {
        return  this.config.getDriver()
                .findElement(By.id("new-workout-modal-text-field"))
                .isDisplayed();
    }

    public void createNewExercise() {
        WebElement name = this.config.getDriver().findElement(By.id("new-workout-modal-text-field"));
        name.sendKeys("Test");

        WebElement button = this.config.getDriver().findElement(By.id("new-workout-modal-save"));
        button.click();
    }

    public boolean workoutModalPresent() {
        return this.config.getDriver()
                .findElement(By.id("open-workout-modal"))
                .isDisplayed();
    }
}
