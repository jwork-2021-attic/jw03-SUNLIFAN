package example;

import example.encoder.SteganographyFactory;
public class makeFile {
    public static void main(String[] args)throws Exception{
        SteganographyFactory.getSteganography("example/InsertionSorter.java", "example/resources/insertion.png");
    }
    
}
