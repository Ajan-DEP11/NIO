import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) {
        File file = new File("something.txt");
        try{
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] buffer = new byte[1024];
        int read = -1;
        while((read =bis.read(buffer))!= -1){
            System.out.println(new String(buffer, 0, read));
        }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}