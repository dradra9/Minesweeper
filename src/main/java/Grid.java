public class Grid {

    //Attributes

    int numberOfRows;
    int numberOfColumns;
    int numberOfMines;
    Tiles [][] newGrid;
    int difficulty;

    //Constructor

    public Grid (int numberOfRows, int numberOfColumns){

        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.numberOfMines = numberOfRows;
        this.newGrid = Tiles [numberOfRows][numberOfColumns];


        this.numberOfRows = 10;
        this.numberOfColumns = 10;
        this.numberOfMines  = 10;


    }

    //Methods





   /* public Tiles[][] getNewGrid() {


        this.newGrid = new Tiles[this.numberOfRows][this.numberOfColumns];

        for(int i = 0; i <= this.numberOfMines - 1; i++){

            int random_rows = (int)Math.floor(Math.random()*(this.numberOfRows-0)+0);
            int random_column = (int)Math.floor(Math.random()*(this.numberOfRows-0)+0);

            this.newGrid[random_rows][random_column]= true;
        }

        return newGrid;
    }    */

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }
}
