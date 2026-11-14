public class GameLauncher {
    static void main() {
        Board board = new Board(10, 10);
        board.initialize(new int[][] { {0,1,0}, {0,0,1}, {1,1,1} });

        GameOfLife game = new GameOfLife(board);
        game.start();

    }
}
