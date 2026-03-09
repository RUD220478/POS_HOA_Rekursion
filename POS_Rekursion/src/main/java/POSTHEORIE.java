public class POSTHEORIE {


    private static boolean[][] werte = {
            {false,false,false,true,true,true,false,false,true,true,false,false},
            {false,true,true,true,false,true,true,true,true,false,false,false},
            {true,false,true,true,false,false,true,true,false,false,true,true},
            {true,false,false,false,true,true,true,false,false,true,true,true},
            {true,true,true,false,false,false,false,true,true,true,false,false},
            {true,true,false,true,true,false,false,true,false,false,true,true},
            {false,false,false,true,false,false,true,false,true,true,true,false},
            {false,false,false,false,false,true,true,true,true,false,false,false}
            };

    public static int zusammenhang(boolean[][] werte){
        for (int i = 0; i < werte.length; i++){
            for (int j = 0; j < werte[i].length; j++){
                if (werte[i][j] == true){
                    System.out.println("ja");
                }
                else {
                    System.out.println("Nein. Nicht true.");
                }
            }
        }
        return -99;
    }

    public static int groesstesDing(int i, int j){
        int n = 0;
        int z = 0;
        if (werte[i][j-1] == true){
            n = j - 1;
            z = j;
            groesstesDing(n,j);
        }
        return -99;
    }

    public static void main(String[] arg){
        zusammenhang(werte);
    }
}
