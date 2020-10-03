//Tim Czepizak tczepi2
//Martin Bragiel mbragi2
//Victor Fong vfong3
//Code for CS342 Homework
//Professor Bell
//Class : Character
//This is the class that creates multiple characters.
//Support for both npc and Players
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;
public class Character {
    protected int ID;
    private int placeID;
    protected String name;
    protected String description;
    private int descLines;
    private int characterCount;
    static public HashMap<Integer, Character> characters = new HashMap<>();
    static public HashMap<Integer, Animal> animals = new HashMap<>();
    protected Place currentPlace;
    public Vector<Artifact> artifacts = new Vector<Artifact>();
    private int inventoryCounter;
    private int attackDamage;
    public String type;
    public static int playerCount = 0;
    public int active = 0;
    public UI u;
    public static Character currentCharacter;

//Default nothing Constructor
    public Character(){

    }

//Constructor for scanning in a file
    public Character(Scanner s, double version){
        String line = CleanLineScanner.getCleanLine(s);
        Scanner scan = new Scanner(line);
        type = scan.next();
        //System.out.println(type);
        if(type == "PLAYER")
            playerCount++;
      //  System.err.println(type);
        placeID = scan.nextInt();
        //System.err.println(placeID);
        line = CleanLineScanner.getCleanLine(s);
        scan = new Scanner(line);
        ID = scan.nextInt();
        scan.skip("[ /t]*");
        name = scan.nextLine();
        line = CleanLineScanner.getCleanLine(s);
        scan = new Scanner(line);
        descLines = scan.nextInt();
        description = "";
        for(int i = 0; i < descLines; i++){
            description += CleanLineScanner.getCleanLine(s) + "\n";
        }
        currentPlace = Place.getPlaceByID(placeID);
        if(placeID > 0) {
            Place.getPlaceByID(placeID).addCharacter(this);
           // Place.getPlaceByID(placeID).charactersInRoom.add(this);
            characters.put(ID,this);
        }
        else {
           // System.err.println(Place.randomPlace().getName());
            Place random = Place.randomPlace();
            random.addCharacter(this);
          //  random.charactersInRoom.add(this);
            this.currentPlace = random;
            characters.put(ID,this);
        }
    }

    public Character(int id, String name, String desc){


    }

    public static Character getCharacterByID(int ID){
        return Character.characters.get(ID);
    }

    public void makeMove(Move move){
        switch(move.getMoveType()){
            case GO:{
                currentPlace = this.currentPlace.followDirection(move.getString(), this);
                return;
            }
            case EXIT: {
                System.exit(1);
            }
            case QUIT: {
                characters.remove(this);
            }
            case INVENTORY:{
                this.inventory();
                return;
            }
            case LOOK:{
                this.currentPlace.printArt(currentPlace);
                return;
            }
            case DROP:{
                for (int k = 0; k < artifacts.size(); k++) {                        //keyword drop
                    if (artifacts.get(k).getName().equalsIgnoreCase(move.getString()))
                        artifacts.remove(k);
                }
                return;
            }
            case USE:{
                for (int k = 0; k < artifacts.size(); k++) {                        //keyword Use
                    if (artifacts.get(k).getName().equalsIgnoreCase(move.getString())){
                        artifacts.get(k).use(this, currentPlace);
                    }
                }
                return;
            }
            case GET:{
                /*for (int k = 0; k < this.currentPlace.artifacts.size(); k++){
                    if(this.currentPlace.artifacts.get(k).getName().equalsIgnoreCase(move.getString())){
                        this.artifacts.add(this.currentPlace.artifacts.get(k));
                        currentPlace.artifacts.remove(k);
                    }
                }
                return;*/
                boolean success = false;

                String artifactName = move.getString();
                Artifact artifactBuff = currentPlace.removeArtifact(artifactName);
                if (artifactBuff != null)
                {
                    this.artifacts.add(artifactBuff);
                    System.out.println("===========================================" +
                                       "You got the " + artifactName + "!" +
                                       "===========================================");
                    ++inventoryCounter;
                    currentPlace.changeArtifactCounter(-1);
                    success = true;
                }
                if (!success)
                {
                    System.out.println("That artifact doesn't exist!");
                    break;
                }
            }
        }


    }
    private void inventory() {
        //System.out.println("inventory");
        for (int i = 0; i < artifacts.size(); i++) {
            artifacts.get(i).print();
        }
    }

    public void print(){
        for(int i = 0; i < characterCount; i++){
            System.out.println(ID);
            System.out.println(name);
            System.out.println(description);
        }
    }

    public void display(){
        System.out.println(this.name);
        System.out.println(" has");
        for (int i = 0; i < inventoryCounter; i++){
            System.out.println(artifacts.get(i).getName());
        }
    }
    public void addArtifact(Artifact a){
        artifacts.add(a);
    }
    public void getArtifact(String s){
        artifacts.add(currentPlace.getArtifact(s));
    }


    public void dropArtifact(int id){
        artifacts.remove(id);
    }

}
