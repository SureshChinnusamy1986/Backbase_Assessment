package com.backbase.assessment.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class SeleniumDef {
    public static WebDriver driver;

    public SeleniumDef() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
    }



    public static WebDriver getDriver() {
        return driver;
    }



    public static void loadPage(String url) {
        sleep();
        getDriver().get(url);
    }

    public static String getPageTitle() {
        return getDriver().getTitle();
    }

    public static WebElement getElementByXpath(String xPath) {
        return getDriver().findElement(By.xpath(xPath));
    }

    public static WebElement getElementById(String id) {
        return getDriver().findElement(By.id(id));
    }

    public static WebElement getElementByClassName(String className) {
        return getDriver().findElement(By.className(className));
    }

    public static <className> Boolean table(String xPath, String computerName) {
        boolean computerIsFound = false;
        int tableIsPresent = driver.findElements(By.xpath(xPath)).size();
        if (tableIsPresent > 0) {
            //To locate table.
            WebElement mytable = getElementByXpath(xPath);
            //To locate rows of table.
            List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
            //To calculate no of rows In table.
            int rows_count = rows_table.size();
            //Loop will execute till the last row of table.
            for (int row = 0; row < rows_count; row++) {
                //To locate columns(cells) of that specific row.
                List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
                //To calculate no of columns (cells). In that specific row.
                int columns_count = Columns_row.size();
                //Loop will execute till the last cell of that specific row.
                for (int column = 0; column < columns_count; column++) {
                    // To retrieve text from that specific cell.
                    String celtext = Columns_row.get(column).getText();
                    if (celtext.equals(computerName)) {
                        computerIsFound = true;
                        break;
                    }

                }

                if (computerIsFound) {
                    break;
                }

            }


        }
        return computerIsFound;
    }


    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
