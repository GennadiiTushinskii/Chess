public class Rook extends ChessPiece{
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    public boolean checkTrue(int toLine, int toColumn){
        if((toLine >= 0 && toColumn >= 0) && (toLine <= 7 && toColumn <= 7))//если новые координаты в пределах поля доски то можно ходить
            return true;
        return false;
    }

    public boolean checkRook(int line, int column, int toLine, int toColumn){
        if(toLine > line && toColumn == column && checkTrue(toLine, toColumn)) return true;//проверка для White при движении вверх
        else if(toLine < line && toColumn == column && checkTrue(toLine, toColumn)) return true;//проверка для Black при движении вниз
        else if(((toColumn > column || toColumn < column) && toLine == line) && checkTrue(toLine, toColumn)) return true;//при движении по горизонтали для любой фигуры
        else return false;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!checkTrue(toLine, toColumn)) return false;//если выходим за пределы поля то возврат ошибка false
        else if (line == toLine && column == toColumn) return false;//если координаты не меняются - остаемся на месте - возврат ошибка false
        else if (checkRook(line, column, toLine, toColumn)) return true;
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
