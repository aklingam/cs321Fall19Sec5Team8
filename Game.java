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
		if(m==null) {
			return false;
		}

		if(!board.checkStructuralMoveValidity(m)) {
			return false;
		}	


	
		//TODO: have to check structural validity and logical validity.
		//This also gets really complicated because we need to see whether or not this move would put the king in check.
		//My best guess is to copy the board and make the move and check whether any of the opponents pieces would capture the king in this alternate board. 
	}


	//Function to actually make the moves
	//Return codes:
	//0: normal move.
	//1: the move was a capture
	//2: the move was a castle
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
