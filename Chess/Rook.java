package Chess;

public class Rook extends Piece {
    public Rook(Color color){
        super(color);
    }

    @Override
    public boolean canMove(int[] from, int[] to){
        if (from[0]==to[0] || from[1]==to[1]){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public char getSymbol(){
        return (getColor()== Color.WHITE) ? 'R' : 'r';
    }
}
