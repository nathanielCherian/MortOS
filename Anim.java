import java.util.Random;
import java.lang.Math; 



public class Anim {
    
    /** main
     * entry point when testing
     */
    public static void main(String[] args)  {
      //clear screen
      //note usage of public statics
      System.out.print(Terminal.ANSI_CLEAR_SCREEN + Terminal.ANSI_HOME_CURSOR);
      //run demos
      Terminal t = new Terminal();
      //t.colors();

      switch(args[0]){

        case "wave":
          t.wave();
          break;
        case "boom":
          t.boom();
        default:
          break;


      }


      //t.loader();
      //t.block();
      //t.wave();
      //t.boom();
      //t.reverse_wave();
    }
}



class Terminal {
  //position builders
  public static final String BUILDER_ESCAPE = "\033[";
  public static final String SAVE_CURSOR = "\033[s";
  public static final String RESTORE_CURSOR = "\033[u";
  //ANSI functions
  public static final String ANSI_CLEAR_SCREEN = "\u001B[2J";
  public static final String ANSI_HOME_CURSOR = "\u001B[0;0H";
  public static final String ANSI_CURSOR_UP       = "\u001B[1000A";
  public static final String ANSI_CURSOR_DOWN     = "\u001B[1000B";
  public static final String ANSI_CURSOR_FORWARD  = "\u001B[1000C";
  public static final String ANSI_CURSOR_BACKWARD = "\u001B[1000D";
  //ANSI colors foreground
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";
  //ANSI colors background
  public static final String ANSI_WHITE_BACK = "\u001B[47m";
  public static final String ANSI_GREEN_BACK = "\u001B[42m";

  //Misc
  public static Random rand = new Random(); //instance of random class



  /**
  Colors and positions demo
  */
  public void colors() {
    //color options
    System.out.println(ANSI_BLACK + ANSI_WHITE_BACK + "Black" + ANSI_RESET);
    System.out.println(ANSI_RED + "Red");
    System.out.println(ANSI_GREEN +"Green");
    System.out.println(ANSI_YELLOW + "Yellow");
    System.out.println(ANSI_BLUE + "Blue");
    System.out.println(ANSI_PURPLE + "Purple");
    System.out.println(ANSI_CYAN + "Cyan");
    System.out.println(ANSI_WHITE +"White");

    //position print: print("\033[4;15HHello")
    //variables are made to show ability to adapt into reusable methods
    System.out.print(SAVE_CURSOR);
    String row = Integer.toString(6);
    String col = Integer.toString(20);
    String message_move = "r"+row+";"+"c"+ col;
    String cursor_move = BUILDER_ESCAPE + row + ";" + col + "H";
    System.out.print(cursor_move + message_move);
    System.out.print(RESTORE_CURSOR);
  }

  /**
  Loading bar demo
  */
  public void loader() {
    System.out.println(ANSI_RED + "Loading!" + ANSI_RESET);
    for (int i = 0; i < 100; i++) {
      try {
          Thread.sleep(100);
      } catch (Exception e) {
          System.out.println(e);
      }
      int width = (i + 1) / 4;

      String str = "#";


      String hashes = new String(new char[width]).replace("\0", str);
      String spaces = new String(new char[25-width]).replace("\0", " ");

      String bar = "[" + hashes + spaces + "]";
      System.out.print(ANSI_CURSOR_BACKWARD);
      System.out.print(bar);
    }
    System.out.println();
  }

  public void block(){

    System.out.print(SAVE_CURSOR);


    String block = new String(new char[50]).replace("\0", ANSI_GREEN + "█");
    for(int y=0; y<10; y++){
      System.out.println(block);

    }
      System.out.println(ANSI_RESET);

  }


