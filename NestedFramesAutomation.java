package com.WDB2.Selenium.Task_11;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class NestedFramesAutomation {
    public static void main(String[] args) {
 
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://the-internet.herokuapp.com/nested_frames");

            Thread.sleep(2000);

            driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));

            int framesInTopFrame = driver.findElements(By.tagName("frame")).size();
            if (framesInTopFrame == 3) {
                System.out.println("Verified that there are three frames in the top frame.");
            } else {
                System.out.println("Verification failed: expected 3 frames, found " + framesInTopFrame);
            }

            driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-left']")));

            WebElement leftText = driver.findElement(By.xpath("//body"));
            if (leftText.getText().equals("LEFT")) {
                System.out.println("Verified text 'LEFT' in the left frame.");
            } else {
                System.out.println("Verification failed for left frame: expected 'LEFT', found '" + leftText.getText() + "'");
            }

            driver.switchTo().parentFrame();

            driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));

            WebElement middleText = driver.findElement(By.cssSelector("div#content"));
            if (middleText.getText().equals("MIDDLE")) {
                System.out.println("Verified text 'MIDDLE' in the middle frame.");
            } else {
                System.out.println("Verification failed for middle frame: expected 'MIDDLE', found '" + middleText.getText() + "'");
            }

            driver.switchTo().parentFrame();

            driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-right']")));

            WebElement rightText = driver.findElement(By.xpath("//body"));
            if (rightText.getText().equals("RIGHT")) {
                System.out.println("Verified text 'RIGHT' in the right frame.");
            } else {
                System.out.println("Verification failed for right frame: expected 'RIGHT', found '" + rightText.getText() + "'");
            }

            driver.switchTo().parentFrame();

            driver.switchTo().defaultContent();  
            driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-bottom']")));

            WebElement bottomText = driver.findElement(By.xpath("//body"));
            if (bottomText.getText().equals("BOTTOM")) {
                System.out.println("Verified text 'BOTTOM' in the bottom frame.");
            } else {
                System.out.println("Verification failed for bottom frame: expected 'BOTTOM', found '" + bottomText.getText() + "'");
            }

            driver.switchTo().defaultContent();

            if (driver.getTitle().equals("Frames")) {
                System.out.println("Verified that the page title is 'Frames'.");
            } else {
                System.out.println("Verification failed for the page title: expected 'Frames', found '" + driver.getTitle() + "'");
            }
            
            String title = driver.getTitle();
            if (title != null && !title.isEmpty()) {
                System.out.println("The title is: " + title);
            } else {
                System.out.println("Hi no title found");
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}


