import java.util.Scanner;

import org.overture.codegen.runtime.Utils;
import org.overture.codegen.runtime.VDMSet;

import quotes.EnterQuote;
import quotes.LeaveQuote;

public class MyInterface {
	static MySystem system;
	public static void main(String[] args) {
		system = new MySystem();
		
		mainMenu();

	}
	
	private static void mainMenu() {
		String menu = "**********\n"
					+ "***MENU***\n"
					+ "**********\n"
					+ "\n"
					+ "1. Add Group\n"
					+ "2. Add Card\n"
					+ "3. Add Parking Lot\n"
					+ "4. Register Operation\n"
					+ "5. Get Card Operations\n"
					+ "6. Cancel Card\n"
					+ "7. Reactivate Card\n"
					+ "\nOption: ";
		
		System.out.print(menu);
		Scanner s = new Scanner(System.in);
		int option = s.nextInt();
		
		
		switch(option) {
			case 1:
				addGroup();
				break;
			case 2:
				addCard();
				break;
			case 3:
				addParking();
				break;
			case 4:
				registerOperation();
				break;
			case 5:
				getCardOps();
				break;
			case 6:
				cancelCard();
				break;
			case 7:
				reactivateCard();
				break;
		}
		
	}

	private static void addGroup() {
		String menu = "***************\n"
					+ "***ADD GROUP***\n"
					+ "***************\n"
					+ "\n"
					+ "Name: ";
		
		System.out.print(menu);
		Scanner s = new Scanner(System.in);
		String name = s.next();
		system.addGroup(name);
		
		System.out.print("Group '"+name+"' added!\nEnter 0 for back menu...");
		s.next();
		mainMenu();
		
	}

	private static void addCard() {
		String menu = "**************\n"
					+ "***ADD CARD***\n"
					+ "**************\n"
					+ "\n"
					+ "CHOOSE A GROUP FROM BELOW:\n";
		
		System.out.println(menu);
	
		for(Object group: system.groups) {
			System.out.println(((Group) group).getId()+". "+((Group) group).getName());
		}
		System.out.print("Group ID: ");
		Scanner s = new Scanner(System.in);
		int groupId = s.nextInt();
		
		
		
		System.out.print("Name: ");
		String name = s.next();
		System.out.print("Day of Expiration Date: ");
		int day = s.nextInt();
		System.out.print("Month of Expiration Date: ");
		int month = s.nextInt();
		System.out.print("Yearr of Expiration Date: ");
		int year = s.nextInt();
		
		Date date = new Date((Number) day, (Number) month, (Number) year);
		Card card = null;
		for(Object group: system.groups) {
			if( groupId == ((Group) group).getId().intValue()) {
				card = system.addCard((Group) group, name, date);
			}
				
		}
		
		boolean add = false;
		do {
			System.out.print("Add a Plate: ");
			String plate = s.next();
			card.addPlate(plate);
			System.out.print("Press 1 to add another one; else to add the card as it is: ");
			int option = s.nextInt();
			if(option == 1)
				add = true;
			else
				add = false;
			
		}
		while (add);
		
		System.out.print("Card '"+name+"' added!\nEnter 0 for back menu...");
		s.next();
		mainMenu();
		
	}

	private static void addParking() {
		String menu = "*****************\n"
					+ "***ADD PARKING***\n"
					+ "******************\n"
					+ "\n"
					+ "CHOOSE A GROUP FROM BELOW:\n";
	
		System.out.println(menu);
	
		for(Object group: system.groups) {
			System.out.println(((Group) group).getId()+". "+((Group) group).getName());
		}
		System.out.print("Group ID: ");
		Scanner s = new Scanner(System.in);
		int groupId = s.nextInt();
		
		System.out.print("Max. Lotation: ");
		int lotation = s.nextInt();
		
		System.out.println();
		
		
		for(Object group: system.groups) {
			if(groupId == ((Group) group).getId().intValue())
				system.addParking((Number) lotation,(Group) group);
		}
		
		
		System.out.print("Parking Lot with "+lotation+" lotation added!\nEnter 0 for back menu...");
		s.next();
		mainMenu();
		
	}

