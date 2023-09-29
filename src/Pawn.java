public class Pawn extends ChessPiece{
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    //проверим правильность движения пешки вперед или при атаке
    public boolean checkMovePawn(int line, int column, int toLine, int toColumn){
        //для белых
        if(toLine == line+1 && toColumn == column) return true;
        //для черных
        if(toLine == line-1 && toColumn == column) return true;
        return false;
    }
    public boolean checkAttackPawn(int line, int column, int toLine, int toColumn){
        //для белых
        if(toLine == line+1 && ((toColumn == column+1)||(toColumn == column-1))) return true;
        //для черных
        if(toLine == line-1 && ((toColumn == column+1)||(toColumn == column-1))) return true;
        return false;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        //так как пешка начинает движение с 1(белая) или с 6(черная) если выходим за пределы поля то возврат ошибка false
        if ((toLine < 1 || toColumn < 0 || toLine > 7  || toColumn > 7)&&(this.getColor().equals("White"))) return false;
        else if((toLine > 6 || toColumn < 0 || toLine < 1  || toColumn > 7)&&(this.getColor().equals("Black"))) return false;
        else if(line == toLine && column == toColumn) return false;//если координаты не меняются - остаемся на месте - возврат ошибка false
        //следующие 4-ре проверки для первого хода пешек
        else if(this.getColor().equals("White") && (line == 1 && toLine == 3) && (column == toColumn)) return true;//если белые и идем вперед через 2
        else if(this.getColor().equals("White") && (toLine == line+1)  && (column == toColumn)) return true;//если белые и идем вперед через 1
        else if(this.getColor().equals("Black") && (line == 6 && toLine == 4) && (column == toColumn)) return true;//если черные и идем вперед через 2
        else if(this.getColor().equals("Black") && (toLine == line-1) && (column == toColumn)) return true;//если черные и идем вперед через 1
        //
        else if((chessBoard.board[toLine][toColumn]==null)&&(checkMovePawn(line, column, toLine, toColumn))) return true;//если поле назначения пустое можно двигаться
        else if(checkAttackPawn(line, column, toLine, toColumn) && !chessBoard.board[toLine][toColumn].getColor().equals(getColor())) return true;//если атака и там противник то можно
        else return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
