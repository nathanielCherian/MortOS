public class Slide {

    public static final String BUILDER_ESCAPE = "\033[";
    public static final String ANSI_CLEAR_SCREEN = "\u001B[2J";


    public int height;
    public int width;
    public String text;

    public Slide(int w, int h, String t){
        this.height = h;
        this.width = w;
        this.text = t;
    }


    public void dispay(){
        clear();
        System.out.println(text);

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
