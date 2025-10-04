package Chess;

public class Knight extends Piece{
    public Knight(Color color){
        super(color);
    }

    @Override
    public boolean canMove(int[] from, int[] to){
        if(from[0] == to[0] || from[1] == to[1]){
            return false;
        }else{
            return (Math.abs(Math.abs(from[0] - to[0]) - Math.abs(from[1] - to[1])) == 1);
            //the absolute value of the difference between x and y can only be 1,
            //for example: I move 2 on the x-axis and 1 on the y-axis, then its 2-1 = 1
            // the same goes for 1 on the x-axis and 2 on the y-axis, 1-2 = |-1| = 1
            // theoretically the absolute value of the difference could be 1 when only moving by 1 on either axis
        }
    }

    @Override
    public char getSymbol(){
        return (getColor()== Color.WHITE) ? 'N' : 'n';
    }
}
