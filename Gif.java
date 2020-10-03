import java.io.File;


public class Gif {
    public static final String BUILDER_ESCAPE = "\033[";

    public void animate(String d, Integer scale, Integer delay){

        File dir = new File(d);
        File[] files = dir.listFiles();

        String[] images = new String[files.length];

        for(int i=0;i<files.length;i++){

            Image im = new Image(d+"/"+files[i].getName(), scale);
            int[][] gs = im.to_grayscale();
            int[][] scaled_gs = im.scale(gs);
            images[i] = im.to_ascii_string(scaled_gs);

        }



        for(int i=0;i<10;i++){

            for (String image : images){
                System.out.println("\u001B[2J");
                String cursor_move = BUILDER_ESCAPE + "0;0H";
                System.out.print(cursor_move+"\033[0m");

                System.out.print(image);
    
                try{
                    Thread.sleep(delay);
                }catch (Exception e) {
                    System.out.println(e);
                }
    
            }

        }



    }

}
