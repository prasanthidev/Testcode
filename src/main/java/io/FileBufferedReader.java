package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileBufferedReader {

    public static void readFile(String filepath) {
        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            int i;
            while((i=br.read())!=-1){
                System.out.print((char)i);
            }

            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found in the given file path: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
    }

}
