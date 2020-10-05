import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.lang.model.util.ElementScanner6;

import java.util.Scanner;
import java.util.ArrayList;


public class Present {
    
    public static final String ANSI_RED_BACK = "\u001B[41m";

    public static String md_name = "present.md";


    
    public static void main(String[] args) {

        String data = load_file();
        Slide[] slides = get_slides(data);

        Scanner controller = new Scanner(System.in);  

        String a = "0";
        int c = 0;
        while(true){

            slides[c].dispay();
            slnum(c, slides.length);
            a = controller.nextLine();

            if(a.equals("d")||a.equals("n")){
                c++;

            }else if(a.equals("a")||a.equals("b")){
                c--;
            }else{
                try{
                    c = Integer.valueOf(a);
                    c--;
                }catch(Exception e){
                    
                }


            }

            if(c<0||c>=slides.length){
                break;
            }
        }


    }


    public static void slnum(int c, int l){

        String stat = ANSI_RED_BACK+Integer.toString(c+1)+"/"+Integer.toString(l)+"\u001B[0m";
        int padSize = 90 - stat.length();
        int padStart = stat.length() + padSize / 2;
        stat = String.format("%" + padStart + "s", stat);
        stat = String.format("%-" + 90  + "s", stat);

        System.out.println(stat);
 
    }

    public static String load_file() {

        try{

            File mdfile = new File(md_name);
            java.util.Scanner mdscanner = new Scanner(mdfile);
    
            String data = "";
            
            while (mdscanner.hasNextLine()){
                data = data + mdscanner.nextLine() + "\n";
            }

            return data;

        }catch(FileNotFoundException e){
            System.out.println("file does not exist!");
            return "FAIL";
        }


    }

    public static Slide[] get_slides(String data){

        ArrayList<Slide> slides = new ArrayList<Slide>();

        for (String block: data.split("---\n")) {

            if (block.length() > 0){
                slides.add(new Slide(80, 20, block));
            }

        }

        return slides.toArray(new Slide[slides.size()]);

    }


}
