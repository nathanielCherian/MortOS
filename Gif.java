import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageInputStream;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.awt.image.BufferedImage;


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



        print_images(images, delay);


    }


    public static void gif_animate(String g, Integer scale, Integer delay){



        try {
            String[] imageatt = new String[]{
                    "imageLeftPosition",
                    "imageTopPosition",
                    "imageWidth",
                    "imageHeight"
            };    
        
            ImageReader reader = (ImageReader)ImageIO.getImageReadersByFormatName("gif").next();
            ImageInputStream ciis = ImageIO.createImageInputStream(new File(g));
            reader.setInput(ciis, false);
        
            int noi = reader.getNumImages(true);
            BufferedImage master = null;
        
            String[] images = new String[noi];


            for (int i = 0; i < noi; i++) { 
                BufferedImage image = reader.read(i);
                IIOMetadata metadata = reader.getImageMetadata(i);
        
                Node tree = metadata.getAsTree("javax_imageio_gif_image_1.0");
                NodeList children = tree.getChildNodes();
        
                for (int j = 0; j < children.getLength(); j++) {
                    Node nodeItem = children.item(j);
        
                    if(nodeItem.getNodeName().equals("ImageDescriptor")){
                        Map<String, Integer> imageAttr = new HashMap<String, Integer>();
        
                        for (int k = 0; k < imageatt.length; k++) {
                            NamedNodeMap attr = nodeItem.getAttributes();
                            Node attnode = attr.getNamedItem(imageatt[k]);
                            imageAttr.put(imageatt[k], Integer.valueOf(attnode.getNodeValue()));
                        }
                        if(i==0){
                            master = new BufferedImage(imageAttr.get("imageWidth"), imageAttr.get("imageHeight"), BufferedImage.TYPE_INT_ARGB);
                        }
                        master.getGraphics().drawImage(image, imageAttr.get("imageLeftPosition"), imageAttr.get("imageTopPosition"), null);
                    }
                }
                Image im = new Image(master, scale);
                int[][] gs = im.to_grayscale();
                int[][] scaled_gs = im.scale(gs);
                images[i] = im.to_ascii_string(scaled_gs);

                //ImageIO.write(master, "PNG", new File( i + ".png")); 
            }

            print_images(images, delay);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void print_images(String[] images, int delay){

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
