//Tim Czepizak tczepi2
//Martin Bragiel mbragi2
//Victor Fong vfong3

//Code for CS342 Homework
//Professor Bell
//Class : UI
//This Class implements the User Interface of the program for each player.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Scanner;

public class UI  extends JFrame implements DecisionMaker
{

    public UI(){

        super(Character.currentCharacter.name);
    }


    private Scanner scan = new Scanner(System.in);
    private String  input;
    private String  m;
    private String  command;
    private String  description;

    public Move getMove(NPC npc, Place place) {return null;}

    @Override
    public Move getMove(Character c, Place p)
    {
        Place currentPlace = p;
        if (currentPlace.isExit())
            System.exit(1);
        currentPlace.display();                                                        //DISPLAYS THE CURRENTPLACES INFO
        //	Place.places.get(12).printAll();


        input = scan
                .nextLine();                                                     //SPLITS INPUT INTO DIFFERENT STRINGS
        Scanner line = new Scanner(input);
        command = line.next();
        // System.out.println(command);
        line.skip("[ \t]*");
        if (line.hasNextLine())
        {
            description = line.nextLine();
        }
        //IF STRING LENGTH IS 2, IGNORES THE FIRST WORD SUCH AS GO

        if (command.equalsIgnoreCase("get") ||
            command.equalsIgnoreCase("pick up") ||
            command.equalsIgnoreCase("grab"))
        {
            //System.out.println("GOOOOOO");
            return new Move(MoveType.GET, description);
            //System.out.println("You are getting something");                //Key word Gets
            //System.out.println(line[1]);
        }
        if (command.equalsIgnoreCase("use"))
        {
            for (int k = 0; k < c.artifacts.size(); k++)
            {                        //keyword Use
                if (c.artifacts.get(k).getName().equalsIgnoreCase(description))
                {
                    System.out.println("You Are using something");
                    return new Move(MoveType.USE, description);
                }
            }
        }
        if (command.equalsIgnoreCase("drop"))
        {
            for (int k = 0; k < c.artifacts.size(); k++)
            {                        //keyword drop
                if (c.artifacts.get(k).getName().equalsIgnoreCase(description))
                {
                    System.out.println("you are dropping something");
                    return new Move(MoveType.DROP, description);
                }
            }
        }

        //CHECKS IF THE INPUT IS QUIT, EXIT, OR LOOK
        if (command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("exit"))
        {
            return new Move(MoveType.EXIT, "exit");
        }
        if (command.equalsIgnoreCase("INVENTORY") ||
            (command.equalsIgnoreCase("INV") ||
             command.equalsIgnoreCase("INVE")))
        {            //keyword inventory
            return new Move(MoveType.INVENTORY, "Inventory");
        }
        if (command.equalsIgnoreCase("look"))
        {
            return new Move(MoveType.LOOK, "look");
            //  currentPlace.printArt(currentPlace);
        }
        if (command.equalsIgnoreCase("go"))
        {
            return new Move(MoveType.GO, description);
        }

        //IF NOT ANY OF THE SPECIAL INPUTS, CHECKS TO SEE IF THE INPUT IS A DIRECTION
        if (!command.equalsIgnoreCase("look") || !command.equalsIgnoreCase("INVENTORY") || !command.equalsIgnoreCase(
                "INVE") || !command.equalsIgnoreCase("go") || !command.equalsIgnoreCase("drop"))
        {
            return new Move(MoveType.GO, command);
            //currentPlace = currentPlace.followDirection(m);                        //Follows the Direction and
            // changes the current Place to either the from or to place for this direction
        }
        //IF NOT REPEATS THE LOOP AND DISPLAYS A MESSAGE ASKING FOR A VALID INPUT
        else
            System.out.println("Please provide valid input");
        //	System.out.println("DEBUG");

        return null;
    }
}
