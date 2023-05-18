package cameraRental;

import java.util.ArrayList;
import java.util.Scanner;

public class FrontMain {
	public static void main(String[] args) {
		float wallet = 1000;
		mainmenu m = new mainmenu();
		Scanner sc = new Scanner(System.in);
		ArrayList<CameraDetails> cameraArray = new ArrayList<>();
		
						//USERS
		UserDetails user1 = new UserDetails("Tesenlo", "Tes123");
		UserDetails user2 = new UserDetails("Stephen", "Stev123");

		ArrayList<UserDetails> userArray = new ArrayList<>();
		userArray.add(user1);
		userArray.add(user2);
		
		
						//CAMERAS
		
		CameraDetails CAMERA1 = new CameraDetails("CANON", "C1234", 2000);
		CameraDetails CAMERA2 = new CameraDetails("SONY", "S123", 1500);

//		System.out.println("CAMERA ID\tBRAND\tMODEL\tPRICE(PER DAY)\tSTATUS");
//		System.out.println(CAMERA1.toString()+"\n"+CAMERA2.toString());

		
		
		cameraArray.add(CAMERA1);
		cameraArray.add(CAMERA2);
		for(CameraDetails obj2:cameraArray) {
			if(obj2.getId()==1)
				obj2.setStatus("Rented");}
//		for(CameraDetails obj3:cameraArray) {
//			System.out.println(obj3.toString());}
	
		
		
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
		
						//MENU
		
		while(true) {
			System.out.println("PLEASE CHOOSE AN OPTION -");
			System.out.println("1. MY CAMERA\n2.RENT A CAMERA\n3.VIEW ALL CAMERA\n4.MY WALLET\n5.EXIT");
			int option = sc.nextInt();
		switch(option) {
			case 1:     //INSIDE MY CAMERA
				while(true) {
				System.out.println("1.ADD\n2.REMOVE\n3.VIEW MY CAMERA\n4.GO TO PREVIOUS MENU");
				int option1 = sc.nextInt();
				
				switch(option1) {
				case 1:	//MY CAMERA - ADD CAMERA
					System.out.print("ENTER THE CAMERA BRAND - ");
					String brand = sc.next();
					System.out.print("ENTER THE MODEL - ");
					String model = sc.next();
					System.out.print("ENTER THE PER  DAY PRICE (INR) - ");
					float perDayRentalAmount = sc.nextFloat();
					CameraDetails addCAMERA = new CameraDetails(brand, model, perDayRentalAmount);
					//cd.CameraDetails(brand, model, perDayRentalAmount);
					cameraArray.add(addCAMERA);
					System.out.println("YOUR CAMERA HAS BEEN SUCCESSFULLY ADDED TO THE LIST");
					//flag=1;
					break;
					
				case 2: //MY CAMERA - REMOVE CAMERA
					System.out.println("============================================================");
					System.out.println("CAMERA ID\tBRAND\tMODEL\tPRICE(PER DAY)\tSTATUS");
					System.out.println("============================================================");
					for(CameraDetails camera:cameraArray) {
						System.out.println(camera.toString());
					}
					System.out.println("============================================================");
					System.out.print("ENTER THE CAMERA ID TO REMOVE -");
					int RemoveID = sc.nextInt();
					
					CameraDetails removeObj = null;
					for(CameraDetails obj: cameraArray) {
						if(obj.getId()==RemoveID)
							removeObj = obj;
					}
					cameraArray.remove(removeObj);
					System.out.println("CAMERA SUCCESSFULLY REMOVED FROM THE LIST");
					break;
					
				case 3: //MY CAMERA - VIEW MY CAMERA
					System.out.println("============================================================");
					System.out.println("CAMERA ID\tBRAND\tMODEL\tPRICE(PER DAY)\tSTATUS");
					System.out.println("============================================================");

					for(CameraDetails camera:cameraArray) {
						if(camera.getStatus()=="Rented")
						System.out.println(camera.toString());
					}
					System.out.println("============================================================");

					break;
					
				case 4://MY CAMERA - GO TO PREVIOUS MENU
					m.menu();
					break;

				default :
					System.out.println("Invalid Choice!");
					break;		
				}}
				
			case 2: //RENT CAMERA
				System.out.println("FOLLOWING IS THE LIST OF AVAILABLE CAMERA(S)");
				System.out.println("============================================================");
				System.out.println("CAMERA ID\tBRAND\tMODEL\tPRICE(PER DAY)\tSTATUS");
				System.out.println("============================================================");
				for(CameraDetails camera:cameraArray) {
					if(camera.getStatus()=="Available")
					System.out.println(camera.toString());
				}
				System.out.println("============================================================");
				System.out.print("ENTER THE CAMERA ID YOU WANT TO RENT -");
				int RentID = sc.nextInt();
				float RentAmount = 0;
				
				for(CameraDetails camera:cameraArray) {
					if(camera.getId()==RentID) {
						camera.setStatus("Rented");
						RentAmount=camera.getperDayRentalAmount();
						if(wallet>RentAmount)
							{wallet = wallet - RentAmount;}
						else if(wallet<RentAmount) {System.out.println("INSUFFICIENT BALANCE!");}
					System.out.println("YOUR TRANSACTION FOR CAMERA - "+camera.getBrand()+" "+camera.getModel()+"WITH RENT"+camera.getperDayRentalAmount()+"HAS SUCCESSFULLY COMPLETED.");
					}
					else
						System.out.println("CAMERA DOES NOT EXISTS!");
				}	
				break;
				
			case 3:	//VIEW ALL CAMERA
				for(CameraDetails camera:cameraArray) {
					System.out.println(camera.toString());
					}
				break;
				
			case 4:	//MY WALLET
				System.out.print("YOUR CURRENT WALLET BALANCE IS - INR."+wallet);
				System.out.print("DO YOU WANT TO DEPOSIT MORE AMOUNT TO YOUR WALLET?(1.YES 2.NO) - ");
				System.out.print("ENTER THE AMOUNT (INR) - ");
				float depositAmount = sc.nextFloat();
				if(depositAmount>0) {
					wallet = wallet+depositAmount;
					System.out.println("YOUR WALLET BALANCE UPDATED SUCCESSFULL. CURRENT WALLET BALANCE - INR."+wallet);
				}else {
					System.out.println("PLEASE ENTER THE CORRECT AMOUNT.");
				}
				
				break;
			case 5: //EXIT
				System.out.println("EXITED FROM PROGRAM SUCCESSFULLY!");
				System.exit(0);
				
			default:
				System.out.println("Invalid option!");
					break;
					
		
		}
		sc.close();	
		}
	
	}
}
	

