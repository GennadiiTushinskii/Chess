public class Bishop extends ChessPiece{

    public Bishop(String color) {
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

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line == toLine && column == toColumn) return false;//если координаты не меняются - остаемся на месте - возврат ошибка false
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
        if (checkMove(toLine,toColumn) && (checkDiag(line, column, toLine, toColumn))) return true;
        else return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
