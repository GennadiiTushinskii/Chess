public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    public boolean checkMove(int toLine, int toColumn) {
        if ((toLine >= 0 && toColumn >= 0) && (toLine <= 7 && toColumn <= 7))//если новые координаты в пределах поля доски то можно ходить
            return true;
        return false;
    }


    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        boolean isUnderAttack = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessBoard.board[i][j] != null) {
                    if (!chessBoard.board[i][j].getColor().equals(getColor())) {
                        if (chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                            isUnderAttack = true;
                        }
                    }
                }
            }
        }
        return isUnderAttack;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line == toLine && column == toColumn) return false;//если координаты не меняются - остаемся на месте - возврат ошибка false
        else if (chessBoard.checkPos(toLine)&&chessBoard.checkPos(toColumn)&&
                (
                    (toLine==line-1&&toColumn==column-1)||
                    (toLine==line&&toColumn==column-1)||
                    (toLine==line+1&&toColumn==column-1)||
                    (toLine==line+1&&toColumn==column)||
                    (toLine==line-1&&toColumn==column)||
                    (toLine==line+1&&toColumn==column+1)||
                    (toLine==line&&toColumn==column+1)||
                    (toLine==line-1&&toColumn==column+1)
                )
        ) return true;//если выходим за пределы поля то возврат ошибка false
        else if(chessBoard.board[toLine][toColumn]==null || !chessBoard.board[toLine][toColumn].getColor().equals(getColor())) return true;
        else return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

}
