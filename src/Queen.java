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
        if (line == toLine && column == toColumn) return false;//если координаты не меняются - остаемся на месте - возврат ошибка false
        else if (checkMove(toLine,toColumn) && (checkDiag(line, column, toLine, toColumn))) return true;
        else if (checkMove(toLine,toColumn) && (checkRook(line, column, toLine, toColumn))) return true;
        if (line == toLine && column == toColumn) return false;//если координаты не меняются - остаемся на месте - возврат ошибка false
        //проверка движения по всем диагоналям
        if((toLine-line)>0 && (toColumn-column)>0) {
            for (int i = line, j = column; i < toLine; i++, j++) {
                if (chessBoard.board[i][j] != null) return false;
            }
        }
        if((toLine-line)<0 && (toColumn-column)<0) {
            for (int i = line, j = column; i > toLine; i--, j--) {
                if (chessBoard.board[i][j] != null) return false;
            }
        }
        if((toLine-line)>0 && (toColumn-column)<0) {
            for (int i = line, j = column; i < toLine; i++, j--) {
                if (chessBoard.board[i][j] != null) return false;
            }
        }
        if((toLine-line)<0 && (toColumn-column)>0) {
            for (int i = line, j = column; i > toLine; i--, j++) {
                if (chessBoard.board[i][j] != null) return false;
            }
        }
        //если правильно двигаемся и поле назначения пустое или там находится фигура противника
        if (checkMove(toLine,toColumn) && (checkDiag(line, column, toLine, toColumn)) &&
                (chessBoard.board[toLine][toColumn]==null || !chessBoard.board[toLine][toColumn].getColor().equals(getColor()))) return true;
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
        return "Q";
    }
}
