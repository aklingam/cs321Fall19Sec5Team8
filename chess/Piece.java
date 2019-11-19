public class Piece {
	PieceType pt;
	Boolean whitesPiece; //true for it being whites piece, false for being blacks piece, null for empty piece.
	public Piece(PieceType pt, Boolean whitesPiece) {
		this.pt = pt;
		this.whitesPiece = whitesPiece;
	}
	//returns the piece's letter, according to FEN nomenclature
	public String PieceLetter() {
		String s = "";
		switch(p.pt) {
			case EMPTY:  s = "-"; break;
			case PAWN:   s = p.whitesPiece.booleanValue() ? ("P") : ("p"); break;
			case ROOK:   s = p.whitesPiece.booleanValue() ? ("R") : ("r"); break;
			case KNIGHT: s = p.whitesPiece.booleanValue() ? ("N") : ("n"); break; 
			case BISHOP: s = p.whitesPiece.booleanValue() ? ("B") : ("b"); break;
			case KING:   s = p.whitesPiece.booleanValue() ? ("K") : ("k"); break;
			case QUEEN:  s = p.whitesPiece.booleanValue() ? ("Q") : ("q"); break;	
		}
		return s;
	}
	
}
