//Tim Czepizak tczepi2
//Martin Bragiel mbragi2
//Victor Fong vfong3

//Code for CS342 Homework
//Professor Bell
//Class : Game
//This game parses the file and runs the game
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Game {

	//PRIVATE DATA 
	private String gameName;
	private Vector<Character> characters = new Vector<>();
	private Vector<NPC> NPCs = new Vector<NPC>();
	private Vector<Player> players = new Vector<Player>();
	private String name;
	private int turn;
	private int numCharacters;
	private NPC npc[];
	private int pCounter;
	private int nCounter;
	private Player player[];
	int playerCountGame = 0;
	private double version2;
	public Random random = new Random();


	//CONSTRUCTOR For Taking in a File
	public Game(Scanner gameScanner) {

		while (gameScanner.hasNextLine()) {
			String line = CleanLineScanner.getCleanLine(gameScanner);
			if(line == null)
				break;
			Scanner scan = new Scanner(line);
			String word = scan.next();
			if (!word.equalsIgnoreCase("GDF")) {
				System.err.println("Error parsing file");
				System.exit(-1);
			}
			double version = scan.nextDouble();
			version2 = version;
			scan.skip("[ \t]*");
			name = scan.nextLine();

			int numPlaces = keywordCounter(gameScanner, "PLACES");
			for (int i = 0; i < numPlaces; i++)
				new Place(gameScanner, version);

			int numDirections = keywordCounter(gameScanner, "DIRECTIONS");
			for (int i = 0; i < numDirections; i++)
				new Direction(gameScanner, version);
			if(version >= 4.0) {																									//If the version isnt new then this is not in it
				numCharacters = keywordCounter(gameScanner, "CHARACTERS");
				for (int i = 0; i < numCharacters; i++) {
					//System.out.println(numCharacters);
				/*line = CleanLineScanner.getCleanLine(gameScanner);
				scan = new Scanner(line);
				String type = scan.next();
				int ID = scan.nextInt();*/
					//Place.getPlaceByID(ID).addCharacter(new Character(gameScanner, version));
					characters.add(new Character(gameScanner, version));
				}
			}
			//System.err.println(Character.characters.getMobility());
			int numArtifacts[];
			numArtifacts = keywordCounterArtifact(gameScanner);
			for (int i = 0; i < numArtifacts[0]; i++)
			{
				new Artifact(gameScanner, version);
			}
			for (int i = 0; i < numArtifacts[1]; i++)
			{
				new Sustenance(gameScanner, version);
			}
		}
	}


	public Game(String a) {
		gameName = a;
	}

	//ADDS THE DIRECTION TO THE PLACE VECTOR
	private void addPlace(int key, Place place) {
		Place.places.put(key, place);
	}

	//PRINTS GAME NAME FOR DEBUGGING
	public void print() {
		System.out.printf("%s %n", gameName);
		//	currentPlace.display();
		//	for (int i = 0; i < artifactsPlayer.getMobility(); i++)
		//	artifactsPlayer.get(i).print();
	}
	//Keeps Track of all keywords
	private int keywordCounter(Scanner file, String keyword) {
		String line = CleanLineScanner.getCleanLine(file);
		Scanner scan = new Scanner(line);
		String word = scan.next();
		if (!word.equalsIgnoreCase(keyword)) {
			System.err.println("Error parsing file");
			System.exit(-4);
		}
		int count = scan.nextInt();
		if (count <= 0) {
			System.err.println("Error parsing file");
			System.exit(-5);
		}
		scan.close();
		return count;
	}

	//Keeps Track of all keywords when keyword is ARTIFACTS
	private int[] keywordCounterArtifact(Scanner file)
    {
		String line = CleanLineScanner.getCleanLine(file);
		Scanner scan = new Scanner(line);
		String word = scan.next();
		if (!word.equalsIgnoreCase("ARTIFACTS")) {
			System.err.println("Error parsing file");
			System.exit(-4);
		}
		int count[] = new int[2];
		count[0] = scan.nextInt();
		count[1] = scan.nextInt();
		for (int i = 0; i < 2; i++)
		if (count[i] <= 0) {
			System.err.println("Error parsing file");
			System.exit(-5);
		}
		scan.close();
		return count;
	}


	//!move.getMoveType().toStrings().equalsIgnoreCase("go"

	//PLAY METHOD THAT CONTROLS ALL OF THE GAME
	public void play() {


	    while(true){
			if(version2 >3.9) {
				turn = 1;
				Move move;
				if (playerCountGame >= Character.playerCount)
					playerCountGame = 0;


				//for(int k = 0; k < numCharacters; k ++){
			//		System.out.println(characters.get(k).getName);
		//		}

				for (int i = 0; i < numCharacters; i++) {
					//System.err.println(characters.get(i).type);
					Character.currentCharacter = characters.get(i);
					if (characters.get(i).type.equalsIgnoreCase("PLAYER")) {
						//System.err.println("hi");
						if (playerCountGame == 0) {
							System.out.println("Player 1's Turn");
						} else if (playerCountGame == 1) {
							System.out.println("Player 2's Turn");
						}

						Scanner keyboard = new Scanner(System.in);
						System.out.println("Please enter an integer corresponding to the UI you would like to use for the character:" + characters.get(i).name);
						System.out.println("1 - Tim C");
						System.out.println("2 - Martin B");
						System.out.println("3 - Victor F");
						System.out.println("4 - Random");

						int choice = keyboard.nextInt();
						if(characters.get(i).active == 0) {
							if ( choice == 1)
								characters.get(i).u = new UI_TimC();
							else if (choice == 2)
								characters.get(i).u = new UI_MartinB();
							else if (choice == 3)
								characters.get(i).u = new UI_VictorF();
							else
							{
								int randoChooser = random.nextInt(4 - 1 ); // randomize
								if(characters.get(i).active == 0) {
									if ( randoChooser == 1)
										characters.get(i).u = new UI_TimC();
									else if (randoChooser == 2)
										characters.get(i).u = new UI_MartinB();
									else
										characters.get(i).u = new UI_VictorF();

									characters.get(i).active = 1;
								}
							}
							characters.get(i).active = 1;
						}



						else if(characters.get(i).active == 1){
							while (true) {
								move = characters.get(i).u.getMove(characters.get(i), characters.get(i).currentPlace);
								characters.get(i).makeMove(move);
								if (move.getMoveType().toStrings().equalsIgnoreCase("go"))
									break;
							}
						}
						playerCountGame++;
					} else if (characters.get(i).type.equalsIgnoreCase("NPC")) {
						AI a = new AI();
						while (true) {
							//	NPC n = (NPC) characters.get(i);
							move = a.getMove(characters.get(i), characters.get(i).currentPlace);
							characters.get(i).makeMove(move);
							if (move.getMoveType().toStrings().equalsIgnoreCase("go")) {
								//System.out.println("DAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD");
								break;
							}
						}
					} else if (characters.get(i).type.equalsIgnoreCase("ANIMAL")) {
						//System.out.println("DAAAAAAAAAAAAAAD");
						AiAnimal an = new AiAnimal();
						while (true) {
							Animal a = new Animal(characters.get(i));
							move = an.getMove(a, characters.get(i).currentPlace);
							a.makeMove(move);
							if (move.getMoveType().toStrings().equalsIgnoreCase("go")) {
								//System.out.println("DAAAAAAAAAAAAAAD");
								break;
							}

						}
					}
					else{
						System.out.println("No-one went");
					}
					//	System.err.println("Hello");
				}

					turn++;
				}
			else {
				//This is for if the version is not new
				UI u = new UI();
				Move move;
				while (true) {
					move = u.getMove(characters.get(1), characters.get(1).currentPlace);
					characters.get(1).makeMove(move);
					if (move.getMoveType().toStrings().equalsIgnoreCase("go"))
						break;
				}
			}
		}
	}
}