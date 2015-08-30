
package src_code.Imagesteganography.classes;


import java.io.ByteArrayInputStream;

import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
//import java.io.File;

public class build_stego {
    
    
    public static BufferedImage stego_build(byte[]bimage,byte[]bfile)throws IOException
    {
       
        int bimagelen = bimage.length;
        int filen=bfile.length;
        
        
        
       //assuming integer is 4 bytes 
        byte[] b = new byte[4];
         b[0]=(byte)((filen>>>24)&0xFF);
          b[1]=(byte)((filen>>>16)&0xFF);
           b[2]=(byte)((filen>>>8)&0xFF);
            b[3]=(byte)((filen)&0xFF);
            
          int totalen =filen+bimagelen;
          byte [] stego = new byte[totalen];
          System.arraycopy(b,0,stego,0,4);
           System.arraycopy(bfile,0,stego,4,filen);
           
           
           
         /*the actual logic of LSB*/ 
          int i1=0; 
          for(int i=0;i<bfile.length;i++)
          {
              int byteval= stego[i];
              for(int j=7;j>=0;j--)
              {
                  int bitvalue=((byteval >>> j) & 1);
                  bimage[i1]=(byte)((bimage[0]&0xFE)|bitvalue);
                  i1++;
              }
          }
          
          
          /*writing back image to file*/
          
            ByteArrayInputStream bin = new ByteArrayInputStream(bimage);
             BufferedImage bI=ImageIO.read(bin);
             
             return bI;
             //ImageIO.write(bI,"png",new File("d:/nikhil.png"));
        
        
        
    }
}
