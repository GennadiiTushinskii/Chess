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

        if ((toLine < 0 || toColumn < 0 || toLine > 7  || toColumn > 7)&&(this.getColor().equals("White"))) return false;//если выходим за пределы поля то возврат ошибка false
        if ((toLine < 0 || toColumn < 0 || toLine > 7  || toColumn > 7)&&(this.getColor().equals("Black"))) return false;//если выходим за пределы поля то возврат ошибка false
        else if (line == toLine && column == toColumn) return false;//если координаты не меняются - остаемся на месте - возврат ошибка false
        else if(this.getColor().equals("White") && (line == 1 && toLine == 3) && (column == toColumn)) return true;
        else if(this.getColor().equals("White") && (toLine == line+1)  && (column == toColumn)) return true;
        else if(this.getColor().equals("Black") && (line == 6 && toLine == 4) && (column == toColumn)) return true;
        else if(this.getColor().equals("Black") && (toLine == line-1) && (column == toColumn)) return true;
        else return false;

    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
