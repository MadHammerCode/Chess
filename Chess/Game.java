package Chess;

public class Game {
    public static void main(String[] args){
        Board board = new Board();
        board.printBoard();
        board.playerTurn(Color.WHITE);
        board.printBoard();
        board.playerTurn(Color.WHITE);
        board.printBoard();
        board.playerTurn(Color.WHITE);
        board.printBoard();
        board.playerTurn(Color.WHITE);
        board.printBoard();
        board.playerTurn(Color.WHITE);
        board.printBoard();


    }
}
