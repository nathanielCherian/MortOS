import java.lang.Math; 

public class Launch extends BaseAnim{

    public static final Double GRAVITY = 9.82;


    public Launch(int w, int h) {
        super(w, h);
    }

    public void present(Double Vi, Double theta){
        
        Double Vix = Math.cos(Math.toRadians(theta))*Vi;
        Double Viy = Math.sin(Math.toRadians(theta))*Vi;

        clear();
        /*
        for(Double time=0.0; time <= 10.0; time=time+0.05){

            int x = (int) (Math.cos(Math.toRadians(theta))*Vi*time);
 
            int y = (int) ((Math.sin(Math.toRadians(theta))*Vi*time) - (GRAVITY/2)*time*time ); //(int) (Math.sin(Math.toRadians(x))*height);
            System.out.println(Integer.toString(x) + ' ' + Integer.toString(y));
            //print(x, y, 100, '#');

            //sleep(50);

        } */

        for(int x = 0; x <= width; x++){

            Double time = x/Vix;
            Double yp1 = Viy*time;
            Double yp2 = GRAVITY*time*time;

            int y = (int) (yp1-yp2/2)/2;
            //System.out.println(Integer.toString(x) + ' ' + Integer.toString(y));
            print(x, y, 100, '#');
            sleep(10);


        }


        reset();

    }
}
