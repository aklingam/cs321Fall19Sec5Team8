//Driver class for the chess game. 
public class Game {
    boolean whitesTurn,whiteInCheck,blackInCheck;
	int movesPlayedWithoutCapture; //30 moves without capture is an automatic draw
	
	public Game() {
		whitesTurn = 1;
		movesPlayedWithoutCapture = 0;
	}
	public Game(File gamefile) {
		//TODO: using serializable is likely to be the best option.
	}
	public boolean validMove(Move m) {
		if(m.	
	
		//TODO: have to check structural validity and logical validity.
		//This also gets really complicated because we need to see whether or not this move would put the king in check.
		//My best guess is to copy the board and make the move and check whether any of the opponents pieces would capture the king in this alternate board. 
	}

	public int move() {


	}

	public static void main() {
		Game game = new Game();
		do { 
		
			while(!validMove(Position startPos, Position endPos)) {
				obtainMove(int source);
			}	



		while(victor()!=-1 && game.movesPlayedWithoutCapture<30);
	}




	//returns the victor of the game, -1 = no victor yet, 0 = draw, 1 = white, 2 = black.
	public int victor() {
		
		//TODO: //check is the person who would like to move has any valid moves at all, if the king is in check, they lose, if the king is not in check, its a draw.
		return -1;
	}


}
