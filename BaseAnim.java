public class BaseAnim {
 
    public static final String BUILDER_ESCAPE = "\033[";
    public static final String SAVE_CURSOR = "\033[s";
    public static final String RESTORE_CURSOR = "\033[u";
    public static final String ANSI_HOME_CURSOR = "\u001B[0;0H";
    public static final String ANSI_CLEAR_SCREEN = "\u001B[2J";

    public int width;
    public int height;

    public BaseAnim(int w, int h){
        width = w;
        height = h;
    }


    public void print(int x, int y, int color_256, char char_){

        if((y <= height) && (y>= 0) && (x <= width) && (x >= 0)){

            String cursor_move = BUILDER_ESCAPE + Integer.toString(height-y) + ";" + Integer.toString(x) + "H";
            String color = "\u001b[38;5;" + color_256 + "m";

            System.out.print(cursor_move+color+char_+"\033[0m");
            
        }   

    }



    public void grid(){

        clear();

        for(int y=0; y<= height; y++){
            for(int x=0; x <= width; x++){
                print(x, y, 40, '+');
                sleep(1);
            }
        }

        reset();
    }




    public void sleep(int interval){
        try{
            Thread.sleep(interval);
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public void clear(){
        System.out.println(ANSI_CLEAR_SCREEN);
    }

    public void reset(){
        String cursor_move = BUILDER_ESCAPE + Integer.toString(height+1) + ";" + Integer.toString(0) + "H";
        System.out.print(cursor_move+"\033[0m");
    }

}
