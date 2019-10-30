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
	public void populatePieces() {
			//TODO: default board layout for a new game. 
	}

	//Checks STRUCTURAL ( not the logical ) validity of transfering a piece from tile a to tile b. Codes as following:
	//0: valid move ( endTile empty )
	//1: valid move ( endTile piece color != startTile piece color ) 
	//2: invalid move ( endTile piece color = startTile piece color ) 
	//3: invalid move ( startTile Has no piece )
	public boolean checkStrucutralMoveValidity(Move m) {
		//TODO
	}



 
}
