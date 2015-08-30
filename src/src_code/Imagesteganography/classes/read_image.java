
package src_code.Imagesteganography.classes;
import javax.imageio.ImageIO;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class read_image {
    
   public static byte[] image_read(String impath)throws IOException
    {
        File imfile = new File(impath); 
        BufferedImage bim= ImageIO.read(imfile);
        WritableRaster wr = bim.getRaster();
        DataBufferByte db= (DataBufferByte)wr.getDataBuffer();
         return db.getData();
        
    
    
   }
      
   
        
      
            
}
