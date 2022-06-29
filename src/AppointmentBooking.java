package src;

import src.interfaceClass;

import java.util.*;
import java.io.*;

class AppointmentBooking {
	ArrayList<String> doctorName = new ArrayList<String>();
	ArrayList<String> doctorQualification = new ArrayList<String>();
	ArrayList<String> doctorGender = new ArrayList<String>();
	ArrayList<String> doctorPassword = new ArrayList<String>();
	ArrayList<Integer> doctorAge = new ArrayList<Integer>();
	ArrayList<Long> doctorMobileNumber = new ArrayList<Long>();
	ArrayList<String> doctorCity = new ArrayList<String>();

	ArrayList<Integer> patientAge = new ArrayList<Integer>();
	ArrayList<String> patientName = new ArrayList<String>();
	ArrayList<String> patientGender = new ArrayList<String>();
	ArrayList<String> patientPassword = new ArrayList<String>();
	ArrayList<String> patientConfirmPassword = new ArrayList<String>();
	ArrayList<Long> patientMobileNumber = new ArrayList<Long>();

	ArrayList<Integer> patientAgeBooking = new ArrayList<Integer>();
	ArrayList<String> patientNameBooking = new ArrayList<String>();
	ArrayList<String> patientGenderBooking = new ArrayList<String>();
	ArrayList<Integer> doctorID = new ArrayList<Integer>();

	// method for creating Default doctor list present in the database.
	void dataAdd() {

		doctorName.add("Shivam");
		doctorName.add("Akshay");
		doctorName.add("raj");
		doctorName.add("Ankit");

		doctorQualification.add("MBBS");
		doctorQualification.add("MBBS");
		doctorQualification.add("MBBS cardio specialist, MD");
		doctorQualification.add("MBBS,MD");

		doctorGender.add("M");
		doctorGender.add("M");
		doctorGender.add("M");
		doctorGender.add("M");

		doctorPassword.add("shivam123");
		doctorPassword.add("Akshay123");
		doctorPassword.add("raj123");
		doctorPassword.add("ankit123");

		doctorAge.add(25);
		doctorAge.add(24);
		doctorAge.add(29);
		doctorAge.add(29);

		doctorMobileNumber.add(9117l);
		doctorMobileNumber.add(123l);
		doctorMobileNumber.add(123l);
		doctorMobileNumber.add(123l);

		doctorCity.add("dhanbad");
		doctorCity.add("Ranchi");
		doctorCity.add("Nagpur");
		doctorCity.add("Nagpur");

	}

	void admin() throws Exception {
		Scanner sc = new Scanner(System.in);
		byte choice;
		boolean flag = true;

		System.out.println("Enter admin password : ");
		String val = sc.next();
		if (val.equals("123")) {
			while (flag) {

				System.out.println("\t\t  _________________________");
				System.out.println("\t\t |                         |");
				System.out.println("\t\t |       Welcome Admin     |");
				System.out.println("\t\t |_________________________|");
				System.out.print(
						"\n\n1. Doctor list \t2. Registered Patients \t3.Pateints with Appointment  \n\nEnter Your Choice.");
				choice = sc.nextByte();
				switch (choice) {
					case 1:
						for (int i = 0; i <= doctorName.size() - 1; i++) {
							System.out.println("Name: \t " + doctorName.get(i));

						}
						Thread.sleep(1000);
						flag = false;

						break;

					case 2:
						if (patientName.isEmpty()) {
							System.out.println("No Registered Patients yet.");
							Thread.sleep(1000);
							flag = false;
							break;

						} else {
							for (int i = 0; i <= patientName.size() - 1; i++) {
								System.out.println(i + ". " + patientName.get(i));
							}

							Thread.sleep(1000);
							flag = false;
						}

						break;

					case 3:
						if (patientNameBooking.isEmpty()) {
							System.out.println("\nNo Appointments yet.");
							Thread.sleep(1000);
							flag = false;
							break;
						}

						else {
							for (int i = 0; i <= patientNameBooking.size() - 1; i++) {
								System.out.println(i + 1 + ". " + patientNameBooking.get(i));
							}

							Thread.sleep(1000);
							flag = false;

						}
						break;
					default:
						System.out.println("Wrong choice");
						Thread.sleep(1000);
						flag = true;
				}

			}
		} else {
			System.out.println("Invalid credentials...loging out!!!!!!");
		}

	}

