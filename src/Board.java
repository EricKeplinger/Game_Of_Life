public class Board {
    private int width;
    private int height;
    private boolean[][] cells;

    public Board(int width, int height){
        this.width = width;
        this.height = height;
        this.cells = new boolean[this.height][this.width];
    }

    public void initialize(int[][] initialState){
        for(int i = 0; i < Math.min(initialState.length, this.height); i++){
            for(int j = 0; j < Math.min(initialState[i].length, this.width); j++){
                int cell = initialState[i][j];
                this.cells[i][j] = (cell == 1);
            }
        }
    }

    public void print(){
        for(int i = 0; i < this.height; i++){
            for(int j = 0; j < this.width; j++){
                String a;
                if(this.cells[i][j]){
                    a = "O ";
                } else {
                    a = ". ";
                }
                IO.print(a);
            }
            IO.println();
        }
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public boolean isAlive(int i, int j){
        return this.cells[i][j];
    }

    public void setState(int i, int j, boolean c){
        this.cells[i][j] = c;
    }


}
