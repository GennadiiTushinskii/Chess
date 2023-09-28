public class Horse extends ChessPiece{
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    public boolean checkMove(int toLine, int toColumn){
        if((toLine >= 0 && toColumn >= 0) && (toLine <= 7 && toColumn <= 7))//если новые координаты в пределах поля доски то можно ходить
            return true;
        else return false;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line == toLine && column == toColumn) return false;//если координаты не меняются - остаемся на месте - возврат ошибка
        else if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(getColor())) return false;
        else if((checkMove(toLine, toColumn)) && (
                ((toLine-1 == line) && (toColumn-2 == column))||
                ((toLine-1 == line) && (toColumn+2 == column))||
                ((toLine+1 == line) && (toColumn-2 == column))||
                ((toLine+1 == line) && (toColumn+2 == column))||
                ((toLine-2 == line) && (toColumn-1 == column))||
                ((toLine-2 == line) && (toColumn+1 == column))||
                ((toLine+2 == line) && (toColumn-1 == column))||
                ((toLine+2 == line) && (toColumn+1 == column))
                )
        )   return true;
        else return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