	// patient page..

	void patient() throws Exception {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {

			System.out.println("\t\t  _________________________");
			System.out.println("\t\t |                         |");
			System.out.println("\t\t | Welcome to Patient Page!|");
			System.out.println("\t\t |_________________________|");
			System.out.println(" ");
			System.out.println("1.Login \t 2.Registration\n");
			int ch = sc.nextInt();
			switch (ch) {
				case 1:
					if (patientMobileNumber.isEmpty()) {
						System.out.println("First register yourself then login..!");
						Thread.sleep(500);
						break;
					} else {
						patientLogin();
						flag = false;

					}

					break;
				case 2:
					patientRegistration();
					flag = false;
					break;

				default:
					System.out.println("\nYou entered wrong choice. enter your choice again....!!!");
					flag = true;
					Thread.sleep(1000);
					break;
			}
		}
	}

	// doctor booking system..........
	void doctor() throws Exception {

		Scanner sc = new Scanner(System.in);
		int choice = 0;

		boolean flag = true;
		while (flag) {

			System.out.println("\t\t  _________________________");
			System.out.println("\t\t |                         |");
			System.out.println("\t\t | Welcome to Doctor Page! |");
			System.out.println("\t\t |_________________________|");
			System.out.println(" ");

			System.out.println("1. Login \t 2.Registration");
			choice = sc.nextInt();

			switch (choice) {
				case 1:
					if (doctorMobileNumber.isEmpty()) {
						System.out.println("Register first...!");
						flag = false;
						Thread.sleep(500);
						break;

					} else {
						doctorLogin();
						flag = false;
					}

					break;
				case 2:
					doctorRegistration();
					flag = false;
					break;

				default:
					System.out.println("Entered Wrong choice..");
					flag = true;
			}
		}

	}

	// patient login function..

	void patientLogin() throws Exception {

		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		long mobileNumber;
		int choice;

		System.out.println("\t\t  _________________________");
		System.out.println("\t\t |                         |");
		System.out.println("\t\t |         Login 		   |");
		System.out.println("\t\t |_________________________|");

		System.out.println("Enter your Username(mobilenumber)");
		mobileNumber = sc.nextLong();

		System.out.println("Enter your Password");
		String password = sc.next();

		boolean check = false;
		int j;
		for (j = 0; j <= patientMobileNumber.size() - 1; j++) {

			if ((patientMobileNumber.get(j)).equals(mobileNumber) && (patientPassword.get(j)).equals(password)) {
				check = true;

				break;
			}

		}
		if (check == true) {
			Thread.sleep(1000);

			System.out.println("\t\t  _________________________");
			System.out.println("\t\t |                         |");
			System.out.println("\t\t |     Book Appointment    |");
			System.out.println("\t\t |_________________________|");
			System.out.println(
					"\n Welcome " + patientName.get(j).toUpperCase() + ", to book appointment, choose your doctor..");

			for (int i = 0; i <= doctorName.size() - 1; i++) {
				System.out.println((i + 1) + ". " + doctorName.get(i));
			}
			choice = sc.nextInt();
			doctorID.add(choice);

			while (check) {
				Thread.sleep(1000);

				System.out.println("\t\t  _________________________");
				System.out.println("\t\t |                         |");
				System.out.println("\t\t |     Book Appointment    |");
				System.out.println("\t\t |_________________________|");

				for (int i = 0; i <= doctorName.size() - 1; i++) {
					if (choice <= doctorName.size() && choice > 0) {
						System.out.println("\n\nName: \t " + doctorName.get(choice - 1) + "\nAge: \t "
								+ doctorAge.get(choice - 1) + "\nMobile:  " + doctorMobileNumber.get(choice - 1)
								+ "\nCity: \t " + doctorCity.get(choice - 1));
						System.out.println("\n Enter patient's name: \t");
						String name = sc.nextLine();
						patientNameBooking.add(sc.nextLine());
						System.out.println(" Enter patient's age: \t");
						patientAgeBooking.add(sc.nextInt());

						System.out.println(" Enter patient's gender: \t");
						patientGenderBooking.add(sc.next());

						System.out.println("\n Booking Successfull..");

						Thread.sleep(1000);
						check = false;
						break;
					} else {
						System.out.println("\n enter correct input..");
						flag = true;
						Thread.sleep(1000);
					}

				}
			}

		} else if (check == false) {
			System.out.println("\nInvalid credentials.. try again\n");
			patientLogin();
		}

	}

