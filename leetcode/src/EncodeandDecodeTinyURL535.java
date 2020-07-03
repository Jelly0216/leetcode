import java.util.HashMap;
import java.util.Map;

public class EncodeandDecodeTinyURL535 {
    private Map<Integer, String> map = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int code = longUrl.hashCode();
        if (!map.containsKey(code)) {
            map.put(code, longUrl);
        }
        return "http://tinyurl.com/" + code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int code = Integer.parseInt(shortUrl.replace("http://tinyurl.com/",""));
        if (!map.containsKey(code)) {
            return null;
        }
        return map.get(code);
    }
}
