//TODO: Follow OOP standards
public class Position {
	int row,col;
	public Position(int r, int c) {
		this.row = row;
		this.col = col;
		//TODO: Error check for position instantiation where r or c is less than 0 or more than 8
	}
	public static Position parsePosition(String s) {
		if(s.length()>!=2) { return null; }
		String copy = s.toUpperCase();
		if(copy[0] < 'A' || copy[0] > 'H') { return null; }
		if(copy[1] < '0' || copy[0] > '8') { return null; }
		Position p = new Position(copy[0]-64,copy[1]-47);	
	}
}
