package Chess;
import static Chess.Notation.notationToArray;
import java.util.Scanner;

public class Board {
    private Piece[][] _board;
    private Scanner _scanner = new Scanner(System.in);

    public Board(){
       _board = new Piece[8][8];
       setUpBoard();
    }

    private void setUpBoard(){
        Piece[] whiteBackRank = new Piece[]{
                new Rook(Color.WHITE), new Knight(Color.WHITE),
                new Bishop(Color.WHITE), new Queen(Color.WHITE),
                new King(Color.WHITE), new Bishop(Color.WHITE),
                new Knight(Color.WHITE), new Rook(Color.WHITE)
        };

        Piece[] blackBackRank = new Piece[]{
                new Rook(Color.BLACK), new Knight(Color.BLACK),
                new Bishop(Color.BLACK), new Queen(Color.BLACK),
                new King(Color.BLACK), new Bishop(Color.BLACK),
                new Knight(Color.BLACK), new Rook(Color.BLACK)
        };

        for (int col = 0;col < 8; col++){ //places all non-pawn pieces
            _board[7][col]=whiteBackRank[col];
            _board[0][col]=blackBackRank[col];

        }

        for (int col = 0; col < 8; col++) { //places all pawns
            _board[6][col] = new Pawn(Color.WHITE);
            _board[1][col] = new Pawn(Color.BLACK);
        }
    }

    public void printBoard(){
        int i = 8;

        for(int row =0; row < 8; row++){
            System.out.println();
            System.out.print(i +"|");
            i--;
            for (int col = 0; col < 8; col++) {

                Piece piece = _board[row][col];

                if(piece ==null){   //if the Space is empty print a '.'
                    System.out.print(".");
                }else{ //if the Space is occupied print the corresponding Piece
                    System.out.print(piece.getSymbol());
                }
            }
        }
        System.out.println();
        System.out.println("  "+"--------");
        System.out.println("  "+"abcdefgh");
    }

    public void move(String from, String to, Color color) throws InvalidMoveException{

        int[] startRowAndCol = notationToArray(from);
        int[] endRowAndCol = notationToArray(to);

        Piece movingPiece = _board[startRowAndCol[0]][startRowAndCol[1]]; //temporarily saves the Piece thats about to move

        if(validateMove(startRowAndCol, endRowAndCol, movingPiece) && movingPiece.getColor() == color){
            //checks if the corresponding Piece can move along the chosen path and that the color corresponds with the players

                _board[startRowAndCol[0]][startRowAndCol[1]] = null; // clears the square

                _board[endRowAndCol[0]][endRowAndCol[1]] = movingPiece; // places the Piece at its new location
        }else{
            throw new InvalidMoveException("Invalid move!");
        }
    }

    public void playerTurn(Color color){ //handles the player input and checks if its valid
        boolean isValid = false;
        while(!isValid){
            System.out.println("What do you want to move: ");
            String start = _scanner.nextLine();

            System.out.println("Where do you want to move it?: ");
            String end = _scanner.nextLine();

            try { //tries to move the Piece and checks if the input was faulty or not
                move(start, end, color);
                isValid=true;
            }catch(InvalidMoveException e){ //if input is faulty then it goes on until a correct move was made
                System.out.println(e + "Try Again!");
            }
        }
    }

    public boolean validateMove(int[] startRowAndCol, int[] endRowAndCol, Piece movingPiece){
        if((startRowAndCol!=endRowAndCol) && (movingPiece.canMove(startRowAndCol, endRowAndCol)){

            if(movingPiece.getSymbol() == 'R' || movingPiece.getSymbol() == 'r'){ //checks the path in the Rooks way
               int row = endRowAndCol[0]-startRowAndCol[0];
               int col = endRowAndCol[1]-startRowAndCol[1];

               int i = 1;
               while(startRowAndCol[0] !=endRowAndCol[0]){ // changes startRowAndCol [0] until its the same as endRowAndCol[0]
                   if(Math.abs(col)!=i){

                       if(endRowAndCol[0] > startRowAndCol[0]){ // if end is greater than start i.e e4 to e5 then start + i
                           startRowAndCol[0] = startRowAndCol[0] + i;

                       }else{
                           startRowAndCol[0] = startRowAndCol[0] - i; // if start is greater than end i.e e5 to e4 then start - i
                       }
                       i = i + 1;
                   }
               }
               i = 1;
               while(startRowAndCol[0] !=endRowAndCol[0]){ // changes startRowAndCol [0] until its the same as endRowAndCol[0]
                    if(Math.abs(col)!=i){

                        if(endRowAndCol[0] > startRowAndCol[0]){ // if end is greater than start i.e e4 to e5 then start + i
                            startRowAndCol[0] = startRowAndCol[0] + i;

                        }else{
                            startRowAndCol[0] = startRowAndCol[0] - i; // if start is greater than end i.e e5 to e4 then start - i
                        }
                        i = i + 1;
                    }
               }



            } else if (movingPiece.getSymbol() == 'B' || movingPiece.getSymbol() == 'b') {//checks the path in the Bishops way


            } else if (movingPiece.getSymbol() == 'Q' || movingPiece.getSymbol() == 'q') {//checks the path in the Queens way


            }else{ // if its a Knight it doesnt matter because it can hop over other Pieces
                return true;
            }
        }

    }
}
