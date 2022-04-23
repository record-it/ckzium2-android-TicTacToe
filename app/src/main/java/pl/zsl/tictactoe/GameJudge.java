package pl.zsl.tictactoe;

public class GameJudge {
    private Player playerO;
    private Player playerX;
    private int turn;
    private char[][] board = new char[3][3];
    private GameResult result = GameResult.GAME_RUNNING;

    public GameJudge(Player playerO, Player playerX) {
        this.playerO = playerO;
        this.playerX = playerX;
    }
    public boolean makeMove(int row, int col){
        if (result != GameResult.GAME_RUNNING){
            return false;
        }
        if (board[row][col] == playerO.getSymbol() || board[row][col] == playerX.getSymbol()) {
            return false;
        } else {
            board[row][col] = getPlayerInTurn().getSymbol();
        }
        boolean playerXwin = isWinner(playerX);
        boolean playerOwin = isWinner(playerO);
        if (playerOwin){
            result = GameResult.PLAYER_O_WINNER;
        }
        if (playerXwin){
            result = GameResult.PLAYER_X_WINNER;
        }
        if (isDraw()){
            result = GameResult.IS_DRAW;
        }
        turn++;
        return true;
    }

    public GameResult getGameState(){
        return result;
    }

    public void restartGame(){
        turn = 0;
        result = GameResult.GAME_RUNNING;
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                board[row][col] = ' ';
            }
        }
    }

    public Player getPlayerInTurn(){
        if (turn % 2 == 0){
            return playerO;
        } else {
            return playerX;
        }
    }

    private boolean isWinner(Player player){
        //sprawdzenie wygranej w wierszu
        for(int row = 0; row < board.length; row++){
            int counter = 0;
            for(int col = 0; col < board[row].length; col++){
                if (board[row][col] == player.getSymbol()){
                    counter++;
                }
            }
            if (counter == 3){
                return true;
            }
        }
        //sprawdzenie wygranej w kolumnach
        //sprawdzić w przekątnych
        return false;
    }
    private boolean isDraw(){
        return turn == 8;
    }

}
