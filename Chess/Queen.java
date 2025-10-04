package Chess;

public class Queen extends Piece {
    public Queen(Color color){
        super(color);
    }

    @Override
    public boolean canMove(int[] from, int[] to){
        if(from[0] == to[0] || from[1] == to[1]){ //can move exactly like a rook
            return true;
        } else if (Math.abs(from[0] - to[0]) == Math.abs(from[1] - to[1])){ // or can move exactly like a bishop
            return true;
        }else{
            return false;
        }
    }

    @Override
    public char getSymbol(){
        return (getColor()== Color.WHITE) ? 'Q' : 'q';
    }
}
