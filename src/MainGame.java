import processing.core.PApplet;

public class MainGame extends PApplet{

    /*
    TO DO:
    make the click actually do something/figure out the fill
    make the error not error anymore.
     */
    Cell[][] cells;
    public static PApplet app; //creates our static variable
    private static int cellLength = 10;
    private boolean click;

    public MainGame(){
        super();
        app = this;
        click = false;
        cells = new Cell[50][100];
    }
    public void settings(){
        size(1000, 500);
    }
    public void setup(){
        int index = 0;
        for (int row = 0; row < cells.length; row++) { //nested loops that goes through the number of panels in a square
            for (int col = 0; col < cells[0].length; col++) {
                int x = col * width; //location of the panel, upper left corner
                int y = row * height;
                Cell c = new Cell(cellLength, cellLength, x, y, index);
                cells[row][col] = c;
                index++;  //increments index
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
    }

    public void mouseClicked() {
        for (int row = 0; row < cells.length; row++) { //this goes through all the panels
            for(int col = 0; col < cells[0].length; col++){
                if (cells[row][col] instanceof Cell) {
                    Cell c = cells[row][col];
                    handleMouseClicked(mouseX, mouseY, c);
                }
            }
        }
    }

    public void handleMouseClicked(int _x, int _y, Cell x) {
        if (_x > x.getX() && _x < x.getX() + x.getWidth()) {
            if (_y > x.getY() && _y < x.getY() + x.getHeight()) {
                click = !click;
                //something with fill
            }
        }
    }

}
