
public class ConnectedCoordinatesInAMatrix {

    // array that keeps track of visited coordinates
    private static boolean[][] matrixOfVisitedCoordinates;
    
    // local counter for number of connected coordinates
    private static int tempAmountConnectedCoordinates = 0;
    
    // global counter saves greatest number of connected coordinates
    private static int finalAmountConnectedCoordinates = 0;

    // Initialize static array (connected coordinates: 19)
    public static boolean[][] matrixOfCoordinates = {
            {false,false,false,true,true,true,false,false,true,true,false,false},
            {false,true,true,true,false,true,true,true,true,false,false,false},
            {true,false,true,true,false,false,true,true,false,false,true,true},
            {true,false,false,false,true,true,true,false,false,true,true,true},
            {true,true,true,false,false,false,false,true,true,true,false,false},
            {true,true,false,true,true,false,false,true,false,false,true,true},
            {false,false,false,true,false,false,true,false,true,true,true,false},
            {false,false,false,false,false,true,true,true,true,false,false,false}
            };

    //
    public static void connectedCoordinatesInAMatrix(boolean[][] werte){

        // initialize a second array to keep track of visited coordinates
        createArrayMatrixOfVisitedCoordinates();

        // iterate over all fields in the array
        for (int i = 0; i < werte.length; i++){
            for (int j = 0; j < werte[i].length; j++){
                if (werte[i][j] && !matrixOfVisitedCoordinates[i][j])
                {
                    // call recursive function to check coordinate(s)
                    checkField(i,j);
                    // if tempAmount from the recursive function is greater, it currently is the greatest number
                    if (tempAmountConnectedCoordinates > finalAmountConnectedCoordinates){
                        finalAmountConnectedCoordinates = tempAmountConnectedCoordinates;
                    }
                    // sets tempAmount to 0 again so the recursive function can start fresh
                    tempAmountConnectedCoordinates = 0;
                }

            }
        }
        System.out.println("\n***\nThe biggest number of connected coordinates is " + countMaximum() + "\n***");
    }

    public static void checkField(int x, int y) throws ConnectedCoordiantesInAMatrixException{
        try {
            if (matrixOfCoordinates[x][y] && !matrixOfVisitedCoordinates[x][y]){
                // mark coordinate as visited so it is not counted again
                matrixOfVisitedCoordinates[x][y] = true;
                // increment tempAmount for current amalgam of coordinates
                tempAmountConnectedCoordinates += 1;
                if (x > 0){
                    checkField(x - 1, y); // Check coordinate above
                }
                if (x < matrixOfCoordinates.length - 1){
                    checkField(x + 1, y); // Check coordinate below
                }
                if (y > 0){
                    checkField(x,y - 1); // Check coordinate to the left
                }
                if (y < matrixOfCoordinates[0].length - 1){
                    checkField(x,y + 1); // Check coordinate to the right
                }
            } else {
                // no "True" has been found, mark the coordinate as visited
                matrixOfVisitedCoordinates[x][y] = true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ConnectedCoordiantesInAMatrixException("Index out of bounds");
        }
    }

    public static int countMaximum(){
        return finalAmountConnectedCoordinates;
    }

    // Helper method to create the array coordinatesVisited
    public static void createArrayMatrixOfVisitedCoordinates(){
        matrixOfVisitedCoordinates = new boolean[matrixOfCoordinates.length][matrixOfCoordinates[0].length];
        for (int i = 0; i < matrixOfVisitedCoordinates.length; i++){
            for (int j = 0; j < matrixOfVisitedCoordinates[0].length; j++){
                matrixOfVisitedCoordinates[i][j] = false;
            }
        }
    }

    // main method
    public static void main(String[] arg){
        connectedCoordinatesInAMatrix(matrixOfCoordinates);
    }

}
