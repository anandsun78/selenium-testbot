package automation;

import model.CommentLink;
import model.LoginPair;
import operations.FileOperations;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class LeetCode implements Automation {
    @Override
    public void automate() throws IOException, InterruptedException {
        FileOperations operations = new FileOperations();

        List<LoginPair> accounts = operations.retrieveAccounts("/Users/anand/Desktop/leetcode_accounts/accounts.txt");
        List<CommentLink> comments = operations.retrieveComments("/Users/anand/Desktop/leetcode_accounts/comments.txt");

        for (CommentLink c : comments) {
            for (LoginPair p : accounts) {

                WebDriver driver = new SafariDriver();
                driver.get("https://leetcode.com/accounts/login/");

                String title = driver.getTitle(); // => "Google"

                System.out.println(title);


                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(10))
                        .pollingEvery(Duration.ofSeconds(3))
                        .ignoring(NoSuchElementException.class);

                WebElement login = wait.until(driver1 -> driver1.findElement(By.name("login")));
                WebElement password = driver.findElement(By.name("password"));


                login.sendKeys(p.getUsername());
                password.sendKeys(p.getPassword());
                password.sendKeys(Keys.RETURN);

                WebElement loggedIn = wait.until(driver1 -> driver1.findElement(By.cssSelector("#home-app > div > div > div.col-md-8.storyboard > div:nth-child(1) > div > div.media-body > h5")));

                String title2 = driver.getTitle(); // => "Google"

                System.out.println(title2);

                driver.get(c.getCommentURL());
                WebElement upvote = wait.until(driver1 -> driver1.findElement(
                        By.cssSelector("[title*='Upvote']")));
                Thread.sleep(1000);
                upvote.click();
                Thread.sleep(1000);
                upvote = wait.until(driver1 -> driver1.findElement(
                        By.cssSelector("[title*='Upvote']")));
                driver.close();
            }
        }
    }
}
