package Chess;

public class Pawn extends Piece {
    private boolean _isFirstMove;

    public Pawn(Color color){
        super(color);
        _isFirstMove = true;
    }

    @Override
    public boolean canMove(int[] from, int[] to){
        if(_isFirstMove) {
            _isFirstMove = false;
            return (((from[0] == to[0]+1) || (from[0] == to[0]+2)) && from[1] == to[1]) ;

        }else {
            return ((from[0] == to[0] + 1) && from[1] == to[1]);
        }
    }

    @Override
    public char getSymbol(){
        return (getColor()== Color.WHITE) ? 'P' : 'p';
    }
}
