import java.util.ArrayList;
import java.util.Arrays;

public class Pascal {
    


    public static void pascal(int height){

        System.out.println("PASCAL");

        

        ArrayList<int[]> tri = new ArrayList<int[]>();
        tri.add(new int[]{1});
        tri.add(new int[]{1,1});


    
        for(int i =0; i < height; i++){

            int len = i+3;
            int[] row = new int[len];

            row[0] = 1;
            row[len-1] = 1;



            int[] prev_row = tri.get(tri.size() - 1);

            for (int c=1; c<len-1;c++){
                
                row[c] = prev_row[c] + prev_row[c-1];

            }

            //System.out.println(Arrays.toString(row));
            tri.add(row);
            
        }


        String[] tri_string = new String[height+2];

        for(int i =0; i<tri.size(); i++){
            tri_string[i] = "";
            for(int n: tri.get(i)){
                tri_string[i] = tri_string[i] + Integer.toString(n)+" ";
            }

        }

        int maxl = tri_string[tri_string.length-1].length();
        for(int i = 0; i< tri_string.length; i++){

            int pad = (int) (maxl-tri_string[i].length())/2;

            for(int x=0;x<pad;x++){
                System.out.print(" ");
            }
            System.out.print(tri_string[i]+"\n");

        }


        System.out.println();
    }


}
