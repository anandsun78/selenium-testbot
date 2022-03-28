package automation;

public class AutomationFactory {



        //use getShape method to get object of type shape
        public Automation getAutomationType(String automationType){
            if(automationType == null){
                return null;
            }
            if(automationType.equalsIgnoreCase("YOUTUBE")){
                return new Youtube();

            } else if(automationType.equalsIgnoreCase("LEETCODE")){
                return new LeetCode();

            }
            return null;

    }
}
