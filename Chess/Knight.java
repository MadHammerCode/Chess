package Chess;

public class Knight extends Piece{
    public Knight(Color color){
        super(color);
    }

    @Override
    public boolean canMove(int[] from, int[] to){
        return false;
    }

    @Override
    public char getSymbol(){
        return (getColor()== Color.WHITE) ? 'N' : 'n';
    }
}
