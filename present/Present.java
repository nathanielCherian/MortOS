import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.ArrayList;


public class Present {
    
    public static String md_name = "present.md";


    
    public static void main(String[] args) {

        //Slide sl = new Slide(30,10,"2");

        String data = load_file();
        Slide[] slides = get_slides(data);

        Scanner controller = new Scanner(System.in);  

        int a = 0;
        while(true){
            slides[a].dispay();
            a = controller.nextInt();
            a--;
            if(a<0||a>=slides.length){
                break;
            }
        }

        /*
        for(Slide s : slides){
            s.dispay();
            int a = controller.nextInt();  
        }*/

        //System.out.println(data);

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
