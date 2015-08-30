
package src_code.Imagesteganography.classes;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.File;

public class read_file {
    public static int len;
    public static String st;
    public static byte[] b;
    public static byte[] file_read(String fipath) throws FileNotFoundException, IOException
    {
        File file = new File(fipath);
        FileInputStream fin= new  FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fin));
        StringBuilder sb = new StringBuilder();
        String s1;
        while(br.read()!=-1)
        {
            s1=br.readLine();
            sb.append(s1);
        }
        st=sb.toString();
        b=new byte[st.length()];
        b=st.getBytes();
        return b;
         
    }
    
}
