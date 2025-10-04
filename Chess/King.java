package Chess;

public class King extends Piece{
    public King(Color color){
        super(color);
    }

    @Override
    public boolean canMove(int[] from, int[] to){
        return false;
    }

    @Override
    public char getSymbol(){
        return (getColor()== Color.WHITE) ? 'K' : 'k';
    }
}
