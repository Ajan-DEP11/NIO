import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Demo7 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("async.txt");
        if(!Files.exists(path)) Files.createFile(path);
        try(var channel = AsynchronousFileChannel.open(path,StandardOpenOption.READ)){
            String content = "This is the thing tht i want too write here";
            ByteBuffer buffer  = Charset.defaultCharset().encode(content);
            channel.write(buffer, 0, null, 
            new CompletionHandler<Integer,Object>() {

                @Override
                public void completed(Integer result, Object attachment) {
                  System.out.println("File Saved");
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                   System.out.println("Fail to save the file");
                   exc.printStackTrace();
                }
                
            });
            System.out.println("-----------------------------");
            Thread.sleep(500);
        }
    }
}
