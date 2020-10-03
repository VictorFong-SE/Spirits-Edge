//Tim Czepizak tczepi2
//Martin Bragiel mbragi2
//Code for CS342 Homework
//Victor Fong vfong3

//Professor Bell
//Class : Direction

import java.util.*;

//DIRECTION class where the directions are added to the places

public class Direction {
	
	private int ID;
	private Place from;
	private Place to;
	private String dir;
	private boolean locked;
	private int lockPattern;
	private DirType DT;
	
	public Direction(Scanner in, double version) { // direction scanner
		
		String line = CleanLineScanner.getCleanLine(in);
		Scanner scan = new Scanner(line);
		ID = scan.nextInt();
		int source = scan.nextInt();
		from = Place.getPlaceByID(source);
		
		String dir = scan.next();
		DT = DirType.NONE;
		for(DirType text : DirType.values()) {
			if(text.match(dir)) {
				DT = text;
				break;
			}
		}
		
		locked = false;
		int destination = scan.nextInt();
		if(destination <= 0) {
			locked = true;
			destination = -destination;
		}
		to = Place.getPlaceByID(destination);
		
		lockPattern = scan.nextInt();
		lockPattern = lockPattern > 0 ? lockPattern : 0;
		from.addDirection(this);
	}
	
	public Direction(int ID, Place from, Place to, String dir, boolean locked, int lockPattern){ // constructor for direction
		this.ID = ID;
		this.from = from;
		this.to = to;
		this.dir = dir;
		locked = false;
		this.lockPattern = lockPattern;
		
		if(DirType.NORTH.match(dir))
			DT = DirType.NORTH;
		else if(DirType.SOUTH.match(dir))
			DT = DirType.SOUTH;
		else if(DirType.EAST.match(dir))
			DT = DirType.EAST;
		else if(DirType.WEST.match(dir))
			DT = DirType.WEST;
		else if(DirType.UP.match(dir))
			DT = DirType.UP;
		else if(DirType.DOWN.match(dir))
			DT = DirType.DOWN;
		else if(DirType.NORTHEAST.match(dir))
			DT = DirType.NORTHEAST;
		else if(DirType.NORTHWEST.match(dir))
			DT = DirType.NORTHWEST;
		else if(DirType.SOUTHEAST.match(dir))
			DT = DirType.SOUTHEAST;
		else if(DirType.SOUTHWEST.match(dir))
			DT = DirType.SOUTHWEST;
		else if(DirType.NORTHNORTHEAST.match(dir))
			DT = DirType.NORTHNORTHEAST;
		else if(DirType.NORTHNORTHWEST.match(dir))
			DT = DirType.NORTHNORTHWEST;
		else if(DirType.EASTNORTHEAST.match(dir))
			DT = DirType.EASTNORTHEAST;
		else if(DirType.WESTNORTHWEST.match(dir))
			DT = DirType.WESTNORTHWEST;
		else if(DirType.EASTSOUTHEAST.match(dir))
			DT = DirType.EASTSOUTHEAST;
		else if(DirType.WESTSOUTHWEST.match(dir))
			DT = DirType.WESTSOUTHWEST;
		else if(DirType.SOUTHSOUTHEAST.match(dir))
			DT = DirType.SOUTHSOUTHEAST;
		else if(DirType.SOUTHSOUTHWEST.match(dir))
			DT = DirType.SOUTHSOUTHWEST;
		else if(DirType.NONE.match(dir))
			DT = DirType.NONE;
	}
	
	private void lock() {
		if(!locked)
			locked = true;
	}
	
	private void unlock() {
		if(locked)
			locked = false;
	}
	
	public boolean isLocked(){
		if(locked)
			return true;
		else 
			return false;
	}

	void useKey(Artifact key)
	{
		if (lockPattern == key.getKeyPattern())
		{
			if (this.isLocked())
				this.unlock();
		}
		else
		{
			this.lock();
		}
	}
	
	public Place follow(){ // follow direction
		if(locked) {
			System.out.println("This is Locked");
			return from;
		}
		else
			return to;
	}
	
	public boolean match(String s) { // sends to enum to match the direction
		return DT.match(s);
		
		/*if(s.toLowerCase().equals("n") || s.toLowerCase().equals("north")) {
			if(dir.contains("north"))
				return true;
			else
				return false;
		}
		if(s.toLowerCase().equals("s") || s.toLowerCase().equals("south")) {
			if(dir.contains("south"))
				return true;
			else
				return false;
		}
		if(s.toLowerCase().equals("e") || s.toLowerCase().equals("east")) {
			if(dir.contains("east"))
				return true;
			else
				return false;
		}
		if(s.toLowerCase().equals("w") || s.toLowerCase().equals("west")) {
			if(dir.contains("west"))
				return true;
			else
				return false;
		}
		else
			return false;*/
	}
	
}
