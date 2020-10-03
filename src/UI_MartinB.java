//Tim Czepizak tczepi2
//Martin Bragiel mbragi2
//Victor Fong vfong3

//Code for CS342 Homework
//Professor Bell
//Class : UI_MartinB
//This Class implements the User Interface of the program for each player. Created by Martin


import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.io.OutputStream;
import javax.swing.*;

public class UI_MartinB extends UI implements ActionListener{

    JPanel p = new JPanel();
    JButton enterButton = new JButton("Enter"); //1
    JButton quitButton = new JButton("QUIT");
    JTextArea textArea = new JTextArea(5,20);
    JScrollPane scroller = new JScrollPane(textArea);

    JTextField getTextField = new JTextField();
    private String n[] = new String[4];
    JComboBox comboBox = new JComboBox();
    JButton invButton = new JButton("INV");
    JButton lookButton = new JButton("LOOK");
    JButton quitGame = new JButton("QUIT GAME");

    private boolean boolMove = false;
    private Move move = new Move(null, null);

    private int first = 0;

    @Override
    public Move getMove(Character c, Place p){
        Place currentPlace = p;
        if (currentPlace.isExit())
            System.exit(1);




        currentPlace.display();
        if(first == 0) {
            textArea.append(p.getPlaceName()+ "\n");
            textArea.append(p.getPlaceDescription());
            first = 1;

            if(p.artifactCounter >= 1){
                textArea.append("\nFurthermore, you see the following items within the room:");
                for (Artifact artifact : p.artifacts){
                    textArea.append(artifact.getName() + ": " + artifact.getDescription());
                }
            }
        }
        while(boolMove == false){
            try {
                Thread.sleep(200);
            } catch(InterruptedException e) {
            }
        }
        textArea.setText("");
        if(move.getMoveType() != null) {



            if (move.getMoveType().toStrings() == "inventory") {
                for (int i = 0; i < c.artifacts.size(); i++) {
                    textArea.append("\nName: " + c.artifacts.get(i).getName());
                    textArea.append("\nDescription: " + c.artifacts.get(i).getDescription());
                    textArea.append("\nValue: " + c.artifacts.get(i).getValue());
                    textArea.append("\nMobility: " + c.artifacts.get(i).getMobility());
                    textArea.append("\nKeypattern: " + c.artifacts.get(i).getKeyPattern() + "\n");
                }
            }
            else if (move.getMoveType().toStrings() == "get") {
                if(p.artifacts.contains(move.getString())) {


                    textArea.append("===========================================" +
                            "You got the " + move.getString() + "!" +
                            "===========================================");

                }
            }
            else if(move.getMoveType().toStrings() == "quit"){
                textArea.append("Thanks For Playing");
                c.active = 2;
            }
            else {
                textArea.append(p.getPlaceName()+ "\n");
                textArea.append(p.getPlaceDescription());
                if(p.artifactCounter >= 1){
                    textArea.append("\nFurthermore, you see the following items within the room:");
                    for (Artifact artifact : p.artifacts){
                        textArea.append(artifact.getName() + ": " + artifact.getDescription());
                    }
                }
            }
        }

        boolMove = false;

        Move nextMove = move;
        move = new Move(null,null);
        return nextMove;

    }

    /*@Override
    public Move getMove(Character c, Place panel){
        Place currentPlace = panel;
        if (currentPlace.isExit())
            System.exit(1);
        currentPlace.display();
        if(move.getMoveType() != null) {
            if (move.getMoveType().toStrings() == "inventory") {
                for (int i = 0; i < c.artifacts.size(); i++) {
                    textArea.append("\nName" + c.artifacts.get(i).getName());
                    textArea.append("\nDescription" + c.artifacts.get(i).getDescription());
                    textArea.append("\nValue" + c.artifacts.get(i).getValue());
                    textArea.append("\nMobility" + c.artifacts.get(i).getMobility());
                    textArea.append("\nKeypattern" + c.artifacts.get(i).getKeyPattern());
                }
            }
        }
       //textArea.setText("");
        textArea.append(panel.getPlaceName()+ "\n");
        textArea.append(panel.getPlaceDescription());
        if(panel.artifactCounter > 1){
            textArea.append("\nFurthermore, you see the following items within the room:");
            for (Artifact artifact : panel.artifacts){
                textArea.append(artifact.getName() + ": " + artifact.getDescription());
            }
        }


        while(boolMove == false){
            try {
                Thread.sleep(200);
            } catch(InterruptedException e) {
            }
        }
        boolMove = false;


        Move nextMove = move;
        move = new Move(null,null);
        return nextMove;

    }*/

