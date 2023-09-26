import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.nio.file.Path;


public class Demo5 {
    public static void main(String[] args) throws IOException {
        
        Path path = Paths.get("something.txt");
       try( AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ)){
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Future<Integer> read =channel.read(buffer, 0);
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        completableFuture.supplyAsync(() ->{
            try{
                read.get();
                buffer.flip();
                return Charset.defaultCharset().decode(buffer).toString();

            }catch(Exception e){
                throw new RuntimeException();
            }


        });
        completableFuture.thenAccept(System.out :: println);
        completableFuture.exceptionally(t -> {
            t.printStackTrace();return null;
        });
         
        //System.out.println(read);
        //lets do somthing here untill read the file 
        System.out.println("i can execute this code ");
       }
    }
}
