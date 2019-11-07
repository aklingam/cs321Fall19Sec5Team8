//Driver class for the chess game. 
public class Game {
    boolean whitesTurn,whiteInCheck,blackInCheck, whiteCastled, blackCastled;
	int movesPlayedWithoutCapture; //30 moves without capture is an automatic draw
	Board board;	
	public Game() {
		whitesTurn = 1;
		movesPlayedWithoutCapture = 0;
		board = new Board();
	}
	public Game(File gamefile) {
		//TODO: using serializable is likely to be the best option.
	}
	public boolean validMove(Move m) {
		//SANITY CHECKS
		if(m==null) { return false; }
		board.checkStructuralMoveValidity(m);
		Piece p = getPieceFromPosition(m.startPos); //obtaining our reference
		if(whitesTurn!=p.whitePiece) { return false; }
		//END SANITY CHECKS
		switch(p.pieceType) {
			case PAWN:   return board.validMovePawn(m);   break;
			case ROOK:   return board.validMoveRook(m);   break;
			case KNIGHT: return board.validMoveKnight(m); break;
			case BISHOP: return board.validMoveBishop(m); break;
			case QUEEN:  return board.validMoveQueen(m);  break;
			case KING:   
				if(whitesTurn) {
					return board.validMoveKing(m,whiteCastled);	
				} else {
					return board.validMoveKing(m,blackCastled);   
				}
				break;
			default: 
				//Something seriously messed up here!
		}	
	}





	//Function to actually make the moves
	//Return codes:
	//0: normal move.
	//1: the move was a capture
	//2: the move was a castle
	//3: the move was a pawn promotion
	//... or something alone those lines, havent gotten to it yet
	public int makeMove() {


	}

	public static void main() {
		Game game = new Game();
		do { 
			Move m;
			do {
				m = IO.obtainMove();	
			}while(!validMove(m));
		int moveCode = makeMove(m);
		//TODO: situational handling of things like: we need to change if white has castled if the makeMove returned a castle.
		}while(victor()!=-1 && game.movesPlayedWithoutCapture<30);
		if(victor()==-1) {
			//TODO: Exit handling on draw.
		}
		//TODO: exit handling on win	
	}



	//returns the victor of the game, -1 = no victor yet, 0 = white, 1 = black.
	public int victor() {
		
		//TODO: //check is the person who would like to move has any valid moves at all, if the king is in check, they lose, if the king is not in check, its a draw.
		return -1;
	}


}
