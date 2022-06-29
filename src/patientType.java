package src;
import java.util.*;


//  multilevel inheritance

class patientType {
    String patientName ;
    int PatientAge ; 
    boolean emergencyConditon = false;
    //  default constructor
    patientType(){
        //  doing nothing...
    }


    //  parametrized constructor

    patientType(String name , int age){
        this.patientName=name;
        this.PatientAge=age;
    }


    //   constructor  overloading
    patientType(String name , int age, boolean condition){
        this.patientName=name;
        this.PatientAge=age;
        this.emergencyConditon=true;
    }

    double applicationNum(){
        return Math.random()*100+1;
    }
    

    void bye(){
        System.out.println("\nThanks for choosing us.. logging out...");
    }


}

class NormalPatient extends patientType {
    void greet(String name){
        System.out.println("\nwelcome to Normal Booking page..\n");
        System.out.println("Hello" + name + "we are happy to assist you");
        
    }

    void appNum(){
        System.out.println("Your normal booking num is : "+ "N"+(int)this.applicationNum());
    }
}

class EmergencyPatient extends NormalPatient {
    @Override
    
    void greet(String name){
        System.out.println("\n welcome to Emergency Booking Page\n");
        System.out.println("Hello" + name + "we are happy to assist you");
    }

    void appNum(){
        System.out.println("\nYou will have to pay 1000 ruppees extra for emergency Booking\n");
        System.out.println("Your Emergency  booking num is : "+ "E"+(int)this.applicationNum());

    }


    //  method returning an object..
    
    patientType m1(patientType p1){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter patient name : ");
        String name = sc.next();
        System.out.println("Enter patient age : ");
        int age = sc.nextInt();
        p1.patientName=name;
        p1.PatientAge=age;
        return p1;
    }
}
