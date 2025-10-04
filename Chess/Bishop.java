package Chess;

public class Bishop extends Piece{
    public Bishop(Color color){
        super(color);
    }

    @Override
    public boolean canMove(int[] from, int[] to){
        return false;
    }

    @Override
    public char getSymbol(){
        return (getColor()== Color.WHITE) ? 'B' : 'b';
    }
}
