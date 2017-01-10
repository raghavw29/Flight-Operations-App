package Flightpack;
import java.io.*;


public class Flight implements Serializable {

 Passenger[] pass;
 Passenger[][] seatingchart;
 Passenger[] waitinglist;
 public int countofpassengers;
 public int countofwaitinglist;

 public Flight() {
  pass = new Passenger[50];
  seatingchart = new Passenger[10][4];
  waitinglist = new Passenger[10];
  countofpassengers = 0;
  countofwaitinglist = 0;
  for (int i = 0; i < 50; i++) {
   {
    pass[i] = new Passenger();
   }
  }
 }

 public void add(String name, int r, int c) throws Invalidrowseat {
  if(r>10 || c >4){
   throw new Invalidrowseat();
  }
  if ((seatingchart[r - 1][c - 1] == null) && countofpassengers <= 40) {
   this.seatingchart[r - 1][c - 1] = this.pass[countofpassengers];
   this.seatingchart[r - 1][c - 1].setName(name);
   countofpassengers++;
   //System.out.println("Adding to regular");
  } else {
  
   this.waitinglist[countofwaitinglist] = this.pass[(countofpassengers +countofwaitinglist) ];
   this.waitinglist[countofwaitinglist].setName(name);
   countofwaitinglist++;
   //System.out.println("Adding + to waiting " + name + );
  }

  
  //System.out.println(countofwaitinglist + countofpassengers);
  this.display();
 }

 public boolean isfull() {
  boolean full = true;
  int count = 0;
  for (int i = 0; i < 10; i++) {
   for (int j = 0; j < 4; j++) {
    if (this.seatingchart[i][j] == null)
     count++;
   }
  }
  if (count >= 1)
   full = false;
  return full;
 }

 public void remove(String name) {
  int endloop = 0;
  for (int i = 0; i < 10 && endloop == 0; i++) {
   for (int j = 0; j < 4 && endloop == 0; j++) {
    if (this.seatingchart[i][j] !=null &&name.equalsIgnoreCase(this.seatingchart[i][j].getName()) && this.waitinglist[0] != null) {
     //System.out.println(" Case 1 match found wait list ");
     this.seatingchart[i][j] = this.waitinglist[0];
     for (int k = 0; k < countofwaitinglist; k++) {
      if (waitinglist[k] != null)
       waitinglist[k] = waitinglist[k + 1];
     }
     waitinglist[countofwaitinglist-1] = null;
     countofwaitinglist--; 
     endloop = 1;
    } else if ( this.seatingchart[i][j] !=null &&name.equalsIgnoreCase(this.seatingchart[i][j].getName()) && this.waitinglist[0] == null) {
     this.seatingchart[i][j] = null;
     countofpassengers--;
     //System.out.println(" Case 2 No waitlist ");
     endloop = 1;
    } 
    //else if ( this.seatingchart[i][j] !=null&&!name.equalsIgnoreCase(this.seatingchart[i][j].getName()))
     //System.out.println("No name found" + this.seatingchart[i][j].geetName() + name);
   }
  this.display();
  }
  if (endloop == 0) {
   System.out.println("Notfound : "  + name);
  }
  System.out.println(countofwaitinglist + " " +  countofpassengers);
 }

 public void display() {
  for (int i = 0; i < 10; i++) {
   for (int j = 0; j < 4; j++) {
    if (this.seatingchart[i][j] != null)
     System.out.println(this.seatingchart[i][j].getName() );
    else
     System.out.println("This spot is open\n");
   }
   System.out.println(" \n");
  }

 }

public void write(){
 try{
 FileOutputStream fs = new FileOutputStream("chart.txt");
 ObjectOutputStream object = new ObjectOutputStream(fs);
 object.writeObject(seatingchart);
 
 
 object.close();
 }
 catch(IOException e){
  System.out.println(e.toString());
 }
 
}

public void read(){
 try{
 
 
 ObjectInputStream in = new ObjectInputStream(new FileInputStream("chart.txt"));
 Flight f = (Flight) in.readObject();
 in.close();
 }
 catch(IOException e){
 System.out.println(e.toString());
 }
 catch(ClassNotFoundException e){
     System.out.println(e.toString());
    }
 }
    

}


