import processing.core.PApplet;
/**
 * This method is the jumping off point for the compiler. it stores the cell size and the number of rows and column
 * for the whole canvas. From there we set up the whole canvas and the 2D array using an array in the setup method.
 * in draw, we display the whole canvas and,when we can draw and it's been toggled to evolve the cells, we apply the
 * rules and call to evolve. both those methods index through the whole 2D array and call Cell methods on the cells
 * we also keep the functionality of mouseClicked and keyPressed to give the user the ability to use the program
 */

public class MainGame extends PApplet{

    private static final int CELL_SIZE = 10;
    private static final int NUM_ROWS = 50;
    private static final int NUM_COLUMNS = 100;
    private boolean doEvolve;
    Cell[][] cells;
    public static PApplet app; //creates our static variable

    /**
     * @param args
     */
    public static void main(String[] args){
        PApplet.main("MainGame");
    }

    public MainGame(){
        super();
        app = this;
        doEvolve = false;
    }

    public void settings(){
        size(NUM_COLUMNS * CELL_SIZE, NUM_ROWS * CELL_SIZE);
    }
    public void setup(){
        frameRate(7);
        int[] birth = {3};
        int[] survival = {2, 3};
        Rules mRules = new MooreRules(birth, survival);
        cells = new Cell[NUM_ROWS][NUM_COLUMNS];
        for (int row = 0; row < cells.length; row++) { //nested loops that goes through the number of panels in a square
            for (int col = 0; col < cells[0].length; col++) {
                int x = col * CELL_SIZE; //location of the panel, upper left corner
                int y = row * CELL_SIZE;
                Cell c = new Cell(CELL_SIZE, x, y, row, col, CellState.DEAD, mRules);
                cells[row][col] = c;
            }
        }
    }

    public void draw(){
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                Cell c = cells[row][col];
                c.display();
            }
        }
        if(doEvolve == true){
            applyRules(cells);
            evolve(cells);
        }
    }

    public void mouseClicked() {
        super.mouseClicked();
        int column = mouseX/CELL_SIZE;
        int row = mouseY/CELL_SIZE;
        Cell c = cells[row][column];
        c.handleMouseClicked();
    }

    /**
     * @param cells
     */
    public void applyRules(Cell[][] cells){
        for(int r = 1; r < cells.length - 1; r++){
            for(int c = 1; c < cells[0].length - 1; c++){
                cells[r][c].applyRules(cells);
            }
        }
        //doesn't iterate over the first and last rows and columns because special cases!
    }

    /**
     * @param cells
     */
    public void evolve(Cell[][] cells){
        for(int r = 0; r < cells.length; r++){
            for(int c = 0; c < cells[0].length; c++){
                cells[r][c].evolve();
            }
        }
    }

    public void keyPressed(){
        doEvolve = !doEvolve;
    }

}