	// patient registration system....
	void patientRegistration() throws Exception {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		long mobileNumber = 1234;

		System.out.println("\n");
		System.out.println("\t\t | Welcome to Patient Registration Page!|");
		System.out.println("\n");
		System.out.println("Please enter your name");
		patientName.add(sc.nextLine());
		System.out.println("enter your age: ");
		try {
			patientAge.add(sc.nextInt());
		} catch (Exception e) {
			System.out.println("Enter valid age..\n");
			patientRegistration();
		}
		System.out.println("Please enter your Mobile number");
		try {
			mobileNumber = sc.nextLong();
		} catch (Exception e) {
			System.out.println("Enter valid phone number..");
			Thread.sleep(1000);
			patientRegistration();
		}
		long mno;

		boolean flag = true, flag1 = true;

		if (patientMobileNumber.isEmpty()) {
			patientMobileNumber.add((mobileNumber));
			System.out.println("Enter password");
			patientPassword.add(sc.next());
			System.out.println("Registration is Successfull.");

			Thread.sleep(900);
			flag1 = false;

		} else {
			for (i = 0; i <= patientMobileNumber.size() - 1; i++) {
				mno = patientMobileNumber.get(i);

				if (mno == mobileNumber) {

					flag1 = false;
					break;
				}

			}
			if (flag1 == true) {
				patientMobileNumber.add(mobileNumber);
				System.out.println("Enter password");
				patientPassword.add(sc.next());
				System.out.println("Registration is Successfull.");
				Thread.sleep(900);
			} else {
				System.out.println("same mobile numebr is not allowed\n");
				Thread.sleep(500);
			}
		}

		System.out.println("\nChoose your bookign mode :");
		System.out.println("\n1.Normal Booking  2.Emergency Booking\n");
		int op;
		op = sc.nextInt();
		switch (op) {
			case 1:
				NormalPatient n1 = new NormalPatient();
				n1.appNum();
				break;

			case 2:
				EmergencyPatient e1 = new EmergencyPatient();
				e1.appNum();
				break;
			default:
				break;
		}
		Thread.sleep(1000);
		patientType p1 = new patientType();
		p1.bye();
	}

	void doctorRegistration() throws Exception {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		long mobileNumber=-1;
		boolean flag = true, flag1 = true;

		System.out.println("\t\t ----------------------------------");
		System.out.println("\t\t| This is doctor registration Page |");
		System.out.println("\t\t ----------------------------------");
		System.out.println("\n");

		System.out.println("Please enter your name");
		doctorName.add(sc.nextLine());

		System.out.println("Please enter your Mobile number");
		try{
			mobileNumber = (sc.nextLong());
		}
		catch(Exception e){
			System.out.println("Invalid phone number type..enter again");
			Thread.sleep(1000);
			doctorRegistration();
		}

		long mno;

		if (doctorMobileNumber.isEmpty()) {
			doctorMobileNumber.add((mobileNumber));
			System.out.println("Enter password");
			doctorPassword.add(sc.next());
			System.out.println("Registration is Successfull.");
			Thread.sleep(900);
			flag1 = false;

		} else {
			for (i = 0; i <= doctorMobileNumber.size() - 1; i++) {
				mno = doctorMobileNumber.get(i);

				if (mno == mobileNumber) {

					flag1 = false;
					break;
				}

			}
			if (flag1 == true) {

				doctorMobileNumber.add(mobileNumber);
				System.out.println("Enter age:");
				doctorAge.add(sc.nextInt());
				System.out.println("Enter City: ");
				doctorCity.add(sc.next());
				System.out.println("Enter password");
				doctorPassword.add(sc.next());
				System.out.println("Registration is Successfull.");
				int key = doctorName.size() - 1;
				System.out.println("Details : ");
				System.out.println("\nName: " + doctorName.get(key) + "\n\nnumber(id):" + doctorMobileNumber.get(key)
						+ "\n\npassword : " + doctorPassword.get(key));
				Thread.sleep(900);

			} else {
				System.out.println("same mobile numebr is not allowed\n");
				System.out.println("Kindly fill the details again..\n");
				int index = doctorName.size() - 1;
				doctorName.remove(index);
				Thread.sleep(1000);
				doctorRegistration();

			}

		}
	}

