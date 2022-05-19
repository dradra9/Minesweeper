import java.util.Scanner;

public class Grid {

    //Attributes

    int numberOfRows;
    int numberOfColumns;
    int numberOfMines;
    Tiles [][] newGrid;
    String [][] displayArray;
    int difficulty;

    //Constructor

    public Grid (int numberOfRows, int numberOfColumns){

        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.numberOfMines = numberOfRows;
        this.newGrid = new Tiles [numberOfRows][numberOfColumns];

        for (int i = 0; i < newGrid.length; ++i) {
            for(int j = 0; j < newGrid[i].length; ++j) {

                newGrid[i][j] = new Tiles(false,0,false);
            }
        }



        for( int i = 0; i < this.numberOfMines; i++ ){

            int random_rows = (int)Math.floor(Math.random()*(this.numberOfRows));
            int random_column = (int)Math.floor(Math.random()*(this.numberOfColumns));

            this.newGrid [random_rows][random_column].haveMine = true;

        }

    }

    //Methods


    public void startGame(){



        System.out.print("    ");



        Scanner userInput = new Scanner(System.in);



        String displayArray[][] = new String[this.numberOfRows][this.numberOfColumns];

        System.out.print("    ");
        for(int i = 0; i<this.numberOfRows; i++){

            System.out.print( (i+1) + "  ");
        }
        System.out.println();

        for (int i = 0; i < displayArray.length; i++) {
            System.out.print((i+1) + "  ");

            for (int j = 0; j < displayArray[i].length; j++) {

                displayArray[i][j] = " _ ";
                System.out.print(displayArray[i][j]);

            }
            System.out.println("\n");

            //

        }

        System.out.println("Enter the coordinates (x,y) : ");

        System.out.println("X : ");
        int xCoordinate = userInput.nextInt();

        System.out.println("Y : ");
        int yCoordinate = userInput.nextInt();












    }

    public int getNumberOfColumns() {


        return numberOfColumns;
    }

    public void setNumberOfColumns(int numberOfColumns) {

        this.numberOfColumns = numberOfColumns;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfMines() {
        return numberOfMines;
    }

    public void setNumberOfMines(int numberOfMines) {
        this.numberOfMines = numberOfMines;
    }

    public Tiles[][] getNewGrid() {

        return newGrid;
    }
}
