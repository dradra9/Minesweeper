import java.util.Objects;
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
            this.newGrid[random_rows][random_column].numberOfMinesCloseBy = -1;

        }

    }

    //Methods

    public void assignNumberOfMines(){

        int mineCounter = 0;

        for (int i = 0; i < this.numberOfRows; i++) {

            for (int j = 0; j < this.numberOfColumns; j++) {

                if( this.newGrid[i][j].haveMine == false){

                for(int x = i-1; x <= i+1 ; x++)
                {
                    if(x >= 0 && x < this.numberOfRows){

                        for(int y = j-1; y <= j+1; y++ ){

                            if(y>=0 && y < this.numberOfColumns){

                                if(this.newGrid[x][y].haveMine)
                                {
                                    this.newGrid[i][j].numberOfMinesCloseBy += 1;
                                }
                            }



                        }
                    }
                }


                }

            }
        }



    }

    public void printGrid(){

        System.out.print("    ");
        for(int i = 0; i<this.numberOfColumns; i++){

            System.out.print( (i) + "  ");
        }
        System.out.println();

        for (int i = 0; i < this.numberOfRows; i++) {
            System.out.print((i) + "  ");

            for (int j = 0; j < this.numberOfColumns; j++) {

                System.out.print(" "+this.newGrid[i][j].numberOfMinesCloseBy+ " ");

            }

            System.out.println("\n");
        }

    }


    public void startGame(){


        System.out.println(" \n \n     WELCOME TO MINESWEEPER!!");
        System.out.println();
        System.out.println();



        this.displayArray= new String[this.numberOfRows][this.numberOfColumns];

        System.out.print("    ");
        for(int i = 0; i<this.numberOfColumns; i++){

            System.out.print( (i) + "  ");
        }
        System.out.println();

        for (int i = 0; i < displayArray.length; i++) {
            System.out.print((i) + "  ");

            for (int j = 0; j < displayArray[i].length; j++) {

                displayArray[i][j] = " _ ";
                System.out.print(displayArray[i][j]);

            }

            System.out.println("\n");

            //

        }



        boolean endGame = false;

       while (!endGame){
           endGame = userDisplay();


        }
        System.out.println("BOOM!!!");
        System.out.println("YOU LOSE!!");

        //!this.newGrid][yCoordinate].haveMine



    }

    public boolean userDisplay(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the coordinates (y,x) : ");
        boolean endGame = false;

        System.out.println("Y : ");
        int xCoordinate = userInput.nextInt();

        System.out.println("X : ");
        int yCoordinate = userInput.nextInt();

        System.out.println("You have entered coordinates (" + xCoordinate +", " + yCoordinate + ") ");
        System.out.println("Insert Flag (F) or Check Tile (C)");

        String decision = userInput.next();

        if ((Objects.equals(decision, "f") || Objects.equals(decision, "F") )&& !this.newGrid[xCoordinate][yCoordinate].revealTile){

            if (this.newGrid[xCoordinate][yCoordinate].flag){

                displayArray[xCoordinate][yCoordinate] = " _ ";
                this.newGrid[xCoordinate][yCoordinate].setFlag(false);
            }
            else{

                displayArray[xCoordinate][yCoordinate] = " F ";
                this.newGrid[xCoordinate][yCoordinate].setFlag(true);

            }


        } else if (Objects.equals(decision,"c") || Objects.equals(decision,"C") && !this.newGrid[xCoordinate][yCoordinate].revealTile ) {

            if(this.newGrid[xCoordinate][yCoordinate].haveMine){

                System.out.print("    ");
                for(int i = 0; i<this.numberOfRows; i++){

                    System.out.print( (i) + "  ");
                }
                System.out.println();

                for (int i = 0; i < displayArray.length; i++) {
                    System.out.print((i) + "  ");

                    for (int j = 0; j < displayArray[i].length; j++) {

                        if (this.newGrid[i][j].haveMine) {

                            displayArray[i][j] = " * ";
                        }

                        System.out.print(displayArray[i][j]);

                    }
                    System.out.println("\n");

                }




                endGame = true;

                return true;
            }
            else {

                //displayArray[xCoordinate][yCoordinate] = " "+ Integer.toString(this.newGrid[xCoordinate][yCoordinate].numberOfMinesCloseBy)+ " ";
                displayArray[xCoordinate][yCoordinate] = " "+ Integer.toString(this.newGrid[xCoordinate][yCoordinate].numberOfMinesCloseBy)+ " " ;
                this.newGrid[xCoordinate][yCoordinate].revealTile = true;




                for(int x = xCoordinate-1; x <= xCoordinate+1 ; x++)
                {
                    if(x >= 0 && x < this.numberOfRows){

                        for(int y = yCoordinate-1; y <= yCoordinate+1; y++ ){

                            if(y>=0 && y < this.numberOfColumns){

                                if(this.newGrid[x][y].numberOfMinesCloseBy == 0 && !this.newGrid[x][y].revealTile ){

                                    displayArray[x][y] = " "+ Integer.toString(this.newGrid[x][y].numberOfMinesCloseBy)+ " ";
                                }
                                else if(this.newGrid[x][y].numberOfMinesCloseBy > 0 && !this.newGrid[x][y].revealTile)
                                    displayArray[x][y] = " "+ Integer.toString(this.newGrid[x][y].numberOfMinesCloseBy)+ " ";
                                    this.newGrid[x][y].revealTile = true;
                                }
                            }



                        }
                    }

              /*  int totalGridNumber = this.numberOfColumns*this.numberOfRows;
                int withoutMines = totalGridNumber - this.numberOfMines;

                int revealTileCounter = 0;

                for (int i = 0; i < this.numberOfRows; i++) {

                    for (int j = 0; j < this.numberOfColumns; j++) {

                        if(this.newGrid[i][j].revealTile){
                            revealTileCounter++;
                        }
                    }
                }

                System.out.println(withoutMines + " " + revealTileCounter );
                if(withoutMines == revealTileCounter)
                {

                    System.out.println("YOU WON!!");

                    endGame = true;
                    return true;
                } */
                }

            }



            

        else{
            System.out.println("Please choose the correct coordinates");
        }

        System.out.print("    ");
        for(int i = 0; i<this.numberOfRows; i++){

            System.out.print( (i) + "  ");
        }
        System.out.println();

        for (int i = 0; i < displayArray.length; i++) {
            System.out.print((i) + "  ");

            for (int j = 0; j < displayArray[i].length; j++) {


                System.out.print(displayArray[i][j]);

            }
            System.out.println("\n");

            //

        }

        return false;
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
