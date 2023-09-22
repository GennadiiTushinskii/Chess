public class Queen extends ChessPiece{
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    public boolean checkMove(int toLine, int toColumn){
        if((toLine >= 0 && toColumn >= 0) && (toLine <= 7 && toColumn <= 7))//если новые координаты в пределах поля доски то можно ходить
            return true;
        return false;
    }

    public boolean checkDiag(int line, int column, int toLine, int toColumn){
        if(Math.abs(toLine-line) == Math.abs(toColumn-column)) return true;
        else return false;
    }

    public boolean checkRook(int line, int column, int toLine, int toColumn){
        if(((toLine > line)||(toLine < line)) && toColumn == column) return true;//проверка при движении по вертикали для любого цвета
        else if(((toColumn > column || toColumn < column) && toLine == line)) return true;//при движении по горизонтали для любого цвета
        else return false;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
//        if (toLine < 0 || toColumn < 0 || toLine > 7  || toColumn > 7) return false;//если выходим за пределы поля то возврат ошибка false
        if (line == toLine && column == toColumn) return false;//если координаты не меняются - остаемся на месте - возврат ошибка false
        else if (checkMove(toLine,toColumn) && (checkDiag(line, column, toLine, toColumn))) return true;
//        else if (!checkMove(toLine, toColumn)) return false;//если выходим за пределы поля то возврат ошибка false
        else if (checkMove(toLine,toColumn) && (checkRook(line, column, toLine, toColumn))) return true;
        else return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
