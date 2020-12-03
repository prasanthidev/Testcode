package io;

import org.testng.annotations.Test;

import static io.FileBufferedReader.readFile;

public class FileBufferedReaderTest {

    @Test
    public void testReadFile() {
        //File file = ResourceUtils.getFile("");
        readFile("src/test/resources/fruits.txt");
    }
}