	private static void registerOperation() {
		String menu = "*******************\n"
					+ "***ADD OPERATION***\n"
					+ "*******************\n"
					+ "\n"
					+ "CHOOSE A CARD FROM BELOW :\n";
	
		System.out.println(menu);
		
		for(Object card: system.cards) {
			System.out.print(((Card) card).getId()+". "+((Card) card).getName()+": ");
			VDMSet plates = ((Card) card).getPlates();
			for(Object plate: plates) {
				System.out.print(plate+" | ");
			}
			System.out.print("\n");
		}
		System.out.print("Card ID: ");
		Scanner s = new Scanner(System.in);
		int cardId = s.nextInt();
		
		System.out.print("\nPlate: ");
		String plate = s.next();
		System.out.println("\nCHOOSE A PARKING LOT FROM BELOW");
		for(Object parking: system.parkings) {
			System.out.println(((ParkingLot) parking).getId()+". Park for "+((ParkingLot) parking).getGroup().getName()
										+" ("+((ParkingLot) parking).getCurrLotation()+"/"+((ParkingLot) parking).getMaxLotation()+")");
		}
		System.out.print("Park ID: ");
		int parkId = s.nextInt();
		
		System.out.print("\nDay of Operation: ");
		int day = s.nextInt();
		System.out.print("Month of Operation: ");
		int month = s.nextInt();
		System.out.print("Year of Operation: ");
		int year = s.nextInt();
		
		Date date = new Date((Number) day, (Number) month, (Number) year);
		
		System.out.print("\n0 for entering, 1 for leaving: ");
		int typeInt = s.nextInt();
		
		Object type;
		
		if(typeInt == 0)
			type = new EnterQuote();
		else
			type = new LeaveQuote();
		
		Object result = null;
		for(Object card: system.cards) {
			if(cardId == ((Card) card).getId().intValue()) {
				for(Object park: system.parkings) {
					Operation op = null;
					if(parkId == ((ParkingLot) park).getId().intValue())
						op = system.addOperation(plate,date,(Card)card,(ParkingLot)park,type);
					result = op.result;
				}
				
			}
				
		}
		
		 if (Utils.equals(result, quotes.AllowQuote.getInstance())) {
			 System.out.println("\nOperation allowed! 0 to back menu.");
		 }
		 else
			 System.out.println("\nOperation denied! 0 to back menu.");
		 
		s.next();
		mainMenu();
	}

	private static void getCardOps() {
		String menu = "*********************\n"
					+ "***LIST OPERATIONS***\n"
					+ "*********************\n"
					+ "\n"
					+ "CHOOSE A CARD FROM BELOW :\n";
	
		System.out.println(menu);
		
		for(Object card: system.cards) {
			System.out.print(((Card) card).getId()+". "+((Card) card).getName()+": ");
			VDMSet plates = ((Card) card).getPlates();
			for(Object plate: plates) {
				System.out.print(plate+" | ");
			}
			System.out.print("\n");
		}
		System.out.print("Card ID: ");
		Scanner s = new Scanner(System.in);
		int cardId = s.nextInt();
		System.out.println("---------------------");
		for(Object card: system.cards) {
			if(cardId == ((Card) card).getId().intValue()) {
				VDMSet ops = ((Card) card).getOperations();
				for(Object op: ops) {
					for(Object park: system.parkings) {
						if(((Operation)op).parking.getId() == ((ParkingLot)park).getId()) {
							System.out.println("Date: "+((Operation)op).date.day.intValue()
														+"-"+((Operation)op).date.month.intValue()
														+"-"+((Operation)op).date.day.intValue()
												+"\nParking: "+((ParkingLot)park).getId());
							
							 if (Utils.equals(((Operation)op).type, quotes.EnterQuote.getInstance()))
								 System.out.println("Type: Enter");
							 else
								 System.out.println("Type: Leave");
							 
							 if (Utils.equals(((Operation)op).result, quotes.AllowQuote.getInstance()))
								 System.out.println("Result: Allow");
							 else
								 System.out.println("Result: Deny");
							 System.out.println("---------------------");
								 
						}
						
					}
				}
			}
				
		}
		System.out.println("0 to main menu");
		s.next();
		mainMenu();
	}

	private static void cancelCard() {
		String menu = "*****************\n"
					+ "***CANCEL CARD***\n"
					+ "*****************\n"
					+ "\n"
					+ "CHOOSE A CARD FROM BELOW:\n";
		
		System.out.println(menu);
		
		for(Object card: system.cards) {
			System.out.println(((Card) card).getId()+". "+((Card) card).getName()+": ");

		}
		System.out.print("Card ID: ");
		Scanner s = new Scanner(System.in);
		int cardId = s.nextInt();
		
		for(Object card: system.cards) {
			if(((Card)card).getId().intValue() == cardId) {
				system.cancelCard((Card)card);
			}

		}
		
		System.out.println("Card cancelled! 0 to main menu.");
		s.next();
		mainMenu();
		
	}

	private static void reactivateCard() {
		String menu = "*****************\n"
					+ "***CANCEL CARD***\n"
					+ "*****************\n"
					+ "\n"
					+ "CHOOSE A CARD FROM BELOW:\n";
		
		System.out.println(menu);
		
		for(Object card: system.cards) {
			System.out.println(((Card) card).getId()+". "+((Card) card).getName()+": ");
	
		}
		System.out.print("Card ID: ");
		Scanner s = new Scanner(System.in);
		int cardId = s.nextInt();
		
		for(Object card: system.cards) {
			if(((Card)card).getId().intValue() == cardId) {
				system.reactivateCard((Card)card);
			}
	
		}
		
		System.out.println("Card reactivated! 0 to main menu.");
		s.next();
		mainMenu();
		
	}
	
	

}
