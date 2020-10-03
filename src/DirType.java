//Tim Czepizak tczepi2
//Martin Bragiel mbragi2
//Victor Fong vfong3

//Code for CS342 Homework
//Professor Bell
//Class : DirType
public enum DirType {

	// all of the enumerated directions
	
	NORTH("North", "N"),
	SOUTH("South", "S"),
	EAST("East", "E"),
	WEST("West", "W"),
	UP("Up", "U"),
	DOWN("Down", "D"),
	NORTHEAST("Northeast", "NE"),
	NORTHWEST("Northwest", "NW"),
	SOUTHEAST("Southeast", "SE"),
	SOUTHWEST("Southwest", "SW"),
	NORTHNORTHEAST("North-Northeast", "NNE"),
	NORTHNORTHWEST("North-Northwest", "NNW"),
	EASTNORTHEAST("East-Northeast", "ENE"),
	WESTNORTHWEST("West-Northwest", "WNW"),
	EASTSOUTHEAST("East-Southeast", "ESE"),
	WESTSOUTHWEST("West-Southwest", "WSW"),
	SOUTHSOUTHEAST("South-Southeast", "SSE"),
	SOUTHSOUTHWEST("South-Southwest", "SSW"),
	NONE("None", "None");
	private String text;
	private String abbreviation;
	
	DirType(String text, String abbreviation) {
		this.text = text;
		this.abbreviation = abbreviation;
	}
	
	public String toString() {
		return this.text;
	}
	
	public boolean match(String s) { // matches the direction chosen by the user
		if(s.equalsIgnoreCase(text) || s.equalsIgnoreCase(abbreviation))
			return true;
		else
			return false;
	}
}
