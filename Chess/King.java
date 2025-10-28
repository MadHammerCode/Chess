package Chess;

public class King extends Piece {
    public King(Color color) {
        super(color);
        _directions= new int[][]{{1,0}, {1,1}, {0,1}, {-1,0}, {-1,-1}, {0,-1}, {1,-1}, {-1,1}};
        _unlimitedRange=false;
    }

    @Override
    public boolean canMove(int[] from, int[] to) {
        if ((from[0] == to[0] + 1 || from[0] == to[0] - 1) && from[1] == to[1]) { //moving vertically
            return true;

        } else if ((from[1] == to[1] + 1 || from[1] == to[1] - 1) && from[0] == to[0]) { //moving horizontally
            return true;

        } else if ((from[0] == to[0] + 1 || from[0] == to[0] - 1) && (from[1] == to[1] + 1 || from[1] == to[1] - 1)) { //moving diagonally
            return true;
        } else {
            return false;
        }
    }

    public boolean isKingChecked() {

    }


    @Override
    public char getSymbol() {
        return (getColor() == Color.WHITE) ? 'K' : 'k';
    }
}
