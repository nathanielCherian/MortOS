import java.util.Arrays;


public class Slide {

    public static final String BUILDER_ESCAPE = "\033[";
    public static final String ANSI_CLEAR_SCREEN = "\u001B[2J";

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_WHITE_BACK = "\u001B[47m";
    public static final String ANSI_RESET = "\u001B[0m";


    public int height;
    public int width;
    public String text;
    public String fintext;

    public Slide(int w, int h, String t){
        this.width = w;
        this.height = h;
        this.text = t;
        compile();
    }


    public void compile(){
        
        String[] parsed = new String[height];
        for(int i=0; i<parsed.length; i++){
            parsed[i] = new String(new char[width]).replace("\0", " ");
        }



        String[] splits = text.split("\n");
        int boost = ((int) (height/2)) - ((int) (splits.length/2));

        int c = 0;
        for (String line: splits){


            int padSize = width - line.length();
            int padStart = line.length() + padSize / 2;
            line = String.format("%" + padStart + "s", line);
            line = String.format("%-" + width  + "s", line);

            parsed[c+boost] = line;
            c++;
        }


        fintext = String.join("\n", parsed);



    }


    public void dispay(){
        clear();

        //System.out.print(ANSI_WHITE_BACK+"sdfsdfsdfsodifsdf"+ANSI_RESET);


        System.out.print(ANSI_BLACK+ANSI_WHITE_BACK+fintext+ANSI_RESET);


        /*
        for(int i=0;i<height;i++){

            for(int x=0; x<width; x++){
                System.out.print(ANSI_BLACK+ANSI_WHITE_BACK+' '+ANSI_RESET);
            }
            System.out.println();

            //System.out.println(new String(new char[width]).replace("\0", ANSI_WHITE_BACK));
        }*/

        //System.out.println(text);

        reset();

    }




    // Eventually inherit from BaseAnim in main package
    public void clear(){
        System.out.println(ANSI_CLEAR_SCREEN);
        String cursor_move = BUILDER_ESCAPE + "0;0H";
        System.out.print(cursor_move+"\033[0m");
    }

    public void reset(){
        String cursor_move = BUILDER_ESCAPE + Integer.toString(height+1) + ";" + Integer.toString(0) + "H";
        System.out.print(cursor_move+"\033[0m");
    }


}
