package Chess;

public class Rook extends Piece {
    public Rook(Color color){
        super(color);
    }

    @Override
    public boolean canMove(int[] from, int[] to){
        return (from[0] == to[0] || from[1] == to[1]); // a rook can only move either horizontally or vertically
    }

    @Override
    public char getSymbol(){
        return (getColor()== Color.WHITE) ? 'R' : 'r';
    }
}
