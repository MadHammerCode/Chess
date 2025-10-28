package Chess;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public  abstract class Piece {
    protected Color _color;
    protected int[][] _directions;
    protected boolean _unlimitedRange;

    public Piece(Color color){
        _color = color;
    }

    public Color getColor(){
        return _color;
    }

    public int[][] getDirections(){
        return _directions;
    }

    public abstract char getSymbol();

    public abstract boolean canMove(int[] from, int[] to);
}
