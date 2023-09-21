public class King extends ChessPiece {
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
                        boolean x = attackHorse((ChessBoard) board, i, j, line, column);
                        if(x) return true;
                    }
                    //если поле не пустое и цвет противника и там стоит слон то
                    if (!board.board[i][j].getSymbol().equals(null) && !board.board[i][j].getColor().equals(this.getColor()) && board.board[i][j].getSymbol().equals("B")){
                        boolean x = attackBishop((ChessBoard) board, i, j, line, column);
                        if(x) return true;
                    }
                    //если поле не пустое и цвет противника и там стоит ладья то
                    if (!board.board[i][j].getSymbol().equals(null) && !board.board[i][j].getColor().equals(this.getColor()) && board.board[i][j].getSymbol().equals("R")){
                        boolean x = attackRook((ChessBoard) board, i, j, line, column);
                        if(x) return true;
                    }
                    //если поле не пустое и цвет противника и там стоит ферзь то
                    if (!board.board[i][j].getSymbol().equals(null) && !board.board[i][j].getColor().equals(this.getColor()) && board.board[i][j].getSymbol().equals("Q")){
                        boolean x = attackQueen((ChessBoard) board, i, j, line, column);
                        if(x) return true;
                    }
                    //если поле не пустое и цвет противника и там стоит пешка то
                    if (!board.board[i][j].getSymbol().equals(null) && !board.board[i][j].getColor().equals(this.getColor()) && board.board[i][j].getSymbol().equals("P")){
                        boolean x = attackPawn((ChessBoard) board, i, j, line, column);
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

    /////////////////////////////////////////////////////////////////////////
    //test attack Horse
    public boolean attackHorse(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
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
    ///////////////////////////////////////////////////////////////////////
    //test attack Bishop
    public boolean attackBishop(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toColumn < 0 || toLine > 7  || toColumn > 7) return false;//если выходим за пределы поля то возврат ошибка false
        else if (line == toLine && column == toColumn) return false;//если координаты не меняются - остаемся на месте - возврат ошибка false
        else if (checkTrue(toLine,toColumn) && (checkDiag(line, column, toLine, toColumn))) return true;
        else return false;
    }
    ////////////////////////////////////////////////////////////////////////
    //attack Rook
    public boolean attackRook(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!checkTrue(toLine, toColumn)) return false;//если выходим за пределы поля то возврат ошибка false
        else if (line == toLine && column == toColumn) return false;//если координаты не меняются - остаемся на месте - возврат ошибка false
        else if (checkRook(line, column, toLine, toColumn)) return true;
        return false;
    }
    //////////////////////////////////////////////////////////////////////
    //attack Pawn
    public boolean attackPawn(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        //так ка пешка начинает движение с 1(белая) или с 6(черная) если выходим за пределы поля то возврат ошибка false
        if ((toLine < 1 || toColumn < 0 || toLine > 7  || toColumn > 7)&&(this.getColor().equals("White"))) return false;
        else if((toLine > 6 || toColumn < 0 || toLine < 1  || toColumn > 7)&&(this.getColor().equals("Black"))) return false;

            //***********************//проверка на занято ли поле
//        else if(chessBoard.board[toLine][toColumn].equals(null)) return true;//если поле куда перемещаем пешку пустое, то можно ходить
            //***********************//

        else if(line == toLine && column == toColumn) return false;//если координаты не меняются - остаемся на месте - возврат ошибка false
        else if(this.getColor().equals("White") && (line == 1 && toLine == 3) && (column == toColumn)) return true;//если белые и идем вперед через 2
        else if(this.getColor().equals("White") && (toLine == line+1)  && (column == toColumn)) return true;//если белые и идем вперед через 1
        else if(this.getColor().equals("Black") && (line == 6 && toLine == 4) && (column == toColumn)) return true;//если черные и идем вперед через 2
        else if(this.getColor().equals("Black") && (toLine == line-1) && (column == toColumn)) return true;//если черные и идем вперед через 1
        else return false;
    }
    //////////////////////////////////////////////////////////////////////
    //attack Queen
    public boolean attackQueen(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toColumn < 0 || toLine > 7  || toColumn > 7) return false;//если выходим за пределы поля то возврат ошибка false
        else if (line == toLine && column == toColumn) return false;//если координаты не меняются - остаемся на месте - возврат ошибка false
        else if (checkTrue(toLine,toColumn) && (checkDiag(line, column, toLine, toColumn))) return true;
        else if (!checkTrue(toLine, toColumn)) return false;//если выходим за пределы поля то возврат ошибка false
        else if (checkRook(line, column, toLine, toColumn)) return true;
        else return false;
    }

}
