package MainPackage;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class shortGame {
	
	/*
	 * Pseudo Code
	 * Use Scanner to ask data from User
	 * 		Background cover:
	 * User stranded in a mysterious Jungle full of vicious MONSTERS
	 * The User is Weak and must power-up during his adventurous journey across the Jungle. 
	 *  	Game Begin:
	 *  1)Ask user for his Warrior Name
	 *  User wakes up, only to notice two paths, two giant gates. 
	 *  2 ) User choose one path: based on RANDOM number from (1,5) java decides
	 *  which path shall be dangerous and will shall be not.
	 *  3)a- IF User walks through DANGEROUS gate: Use one INHABITANT to do an ATTACK ON User
	 *  3)b- IF User walks through SAFE gate: Place A REWARD to be picked up. User can ACCEPT or DENY the REWARD
	 */ 
	
	//About User
	private String Name;
	private int Age;
	private String Gender;
	private Scanner userInput;
	private ArrayList<Object> myList;
	private ArrayList<String> powerList = new ArrayList<String>();
	private String validate;

	shortGame(String UserName, int UserAge, String UserGender){
		this.Name = UserName;
		this.Age = UserAge;
		this.Gender = UserGender;
		
	}
	
	

	public shortGame() {
		// TODO Auto-generated constructor stub
	}



	public String getName() {
		return Name;
	}

	public int getAge() {
		return Age;
	}
	
	public String getGender() {
		return Gender;
	}
	
	
	/**
	 * @return the myList
	 */
	public ArrayList<Object> getMyList() {
		return myList;
	}



	/**
	 * @param myList the myList to set
	 */
	public void setMyList(ArrayList<Object> myList) {
		this.myList = myList;
	}



	/**
	 * @return the validate
	 */
	public String getValidate() {
		return validate;
	}



	/**
	 * @param validate the validate to set
	 */
	public void setValidate(String validate) {
		this.validate = validate;
	}



	//Return user Information [Name, Age, Gender]
	public Object gettingStarted() {
		
		userInput = new Scanner(System.in);
		ArrayList<Object> myList = new ArrayList<Object>();
		
		System.out.println("Enter a Warrior Name: ");
		Name = userInput.nextLine();
		myList.add(Name);
		
		String str1 = ("What is your Age?");
		System.out.println(str1);
		
		Age = userInput.nextInt();
		myList.add(Age);
		
		String str2 = ("Now Tell me About your Gender?");
		System.out.println(str2);
		
		Gender = userInput.next();
		myList.add(Gender);
		
		System.out.println("Welcome to the Game " + myList.get(0) + ":");
		System.out.println();
		
		return (myList);
	}
	
	public String firstChoice() {
		
		String str3 = "A safe path";
		String str4 = "A dangerous path";
		String pathChoice;
		
		int userNumber;
		int randNumber;
		Random rand = new Random();
		randNumber = rand.nextInt(1) + 1;
		
		System.out.println("Random number is: " + randNumber);
		
		System.out.println("Type one number: 0 or 1");
		userNumber = userInput.nextInt();
		
		if (userNumber == randNumber) {
			
			System.out.println("Same number as random Number:");
			pathChoice = str3;
		}
		else {
			
			System.out.println("different number as random Number:");
			pathChoice = str4;
		}
		
		int caseNumbers = userNumber;
		switch (caseNumbers) {
		
		case 0: setValidate("Gate1");
			System.out.println("You chose Gate1: " + pathChoice);
			break;

		case 1: setValidate("Gate2");
			System.out.println("You chose Gate2: " + pathChoice);
			break;
		
		default: setValidate("invalid number");
			System.out.println("Try again with a number");
			break;
		}
		
		if (pathChoice == str4) {
			
			wolfAttack();
			
		}
		
		else {
			
			System.out.println("No monster in sight, Let's move on!");
		}
		
		return "";
		
	}
	
	public void wolfAttack() {
		
		System.out.println("A WOLF has appeared!");
		System.out.println("Prepare to defend against the monster!");
		
		int userHealth = 50;
		int altuserHealth = userHealth;
		System.out.println("userHealth: " + userHealth);
		int userDefend;
		double monsterHealth = 102;
		System.out.println("monsterHealth: " + monsterHealth);
	
		String power1 = "Full-Health-Regenerate|perBattle";
		
		powerList.add(power1);

		
		while (monsterHealth >= 0) {
			
			int randomNumber;
			Random rand = new Random();
			randomNumber = rand.nextInt(6)+1;
			System.out.println("randomNumber is: " + randomNumber);
			System.out.println("Monster attacks!" + '\n' +
								"Type number from 0 - 7");
			
			userDefend = userInput.nextInt();
			
			if (userDefend == randomNumber) {
				
				switch (userDefend) {
				
				case 0: monsterHealth = monsterHealth - 102;
						System.out.println("You have slayed the monster. Great Job!");
						break;
				
				case 1: monsterHealth = monsterHealth - 51;
						System.out.println("The monster health is half, keep attacking!");
						break;
				
				case 2: monsterHealth = monsterHealth - 25.5;
						System.out.println("The monster is nearly slain, keep attacking!");
						break;
				
				case 3: monsterHealth = monsterHealth - 12.75;
						System.out.println("The monster is almost finished!");
						break;
				
				case 4: monsterHealth = monsterHealth - 6.375;
						System.out.println("The monster has taken damage, keep attacking!");
						break;
						
				case 5: monsterHealth = monsterHealth - 3.1875;
						System.out.println("The monster has taken little more damage!");
						break;
						
				case 6: monsterHealth = monsterHealth - 1.59375;
						System.out.println("The monster has taken little damage!");
						break;
						
				case 7: monsterHealth = 0;
						System.out.println("The monster did not take any damage!");
						break;
				}
				
			}
			
			else {

				altuserHealth = altuserHealth - 10; 
				
				String str5 = "y";
				String validate;
				System.out.println("You are wounded" + '\n' +
								"You may use a power: (y/n)");
				
				validate = userInput.next();
				
				if (validate == str5) {
					
					altuserHealth = userHealth;
					
					System.out.println("You chose to use health-Regeneration for this battle!" + '\n' +
									"Regeneration Complete!");
					powerList.remove(power1);
				}
				
				else {
					
					System.out.println("Health power denied." + '\n' +
									"Saved for next Round!");
				}
				
				
				
			}
			
			System.out.println(Name + " : " + "Health: " + altuserHealth + "------------------------" + powerList);
			System.out.println("Wolf: " + monsterHealth);
			
		}
		
		if (monsterHealth <= 0) {
			
			System.out.println("You WON against a high level WOLF!" + '\n' +
							"Let's keep moving!");
		}
		
	}
	
	public static void main(String[] args) {
		
		shortGame tester = new shortGame();
		
		System.out.println(tester.gettingStarted());
		
		tester.firstChoice();
		
	}

	
	
}