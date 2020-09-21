import java.lang.Math; 

public class Launch extends BaseAnim{

    public Launch(int w, int h) {
        super(w, h);
    }

    public void present() {
        
        clear();

        for(int x=0; x <= width; x++){
            int y = (int) (Math.sin(Math.toRadians(x))*height);
            print(x, y, 100, '#');
            sleep(25);
        }

        reset();

    }
}
