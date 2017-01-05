package Flightpack;
import java.util.Scanner;

class Driver {

	public static void main(String[] args) throws Invalidrowseat {
		int choice=0;
		FlightinImplementation test1 = new FlightinImplementation();
		Scanner s1 = new Scanner(System.in);
		for(int i=0; i<1000000 || choice != 3;i++){
			System.out.println("enter 1 for adding passenger\n");
			System.out.println("enter 2 for removing passenger\n");
			System.out.println("enter 3 for quitting \n");
			 choice = s1.nextInt();
			switch(choice){
			case 1: test1.add();
			break;
			case 2: test1.remove();
			break;
			case 3: test1.quit();
			break;
			default: System.out.println("Please Enter a number between 1-3");
	
			}
			
		}
	}



}