package Chess;

public class Notation {
    public static int[] notationToArray(String notation) throws InvalidMoveException {
        int[] rowAndCol = new int[2];

        for (char c : notation.toCharArray()) {

            if('i' <=c){
                throw new InvalidMoveException("Square does not exist ");
            } else if  ('a' <= c && c <= 'h') {  //checks if c is between a and h, i.e d
                rowAndCol[1] = c - 'a'; // a has ASCII value of 97 so c - 97 = ... {
            } else {
                rowAndCol[0] = 8 - (c - 48); //'1' has ASCII value of 49 so '1' - 48 = 1, '2' - 48 = 2. 8-(c-48) is because the Array is inverted.
            }
        }
        return rowAndCol;
    }
}
