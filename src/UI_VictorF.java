//Victor Fong vfong3
//Tim Czepizak tczepi2
//Martin Bragiel mbragi2

//Code for CS342 Homework
//Professor Bell
//Class : UI_VictorF
//This Class implements the User Interface of the program for each player. Created by Victor

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI_VictorF extends UI implements ActionListener
{
    JPanel panel = new JPanel();

    JButton buttonNorth          = new JButton("N");
    JButton buttonNorthNorthEast = new JButton("NNE");
    JButton buttonNorthEast      = new JButton("NE");
    JButton buttonEastNorthEast  = new JButton("ENE");
    JButton buttonEast           = new JButton("E");
    JButton buttonEastSouthEast  = new JButton("ESE");
    JButton buttonSouthEast      = new JButton("SE");
    JButton buttonSouthSouthEast = new JButton("SSE");
    JButton buttonSouth          = new JButton("S");
    JButton buttonSouthSouthWest = new JButton("SSW");
    JButton buttonSouthWest      = new JButton("SW");
    JButton buttonWestSouthWest  = new JButton("WSW");
    JButton buttonWest           = new JButton("W");
    JButton buttonWestNorthWest  = new JButton("WNW");
    JButton buttonNorthWest      = new JButton("NW");
    JButton buttonNorthNorthWest = new JButton("NNW");
    JButton buttonQuit           = new JButton("QUIT");
    JButton buttonInventory      = new JButton("INV");
    JButton buttonLook           = new JButton("LOOK");
    JButton buttonGet            = new JButton("GET");
    JButton buttonUse            = new JButton("USE");
    JButton buttonDrop           = new JButton("DROP");
    JButton buttonGameQuit       = new JButton("QUIT GAME");

    JTextArea textArea = new JTextArea(5, 20);

    JTextField textfieldGet  = new JTextField();
    JTextField textfieldDrop = new JTextField();
    JTextField textfieldUse  = new JTextField();

    private boolean moveMade = false;
    private Move    move     = new Move(null, null);
    private int     first    = 0;

    public UI_VictorF()
    {
        super();    //call UI

        textArea.setBounds(0, 0, 540, 200); //keep bounds somewhat consistent with other UIs
        textArea.setLineWrap(true);

        buttonGameQuit.setBounds(700, 25, 150, 25);
        buttonQuit.setBounds(550, 50, 300, 60);

        textfieldGet.setBounds(550, 125, 180, 25);
        buttonGet.setBounds(730, 125, 100, 25);

        textfieldUse.setBounds(550, 150, 180, 25);
        buttonUse.setBounds(730, 150, 100, 25);

        textfieldDrop.setBounds(550, 175, 180, 25);
        buttonDrop.setBounds(730, 175, 100, 25);
        buttonInventory.setBounds(730, 200, 100, 25);


        buttonNorth.setBounds(400, 220, 75, 25);
        buttonNorthNorthEast.setBounds(438, 245, 75, 25);
        buttonNorthEast.setBounds(476, 270, 75, 25);
        buttonEastNorthEast.setBounds(514, 295, 75, 25);
        buttonEast.setBounds(552, 320, 75, 25);
        buttonEastSouthEast.setBounds(514, 345, 75, 25);
        buttonSouthEast.setBounds(476, 370, 75, 25);
        buttonSouthSouthEast.setBounds(438, 395, 75, 25);

        buttonSouth.setBounds(400, 420, 75, 25);

        buttonLook.setBounds(400, 320, 75, 25);


        buttonSouthSouthWest.setBounds(362, 395, 75, 25);
        buttonSouthWest.setBounds(324, 370, 75, 25);
        buttonWestSouthWest.setBounds(286, 345, 75, 25);
        buttonWest.setBounds(248, 320, 75, 25);
        buttonWestNorthWest.setBounds(286, 295, 75, 25);
        buttonNorthWest.setBounds(324, 270, 75, 25);
        buttonNorthNorthWest.setBounds(362, 245, 75, 25);


        buttonGameQuit.setActionCommand("quitgame");
        buttonNorth.setActionCommand("N");
        buttonSouth.setActionCommand("S");
        buttonEast.setActionCommand("E");
        buttonWest.setActionCommand("W");
        buttonNorthEast.setActionCommand("NE");
        buttonSouthEast.setActionCommand("SE");
        buttonEastSouthEast.setActionCommand("ESE");
        buttonWestSouthWest.setActionCommand("WSW");
        buttonNorthWest.setActionCommand("NW");
        buttonSouthWest.setActionCommand("SW");
        buttonNorthNorthEast.setActionCommand("NNE");
        buttonNorthNorthWest.setActionCommand("NNW");
        buttonSouthSouthEast.setActionCommand("SSE");
        buttonSouthSouthWest.setActionCommand("SSW");
        buttonWestNorthWest.setActionCommand("WNW");
        buttonEastNorthEast.setActionCommand("ENE");
        buttonQuit.setActionCommand("quit");
        buttonInventory.setActionCommand("inv");
        buttonLook.setActionCommand("look");
        buttonGet.setActionCommand("get");
        buttonUse.setActionCommand("use");
        buttonDrop.setActionCommand("drop");


        buttonGameQuit.addActionListener(this);
        buttonNorth.addActionListener(this);
        buttonSouth.addActionListener(this);
        buttonEast.addActionListener(this);
        buttonWest.addActionListener(this);
        buttonNorthEast.addActionListener(this);
        buttonSouthEast.addActionListener(this);
        buttonEastSouthEast.addActionListener(this);
        buttonWestSouthWest.addActionListener(this);
        buttonNorthWest.addActionListener(this);
        buttonSouthWest.addActionListener(this);
        buttonNorthNorthEast.addActionListener(this);
        buttonNorthNorthWest.addActionListener(this);
        buttonSouthSouthEast.addActionListener(this);
        buttonSouthSouthWest.addActionListener(this);
        buttonWestNorthWest.addActionListener(this);
        buttonEastNorthEast.addActionListener(this);
        buttonQuit.addActionListener(this);
        buttonInventory.addActionListener(this);
        buttonLook.addActionListener(this);
        buttonGet.addActionListener(this);
        buttonUse.addActionListener(this);
        buttonDrop.addActionListener(this);


        panel.setLayout(null);

        panel.add(buttonGameQuit);
        panel.add(buttonNorth);
        panel.add(buttonSouth);
        panel.add(buttonEast);
        panel.add(buttonWest);
        panel.add(buttonNorthEast);
        panel.add(buttonSouthEast);
        panel.add(buttonEastSouthEast);
        panel.add(buttonWestSouthWest);
        panel.add(buttonNorthWest);
        panel.add(buttonSouthWest);
        panel.add(buttonNorthNorthEast);
        panel.add(buttonNorthNorthWest);
        panel.add(buttonSouthSouthEast);
        panel.add(buttonSouthSouthWest);
        panel.add(buttonWestNorthWest);
        panel.add(buttonEastNorthEast);
        panel.add(buttonQuit);
        panel.add(buttonInventory);
        panel.add(buttonLook);
        panel.add(buttonGet);
        panel.add(buttonUse);
        panel.add(buttonDrop);
        panel.add(textArea);
        panel.add(textfieldGet);
        panel.add(textfieldDrop);
        panel.add(textfieldUse);

        add(panel);


        setSize(900, 500);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        setVisible(true);
    }

    @Override
    public Move getMove(Character character, Place place)
    {
        Place currentPlace = place;
        if (currentPlace.isExit())
            System.exit(1);


        currentPlace.display();
        if (first == 0)
        {
            textArea.append(place.getPlaceName() + "\n");
            textArea.append(place.getPlaceDescription());
            first = 1;

            if (place.artifactCounter >= 1)
            {
                textArea.append("\nFurthermore, you see the following items within the room:");
                for (Artifact artifact : place.artifacts)
                {
                    textArea.append(artifact.getName() + ": " + artifact.getDescription());
                }
            }
        }

        while (moveMade == false)
        {
            try
            {
                Thread.sleep(200);
            } catch (InterruptedException e)
            {
            }
        }
        textArea.setText("");
        if (move.getMoveType() != null)
        {
            if (move.getMoveType().toStrings() == "inventory")
            {
                for (int i = 0; i < character.artifacts.size(); i++)
                {
                    textArea.append("\nName" + character.artifacts.get(i).getName());
                    textArea.append("\nDescription" + character.artifacts.get(i).getDescription());
                    textArea.append("\nValue" + character.artifacts.get(i).getValue());
                    textArea.append("\nMobility" + character.artifacts.get(i).getMobility());
                    textArea.append("\nKeypattern" + character.artifacts.get(i).getKeyPattern() + "\n");
                }
            } else if (move.getMoveType().toStrings() == "get")
            {
                if (place.artifacts.contains(move.getString()))
                {
                    textArea.append("===========================================" +
                                    "You got the " + move.getString() + "!" +
                                    "===========================================");

                }
            } else if (move.getMoveType().toStrings() == "quit")
            {
                textArea.append("Thanks For Playing");
                character.active = 2;
            } else
            {
                textArea.append(place.getPlaceName() + "\n");
                textArea.append(place.getPlaceDescription());
                if (place.artifactCounter >= 1)
                {
                    textArea.append("\nFurthermore, you see the following items within the room:");
                    for (Artifact artifact : place.artifacts)
                    {
                        textArea.append(artifact.getName() + ": " + artifact.getDescription());
                    }
                }
            }
        }

        moveMade = false;

        Move nextMove = move;
        move = new Move(null, null);
        return nextMove;

    }

    public void actionPerformed(ActionEvent e)
    {
        if ("N".equals(e.getActionCommand()))
        {
            moveMade = true;
            move = new Move(MoveType.GO, "N");
        } else if ("S".equals(e.getActionCommand()))
        {
            moveMade = true;
            move = new Move(MoveType.GO, "S");
        } else if ("E".equals(e.getActionCommand()))
        {
            moveMade = true;
            move = new Move(MoveType.GO, "E");
        } else if ("W".equals(e.getActionCommand()))
        {
            moveMade = true;
            move = new Move(MoveType.GO, "W");
        } else if ("NE".equals(e.getActionCommand()))
        {
            moveMade = true;
            move = new Move(MoveType.GO, "NE");
        } else if ("SE".equals(e.getActionCommand()))
        {
            moveMade = true;
            move = new Move(MoveType.GO, "SE");
        } else if ("ESE".equals(e.getActionCommand()))
        {
            moveMade = true;
            move = new Move(MoveType.GO, "ESE");
        } else if ("WSW".equals(e.getActionCommand()))
        {
            moveMade = true;
            move = new Move(MoveType.GO, "WSW");
        } else if ("NW".equals(e.getActionCommand()))
        {
            moveMade = true;
            move = new Move(MoveType.GO, "NW");
        } else if ("SW".equals(e.getActionCommand()))
        {
            moveMade = true;
            move = new Move(MoveType.GO, "SW");
        } else if ("NNE".equals(e.getActionCommand()))
        {
            moveMade = true;
            move = new Move(MoveType.GO, "NNE");
        } else if ("NNW".equals(e.getActionCommand()))
        {
            moveMade = true;
            move = new Move(MoveType.GO, "NNW");
        } else if ("SSE".equals(e.getActionCommand()))
        {
            moveMade = true;
            move = new Move(MoveType.GO, "SSE");
        } else if ("SSW".equals(e.getActionCommand()))
        {
            moveMade = true;
            move = new Move(MoveType.GO, "SSW");
        } else if ("WNW".equals(e.getActionCommand()))
        {
            moveMade = true;
            move = new Move(MoveType.GO, "WNW");
        } else if ("ENE".equals(e.getActionCommand()))
        {
            moveMade = true;
            move = new Move(MoveType.GO, "ENE");
        } else if ("quit".equals(e.getActionCommand()))
        {
            moveMade = true;
            move = new Move(MoveType.QUIT, "quit");
        } else if ("inv".equals(e.getActionCommand()))
        {
            moveMade = true;
            move = new Move(MoveType.INVENTORY, "inv");
        } else if ("look".equals(e.getActionCommand()))
        {
            moveMade = true;
            move = new Move(MoveType.LOOK, "look");
        } else if ("get".equals(e.getActionCommand()))
        {
            moveMade = true;
            move = new Move(MoveType.GET, textfieldGet.getText());
        } else if ("use".equals(e.getActionCommand()))
        {
            moveMade = true;
            move = new Move(MoveType.USE, textfieldUse.getText());
        } else if ("drop".equals(e.getActionCommand()))
        {
            moveMade = true;
            move = new Move(MoveType.DROP, textfieldDrop.getText());
        } else if ("quitgame".equals((e.getActionCommand())))
        {
            System.exit(1);
        }
    }


}