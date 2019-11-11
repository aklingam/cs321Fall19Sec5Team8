public class Piece {
	PieceType pt;
	Boolean whitesPiece; //true for it being whites piece, false for being blacks piece, null for empty piece.
	public Piece(PieceType pt, Boolean whitesPiece) {
		this.pt = pt;
		this.whitesPiece = whitesPiece;
	}
}
