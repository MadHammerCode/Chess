package Chess;
import static Chess.Notation.notationToArray;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class Board {
    private Piece[][] _board;
    private Scanner _scanner = new Scanner(System.in);

    public Board() {
        _board = new Piece[8][8];
        setUpBoard();
    }

    public Piece getPiece(int row, int col){
        return _board[row][col];
    }

    public boolean checkTeamMate(Piece movingPiece, int row, int col){
        if(_board[row][col] != null){
            return(movingPiece.getColor() != _board[row][col].getColor());
        }else{
            return true;
        }
    }

    private void setUpBoard() {
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

        for (int col = 0; col < 8; col++) { //places all non-pawn pieces
            _board[7][col] = whiteBackRank[col];
            _board[0][col] = blackBackRank[col];

        }

        for (int col = 0; col < 8; col++) { //places all pawns
            _board[6][col] = new Pawn(Color.WHITE);
            _board[1][col] = new Pawn(Color.BLACK);
        }
    }

    public void printBoard() {
        int i = 8;

        for (int row = 0; row < 8; row++) {
            System.out.println();
            System.out.print(i + "|");
            i--;
            for (int col = 0; col < 8; col++) {

                Piece piece = _board[row][col];

                if (piece == null) {   //if the Space is empty print a '.'
                    System.out.print(".");
                } else { //if the Space is occupied print the corresponding Piece
                    System.out.print(piece.getSymbol());
                }
            }
        }
        System.out.println();
        System.out.println("  " + "--------");
        System.out.println("  " + "abcdefgh");
    }

    public void move(String from, String to, Color color) throws InvalidMoveException {

        int[] startRowAndCol = notationToArray(from);
        int[] endRowAndCol = notationToArray(to);

        Piece movingPiece = _board[startRowAndCol[0]][startRowAndCol[1]]; //temporarily saves the Piece thats about to move

        if (validateMove(startRowAndCol, endRowAndCol, movingPiece) && (movingPiece.getColor() == color)  && (checkTeamMate(movingPiece, endRowAndCol[0], endRowAndCol[1]))){
            //checks if the corresponding Piece can move along the chosen path and that the color corresponds with the players

            //In case the Piece to be moved is a pawn, the take logic has to be a bit different.
            if (movingPiece.getSymbol() == 'P' || movingPiece.getSymbol() == 'p'){
                if (_board[endRowAndCol[0]][endRowAndCol[1]] != null){
                    throw new InvalidMoveException("Invalid move!");
                }
            }

            _board[startRowAndCol[0]][startRowAndCol[1]] = null; // clears the square

            _board[endRowAndCol[0]][endRowAndCol[1]] = movingPiece; // places the Piece at its new location
        }else{
            throw new InvalidMoveException("Invalid move!");
        }
    }

    public void playerTurn(Color color) { //handles the player input and checks if its valid
        boolean isValid = false;
        while (!isValid) {
            System.out.println("What do you want to move: ");
            String start = _scanner.nextLine();

            System.out.println("Where do you want to move it?: ");
            String end = _scanner.nextLine();

            try { //tries to move the Piece and checks if the input was faulty or not
                move(start, end, color);
                isValid = true;
            } catch (InvalidMoveException e) { //if input is faulty then it goes on until a correct move was made
                System.out.println(e + "Try Again!");
            }
        }
    }

    public boolean validateMove(int[] startRowAndCol, int[] endRowAndCol, Piece movingPiece) {
        if (movingPiece.getSymbol() == 'N' || movingPiece.getSymbol() == 'n') {
            return ((startRowAndCol != endRowAndCol) && (movingPiece.canMove(startRowAndCol, endRowAndCol)));
        }else{
            return ((startRowAndCol != endRowAndCol) && (movingPiece.canMove(startRowAndCol, endRowAndCol)) && checkPathClear(startRowAndCol, endRowAndCol));
        }
    }

    public boolean checkPathClear(int[] startRowAndCol, int[] endRowAndCol) {
        int[] tempEndRowAndCol = Arrays.copyOf(endRowAndCol, endRowAndCol.length); // creates copies because otherwise the og Arrays get corrupted
        int[] tempStartRowAndCol = Arrays.copyOf(startRowAndCol, startRowAndCol.length);

        while (!Arrays.equals(tempStartRowAndCol, tempEndRowAndCol)) {
            // I have to compare Arrays like that otherwise this condition will always be true because with "==" it would compare references and not content


            if (tempStartRowAndCol[0] < tempEndRowAndCol[0]) { // if start is smaller than end i.e. e4 to e5 then start + 1
                tempStartRowAndCol[0] = tempStartRowAndCol[0] + 1;
            }
            if (tempStartRowAndCol[0] > tempEndRowAndCol[0]){
                tempStartRowAndCol[0] = tempStartRowAndCol[0] - 1; // if start is greater than end i.e. e5 to e4 then start - 1
            }

            if (tempStartRowAndCol[1] < tempEndRowAndCol[1]) {
                tempStartRowAndCol[1] = tempStartRowAndCol[1] + 1;
            }
            if(tempStartRowAndCol[1] > tempEndRowAndCol[1]){
                tempStartRowAndCol[1] = tempStartRowAndCol[1] - 1;
            }

            //I check if the current square is occupied or not
            if (((_board[tempStartRowAndCol[0]][tempStartRowAndCol[1]]) != null) && !Arrays.equals(tempStartRowAndCol, tempEndRowAndCol)) { // I have to access board because only it possesses Piece objects,
                return false;
            }
        }
        return true;
    }

    public List<List<Integer>> generateMoves(int[] startRowAndCol, Piece movingPiece){ // Im using an ArrayList because they can dynamically grow
        int[] tempStartRowAndCol = Arrays.copyOf(startRowAndCol, startRowAndCol.length);

        for(int[] dir: movingPiece.getDirections() ){
            int row = dir[0];
            int col = dir[1];
        }
    }
}
