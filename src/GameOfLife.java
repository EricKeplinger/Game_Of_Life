public class GameOfLife {
    private Board board;

    public GameOfLife(Board b){
        this.board = b;
    }

    private Board iterate(){
        Board newBoard = new Board(board.getWidth(), board.getHeight());
        for(int i = 0; i < board.getHeight(); i++){
            for(int j = 0; j < board.getWidth(); j++){
                int aliveNeighbours = 0;
                for(int x = i-1; x < i+2; x++){
                    int torusx = x;
                    if(x == -1){
                        torusx = board.getHeight() -1;
                    } else if(x == board.getHeight()){
                        torusx = 0;
                    }
                    for(int y = j-1; y < j+2; y++){
                        if(x == i && y == j){
                            continue;
                        }
                        int torusy = y;
                        if(y == -1){
                            torusy = board.getWidth() -1;
                        }else if(y == board.getWidth()){
                            torusy = 0;
                        }
                        if(board.isAlive(torusx, torusy)){
                            aliveNeighbours++;
                        }
                    }
                }
                if(board.isAlive(i, j) && aliveNeighbours >= 2 && aliveNeighbours <= 3){
                    newBoard.setState(i, j, true);
                }else if(!board.isAlive(i, j) && aliveNeighbours == 3){
                    newBoard.setState(i, j, true);
                }else {
                    newBoard.setState(i, j, false);
                }
            }
        }
        return newBoard;
    }

    public void start(){
        String input;
        do{
            board.print();
            board = iterate();
            input = IO.readln();
        }while(!input.equals("q"));

    }


}
