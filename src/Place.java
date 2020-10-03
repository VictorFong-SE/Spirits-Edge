//Tim Czepizak tczepi2
//Martin Bragiel mbragi2
//Victor Fong vfong3

//Code for CS342 Homework
//Martin Bragiel mbragi2
//Professor Bell
//Class : Place
import java.util.*;

// PLACE class that keeps track of places the characters in the places as well as the artifacts in the places

public class Place {
	
	private String placeDescription;
	private String placeName;
	private int ID;
	private ArrayList<Direction> directions;
	public ArrayList<Artifact> artifacts;
	private static ArrayList<Character> characters;
	private static boolean firstPlace = true;
	public static HashMap<Integer, Place> places = new HashMap<Integer, Place>();
	private int directionCounter = 0;
	public int artifactCounter = 0;
	public static Random random;
	static public Random rand = new Random();
	private static Vector<Place> placeVector = new Vector<>();
	public Vector<Character> charactersInRoom = new Vector<>();
	private int roomType;

	public Place(Scanner in, double version){ // scanner for the place class, first place is idea for prof bell
		directions = new ArrayList<Direction>();
		artifacts = new ArrayList<Artifact>();
		characters = new ArrayList<Character>();
		String line = CleanLineScanner.getCleanLine(in);
		Scanner scan = new Scanner(line);
		ID = scan.nextInt();
		scan.skip("[ \t]*");
		placeName = scan.nextLine();
		line = CleanLineScanner.getCleanLine(in);
		scan = new Scanner(line);
		int numLines = scan.nextInt();
		roomType = scan.nextInt();
		placeDescription = "";
		for(int i = 0; i < numLines; i++)
			placeDescription += CleanLineScanner.getCleanLine(in) + "\n";
		places.put(ID, this);
		placeVector.add(this);
		if(firstPlace) {
			firstPlace = false;
			new Place(1, "Exit", "Exit place", 0);
			new Place(0, "Nowhere", "No Place", 0);
		}
		return;
	}
	
	public Place(int ID, String placeName, String placeDescription, int derkness) { // constructor for the place class
		this.ID = ID;
		this.placeName = placeName;
		this.placeDescription = placeDescription;
		directions = new ArrayList<Direction>();
		artifacts = new ArrayList<Artifact>();
		random = new Random();
		places.put(ID, this);
		roomType = derkness;

	}
	public Place(){

	}
	
	public boolean isExit() { // if the exit room is chosen the game exits
		return ID == 1 || ID == 0;
	}
	
	public static Place getRandomPlace() { // gets a random place from the places list
		int index = random.nextInt(places.size());
		Place p = places.get(index);
		return p;
	}
	
	public String getPlaceName(){
		return placeName;
	}
	
	public String getPlaceDescription() {
		return placeDescription;
	}
	
	public void addDirection(Direction d) {
		directions.add(d);
		directionCounter++;
	}
	
	public Place followDirection(String s, Character c) {
		for(int i = 0; i < directionCounter; i++) {
			if(directions.get(i).match(s)) {
				if(directions.get(i).follow().roomType == 1) {
					directions.get(i).follow().display();
					DarkRoom d = new DarkRoom(directions.get(i).follow());
					c.currentPlace = d.Teleport();
					return c.currentPlace;
				}
				else if(directions.get(i).follow().roomType == 2) {
					directions.get(i).follow().display();
					MysteryRoom m = new MysteryRoom(directions.get(i).follow());
					m.deleteInv(c);
					return directions.get(i).follow();
				}
				else
					return directions.get(i).follow();
			}
		}
		return this;
	}
	
	public void addArtifact(Artifact a) { // add artifact to the place
		artifacts.add(a);
		artifactCounter++;
	}
	
	public void addCharacter(Character c) { // add character to the place
		characters.add(c);
	}
	
	public Artifact removeArtifact(String s) { // remove artifact from the place
		for(Artifact a : artifacts) {
			if(a.match(s)) {
				artifacts.remove(a);
				return a;
			}
		}
		return null;
	}
	
	static Place getPlaceByID(int ID) {
		Place p = places.get(ID);
		return p;
	}
	
	public void useKey(Artifact a) {
		for(Direction d : directions) {
			d.useKey(a);
		}
	}

	public void printArt(Place p) {
		for(int j = 0; j < p.artifacts.size();j++)
			p.artifacts.get(j).print();
	}
	static public Place randomPlace(){
		int index = rand.nextInt(placeVector.size()-1) + 0;
		return placeVector.get(index);
	}
	public Artifact getArtifact(String s) {
		for (int i = 0; i < artifacts.size(); i++) {
			//System.out.println("YOU MADE IT TO PLACE 1");
			if (s.equalsIgnoreCase(artifacts.get(i).getName())) {
				//System.out.println("YOU MADE IT TO PLACE");
				Artifact a = artifacts.get(i);
				artifacts.remove(i);
				return a;

			}
		}
		return null;
	}


	public void changeArtifactCounter(int value)
    {
        artifactCounter += value;
    }


	public void display() {
		//System.out.printf("%d %n",myID);
		System.out.printf("%s %n", getPlaceName());
		System.out.printf("%s %n", getPlaceDescription());
        if (artifactCounter >= 1)
        {
            System.out.println("Furthermore, you see the following items within the room:");
            for (Artifact artifact : artifacts)
            {
                System.out.println(artifact.getName() + ": " + artifact.getDescription());
            }

        }

        //DEBUGGING INFORMATION
		//System.out.printf("%d %n",directionCounter);
	}

	public void displayStank(){
		if(artifacts.contains(new Feces("wet poop", "Large pile of wet poop", 12, 1, 0, 303))){
			System.out.printf("This room smells like it has been defecated in ...");
		}
	}

}