package automation;

import model.YoutubeLink;
import operations.FileOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.util.List;

public class Youtube implements Automation{
    @Override
    public void automate() throws IOException, InterruptedException {
        FileOperations operations = new FileOperations();
        List<YoutubeLink> youtubeLinks = operations.retrieveVideos("/Users/anand/Desktop/leetcode_accounts/youtube_vids.txt");
        WebDriver driver = new SafariDriver();
        for(int i =0; i<10;i++) {
            System.out.println("View #" + i);
            for (YoutubeLink vid : youtubeLinks) {
                driver.get(vid.getVideoURL());
                Thread.sleep(18000);
                if(i%3==0){
                    driver.close();
                    Thread.sleep(3000);
                    driver = new SafariDriver();
                }
            }
        }
        driver.close();
    }
}
