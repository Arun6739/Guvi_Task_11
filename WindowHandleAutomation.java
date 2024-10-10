package com.WDB2.Selenium.Task_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.util.Set;

public class WindowHandleAutomation {
    public static void main(String[] args) {
     
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://the-internet.herokuapp.com/windows");
            Thread.sleep(2000);

            WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
            clickHereButton.click();

            String originalWindow = driver.getWindowHandle();
            Set<String> allWindows = driver.getWindowHandles();

            for (String windowHandle : allWindows) {
                if (!windowHandle.equals(originalWindow)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
            

            WebElement newWindowText = driver.findElement(By.tagName("h3"));
            if (newWindowText.getText().equals("New Window")) {
                System.out.println("New Window text verified successfully.");
            } else {
                System.out.println("Failed to verify New Window text.");
            }

            Thread.sleep(2000);
            driver.close();

            driver.switchTo().window(originalWindow);
            if (driver.getTitle().equals("The Internet")) {
                System.out.println("Switched back to the original window successfully.");
            } else {
                System.out.println("Failed to switch back to the original window.");
            }

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
