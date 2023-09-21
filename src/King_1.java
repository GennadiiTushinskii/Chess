public class King_1 extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    public boolean checkTrue(int toLine, int toColumn) {
        if ((toLine >= 0 && toColumn >= 0) && (toLine <= 7 && toColumn <= 7))//если новые координаты в пределах поля доски то можно ходить
            return true;
        return false;
    }

    public boolean checkDiag(int line, int column, int toLine, int toColumn) {
        if (Math.abs(toLine - line) == Math.abs(toColumn - column)) return true;
        else return false;
    }

    public boolean checkRook(int line, int column, int toLine, int toColumn) {
        if (((toLine > line) || (toLine < line)) && toColumn == column)
            return true;//проверка при движении по вертикали для любого цвета
        else if (((toColumn > column || toColumn < column) && toLine == line))
            return true;//при движении по горизонтали для любого цвета
        else return false;
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
            //в цикле ищем кто может нас атаковать         board.board[line][column].getSymbol().equals("P")&&!
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    //если поле не пустое и цвет противника и там стоит конь то
                    if (!board.board[i][j].getSymbol().equals(null) && !board.board[i][j].getColor().equals(this.getColor()) && board.board[i][j].getSymbol().equals("H")){
                        Horse h = new Horse(board.board[i][j].getColor());
                        boolean x = h.canMoveToPosition((ChessBoard) board, i, j, line, column);
                        if(x) return true;
                    }
                    //если поле не пустое и цвет противника и там стоит слон то
                    if (!board.board[i][j].getSymbol().equals(null) && !board.board[i][j].getColor().equals(this.getColor()) && board.board[i][j].getSymbol().equals("B")){
                        Bishop b = new Bishop(board.board[i][j].getColor());
                        boolean x = b.canMoveToPosition((ChessBoard) board, i, j, line, column);
                        if(x) return true;
                    }
                    //если поле не пустое и цвет противника и там стоит ладья то
                    if (!board.board[i][j].getSymbol().equals(null) && !board.board[i][j].getColor().equals(this.getColor()) && board.board[i][j].getSymbol().equals("R")){
                        Rook r = new Rook(board.board[i][j].getColor());
                        boolean x = r.canMoveToPosition((ChessBoard) board, i, j, line, column);
                        if(x) return true;
                    }
                    //если поле не пустое и цвет противника и там стоит ферзь то
                    if (!board.board[i][j].getSymbol().equals(null) && !board.board[i][j].getColor().equals(this.getColor()) && board.board[i][j].getSymbol().equals("Q")){
                        Queen q = new Queen(board.board[i][j].getColor());
                        boolean x = q.canMoveToPosition((ChessBoard) board, i, j, line, column);
                        if(x) return true;
                    }
                    //если поле не пустое и цвет противника и там стоит пешка то
                    if (!board.board[i][j].getSymbol().equals(null) && !board.board[i][j].getColor().equals(this.getColor()) && board.board[i][j].getSymbol().equals("P")){
                        Pawn p = new Pawn(board.board[i][j].getColor());
                        boolean x = p.canMoveToPosition((ChessBoard) board, i, j, line, column);
                        if(x) return true;
                    }

                }
//                return true;
            }
    return false;
}

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toColumn < 0 || toLine > 7  || toColumn > 7) return false;//если выходим за пределы поля то возврат ошибка false
        else if (line == toLine && column == toColumn) return false;//если координаты не меняются - остаемся на месте - возврат ошибка false
        else if (checkTrue(toLine,toColumn) && (checkDiag(line, column, toLine, toColumn))) return true;
        else if (!checkTrue(toLine, toColumn)) return false;//если выходим за пределы поля то возврат ошибка false
        else if (checkRook(line, column, toLine, toColumn)) return true;
        else return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
