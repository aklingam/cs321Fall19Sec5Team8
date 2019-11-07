import java.util.*;
public class Board {
	
	public Piece[8][8] boardState; //Empty is also considered a piece, so we get to hold explicit references to all 64 places.

	public Board() {
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				boardState[i][j] = new Piece(PieceType.EMPTY);		
			}
		}	
	}
	public Piece getPieceFromPosition(Position p) {
		return boardState[p.row][p.col];	
	}
	public void populatePieces() {
			//TODO: default board layout for a new game. 
	}

	//Checks STRUCTURAL ( not the logical ) validity of transfering a piece from tile a to tile b. Cases as following
	//1. null checking everything
	//2. checking bounds of the moves position values.
	public boolean checkStrucutralMoveValidity(Move m) {
		if(m.startPos==null||m.endPos==null) { return false; }
		if(m.startPos.row<0||m.startPos.col>7||m.endPos<0||m.endPos>7) { return false; }
		Piece start = getPieceFromPosition(m.startPos);
		Piece end = getPieceFromPosition(m.endPos);
		if(start.PieceType==EMPTY) { return false; }
        if(start.whitePiece==end.whitePiece) { return false; } 

	}

	public boolean validMovePawn(Move m)   { return false; }
	public boolean validMoveRook(Move m)   { return false; }
	public boolean validMoveKnight(Move m) { return false; }
	public boolean validMoveBishop(Move m) { return false; }
	public boolean validMoveKing(Move m, boolean castled)   { return false; }
	public boolean validMoveQueen(Move m)  { return false; }


 
}
