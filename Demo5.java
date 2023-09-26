import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
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
        CompletableFuture<Void> completableFuture = new CompletableFuture<>();
        completableFuture.runAsync(() ->{
            

        });
        //System.out.println(read);
        //lets do somthing here untill read the file 
        System.out.println("i can execute this code ");
       }
    }
}
