import automation.Automation;
import automation.AutomationFactory;
import java.io.IOException;
import java.util.Scanner;

public class Main {



    public static void main(String args[]) throws IOException, InterruptedException {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Youtube or comment?");
        String input = myObj.nextLine();

        AutomationFactory automationFactory = new AutomationFactory();
        Automation automation = automationFactory.getAutomationType(input);
        automation.automate();
    }
}

