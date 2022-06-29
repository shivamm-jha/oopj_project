package src;

class interfaceClass implements demoInterface{
    public void welcome(){
        System.out.println("---------------------------------------------------------------------");
		System.out.println("\t\t | Welcome to Doctor AppointmentBooking |");
		System.out.println("----------------------------------------------------------------------\n\n");
    }
    public void sayHi(String user){
        System.out.println("\nHello " + user + " choose the desired option..\n");
    }
}
