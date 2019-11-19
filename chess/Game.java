//Driver class for the chess game. 
import java.util.*;
import java.io.*;
public class Game {
    boolean whitesTurn, gameSaved;
	int moveCount;
	Board board;	
	public Game() {
		whitesTurn = true;
		gameSaved = true; //we wont bother telling the user they havent saved on a new game.
		movesPlayedWithoutCapture = 0;
		moveCount = 0;
		board = new Board();
	}
	public Game(String data) {
		StringTokenizer st = new StringTokenizer(data," ");
		String pieces = st.nextToken(); 
		String turn = st.nextToken();
		moveCount = Integer.parseInt(st.nextToken());
		whitesTurn = turn.equals("w") ? true : false;
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



	//returns a simplified FEN string to load into file..
	public String FENString() {
		Stringbuilder sb = board.boardFENString();
		String turn = whitesTurn ? " w " : " b "; //the space is needed, dont remove.
		sb.append(turn);
		return sb.toString();		
	}

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
			StringTokenizer st = new StringTokenizer(sc.nextLine()," ");
			ArrayList<String> tokens = new ArrayList<String>();
			while(st.hasNextToken()) { tokens.add(st.nextToken()); }		
			if(tokens.size()==0) { break; }
			switch(tokens.get(0)) { 
				case "move": 
					//TODO: check if the move is valid with valid move, and if valid, use makemove.
					//TODO: also set the game saved boolean to false.
					if (tokens.size() != 3) {
						System.out.println("There must be 3 arguments: \"move\" (which implies that it is a command to move a piece), starting postition, and ending position");
						break;
					}
					Postion start = tokens.get(1);
					Postion end = tokens.get(2);
					Move m = new Move(start, end);
					if (validMove(m)) {
						makeMove(m);
					}
					gameSaved = false;
					break;
				case "save":
					//TODO: write to file by calling FEN string, and writing result to file
					//ALSO update the gamesaved boolean.
					//if user supplied another arg try to save to a file named what they passed, otherwise save over the file they loaded if there is one, and if there isnt one, fail to save and prompt for a file name.
					if (gameSaved == true) {
						System.out.println("File has already been saved.");
						break;
					}
					if (tokens.get(1) == null) {
						System.out.println("This argument cannot be empty, you must pass a file name (without \".txt\" extension).");
						break;
					}
					else {
						try {
							File file = new File(tokens.get(1) + ".txt");
							FileWriter fileWriter = new FileWriter(file);
							fileWriter.write(FENString());
							fileWriter.flush();
							fileWriter.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					gameSaved = true;
					break;	
				case "load":
					//TODO: if the user has not saved, tell them to use load -filename- -force to override this
					//otherwise if they typed force or if they have saved the game, load the filename
					if (tokens.size() < 2) {
						System.out.println("You must include the name of a file as an argument (without \".txt\" extension).");
						break;
					}
					if (gameSaved == false || ( !tokens.contains("force") && !tokens.contains("load") )) {
						System.out.println("Error. Please save the game or use command \"load -filename- -force\" instead to load without saving.");
						break;
					}
					else {
						InputStream inputStream = Game.class.getResourceAsStream(tokens.get(1) + ".txt");
					}
					break;
				case "exit":
					//TODO: similar functionality to load, in that if the user has not saved we prompt and ignore the request, but if the user types force afterwards, we do it anyways.
					if (gameSaved = false || !tokens.contains("force")) {
						System.out.println("Error. You must save your game or use command \"exit -force\" instead to close without saving.");
						break;
					}
					System.exit(0);
				break; 
			}
		}		
	
	}

}
