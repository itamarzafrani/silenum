import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter your user name :");
//        String userName = scanner.nextLine();
//        System.out.println("Enter your password : ");
//        String password = scanner.nextLine();

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\97254\\Desktop\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.aac.ac.il/");
        driver.manage().window().maximize();
        List<WebElement> elements = driver.findElements(By.id("menu-%d7%9b%d7%9c%d7%9c%d7%99"));
        WebElement menu = elements.get(0);
        List<WebElement>menuItem = menu.findElements(By.tagName("li"));
        WebElement personalInfo = menuItem.get(20);
        personalInfo.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement username = driver.findElement(By.id("Ecom_User_ID"));
        username.sendKeys("itamarzaf");
        WebElement passwordEnter = driver.findElement(By.id("Ecom_Password"));
        passwordEnter.sendKeys("itamar0545");
        WebElement enterButton = driver.findElement(By.id("wp-submit"));
        enterButton.click();
        List<WebElement> moudle = driver.findElements(By.className("col-sm-6"));
//        for (int i = 0; i < moudle.size(); i++) {
//            System.out.println(i + " :" + moudle.get(i).getText());       \\check in which index the moodle system found\\
//        }
//        System.out.println("------------------------------------");
        WebElement moodle = moudle.get(6);
        moodle.click();

        try {
            Thread.sleep(3999);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> courses = driver.findElements(By.className("multiline"));
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(i + ". " + courses.get(i).getText());
        }
        System.out.println();
        System.out.println("Enter the number of the course that you want to enter:");
        int choice = scanner.nextInt();
        scanner.nextLine();
        WebElement chosenCourse = courses.get(choice);
        chosenCourse.click();

        WebElement menuLogOut = driver.findElement(By.id("action-menu-toggle-1"));
        menuLogOut.click();

        WebElement logOut = driver.findElement(By.id("actionmenuaction-6"));
        logOut.click();

        WebElement exit = driver.findElement(By.cssSelector("body > div.pageContentWrapper > div > div.portal > div:nth-child(4) > a"));
        exit.click();
    }
}


