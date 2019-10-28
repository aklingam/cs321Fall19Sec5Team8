//TODO: Follow OOP standards of private vars with getters and setters, ATM this is operating as a c style struct.
import java.util.*;
public class Tile {
	Position pos;
	Piece piece;
	public Tile(Position pos, Piece piece) {
		this.pos = pos;
		this.piece = piece;
	}

	
	//Checks STRUCTURAL ( not the logical )validity of transfering a piece from tile a to tile b. Codes as following:
	//0: valid move ( endTile empty )
	//1: valid move ( endTile piece color != startTile piece color ) 
	//2: invalid move ( endTile piece color = startTile piece color ) 
	//3: invalid move ( startTile Has no piece )
	//NOTE: This should ONLY be called if the move has already been checked for being 
	public static int checkMoveStructuralValidity(Tile endTile) {	
		//TODO
	}
	
}
