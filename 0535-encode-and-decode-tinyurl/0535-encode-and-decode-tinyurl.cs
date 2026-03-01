public class Codec {
    private Dictionary<string, string> longToShort = new Dictionary<string, string>();
    private Dictionary<string, string> shortToLong = new Dictionary<string, string>();
    private int counter = 1;
    private const string baseUrl = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL
    public string encode(string longUrl) {
        if (longToShort.ContainsKey(longUrl)) {
            return longToShort[longUrl];
        }

        string shortUrl = baseUrl + counter.ToString();
        counter++;

        longToShort[longUrl] = shortUrl;
        shortToLong[shortUrl] = longUrl;

        return shortUrl;
    }

    // Decodes a shortened URL to its original URL
    public string decode(string shortUrl) {
        return shortToLong.ContainsKey(shortUrl) ? shortToLong[shortUrl] : "";
    }
}