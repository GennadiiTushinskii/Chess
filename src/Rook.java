public class Rook extends ChessPiece{
    public Rook(String color) {
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

    public boolean checkRook(int line, int column, int toLine, int toColumn){
        if(((toLine > line)||(toLine < line)) && toColumn == column) return true;//проверка при движении по вертикали для любого цвета
        else if(((toColumn > column || toColumn < column) && toLine == line)) return true;//при движении по горизонтали для любого цвета
        else return false;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!checkMove(toLine, toColumn)) return false;//если выходим за пределы поля то возврат ошибка false
        if (line == toLine && column == toColumn) return false;//если координаты не меняются - остаемся на месте - возврат ошибка false
        //проверка при движении вверх для любой фигуры
        if(toLine>line&&toColumn==column){
            for (int i = line; i < toLine; i++) {
                if (chessBoard.board[i][column] != null) return false;
            }
        }
        //проверка при движении вниз для любой фигуры
        if(toLine<line&&toColumn==column){
            for (int i = line; i > toLine; i--) {
                if (chessBoard.board[i][column] != null) return false;
            }
        }
        //проверка при движении ---> для любой фигуры
        if(toColumn>column&&toLine==toLine){
            for (int i = column; i < toColumn; i++) {
                if (chessBoard.board[line][i] != null) return false;
            }
        }
        //проверка при движении <--- для любой фигуры
        if(toColumn<column&&toLine==toLine){
            for (int i = column; i > toColumn; i--) {
                if (chessBoard.board[line][i] != null) return false;
            }
        }
        if (checkRook(line, column, toLine, toColumn)&&
                (chessBoard.board[toLine][toColumn]==null || !chessBoard.board[toLine][toColumn].getColor().equals(getColor()))) return true;
        else return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
