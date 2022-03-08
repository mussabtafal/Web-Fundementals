import java.util.HashMap;
import java.util.Set;

public class HashmatiqueTest {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Cadmium", "Nothing i can do");
        trackList.put("Sasha", "Dancing With Your Ghost");
        trackList.put("Robin", "Sugar");
        trackList.put("Kygo", "Stole The Show ");
        // get the keys by using the keySet method
        Set<String> keys = trackList.keySet();
        for(String key : keys) {
        System.out.println(key + ":" + trackList.get(key));
        String song = trackList.get("Sasha");
        System.out.println(song); 
        }
    }
}
