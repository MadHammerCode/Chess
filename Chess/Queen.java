package Chess;

public class Queen extends Piece {
    public Queen(Color color){
        super(color);
    }

    @Override
    public boolean canMove(int[] from, int[] to){
        return false;
    }

    @Override
    public char getSymbol(){
        return (getColor()== Color.WHITE) ? 'Q' : 'q';
    }
}
