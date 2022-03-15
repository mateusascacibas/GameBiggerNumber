package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class Main {
	
	public static void main(String[] args) {
		Scanner keyboard = new java.util.Scanner(System.in);
		//Number Rounds
		int game = 12;
		int index;
		int oponentIndex;
		
		//Score
		int yourScore = 0, oponentScore = 0;
		
		//IsValid?
		boolean valid = false;
		
		//Choices
		int choice, choiceOponent;
		
		//ArraysList
		List<Integer> you = new ArrayList<>() {{
			add(1);
			add(2);
			add(3);
			add(4);
			add(5);
			add(6);
			add(7);
			add(8);
			add(9);
			add(10);
			add(11);
			add(11);
		}
		};
		
		List<Integer> oponent = new ArrayList<>() {{
			add(1);
			add(2);
			add(3);
			add(4);
			add(5);
			add(6);
			add(7);
			add(8);
			add(9);
			add(10);
			add(11);
			add(11);
		}
		};
		
		while(game > 0 || yourScore != 5 || oponentScore != 5) {
			
			System.out.println("Your cards: " + you);
			System.out.println("Choose your number to play: ");
			choice = keyboard.nextInt();
			System.out.println("-----------------------------");
			if(!you.contains(choice)) {
				while(!valid) {
					System.out.println("Enter valid number, please: ");
					choice = keyboard.nextInt();
					if(you.contains(choice)) {
						valid = true;
					}
				}
			}
			
			index = you.indexOf(choice);
			you.remove(index);
			
			Main m = new Main();
			choiceOponent = m.getRandomElement(oponent);
			oponentIndex = oponent.indexOf(choiceOponent);
			oponent.remove(oponentIndex);
			if(choice > choiceOponent) {
				yourScore += 1;
				System.out.println("Your number is bigger. More 1 point for you.");
			}else if(choiceOponent > choice) {
				
				oponentScore += 1;
				System.out.println("Your oponent number is bigger. More 1 point for your oponent.");
			}else {
				System.out.println("You choose the same number. Point for no one.");
			}
			System.out.println("\n-----------------------------");
			System.out.println("------- Current Round -------\nYou: " + choice + "\nOponent: " + choiceOponent);
			System.out.println("-----------------------------");
			System.out.println("------- SCORE -------\nYou: " + yourScore + "\nOponent: " + oponentScore);
			System.out.println("-----------------------------");
			if(yourScore == 5) {
				System.out.println("CONGRATULATIONS !!! You are the CHAMPION player.");
				return;
			}else if(oponentScore == 5) {
				System.out.println("Sorry, Your oponent is the CHAMPION player.");
				return;
			}
		}

	}
	

	  public int getRandomElement(List<Integer> list)
	    {
	        Random rand = new Random();
	        return list.get(rand.nextInt(list.size()));
	    }

}
