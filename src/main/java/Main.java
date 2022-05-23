import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        // int random_int = (int)Math.floor(Math.random()*(10-0+1)+0);
        // System.out.println(random_int);


       // Tiles tiles = new Tiles(false,0,false);
        System.out.println("How many rows and columns?");
        System.out.println("Rows :");
        Scanner myScanner = new Scanner(System.in);
        int rows = Integer.valueOf(myScanner.nextLine());
        System.out.println("Columns :");
        int columns = Integer.valueOf(myScanner.nextLine());
        Grid newGrid = new Grid(rows,columns);
        newGrid.assignNumberOfMines();
        newGrid.printGrid();
        newGrid.startGame();



    }
}