=============================================================================================================================
//Tim Czepizak tczepi2
//Martin Bragiel mbragi2
//Victor Fong vfong3
//Code for CS342 Homework
//Professor Bell
//Read Me
============================================================================================================================

New Features (HW5)

Added GUI's that are used when playing the game (UI_MartinB, UI_TimC, UI_VictorF)
Changed the Game class to utilize the GUI's
Changed the Character class to utilize the GUI's
Changed the GameTester class to utilize the GUI's
Changed the UI class to utilize the GUI's


New Features (HW4)

Added Animal Character that runs around and does daily task
Added AnimalAi
Added Darkroom that teleports you to a random location
Added "Daily activity"
Added Mystery room which deletes your inventory
Added More Support for NPC
Added support to Place class for additional rooms
Added additional UI

Victor Fong:
*GameTester class additions and modifications
*Artifact improvements (some changes made to other classes to reflect this)
*Artifact diversification - Food to implement hunger and healing, weapons to eventually attack
*optimization of getMove,makeMove and a bugfix of get,pick up,grab
*creation of other types of artifacts (Sustenance, used to heal, eventually fill hunger)
*other stuff

USE GDF-4.0_MysticCity.gdf for legacy
USE GDF_Custom.gdf for generic
USE GDF_Custom_Experimental.gdf to view sustenance items

===============================================================================================================================

Description

This is a group of files for the HW5 of John Bell's CS342 Class.

============================================================================================================================
How to give Input - THIS GAME SUPPORTS ALL THE DIRECTIONS AS WELL AS USE, DROP, LOOK, AND GET

1. Command line arguments such as n, N, north, North, NORTH, or any other capitalization of the word. This will send
you to the direction stated if this is possible.
Ex: if you can go North and you put North you will be sent to a new Place.


2. Command line Arguments consisting of "quit" or "exit" or any capitalization of the two. This Terminates the program

3. Command Line Argument of "look". This simply just restates the current place and current description.

4. Get Picks Up the object that you specify

5. Inventory allows you to see what your player is carrying

6. Use Allows a player to use an item

7. Number 1 does not get utilized anymore because of the implemented GUI's

8. Each GUI gets randomly chosen when being played

9. Tim's GUI: Has a bunch of buttons that allow you to press them and move in each direction, look and inventory buttons,
as well as a get, drop, and use button alongside a textbox where you can input the name of things. Also has a screen that
displays the game as well as a large quit button that quits the game.

10. Martin's GUI: Has has a screen that displays the game as well as a large quit button that quits the game. Also has
buttons for the inventory and look functionality as well as a drop down menu that has selections for go, get, drop, and 
use next to a textbox that allows you input what you want to do. Scroll features do not work as intended.

============================================================================================================================
To Create Game Files, Use the make command in the folder with the makefile and java files
To Run Game. Type java GameTester after you have typed make
=============================================================================================================================

New Features	2.0
Added Enum
Artifacts- These Artifacts are tested and are in the right locations however and do work

Added functionality to load files.

=============================================================================================================================

Problems
No Nowhere Place, You can pick up very large objects

=============================================================================================================================

New Features 3.0
Added MoveType Enum to make moves
Added the following classes
AI
Character
CleanLineScanner
DecisionMaker (Interface)
Move
NPC
Player
UI

With these new classes we have new features like
-Multiplayer support
-NPCS
-Easy improvement for future add-ons

==============================================================================================================================


New Features (HW4)

Added Animal Character that runs around and does daily task
Added AnimalAi
Added Darkroom that teleports you to a random location
Added "Daily activity"
Added Mystery room which deletes your inventory
Added More Support for NPC
Added support to Place class for additional rooms
Added additional UI

Victor:
*GameTester class additions and modifications
*Artifact improvements (some changes made to other classes to reflect this)
*Artifact diversification - Food to implement hunger and healing, weapons to eventually attack
*optimization of getMove,makeMove and a bugfix of get,pick up,grab



===============================================================================================================================