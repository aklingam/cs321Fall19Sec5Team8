//C style struct to hold moves, TODO: follow OOP standards
public class Move {
	Position startPos;
	Position endPos;
	public Move(Position start, Position end) { //Castling will be a move of the king to a space more than 1 space away. 
		this.startPos = startPos;
		this.endPos = endPos;
	}
}
