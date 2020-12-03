package network;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpUrlConnection {

    public static boolean downloadHTMLWebPage(String url, String filepath) {
        try {
            URL urlObj = new URL(url);
            java.net.URLConnection urlCon = urlObj.openConnection();

            InputStream inputStream = urlCon.getInputStream();
            BufferedInputStream reader = new BufferedInputStream(inputStream);

            BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(filepath));

            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            while ((bytesRead = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, bytesRead);
            }

            writer.close();
            reader.close();

            System.out.println("Web page saved");

            return true;

        } catch (MalformedURLException e) {
            System.out.println("The specified URL is malformed: " + e.getMessage());
            return false;
        } catch (IOException e) {
            System.out.println("An I/O error occurs: " + e.getMessage());
            return false;
        }
    }

    public static int getHTTPStatusCode(String url) {
        try {
            URL urlObj = new URL(url);
            HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();

            int responseCode = httpCon.getResponseCode();

            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.out.println("Server returned response code " + responseCode + ". Download failed.");
            } else {
                System.out.println("Server returned response code " + responseCode);
            }

            return responseCode;

        } catch (MalformedURLException e) {
            System.out.println("The specified URL is malformed: " + e.getMessage());
            return -1;
        } catch (IOException e) {
            System.out.println("An I/O error occurs: " + e.getMessage());
            return -1;
        }
    }

    public static void printConnectionHeaders(String url) {
        try {
            URL urlObj = new URL(url);
            URLConnection urlCon = urlObj.openConnection();

            Map<String, List<String>> map = urlCon.getHeaderFields();


            for (String key : map.keySet()) {
                System.out.println(key + ":");

                List<String> values = map.get(key);

                for (String aValue : values) {
                    System.out.println("\t" + aValue);
                }
            }
        } catch (MalformedURLException e) {
            System.out.println("The specified URL is malformed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An I/O error occurs: " + e.getMessage());
        }
    }

}
