import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Demo3 {
    /**
     * @param args
     */
    public static void main(String[] args) {
      File file = new File("something2.txt");
      file.createNewFile();

      try(FileOutputStream fos = new FileOutputStream(file, false);
      var bos = new BufferedOutputStream(fos)){
        int content = "gdfjkhlnl";
        bos.write(content);
      }
    }
}
