package src;
import java.util.*;
class childThread extends Thread {
    childThread(){
        super("newThread");
        start();
    }
    
    @Override
    public void run(){
        ArrayList<String> a1= new ArrayList<>();
        a1.add("Thank you for visiting us..\n");
        a1.add("We would love to help you in future :)\n");
        a1.add("For any Enquiry or Assistance you can reach out to us on our mobile number or email\n");
        a1.add("Our support executives will directly get in touch with you\n");
        a1.add("Email : xyz@gmail.com  , contact num : 1234578");

        try{
            for(String  msg : a1){
                System.out.println(msg);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e){
            System.out.println("Exception caught in thread");
        }
    }
}
