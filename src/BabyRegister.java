import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import info.Baby;
import info.Gift;

public class BabyRegister {
	static private ArrayList<Gift> gifts = new ArrayList<Gift>(); 
	static private ArrayList<Baby> babies = new ArrayList<Baby>();
	static Scanner scan = new Scanner(System.in);
	static SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	public static void main(String args[]) {
		init();
		int userInput;
		
		do {
			System.out.println("\nEnter\n'1' to add babies\n'2' to list babies by age\n'3' to list babies by name\n'4' to add gifts\n'5' to list gifts\n'0' to exit");
			
			switch(userInput = scan.nextInt()){
				case 1:
					addBabies();
					break;				
				case 2:
					listBabiesByAge();
					break;
				case 3:
					listBabiesByName();
					break;
				case 4:
					addGifts();
					break;				
				case 5:
					listGifts();
					break;
			}
		} while(userInput != 0);
		
		scan.close();
	}
	
	private static void addBabies() {
		System.out.println("What is the baby's name? ");
		String name = scan.next();
		
		System.out.println("When was the baby born (dd/mm/yyyy hh:mm)? ");
		Date birthday = new Date();
		boolean invalid = true;
		do {
			try {
				String date = scan.next();
				String time = scan.next();
				birthday = myFormat.parse(date + " " + time);
				invalid = false;
			} catch(ParseException e){
				System.out.println("You entered an invalid date, please try again: ");
			}		
		} while(invalid);
		
		System.out.println("What is the baby's gender (f/m)? ");
		char gender = scan.next().charAt(0);
		while(gender != 'f' && gender != 'm') {
			System.out.println("You entered an invalid gender, please try again: ");
			gender = scan.next().charAt(0);
		}

		babies.add(new Baby(birthday, name, gender));
		System.out.println("Added!");
	}

	private static void addGifts() {
		System.out.println("What is the donor's name? ");
		String donorName = scan.next();
		
		System.out.println("What is the donated gift? ");
		String giftName = scan.next();
		
		System.out.println("When was the gift donated (dd/mm/yyyy hh:mm)? ");
		Date donationDate = new Date();
		boolean invalid = true;
		do {
			try {
				String date = scan.next();
				String time = scan.next();
				donationDate = myFormat.parse(date + " " + time);
				invalid = false;
			} catch(ParseException e){
				System.out.println("You entered an invalid date, please try again. ");
			}		
		} while(invalid);

		gifts.add(new Gift(donorName, giftName, donationDate));
		System.out.println("Added!");
	}
	
	private static void listBabiesByName() {
		for(int i=0; i<babies.size()-1; i++){
			for(int j=i+1; j<babies.size(); j++){
				Baby b1 = babies.get(i);
				Baby b2 = babies.get(j);
				if(b1.getName().compareToIgnoreCase(b2.getName())>0){
					babies.set(i,b2);
					babies.set(j,b1);
				}
				
			}
		}
		for(Baby baby: babies){
			System.out.println(baby.getName());
		}
	}
	
	private static void listBabiesByAge() {
		for(int i=0; i<babies.size()-1; i++){
			for(int j=i+1; j<babies.size(); j++){
				Baby b1 = babies.get(i);
				Baby b2 = babies.get(j);
				if(b2.isOlder(b1)){
					babies.set(i,b2);
					babies.set(j,b1);
				}
			}
		}
		for(Baby baby: babies){
			System.out.println(baby.howOld());
		}
	}
	
	private static void listGifts() {
		for(Gift gift: gifts){
			System.out.println(gift);
		}
	}
	
	private static void init() {
		Baby[] babiesArray = {new Baby("01/02/2017 00:00", "Najib", 'm'), new Baby("11/01/2017 11:11", "Sujeong", 'f'), new Baby("11/04/2017 22:22", "Sanaa", 'f')};
		babies.addAll(Arrays.asList(babiesArray));
		
		Gift[] giftsArray = {new Gift("Batman", "Bat", "01/02/2017 00:00"), new Gift("Superman", "Cape", "11/01/2017 11:11"),  new Gift("Mark", "Facebook", "11/04/2017 22:22")};
		gifts.addAll(Arrays.asList(giftsArray));
	
	}
}