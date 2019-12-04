import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


/***************************************************************************
/  Code reuse and reference from:
/  https://forgetcode.com/Java/848-Chess-game-Swing
/
/
/  Chess piece art found from:
/  https://commons.wikimedia.org/wiki/File:Chess_Pieces_Sprite.svg
***************************************************************************/

public class ChessUI extends JFrame implements MouseListener, MouseMotionListener {
    JLayeredPane layeredPane;
    JPanel chessBoard;
    JLabel chessPiece;
    int xAdjustment;
    int yAdjustment;

    //File names
    String wPawn   = "./wPawn.png";
    String bPawn   = "./bPawn.png";
    String wCastle = "./wCastle.png";
    String bCastle = "./bCastle.png";
    String wKnight = "./wKnight.png";
    String bKnight = "./bKnight.png";
    String wBishop = "./wBishop.png";
    String bBishop = "./bBishop.png";
    String wQueen  = "./wQueen.png";
    String bQueen  = "./bQueen.png";
    String wKing   = "./wKing.png";
    String bKing   = "./bKing.png";


    
    

    public ChessUI(){
        Dimension boardSize = new Dimension(800, 800);

        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);


        chessBoard = new JPanel();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout( new GridLayout(8, 8) );
        chessBoard.setPreferredSize( boardSize );
        chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);

        for (int i = 0; i < 64; i++) {
            JPanel square = new JPanel( new BorderLayout() );
            chessBoard.add(square);


            //Color customizability can be added here
            if ((i / 8) % 2 == 0) 
                square.setBackground( i % 2 == 0 ? Color.white : Color.gray );
            else 
                square.setBackground( i % 2 == 0 ? Color.gray : Color.white );
            
        }


        //Setting Pieces
        //Kings
        setPiece(wKing, 60);
        setPiece(bKing, 4);

        //Queens
        setPiece(wQueen, 59);
        setPiece(bQueen, 3);

        //Bishops
        setPiece(wBishop, 58, 61);
        setPiece(bBishop, 2, 5);

        //Knights
        setPiece(wKnight, 57, 62);
        setPiece(bKnight, 1, 6);

        //Castles
        setPiece(wCastle, 56, 63);
        setPiece(bCastle, 0, 7);
        //Pawns
        for (int i = 8; i<16; i+=2) {
            setPiece(bPawn, i, i+1);
        }
        for (int i = 48; i<56; i+=2) {
            setPiece(wPawn, i, i+1);
        }

    }

    public void setPiece(String pieceName, int place) {
        JLabel piece = new JLabel( new ImageIcon(pieceName) );
        JPanel panel = (JPanel)chessBoard.getComponent(place);
        panel.add(piece);
    }
    //two pieces
    public void setPiece(String pieceName, int place, int place2) {
        JLabel piece = new JLabel( new ImageIcon(pieceName) );
        JPanel panel = (JPanel)chessBoard.getComponent(place);
        panel.add(piece);

        piece = new JLabel( new ImageIcon(pieceName) );
        panel = (JPanel)chessBoard.getComponent(place2);
        panel.add(piece);
    }


    public void mousePressed(MouseEvent e){
        chessPiece = null;
        Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
        
        if (c instanceof JPanel) {
            System.out.println("Clicked " + c.getX() + " "+ c.getY()); 
            return;
        }
        Point parentLocation = c.getParent().getLocation();
        xAdjustment = parentLocation.x - e.getX();
        yAdjustment = parentLocation.y - e.getY();
        chessPiece = (JLabel)c;
        chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
        chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
        layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
    }
    public void mouseDragged(MouseEvent me) {
        if (chessPiece == null) { return; }
        chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
    }


  public void mouseReleased(MouseEvent e) {
      if(chessPiece == null) return;
      chessPiece.setVisible(false);
      Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
      
      if (c instanceof JLabel){
          Container parent = c.getParent();
          parent.remove(0);
          parent.add(chessPiece);
      } else {
      Container parent = (Container)c;
      parent.add(chessPiece);
    }
 
  chessPiece.setVisible(true);
  }
 
  public void mouseClicked(MouseEvent e) {
  
  }
  public void mouseMoved(MouseEvent e) {
    
  }
  public void mouseEntered(MouseEvent e){
  
  }
  public void mouseExited(MouseEvent e) {
  
  }
 
  public static void main(String[] args) {
  JFrame frame = new ChessUI();
  frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
  frame.pack();
  frame.setResizable(true);
  frame.setLocationRelativeTo( null );
  frame.setVisible(true);
 }
}
