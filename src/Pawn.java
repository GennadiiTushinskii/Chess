public class Pawn extends ChessPiece{
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        //так ка пешка начинает движение с 1(белая) или с 6(черная) если выходим за пределы поля то возврат ошибка false
        if ((toLine < 1 || toColumn < 0 || toLine > 7  || toColumn > 7)&&(this.getColor().equals("White"))) return false;
        else if((toLine > 6 || toColumn < 0 || toLine < 1  || toColumn > 7)&&(this.getColor().equals("Black"))) return false;
        else if(line == toLine && column == toColumn) return false;//если координаты не меняются - остаемся на месте - возврат ошибка false

//        else if(chessBoard.board[toLine][toColumn].equals(null)) return true;//если поле куда перемещаем пешку пустое, то можно ходить

        else if(this.getColor().equals("White") && (line == 1 && toLine == 3) && (column == toColumn)) return true;//если белые и идем вперед через 2
        else if(this.getColor().equals("White") && (toLine == line+1)  && (column == toColumn)) return true;//если белые и идем вперед через 1
        else if(this.getColor().equals("Black") && (line == 6 && toLine == 4) && (column == toColumn)) return true;//если черные и идем вперед через 2
        else if(this.getColor().equals("Black") && (toLine == line-1) && (column == toColumn)) return true;//если черные и идем вперед через 1
        else return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
