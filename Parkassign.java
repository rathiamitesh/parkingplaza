package parkplaza;

import java.util.ArrayList;

class Vehicle {	 
	private String regnum;
	 private int numofwheels;
	 private int numberofspots;
	 ParkingSpot parkingspotveh=new ParkingSpot();
	
	public ParkingSpot getParkingspotveh() {
		return parkingspotveh;
	}
	public void setParkingspotveh(ParkingSpot parkingspotveh) {
		this.parkingspotveh = parkingspotveh;
	}
	public String getRegnum() {
		return regnum;
	}
	public void setRegnum(String model) {
		this.regnum = model;
	}
	public int getNumofwheels() {
		return numofwheels;
	}
	public void setNumofwheels(int numofwheels) {
		this.numofwheels = numofwheels;
	}
	public int getNumberofspots() {
		return numberofspots;
	}
	public void setNumberofspots(int numberofspots) {
		this.numberofspots = numberofspots;
	}
	



 
 public void printDetails(){
 System.out.println("The registration number of this vehicle is " + this.regnum);
 System.out.println("The number of wheels in this vehicle is "+ this.numofwheels);
 System.out.println("The parking spot of this vehicle is "+ this.parkingspotveh.getSpotno()+"and the level is"+this.parkingspotveh.getLevelno());
 }
  
}

class Bike extends Vehicle {
	
	private Boolean motorised;
	public Boolean getMotorised() {
		return motorised;
	}
	public void setMotorised(Boolean motorised) {
		this.motorised = motorised;
	}

	public Bike(){	  
	 }
	 public Bike(String regnum){
	 setRegnum(regnum);
	 setNumofwheels(2);
	 setNumberofspots(1);
	}
 }
class Car extends Vehicle {
	private Boolean electric;
	public Boolean getElectric() {
		return electric;
	}
	public void setElectric(Boolean electric) {
		this.electric = electric;
		setElectric(electric);
	}
	public Car(){	  
	 }
	 public Car(String regnum, Boolean electric){
		 setRegnum(regnum);
		 setNumofwheels(4);
		 setNumberofspots(2);
	}
 }
class Bus extends Vehicle{
	
	public Bus(String regnum) {
		 setNumofwheels(6);
		setRegnum(regnum);
		 setNumberofspots(3);
		 
	}
public Bus(String regnum,int numofwheels,int numberofspots) {
	setNumofwheels(numofwheels);
		setRegnum(regnum);
		 setNumberofspots(numberofspots);
		 
	}
}
class Level {
	
	public Level(int levelsize, int levelnumber) {
		this.levelsize=levelsize;
		this.freespaces=levelsize;
		this.levelnumber=levelnumber;
		for(int i=0; i<levelsize; i++) { 
			ParkingSpot randomspot = new ParkingSpot();
			randomspot.setFree(true);
			randomspot.setLevelno(levelnumber);
			randomspot.setSpotno(levelsize-freespaces);
		}
	}
	
	private int levelsize,freespaces,levelnumber;	
	private ArrayList<Car> carlist = new ArrayList<>();
	private ArrayList<Bus> buslist = new ArrayList<>();
	private ArrayList<Bike> bikelist = new ArrayList<>();
	private ArrayList<ParkingSpot> spots = new ArrayList<>();
	
	public int getLevelsize() {
		return levelsize;
	}
	
	
	public void setLevelsize(int Levelsize) {
		this.levelsize = Levelsize;
	}
	public int getFreespaces() {
		return freespaces;
	}


	public void setFreespaces(int freespaces) {
		this.freespaces = freespaces;
	}


	public int getLevelnumber() {
		return levelnumber;
	}


	public void setLevelnumber(int levelnumber) {
		this.levelnumber = levelnumber;
	}
	
	
	
	public void addcar(Car a) {
		
		if(freespaces>=2)
			{this.carlist.add(a);
			ParkingSpot p=new ParkingSpot(levelnumber,levelsize-freespaces);
			a.setParkingspotveh(p);
			freespaces=freespaces-2;
			}else
			System.out.println("Not enough space");
	}
public void addbike(Bike b) {
		
		if(freespaces>=1)
			{this.bikelist.add(b);
			ParkingSpot p=new ParkingSpot(levelsize,levelsize-freespaces);
			b.setParkingspotveh(p);
			freespaces--;
			}
		else
			System.out.println("Not enough space");
	}
public void addbus(Bus c) {
	
	if(freespaces>=3)
		{this.buslist.add(c);
		ParkingSpot p=new ParkingSpot(levelsize,levelsize-freespaces);
		c.setParkingspotveh(p);
		freespaces=freespaces-3;
		}
	else
		System.out.println("Not enough space");
}
public void removecar(String regnum) {
	
	for(int i=0; i<carlist.size();i++) {
		if(carlist.get(i).getRegnum().equals(regnum)) {
			this.carlist.remove(i);
			freespaces+=2;
		}	
	}
}
public void removebike(String regnum) {
	
	for(int i=0; i<bikelist.size();i++) {
		if(bikelist.get(i).getRegnum().equals(regnum)) {
			this.bikelist.remove(i);
			freespaces++;
		}	
	}
}
public void removebus(String regnum) {
	
	for(int i=0; i<buslist.size();i++) {
		if(buslist.get(i).getRegnum().equals(regnum)) {
			this.buslist.remove(i);
			freespaces+=3;
		}	
	}
}	
	}
class ParkingSpot {
	private int levelno;
	private int spotno;
	private boolean free;
	private boolean disabled;
	private boolean charging;
	public ParkingSpot()
	{}
	public ParkingSpot(int levelno, int spotno) {
		this.levelno=levelno;
		this.spotno=spotno;
	}
	
	public int getLevelno() {
		return levelno;
	}
	public void setLevelno(int levelno) {
		this.levelno = levelno;
	}
	public int getSpotno() {
		return spotno;
	}
	public void setSpotno(int spotno) {
		this.spotno = spotno;
	}
	public boolean isFree() {
		return free;
	}
	public void setFree(boolean free) {
		this.free = free;
	}
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	public boolean isCharging() {
		return charging;
	}
	public void setCharging(boolean charging) {
		this.charging = charging;
	}
	
	

	
}
class Plaza
{
	private ArrayList<Level> levellist = new ArrayList<>();

	public ArrayList<Level> getLevellist() {
		return levellist;
	}

	public void setLevellist(ArrayList<Level> levellist) {
		this.levellist = levellist;
	}
	public int getNumberoflevels() {
		return levellist.size();
	}
	public void addLevel(Level a) {
		this.levellist.add(a);
	}

	public void removeLevel(Level a) {
		this.levellist.remove(a);
	}
	
}

public class Parkassign {
		 		 
public static void main(String[] args) {
	Plaza The_plaza = new Plaza();
	Level newlevel = new Level(200,1);
	Car newcar = new Car();
}}
