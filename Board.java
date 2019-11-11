import java.util.*;
public class Board {
	Piece[][] boardState;; //Empty is also considered a piece, so we get to hold explicit references to all 64 places.
	public Board() {
		boardState = new Piece[8][8];
		for(int i = 0; i<8; i++) { //I suppose i can skip the 4 rows where pieces are generated but whatever.
			for(int j = 0; j<8; j++) {
				boardState[i][j] = new Piece(PieceType.EMPTY, null);		
			}
		}	
		populatePieces();
	}
	public Piece getPieceFromPosition(Position p) {
		return boardState[p.row][p.col];	
	}
	public void populatePieces() {
		for(int i = 0; i<8; i++) {
			boardState[1][i] = new Piece(PieceType.PAWN, new Boolean(false)); 
			boardState[6][i] = new Piece(PieceType.PAWN, new Boolean(true));
		}	
		//ROOKS
		boardState[0][0] = new Piece(PieceType.ROOK, new Boolean(false));	
		boardState[0][7] = new Piece(PieceType.ROOK, new Boolean(false));	
		boardState[7][0] = new Piece(PieceType.ROOK, new Boolean(true));	
		boardState[7][7] = new Piece(PieceType.ROOK, new Boolean(true));		
		//ROOKS
		//KNIGHTS
		boardState[0][1] = new Piece(PieceType.KNIGHT, new Boolean(false));	
		boardState[0][6] = new Piece(PieceType.KNIGHT, new Boolean(false));	
		boardState[7][1] = new Piece(PieceType.KNIGHT, new Boolean(true));	
		boardState[7][6] = new Piece(PieceType.KNIGHT, new Boolean(true));	
		//KNIGHTS
		//BISHOPS
		boardState[0][2] = new Piece(PieceType.BISHOP, new Boolean(false));	
		boardState[0][5] = new Piece(PieceType.BISHOP, new Boolean(false));	
		boardState[7][2] = new Piece(PieceType.BISHOP, new Boolean(true));	
		boardState[7][5] = new Piece(PieceType.BISHOP, new Boolean(true));	
		//BISHOPS
		//QUEENS
		boardState[0][3] = new Piece(PieceType.QUEEN, new Boolean(false));	
		boardState[7][3] = new Piece(PieceType.QUEEN, new Boolean(true));	
		//QUEENS
		//KINGS
		boardState[0][4] = new Piece(PieceType.KING, new Boolean(false));	
		boardState[7][4] = new Piece(PieceType.KING, new Boolean(true));	
			
	}

	//Checks STRUCTURAL ( not the logical ) validity of transfering a piece from tile a to tile b. Cases as following
	//1. null checking everything
	//2. checking bounds of the moves position values.
	public boolean checkStructuralMoveValidity(Move m) {
		if(m.startPos==null||m.endPos==null) { return false; }
		if((m.startPos.row<0)||(m.startPos.col>7)||(m.endPos.row<0)||(m.endPos.col>7)) { return false; }
		Piece start = getPieceFromPosition(m.startPos);
		Piece end = getPieceFromPosition(m.endPos);
		if(start.pt==PieceType.EMPTY) { return false; }
        if(start.whitesPiece==end.whitesPiece) { return false; } 
		return true;
	}
	public void printBoard() {
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				String s = ""; //We never print the "", just need it so compiler will shut up about uninstantiated values
				Piece p = boardState[i][j];
				switch(p.pt) {
					case EMPTY:  s = "-"; break;
					case PAWN:   s = p.whitesPiece.booleanValue() ? ("P") : ("p"); break;
					case ROOK:   s = p.whitesPiece.booleanValue() ? ("R") : ("r"); break;
					case KNIGHT: s = p.whitesPiece.booleanValue() ? ("N") : ("n"); break; //Standard nomenclature gives king k, so knight gets n
					case BISHOP: s = p.whitesPiece.booleanValue() ? ("B") : ("b"); break;
					case KING:   s = p.whitesPiece.booleanValue() ? ("K") : ("k"); break;
					case QUEEN:  s = p.whitesPiece.booleanValue() ? ("Q") : ("q"); break;	
				}
				System.out.print(s);
			}
			System.out.println();
		}
	}

	public boolean validMovePawn(Move m)   { return true; }
	public boolean validMoveRook(Move m)   { return true; }
	public boolean validMoveKnight(Move m) { return true; }
	public boolean validMoveBishop(Move m) { return true; }
	public boolean validMoveKing(Move m, boolean castled)   { return true; }
	public boolean validMoveQueen(Move m)  { return true; }
	
	public static void main(String[] args) { //TESTING function to see if ive made things work so far
		new Board().printBoard();
	}
 
}
