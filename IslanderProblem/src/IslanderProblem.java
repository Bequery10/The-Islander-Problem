

import java.util.Random;
import java.util.Scanner;

public class IslanderProblem {
	
	public static void main(String[] args) {
		new IslanderProblem();
	}

	Islander islander1=new Islander("islander1");
	Islander islander2=new Islander("islander2");
	Islander islander3=new Islander("islander3");
	Islander islander4=new Islander("islander4");
	Islander islander5=new Islander("islander5");
	Islander islander6=new Islander("islander6");
	Islander islander7=new Islander("islander7");
	Islander islander8=new Islander("islander8");
	Islander islander9=new Islander("islander9");
	Islander islander10=new Islander("islander10");
	Islander islander11=new Islander("islander11");
	Islander islander12=new Islander("islander12");
	
	public IslanderProblem() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("-Hi, welcome to the 12 islanders problem.\n There are 12 islanders, "
				+ "11 of them are same weight but one of them is slightly heavier or lighter.\n Luckily there is a seesaw"
				+ " in the island but you're only allowed to use it less than 4 times."
				+ "\n Your mission which you should choose to accept it, is to find the odd islander.\n Good luck!\n");
		
		for(int i=0;i<3;i++) {
			System.out.println("How many islanders would you like to put on both sides of the seesaw ?");
			int value=sc.nextInt();
			
			int leftWeight=0;
			for(int j=0;j<value;j++) {
				System.out.println("Type the index of islander "+(j+1)+" you would like to put on the left side of the seesaw");
				leftWeight+=Islander.islanders[sc.nextInt()-1].getWeight();sc.nextLine();
			}
			
			int rightWeight=0;
			for(int j=0;j<value;j++) {
				System.out.println("Type the index of islander "+(j+1)+" you would like to put on the right side of the seesaw");
				rightWeight+=Islander.islanders[sc.nextInt()-1].getWeight();sc.nextLine();
			}
			
			if(leftWeight>rightWeight) 
				System.out.println("Left side of the seesaw goes down. Left is heavier, Right is ligther");
			
			else if(leftWeight<rightWeight)
				System.out.println("Right side of the seesaw goes down. Right is heavier, Left is lighter");

			else
				System.out.println("Seesaw stays still, both sides are equal weight.");

			System.out.println("Would you like to guess it now ? If yes, press 1; else, press 2");
			int pass=sc.nextInt();sc.nextLine();
			if(pass==1)break;
			
		}
		
		System.out.println("Enter what's number of the islander that is heavier or lighter than the others");
		int answer=sc.nextInt();sc.nextLine();
		
		if(Islander.islanders[answer-1].getWeight()==3)
			System.out.println("Your guess is correct islander "+answer+" is heavier.\n Mission complete!");
	
		else if(Islander.islanders[answer-1].getWeight()==1)
			System.out.println("Your guess is correct islander "+answer+" is lighter.\n Mission complete!");
	
		else
			
			System.out.println("You're wrong.\n Mission failed!");
	
	}
}

class Islander{
	static int count;
	
	String name;
	private int weight;
	
	static Islander[]islanders=new Islander[12];
	
	public Islander(String name) {
		
		this.name=name;
		weight=2;
		islanders[count]=this;
		count++;
		
		if(count==12)
			changer();
	}

	private void changer() {
		Random random=new Random();
		
		int[]nums=new int[2];
		nums[0]=1;
		nums[1]=3;
		islanders[random.nextInt(0,12)].weight=nums[random.nextInt(0,2)];
		
	}
	
	public int getWeight() {
	
return this.weight;
				
	}
	
	
}