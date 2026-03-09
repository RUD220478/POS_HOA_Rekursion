
public class Rekursion {

    private static boolean[][] werteCheck;
    public static int maximumLokal = 0;
    public static int maximumTotal = 0;

    // Initialize static example array
    public static boolean[][] werte = {
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
    public static void zusammenhang(boolean[][] werte){

        // initialize a second array to keep track of visited fields
        createSecondaryArray();

        // iterate over all fields in the array
        for (int i = 0; i < werte.length; i++){
            for (int j = 0; j < werte[i].length; j++){
                if (werte[i][j] && !werteCheck[i][j])
                {
                    // call recursive function
                    checkField(i,j);
                    if (maximumLokal > maximumTotal){
                        maximumTotal = maximumLokal;
                    }
                    maximumLokal = 0;
                }

            }
        }
        System.out.println("Die Groesse betraegt " + countMaximum());
    }

    public static void checkField(int x, int y) throws RekursionException{
        try {
            if (werte[x][y] && !werteCheck[x][y]){
                werteCheck[x][y] = true;
                maximumLokal += 1;
                if (x > 0){
                    checkField(x - 1, y); // Check field above
                }
                if (x < werte.length - 1){
                    checkField(x + 1, y); // Check field below
                }
                if (y > 0){
                    checkField(x,y - 1); // Check field to the left
                }
                if (y < werte[0].length - 1){
                    checkField(x,y + 1); // Check field to the right
                }
            } else {
                werteCheck[x][y] = true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RekursionException("Index out of bounds");
        }
    }

    public static int countMaximum(){
        return maximumTotal;
    }

    // Create second array and set all values to false
    public static void createSecondaryArray(){
        werteCheck = new boolean[werte.length][werte[0].length];
        for (int i = 0; i < werteCheck.length;i++){
            for (int j = 0; j < werteCheck[0].length;j++){
                werteCheck[i][j] = false;
            }
        }
    }

    // main method
    public static void main(String[] arg){
        zusammenhang(werte);
    }

}
