package Chess;

public class Bishop extends Piece{
    public Bishop(Color color){
        super(color);
    }

    @Override
    public boolean canMove(int[] from, int[] to) { //from and to are arrays with 2 indices, x and y coordinates
        return(Math.abs(from[0] - to[0]) == Math.abs(from[1] - to[1]));
            //the absolute value of the difference of start x and end x has to be the same as start y and end y
            // a bishop can only move the same horizontally as it does vertically
    }

    @Override
    public char getSymbol(){
        return (getColor()== Color.WHITE) ? 'B' : 'b';
    }
}