    public void actionPerformed(ActionEvent e){

        if("quit".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.QUIT, "quit");
        }
        else if("inv".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.INVENTORY, "inv");
        }
        else if("look".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.LOOK, "look");
        }
        else if("enter".equals(e.getActionCommand())){
            if("Get".equals(n[comboBox.getSelectedIndex()])){
                boolMove = true;

                move = new Move(MoveType.GET, getTextField.getText());
            }
            else if("Use".equals(n[comboBox.getSelectedIndex()])){
                boolMove = true;

                move = new Move(MoveType.USE, getTextField.getText());
            }
            else if("Drop".equals(n[comboBox.getSelectedIndex()])){
                boolMove = true;
                move = new Move(MoveType.DROP, getTextField.getText());
            }
            else if("Go".equals(n[comboBox.getSelectedIndex()])){
                boolMove = true;
                move = new Move(MoveType.GO, getTextField.getText());
            }
            else if("quitgame".equals((e.getActionCommand()))){
                System.exit(1);
            }
        }

    }

    public UI_MartinB (){
        super();
        n[0] = "Get";
        n[1] = "Use";
        n[2] = "Drop";
        n[3] = "Go";

        textArea.setBounds(0,0,480,200);
        textArea.setLineWrap(true);

        comboBox.setBounds(520,220,70,25);
        comboBox.addItem(n[0]);
        comboBox.addItem(n[1]);
        comboBox.addItem(n[2]);
        comboBox.addItem(n[3]);

        getTextField.setBounds(590,220,180,25);

        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setBounds(480,0,20,200);

        quitGame.setBounds(580,25,150,25);
        enterButton.setBounds(770, 220 , 100 , 25);
        quitButton.setBounds(550,50,300,60);
        invButton.setBounds(300,220,75,25);
        lookButton.setBounds(300,245,75,25);

/*
        buttonNorth
        buttonSouth
        buttonEast
        buttonWest
        buttonNorthEast
        buttonSouthEast
        buttonEastSouthEast
        buttonWestSouthWest
        buttonNorthWest
        buttonSouthWest
        buttonNorthNorthEast
        buttonNorthNorthWest
        buttonSouthSouthEast
        buttonSouthSouthWest
        buttonWestNorthWest
        buttonEastNorthEast
        buttonQuit
        buttonInventory
        buttonLook
        buttonGet
        buttonUse
        buttonDrop

        */

        quitGame.setActionCommand("quitgame");
        quitButton.setActionCommand("quit");
        invButton.setActionCommand("inv");
        lookButton.setActionCommand("look");
        enterButton.setActionCommand("enter");

        quitGame.addActionListener(this);
        quitButton.addActionListener(this);
        invButton.addActionListener(this);
        lookButton.addActionListener(this);
        enterButton.addActionListener(this);


        p.setLayout(null);
        p.add(quitGame);
        p.add(enterButton);
        p.add(comboBox);
        p.add(quitButton);
        p.add(invButton);
        p.add(lookButton);
        p.add(scroller);

        p.add(textArea);
        p.add(getTextField);

        add(p);


        setSize(900,400);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        // panel.setLayout(new GridLayout(9,8));
       /* buttonNorth.setLocation(100,1);
        buttonSouth.setLocation(2,2);
        buttonEast.setLocation(3,3);
        buttonWest.setLocation(4,4);
        */

        setVisible(true);

    }

}