  public void present(){

    for(int i=0; i < 10; i++){
      String x = Integer.toString(rand.nextInt(40));
      String y = Integer.toString(rand.nextInt(20));
      String cursor_move = BUILDER_ESCAPE + y + ";" + x + "H";
      System.out.print(cursor_move+"#");
    }

    System.out.print(BUILDER_ESCAPE+"21;0H");

  }


  public void boom(){

    int startX = rand.nextInt(40);
    int startY = rand.nextInt(20);
    
    for(int radius=1; radius<30;radius++){


        for(int x=0;x<=radius;x++){

          int y = (int) Math.sqrt(((radius*radius) - (x-0)*(x-0)));

          //System.out.println("["+Integer.toString(radius)+"]("+Integer.toString(x)+", "+Integer.toString(y)+")");

          if((y <= 40) && (y>= 0) ){
            String cursor_move = BUILDER_ESCAPE + Integer.toString(y) + ";" + Integer.toString(2*x) + "H";

            String chars = "@#$%&+=";
            char dchar = chars.charAt(rand.nextInt(chars.length()));

            System.out.print(cursor_move+"#");


            //System.out.print(cursor_move+dchar);
            
          }
          //System.out.println("x: " + Integer.toString(x));
        }

        try {
          Thread.sleep(100);
      } catch (Exception e) {
          System.out.println(e);
      }
      
    }

    System.out.print("\033[0m");
    System.out.print(BUILDER_ESCAPE+ 41 +";0H");
    

  }



  public void wave(){
    // x= 40 y=0
    // x=0 y=20
    // y= x/2

    //System.out.print("\u001b[38;5;87m");

    String chars = "@#$%&+=";

    int width = 80;
    int height = 40;
    int mem = 5;
  
    int divisor = (int) width/5;

    for (int d=height; d>-height; d--){

      for(int x=0; x<width; x++){

        int y = (int) x/2 + d;
        int y_space = (int) x/2 + d + mem;

        int randomsx = rand.nextInt(2) * rand.nextInt(3);
        int randomsy = rand.nextInt(2) * rand.nextInt(2);

        x = x-randomsx;
        y = y-randomsy;

        if((y <= height) && (y>= 0)){
          String cursor_move = BUILDER_ESCAPE + Integer.toString(y) + ";" + Integer.toString(x) + "H";

          char dchar = chars.charAt(rand.nextInt(chars.length()));

          int box = (int) x/divisor + 160;
          System.out.print("\u001b[38;5;" + Integer.toString(box) + "m");
          
          System.out.print(cursor_move+dchar);
        }


        if((y_space <= height) && (y_space>= 0)){
          String cursor_move = BUILDER_ESCAPE + Integer.toString(y_space) + ";" + Integer.toString(x) + "H";
          System.out.print(cursor_move+" ");
        }


      }

      try {
          Thread.sleep(75);
      } catch (Exception e) {
          System.out.println(e);
      }

    }



    System.out.print("\033[0m");
    System.out.print(BUILDER_ESCAPE+ Integer.toString(height+1) +";0H");

  }




  public void reverse_wave(){
    // x= 40 y=0
    // x=0 y=20
    // y= x/2

    //Integer x = 0;
    //Integer y = 20;

    for (int d=20; d>-20; d--){

      for(int x=0; x<40; x++){

        int y = (int) -x/2 + d;
        int y_space = (int) -x/2 + d + 3;


        if((y <= 20) && (y>= 0)){
          String cursor_move = BUILDER_ESCAPE + Integer.toString(y) + ";" + Integer.toString(x) + "H";
          System.out.print(cursor_move+"#");
        }


        if((y_space <= 20) && (y_space>= 0)){
          String cursor_move = BUILDER_ESCAPE + Integer.toString(y_space) + ";" + Integer.toString(x) + "H";
          System.out.print(cursor_move+" ");
        }


      }

      try {
          Thread.sleep(75);
      } catch (Exception e) {
          System.out.println(e);
      }

    }


    System.out.print(BUILDER_ESCAPE+"21;0H");

  }

  
}

