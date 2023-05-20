package cameraRental;

import java.util.ArrayList;
import java.util.Scanner;

public class FrontMain {
	
	float wallet = 0;
	static Scanner sc = new Scanner(System.in);
	static ArrayList<CameraDetails> cameraArray = new ArrayList<>();
	
		
		
						//MENU
	private void menuMain() {	
		while(true) {
			System.out.println("\nPLEASE CHOOSE AN OPTION -");
			System.out.println("1. MY CAMERA\n2.RENT A CAMERA\n3.VIEW ALL CAMERA\n4.MY WALLET\n5.EXIT");
			int option = sc.nextInt();
		switch(option) { //MAIN SWITCH
			case 1:     //INSIDE MY CAMERA
				boolean flag = true;
			while(flag) {
				System.out.println("1.ADD\n2.REMOVE\n3.VIEW MY CAMERA\n4.GO TO PREVIOUS MENU");
				int option1 = sc.nextInt();
				
				switch(option1) {  //SUB-SWITCH
				case 1:	//MY CAMERA - ADD CAMERA
					System.out.print("ENTER THE CAMERA BRAND - ");
					String brand = sc.next();
					System.out.print("ENTER THE MODEL - ");
					String model = sc.next();
					System.out.print("ENTER THE PER  DAY PRICE (INR) - ");
					float perDayRentalAmount = sc.nextFloat();
					CameraDetails addCAMERA = new CameraDetails(brand, model, perDayRentalAmount);
					cameraArray.add(addCAMERA);
					System.out.println("YOUR CAMERA HAS BEEN SUCCESSFULLY ADDED TO THE LIST");
					break;
					
				case 2: //MY CAMERA - REMOVE CAMERA
					System.out.println("================================================================");
					System.out.println("CAMERA ID\tBRAND\tMODEL\tPRICE(PER DAY)\tSTATUS");
					System.out.println("================================================================");
					for(CameraDetails camera:cameraArray) {
						System.out.println(camera.toString());
					}
					System.out.println("================================================================");
					System.out.print("ENTER THE CAMERA ID TO REMOVE -");
					int RemoveID = sc.nextInt();
					
					int count=0;
					for(CameraDetails obj: cameraArray) {
						count++;
						if(obj.getId()==RemoveID) {
							cameraArray.remove(obj);
							System.out.println("CAMERA SUCCESSFULLY REMOVED FROM THE LIST");
							break;
						}
						else if(count>=cameraArray.size()) {
							System.out.println("INVALID CAMERA ID");
						}
						
					}
					
					
				case 3: //MY CAMERA - VIEW MY CAMERA
					System.out.println("================================================================");
					System.out.println("CAMERA ID\tBRAND\tMODEL\tPRICE(PER DAY)\tSTATUS");
					System.out.println("================================================================");

					for(CameraDetails camera:cameraArray) {
						if(camera.getStatus()=="Rented")
						System.out.println(camera.toString());
					}
					System.out.println("================================================================");

					break;
					
				case 4://MY CAMERA - GO TO PREVIOUS MENU
					flag = false;
					menuMain();				
					break;
					
					

				default :
					System.out.println("Invalid Choice!");
					break;		
				}}
				
			case 2: //RENT CAMERA
				System.out.println("FOLLOWING IS THE LIST OF AVAILABLE CAMERA(S)");
				System.out.println("================================================================");
				System.out.println("CAMERA ID\tBRAND\tMODEL\tPRICE(PER DAY)\tSTATUS");
				System.out.println("================================================================");
				for(CameraDetails camera:cameraArray) {
					if(camera.getStatus()=="Available")
					System.out.println(camera.toString());
				}
				System.out.println("================================================================");
				System.out.print("ENTER THE CAMERA ID YOU WANT TO RENT - ");
				int RentID = sc.nextInt();

				int counter=0;
				for(CameraDetails camera:cameraArray) {
					counter++;
					if(camera.getId()==RentID && camera.getStatus()=="Available") {
						if(camera.getperDayRentalAmount()>wallet) {System.out.println("INSUFFICIENT BALANCE.");break;}
						else  {
						wallet = wallet - camera.getperDayRentalAmount();
						camera.setStatus("Rented");	
						System.out.println("YOUR TRANSACTION FOR CAMERA - "+camera.getBrand()+" "+camera.getModel()+" WITH RENT "+camera.getperDayRentalAmount()+" HAS SUCCESSFULLY COMPLETED.");
						break;}
						}
					
					else if(camera.getId()==RentID && camera.getStatus()!="Available") {
						System.out.println("CAMERA NOT FOUND!");
					break;}
					
					else if(counter>=cameraArray.size()) {
						System.out.println("CAMERA NOT FOUND!");
						break;
					}					
					}		
				
			case 3:	//VIEW ALL CAMERA
				System.out.println("================================================================");
				System.out.println("CAMERA ID\tBRAND\t\tMODEL\tPRICE(PER DAY)\tSTATUS");
				System.out.println("================================================================");
				for(CameraDetails camera:cameraArray) {
					System.out.println(camera.toString());
					}
				System.out.println("================================================================");
				break;
				
			case 4:	//MY WALLET
				System.out.println("YOUR CURRENT WALLET BALANCE IS - INR."+wallet);
				System.out.print("DO YOU WANT TO DEPOSIT MORE AMOUNT TO YOUR WALLET?(1.YES 2.NO) - ");
				int depositAnswer = sc.nextInt();
				if (depositAnswer == 1) {
				System.out.print("ENTER THE AMOUNT (INR) - ");
				float depositAmount = sc.nextFloat();
				if(depositAmount>0) {
					wallet = wallet+depositAmount;
					System.out.println("YOUR WALLET BALANCE UPDATED SUCCESSFULL. CURRENT WALLET BALANCE - INR."+wallet);
				}else {
					System.out.println("PLEASE ENTER THE CORRECT AMOUNT.");
				}
				}
				else if(depositAnswer == 2) {	
					System.out.println("EXITED MY WALLET.");
				}	
				else if(depositAnswer != 1 ||depositAnswer != 2 ){
					System.out.println("PLEASE CHOOSE THE CORRECT OPTION.");
						}
				break;
			case 5: //EXIT
				System.out.println("EXITED FROM PROGRAM SUCCESSFULLY!");
				System.exit(0);
				
			default:
				System.out.println("Invalid option!");
					break;
					
		
		}
		
		}
	}
	
	
	public static void main(String[] args) {
		FrontMain app = new FrontMain();	
		
		
						//USERS
		UserDetails user1 = new UserDetails("Tesenlo", "Tes123");
		UserDetails user2 = new UserDetails("Stephen", "Stev123");

		ArrayList<UserDetails> userArray = new ArrayList<>();
		userArray.add(user1);
		userArray.add(user2);
		
		
						//CAMERAS
		
		CameraDetails CAMERA1 = new CameraDetails("Samsung", "DS123", 2000);
		CameraDetails CAMERA2 = new CameraDetails("Sony", "HD214", 1500);
		CameraDetails CAMERA3 = new CameraDetails("Nikon", "XC", 500);
		CameraDetails CAMERA4 = new CameraDetails("Canon", "J5", 1000);
		CameraDetails CAMERA5 = new CameraDetails("Fujitsu", "XPL", 2500);
		CameraDetails CAMERA6 = new CameraDetails("LG", "CT", 1100);

		
						//ADD CAMERA  TO ARRAYLIST
		cameraArray.add(CAMERA1);
		cameraArray.add(CAMERA2);
		cameraArray.add(CAMERA3);
		cameraArray.add(CAMERA4);
		cameraArray.add(CAMERA5);
		cameraArray.add(CAMERA6);
		for(CameraDetails obj2:cameraArray) {  //SETTING SOME CAMERAS AS ALREADY RENTED
			if(obj2.getId()==1)
				obj2.setStatus("Rented");}
		for(CameraDetails obj2:cameraArray) {
			if(obj2.getId()==4)
				obj2.setStatus("Rented");}
	
		
		
							//LOGIN
		System.out.println("+------------------------------------------+");
		System.out.println("|	WELCOME TO CAMERA RENTAL APP	   |");
		System.out.println("+------------------------------------------+");
		System.out.println("PLEASE LOGIN TO CONTINUE -");
		while (true) {
			System.out.print("USERNAME: ");
			String uname = sc.next();
			System.out.print("PASSWORD: ");
			String upassword = sc.next();
			
			
						//AUTHENTICATION
			
			int flag = 0;
			for(UserDetails obj: userArray) {
				if(obj.getUsername().contentEquals(uname)&&obj.getPassword().contentEquals(upassword)) {
					System.out.println("LOGIN SUCCESSFUL!\n");
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				System.out.println("INVALID USERNAME AND PASSWORD!\nRETRY\n");
			}
			else if(flag == 1) break;
			}
		
		app.menuMain(); 
		
	}
	
}
	

