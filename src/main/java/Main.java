

public class Main {


    public static void main(String[] args) {

        // int random_int = (int)Math.floor(Math.random()*(10-0+1)+0);
        // System.out.println(random_int);

        Grid newGrid = new Grid();

        boolean Grid[][] = newGrid.getNewGrid();

        int rows = newGrid.getNumberOfRows();
        int columns = newGrid.getNumberOfColumns();

        String displayArray[][] = new String[rows][columns];

        System.out.print("    ");
        for(int i = 0; i<rows; i++){

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


    }
}