import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil implements Serializable {

    private static final String POST_PATH = "src/blogPackage/outputFiles/Post.txt";

    public static void postSerialize (List<Post> list){

        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(POST_PATH))){
            obj.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Post> deserializePost (){
        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream(POST_PATH))){
           return (List<Post>) obj.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();

    }




}
