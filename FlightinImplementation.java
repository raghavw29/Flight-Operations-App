package Flightpack;

public class FlightinImplementation implements Flightin {
	FlightOperations ops1;
	public  FlightinImplementation(){
		 ops1 = new FlightOperations();
	}
	public void add() throws Invalidrowseat{
		
		ops1.add();
		
	}
    public void remove(){
    	ops1.remove();
    }
    public void quit(){
    	ops1.quit();
    }
}
