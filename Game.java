//Driver class for the chess game. 
import java.util.*;
public class Game {
    boolean whitesTurn,whiteInCheck,blackInCheck, whiteCastleKing, whiteCastleQueen, blackCastleKing, blackCastleQueen, gameSaved;
	int movesPlayedWithoutCapture; //30 moves without capture is an automatic draw
	int moveCount;
	Board board;	
	public Game() {
		whitesTurn = true;
		whiteCastleKing = true;
		whiteCastleQueen = true;
		blackCastleKing = true;
		blackCastleQueen = true;
		gameSaved = true;
		movesPlayedWithoutCapture = 0;
		moveCount = 0;
		board = new Board();
	}
	public Game(String FENString) {
		StringTokenizer st = new StringTokenizer(" ");
		String pieces = st.nextToken(); 
		String turn = st.nextToken();
		String castleAvail = st.nextToken();
		st.nextToken(); //In this rep we are not doing enpassant, so we are just throwing that token out.
		movesPlayedWithoutCapture = Integer.parseInt(st.nextToken());
		moveCount = st.nextToken();
	}
	public void stockfishInit() {

	}
	public boolean validMove(Move m) {
		//SANITY CHECKS
		if(m==null) { return false; }
		board.checkStructuralMoveValidity(m);
		Piece p = board.getPieceFromPosition(m.startPos); //obtaining our reference
		if(whitesTurn!=p.whitesPiece) { return false; }
		//END SANITY CHECKS
		return true;
	}



	//returns an FEN string of the game state for use with the stockfish api.
	public String FENString() {
		Stringbuilder sb = board.boardFENString();
		String turn = whitesTurn ? " w " : " b "; //the space is needed, dont remove.
		sb.append(turn);
		String castling = "";
		if(whiteCastleKing)  { castling+="K" }	
		if(whiteCastleQueen) { castling+="Q" }	
		if(blackCastleKing)  { castling+="k" }	
		if(blackCastleQueen) { castling+="q" }	
		if(castling.equals("") { castling = "-"; }	
		sb.append(castling);
		sb.append(" -");
		sb.append(" " + movesPlayedWithoutCapture);
		sb.append(" " + moveCount);
		return sb.toString();		
	}

	//Function to actually make the moves
	//Return codes:
	//0: normal move.
	//1: the move was a capture
	//2: the move was a castle
	//3: the move was a pawn promotion
	//... or something alone those lines, havent gotten to it yet
	public int makeMove(Move m) {
		gameSaved = false;
		board.boardState[m.endPos.row][m.endPos.col] = board.boardState[m.startPos.row][m.startPos.col]; //Put the start pieces data in the end pieces spot.
		board.boardState[m.startPos.row][m.startPos.col] = new Piece(PieceType.EMPTY,null);	

	}
	public static void main(String[] args) {
		Game game;
		if(args.length == 1) { //if a runtime arg file was provided, try to open it and turn it into a game.
			try {
				game = new Game(new Scanner(new FileReader(args[0])).nextLine());			
			} catch(Exception e) { //TODO, handle telling user how they messed up}
		} else {
			game = new Game();
		}
		Scanner sc = new Scanner(System.in);
		while(1) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			switch(st.nextToken().toLower()) {
				case "move": 			
					Move m = new Move( parsePosition(st.nextToken()) , 
									   parsePosition(st.nextToken()) );
					if(validMove(m)) { 
						makeMove(m); 
					} else {
						System.out.println("Invalid move try again");
					}
					if(victor()!=-1) { } //TODO: handle output on someone winning
					break;
				case "save":
					if(gameSaved) {
						break; 
					}	
					String s = 	FENString();	
					//TODO: write to file
					//if user supplied another arg try to save to a file named what they passed, otherwise save over the file they loaded if there is one, and if there isnt one, fail to save and prompt for a file name.	
				case "load":
					if(!st.hasNextToken()) {
						System.out.println("Usage: load filename");
						break;
					}
					String file = st.nextToken(); //Half of this stuff needs to be wrapped in try catches or checked
					String force = st.nextToken();	
					if(!gameSaved) {
						if(force!=null || !force.equals("force")) {
							
						} else {
							System.out.println("Game is not saved, type load -filename- force if you wish to ignore this
						}
					}	
				case "voice": 
					//TODO: wrap in voice control.
					Move m; //m would be gotten from some kind of function
					if(validMove(m)) { 
						makeMove(m); 
					} else {
						System.out.println("Invalid move try again");
					}
					if(victor()!=-1) { } //TODO: handle output on someone winning
					break;	
				case "exit":
					//TODO: similar functionality to load, in that if the user has not saved we prompt and ignore the request, but if the user types force afterwards, we do it anyways.
					System.exit(0); 
			}
		}		
	
	}


	//returns the victor of the game, -1 = no victor yet, 0 = white, 1 = black.
	public int victor() {
		
		//TODO: //check is the person who would like to move has any valid moves at all, if the king is in check, they lose, if the king is not in check, its a draw.
		return -1;
	}


}
