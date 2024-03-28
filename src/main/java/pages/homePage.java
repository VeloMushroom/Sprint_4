package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class homePage {
    private WebDriver driver;

    public homePage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка Самокат
    private By scooterButton = By.xpath(".//a[@class='Header_LogoScooter__3lsAR']");

    //Кнопка Яндекс
    private By yandexButton = By.xpath(".//a[@class='Header_LogoYandex__3TSOI']");

    //Кнопка заказать вверху страницы
    private By orderUpButton = By.xpath(".//button[@class='Button_Button__ra12g']");

    //Кнопка Заказать внизу страницы
    private By orderDownButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    public void clickOrderUpButton() {
        driver.findElement(orderUpButton).click();
    }

    public void clickOrderDownButton() {
        driver.findElement(orderDownButton).click();
    }

    public void clickFAQuestion(int questionNumber) {
        WebElement element = driver.findElement(By.xpath(".//div[@id='accordion__heading-" + questionNumber + "']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public String FAQAnswer(int answerNumber) {
        By answer = By.xpath(".//div[@id='accordion__panel-" + answerNumber + "']");
        new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(driver.findElement(answer)));
        return driver.findElement(answer).getText();
    }

    public String clickScooterButton() {
        driver.findElement(scooterButton).click();
        return driver.getCurrentUrl();
    }

    public String clickYandexButton() {
        driver.findElement(yandexButton).click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return driver.getCurrentUrl();
    }
}