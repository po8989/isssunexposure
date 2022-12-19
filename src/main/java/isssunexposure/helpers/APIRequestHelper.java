package isssunexposure.helpers;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class APIRequestHelper {

    private static final String CONTENTTYPESTRING = "Content-Type";

    /** Method helper to send a request
     * @return The list of the sun exposure history as a JSON
     * @param url The url that will be used for the request
     * @param contentType The contentType of the response
     */
    public static HttpResponse<String> SendGETRequest(String url,
                                                      String contentType) throws Exception {
        // Build the request to the ISS API
        var httpClient = HttpClient.newBuilder().build();
        var request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .header(CONTENTTYPESTRING, contentType)
                .build();
        // Send the request and catch the response
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    /** Method helper to for an url
     * @return The url formatted with the different values
     * @param host The url that will be used for the request
     * @param version The version of the API used
     * @param path The path in the API
     */
    public static String GetUrl(String host, String version, String path){
        return String.format("%1s/%2s/%3s/", host, version, path);
    }
}
