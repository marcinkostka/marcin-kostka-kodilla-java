package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_FIRSTNAME = "//div[@class=\"_1ixn\"]/div/div/div/div/input";
    public static final String XPATH_LASTNAME = "//div[@class=\"_1ixn\"]/div/div[2]/div/div/input";
    public static final String XPATH_EMAIL = "//div[@class=\"mbm _a4y\"]/div/div/input";
    public static final String XPATH_EMAIL_CONFIRM = "//div[@class=\"large_form\"]/div[3]/div/div/div/input";

    public static final String XPATH_PASSWORD = "//div[@class=\"large_form\"]/div[5]/div/div/input";
    public static final String XPATH_FEMALE = "//div[@class=\"mtm _5wa2 _5dbb\"]/span/span/input";
    public static final String XPATH_MALE = "//div[@class=\"mtm _5wa2 _5dbb\"]/span/span[2]/input";

    private static final String XPATH_DAY_SELECT = "//div[@class=\"_5k_5\"]//select[1]";
    private static final String XPATH_MONTH_SELECT = "//div[@class=\"_5k_5\"]//select[2]";
    private static final String XPATH_YEAR_SELECT = "//div[@class=\"_5k_5\"]//select[3]";

    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com");

        WebElement selectCombo = driver.findElement(By.xpath(XPATH_FIRSTNAME));
        selectCombo.sendKeys("FirstName");

        selectCombo = driver.findElement(By.xpath(XPATH_LASTNAME));
        selectCombo.sendKeys("LastName");

        selectCombo = driver.findElement(By.xpath(XPATH_EMAIL));
        selectCombo.sendKeys("email@email.eml");

        selectCombo = driver.findElement(By.xpath(XPATH_EMAIL_CONFIRM));
        selectCombo.sendKeys("email@email.eml");

        selectCombo = driver.findElement(By.xpath(XPATH_DAY_SELECT));
        Select daySelect = new Select(selectCombo);
        daySelect.selectByIndex(5);

        selectCombo = driver.findElement(By.xpath(XPATH_MONTH_SELECT));
        Select monthSelect = new Select(selectCombo);
        monthSelect.selectByIndex(12);

        selectCombo = driver.findElement(By.xpath(XPATH_YEAR_SELECT));
        Select yearSelect = new Select(selectCombo);
        yearSelect.selectByIndex(9);

        selectCombo = driver.findElement(By.xpath(XPATH_PASSWORD));
        selectCombo.sendKeys("password");

        selectCombo = driver.findElement(By.xpath(XPATH_MALE));
        selectCombo.click();
    }
}
