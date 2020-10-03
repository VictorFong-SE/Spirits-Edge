JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
    AI.java \
    AiAnimal.java \
    Animal.java \
    Artifact.java \
    Sustenance.java \
    Character.java \
    CleanLineScanner.java \
    DarkRoom.java \
    DecisionMaker.java \
	Direction.java \
	DirType.java \
	Feces.java\
    Game.java \
    GameTester.java \
	Move.java \
	MoveType.java \
	MysteryRoom.java \
	NPC.java \
	Place.java \
	Player.java \
	UI.java \
	UI_MartinB.java \
	UI_TimC.java \
	UI_VictorF.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM)*.class
