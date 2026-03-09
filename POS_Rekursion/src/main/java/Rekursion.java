
public class Rekursion {

    private static boolean[][] werteCheck;
    public static int maximumLokal = 0;
    public static int maximumTotal = 0;

    // Initialisiere Array
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

    // Test: Werden Werte erkannt?
    public static void zusammenhang(boolean[][] werte){

        createSecondaryArray();

        for (int i = 0; i < werte.length; i++){
            for (int j = 0; j < werte[i].length; j++){

                if (werte[i][j] && !werteCheck[i][j])
                {
                    checkField(i,j);
                    System.out.println("Ausgabe: " + i + " " + j + " MaximumLokal : " + maximumLokal);
                    if (maximumLokal > maximumTotal){
                        maximumTotal = maximumLokal;
                    }
                    maximumLokal = 0;
                }

            }
        }
        System.out.println(maximumTotal);
    }

    public static void checkField(int x, int y) throws RekursionException{
        try {
            boolean w = werte[x][y];
            boolean wc = werteCheck[x][y];
            if (werte[x][y] && !werteCheck[x][y]){
                werteCheck[x][y] = true;
                maximumLokal += 1;
                if (x > 0){
                    checkField(x - 1, y); //Links --oben
                }
                if (x < werte.length - 1){
                    checkField(x + 1, y); //Rechts
                }
                if (y > 0){
                    checkField(x,y - 1); //Rauf
                }
                if (y < werte[0].length - 1){
                    checkField(x,y + 1); //Runter
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

    // Placeholder create second array and set values to false
    public static void createSecondaryArray(){
        werteCheck = new boolean[werte.length][werte[0].length];
        for (int i = 0; i < werteCheck.length;i++){
            for (int j = 0; j < werteCheck[0].length;j++){
                werteCheck[i][j] = false;
            }
        }
    }

    //yo
    public static void main(String[] arg){
        zusammenhang(werte);
    }

}
