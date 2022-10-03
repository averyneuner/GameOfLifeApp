/**
 *this class defines the cell object. each cell has a size, x position, y position, row, column,
 * state and an object of the rules. It also keeps track of a boolean for if someone has clicked
 * the display method dictates what color each cell is displayed as according to their state
 * Alive is black, white is dead. this class also has a applyRules and evolve method that tell
 * each cell what to do, whether to evolve or not and how to apply rules. this class as handles
 * clicks for each of the cells. it also has the capability to count the amount of alive neighbors
 * a cell has in its neighborhood.
 */


public class Cell{
    private int size;
    private int x;
    private int y;
    private int row;
    private int column;
    private CellState cellState;
    private Rules rules;
    private boolean click;

    /**
     * @param size
     * @param x
     * @param y
     * @param row
     * @param column
     * @param cellState
     * @param rules
     */

    public Cell(int size,int x, int y, int row, int column, CellState cellState, Rules rules){
        this.size = size;
        this.x = x;
        this.y = y;
        this.row = row;
        this.column = column;
        this.cellState = cellState;
        this.rules = rules;
        click = false;
    }

    public void display() {
        if(cellState == CellState.DEAD)
            MainGame.app.fill(255);
        else{
            MainGame.app.fill(0);
        }
        MainGame.app.rect(x, y, size, size); //displays the images, you call it in draw
    }

    public void handleMouseClicked() {

        click = !click;
        if(cellState == CellState.DEAD){
            cellState = CellState.ALIVE;
        }else if(cellState == CellState.ALIVE) {
            cellState = CellState.DEAD;
        }
    }

    /**
     * @param cells
     */
    public void applyRules(Cell[][] cells){
        int liveNeighbors = countLiveNeighbors(cells);
        cellState = rules.applyRules(cellState, liveNeighbors);
    }

    public void evolve(){
        if (cellState == CellState.WILL_REVIVE){
            cellState = CellState.ALIVE;
        } else if (cellState == CellState.WILL_DIE){
            cellState = CellState.DEAD;
        }
    }

    /**
     * @param cells
     * @return
     */
    private int countLiveNeighbors(Cell[][] cells){
        int neighbors = 0;
        for(int r = row - 1; r <= row + 1; r++){
            for(int c = column - 1; c <= column + 1; c++){
                if(cells[r][c].cellState == CellState.ALIVE || cells[r][c].cellState == CellState.WILL_DIE){
                    neighbors++;
                }
            }
        }
        if(cellState == CellState.ALIVE || cellState == CellState.WILL_DIE){
            neighbors--;
        }
        return neighbors;
    }



}
