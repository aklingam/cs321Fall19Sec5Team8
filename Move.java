//C style struct to hold moves, TODO: follow OOP standards
public Move {
	Position startPos;
	Position endPos;
	public Move(Position start, Position end) {
		this.startPos = startPos;
		this.endPos = endPos;
	}
}
