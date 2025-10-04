package Chess;

public class Pawn extends Piece {
    private boolean _isVirgin;

    public Pawn(Color color){
        super(color);
        _isVirgin = true;
    }

    @Override
    public boolean canMove(int[] from, int[] to){
        return false;
    }

    @Override
    public char getSymbol(){
        return (getColor()== Color.WHITE) ? 'P' : 'p';
    }
}