	void doctorLogin() throws Exception {
		Scanner sc = new Scanner(System.in);
		Long mobileNumber;

		System.out.println("\t\t---------------------------------");
		System.out.println("\t\t| This is doctor login page     |");
		System.out.println("\t\t---------------------------------");
		System.out.println("Enter your Username(mobilenumber)");
		mobileNumber = sc.nextLong();
		System.out.println("Enter your Password");
		String password = sc.next();
		int i = 0;
		byte choice;

		boolean check = false;

		for (i = 0; i <= doctorMobileNumber.size() - 1; i++) {
			// string handling function
			if ((doctorMobileNumber.get(i)).equals(mobileNumber) && (doctorPassword.get(i)).equals(password)) {
				check = true;
				break;
			}
		}

		if (check == true) {
			while (check) {

				System.out.println("\t\t----------------------------------------");
				System.out.println("\t\t| Welcome Doctor " + doctorName.get(i) + " |");
				System.out.println("\t\t----------------------------------------");
				System.out.println("\n\nPress 1 to see your Appointments. \n");

				choice = sc.nextByte();
				byte j = 0;
				switch (choice) {
					case 1:
						if ((doctorID.isEmpty() != true)) {
							while (j <= doctorID.size() - 1) {

								if ((i + 1) == doctorID.get(j)) {
									System.out.println("patient name: " + patientNameBooking.get(j));
									j++;

								}
							}
							Thread.sleep(1000);
							check = false;

						} else {
							System.out.println("No Appointments for today :0)");
							Thread.sleep(1000);
							check = false;
						}

						break;
				}
			}

		} else {
			System.out.println("\nLogin failed.. invalid credentials..\n");
			System.out.println("Try again..\n");
			Thread.sleep(500);
			doctorLogin();

		}

	}

	// main program...

	public static void main(String[] args) throws Exception {
		AppointmentBooking ap = new AppointmentBooking();
		Scanner sc = new Scanner(System.in);
		ap.dataAdd();
		boolean flag = true;

		// implementing interface method..

		interfaceClass d1 = new interfaceClass();
		d1.welcome();
		System.out.print("Enter your name : ");
		String l1="";
		try{
			l1 = sc.nextLine();
			for(int i=0;i<l1.length();i++){
				if(l1.charAt(i)>='0' && l1.charAt(i)<='9'){
					throw new customException("Enter valid name..");
				}
			}
		}
		catch(customException e){
			System.out.println("Exception caught : "+e+"\n");
			flag=false;
		}
		

		
		while (flag == true) {
			d1.sayHi(l1);
			System.out.println("\n1. Doctor \t 2. Patient \t 3. Admin \t 4. Exit");
			int choice = sc.nextInt();
			switch (choice) {
				case 1:
					ap.doctor();
					flag = true;
					break;
				case 2:
					ap.patient();
					flag = true;
					break;
				case 3:

					ap.admin();
					flag = true;
					break;

				case 4:
					childThread c1 = new childThread();
					
					try {
						c1.join();
						System.out.println("\n\nonce again .. :) :)\n\n");
						childThread c2 = new childThread();
						c2.join();
					} catch (InterruptedException e) {
						System.out.println("child thread interuupted");
					}

					


					System.out.println("\nHave a good day(main thread exiting)..");
					System.exit(0);
				default:
					break;

			}
		}
	}
}