package Flightpack;
import java.util.Scanner;
public class FlightOperations {
Flight f1;
	public FlightOperations(){
	 f1 = new Flight();
}
public void add() throws Invalidrowseat{
	System.out.println("What is the name of passenger : \n");
	Scanner s1 = new Scanner(System.in);
	String name = s1.nextLine();
	System.out.println("What row do you wish to be seated:  \n");
	int row = s1.nextInt();
	System.out.println("What seat do you wish to be seated:  \n");
	int col = s1.nextInt();
	//f1.read();
	f1.add(name,row,col);
	//f1.write();
    
}


public void remove(){
	System.out.println("What is the name of passenger : \n");
	Scanner s2 = new Scanner(System.in);
	String name = s2.nextLine();
	//f1.read();
	f1.remove(name);
	//f1.write();
}

public void quit(){
	System.exit(0);
}


}
