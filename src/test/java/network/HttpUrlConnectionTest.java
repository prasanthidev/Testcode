package network;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HttpUrlConnectionTest {

    @Test
    public void testDownloadHTMLGoogleWebPage() {
        boolean isSuccess = HttpUrlConnection.downloadHTMLWebPage("https://google.com",
                "temp/Google.html");

        Assert.assertTrue(isSuccess);
    }

    @Test
    public void testDownloadHTMLFacebookWebPage() {
        boolean isSuccess = HttpUrlConnection.downloadHTMLWebPage("https://facebook.com",
                "temp/Facebook.html");

        Assert.assertTrue(isSuccess);
    }

    @Test
    public void testGetHTTPStatusCodeGoogleWebPage() {
        int isSuccess = HttpUrlConnection.getHTTPStatusCode("https://google.com");
        Assert.assertNotEquals(isSuccess, -1);
    }

    @Test
    public void testGetHTTPStatusCodeFacebookWebPage() {
        int isSuccess = HttpUrlConnection.getHTTPStatusCode("https://facebook.com");

        Assert.assertNotEquals(isSuccess, -1);
    }

    @Test
    public void testPrintConnectionHeadersGoogleWebPage() {
        HttpUrlConnection.printConnectionHeaders("https://google.com");
    }

    @Test
    public void testPrintConnectionHeadersFacebookWebPage() {
        HttpUrlConnection.printConnectionHeaders("https://facebook.com");
    }
}