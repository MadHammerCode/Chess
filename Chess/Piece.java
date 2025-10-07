package Chess;

public  abstract class Piece {
    private Color _color;

    public Piece(Color color){
        _color = color;
    }

    public Color getColor(){
        return _color;
    }

    public abstract char getSymbol();

    public abstract boolean canMove(int[] from, int[] to);
}
