package cameraRental;
import java.util.ArrayList;
import java.util.Scanner;

public class mainmenu {
	Scanner sc = new Scanner(System.in);
	ArrayList<UserDetails> userArray = new ArrayList<>();
	ArrayList<CameraDetails> cameraArray = new ArrayList<>();
	float wallet;

	public void menu(){
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
				menu();
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
