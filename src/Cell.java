import processing.core.PApplet;

public class Cell{
    private int height;
    private int width;
    private int x;
    private int y;
    private int index;

    public Cell(int height, int width, int x, int y, int index){
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
        this.index = index;
    }

    public void display() {
        MainGame.app.rect(x, y, width, height); //displays the images, you call it in draw
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public int getIndex(){
        return index;
    }



}
