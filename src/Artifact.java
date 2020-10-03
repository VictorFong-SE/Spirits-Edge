//Victor Fong vfong3
//Tim Czepizak tczepi2
//Martin Bragiel mbragi2
//Code for CS342 Homework
//Professor Bell
//Class : Artifact
//This Class creates an object which can be given to characters and places

import java.util.Scanner;

public class Artifact
{
    private int    artifactID;
    private int    playableCharID;
    private int    placeID;
    private int    charID;
    private String name;
    private String description;
    private int    value;
    private int    mobility;
    private int    keyPattern;
    private int    descLines;
    private int    typeOfArtifact;

    private int artifactType;

    public Artifact() {} //for use with feces class


    //Basic Constructor to make Objects without a scanner
    public Artifact(String toName, String toDescription, int toValue, int toMobility, int toKeypattern, int toID)
    {
        name = toName;
        description = toDescription;
        value = toValue;
        mobility = toMobility;
        keyPattern = toKeypattern;
        artifactID = toID;
    }


    //Constructor that utilizes a scanner to create object
    public Artifact(Scanner scanner, double version)
    {
        int descriptionLineCount;
        name = "";
        description = "";

        String  buffLine   = CleanLineScanner.getCleanLine(scanner);
        Scanner lineParser = new Scanner(buffLine);

        playableCharID = lineParser.nextInt();
        if (playableCharID > 0)
        {
            placeID = playableCharID;
        } else if (playableCharID < 0)
        {
            charID = -playableCharID;
        }

        buffLine = CleanLineScanner.getCleanLine(scanner);
        lineParser = new Scanner(buffLine);
        artifactID = lineParser.nextInt();
        value = lineParser.nextInt();
        mobility = lineParser.nextInt();
        keyPattern = lineParser.nextInt();
        lineParser.skip("[ \t]*");
        name = lineParser.nextLine();

        buffLine = CleanLineScanner.getCleanLine(scanner);
        lineParser = new Scanner(buffLine);

        descriptionLineCount = lineParser.nextInt();
        for (int i = 0; i < descriptionLineCount; i++)
        {
            description += scanner.nextLine() + " ";
        }

        if (playableCharID > 0)
        {
            // System.err.println(placeID);
            Place.places.get(placeID).addArtifact(this);
        } else if (playableCharID < 0)
        {
            //System.err.println(charID);
            //System.err.println(Character.characters.getMobility());
            Character.getCharacterByID(charID).addArtifact(this);
        } else
        {
            Place.randomPlace().addArtifact(this);
        }
    }


    int getMobility()
    {
        return mobility;
    }

    int getArtifactID()
    { return artifactID; }

    int getValue()
    {
        return value;
    }

    String getName()
    {
        return name;
    }

    String getDescription()
    {
        return description;
    }

    void use(Character character, Place place)  //pass key to useKey method
    {
        if (keyPattern > 0)
            place.useKey(this);
    }

    int getKeyPattern()
    {
        return keyPattern;
    }

    Artifact getArtifact()
    {
        return this;
    }

    boolean match(String artifact)
    {
        return artifact.trim().equalsIgnoreCase(name);
    }


    //Prints details
    void print()
    {
        System.out.println("Name = " + name);
        System.out.println("Description = " + description);
        System.out.println("Value = " + value);
        System.out.println("Mobility = " + mobility);
        System.out.println("KeyPattern = " + keyPattern + "\n");
    }
}
