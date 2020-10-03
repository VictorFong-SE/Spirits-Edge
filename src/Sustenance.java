import java.util.Scanner;

public class Sustenance extends Artifact
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


    private int uses;
    private int recoveryAmount;

    public Sustenance(){}


    public Sustenance(String toName, String toDescription, int toValue, int toMobility, int toKeypattern, int toID,
                      int toUses, int toRecoveryAmount)
    {
        super(toName,toDescription,toValue,toMobility,toKeypattern,toID);
        uses = toUses;
        recoveryAmount = toRecoveryAmount;
    }

    public Sustenance(Scanner scanner, double version)
    {
        int    descriptionLineCount;
        name = "";
        description = "";

        String buffLine = CleanLineScanner.getCleanLine(scanner);
        Scanner lineParser = new Scanner(buffLine);

        playableCharID = lineParser.nextInt();
        if (playableCharID > 0)
        {
            placeID = playableCharID;
        }
        else if (playableCharID < 0)
        {
            charID = -playableCharID;
        }

        buffLine = CleanLineScanner.getCleanLine(scanner);
        lineParser = new Scanner(buffLine);
        artifactID = lineParser.nextInt();
        value = lineParser.nextInt();
        mobility = lineParser.nextInt();
        keyPattern = lineParser.nextInt();
        uses = lineParser.nextInt();
        recoveryAmount = lineParser.nextInt();
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


    String getName()
    { return name; }

    String getDescription()
    { return description; }


    int getUses(){return uses;}


    int getRecoveryAmount(){return recoveryAmount;}



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

    void use(Character character, Place place)  //pass key to useKey method
    {
        if (keyPattern > 0)
            place.useKey(this);
    }

    int getKeyPattern()
    {
        return keyPattern;
    }

    Sustenance getArtifact()
    {
        return this;
    }

    boolean match(String artifact)
    {
        return artifact.trim().equalsIgnoreCase(getName());
    }


    //Prints details
    void print()
    {
        System.out.println("Name = " + getName());
        System.out.println("Description = " + getDescription());
        System.out.println("Value = " + getValue());
        System.out.println("Mobility = " + getMobility());
        System.out.println("Uses = " + getUses());
        System.out.println("Healing potency = " + getRecoveryAmount());
    }
}

