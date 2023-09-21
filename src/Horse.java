public class Horse extends ChessPiece{
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    public boolean checkTrue(int toLine, int toColumn){
        if((toLine >= 0 && toColumn >= 0) && (toLine <= 7 && toColumn <= 7))//если новые координаты в пределах поля доски то можно ходить
            return true;
        else return false;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toColumn < 0 || toLine > 7  || toColumn > 7) return false;//если выходим за пределы поля то возврат ошибка
        else if (line == toLine && column == toColumn) return false;//если координаты не меняются - остаемся на месте - возврат ошибка
        else if((checkTrue(toLine, toColumn)) && (
                ((toLine-1 == line) && (toColumn-2 == column))||
                ((toLine-1 == line) && (toColumn+2 == column))||
                ((toLine+1 == line) && (toColumn-2 == column))||
                ((toLine+1 == line) && (toColumn+2 == column))||
                ((toLine-2 == line) && (toColumn-1 == column))||
                ((toLine-2 == line) && (toColumn+1 == column))||
                ((toLine+2 == line) && (toColumn-1 == column))||
                ((toLine+2 == line) && (toColumn+1 == column))
                )
        )   return true;//если не выходим за пределы доски и правильно перемещаемся тогда возврат true
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
