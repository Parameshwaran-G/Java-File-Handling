package Byte_Stream;

import java.io.*;

public class ByteStream_00 {
    public static void main(String[] args) throws IOException{
        try(FileInputStream input_file = new FileInputStream("Byte_Stream\\input_file.jpg");
            FileOutputStream output_file = new FileOutputStream("Byte_Stream\\output_file.jpg")) {

            byte[] buffer = new byte[1024];

            int line = input_file.read(buffer);
            while(line != -1){
                output_file.write(buffer);
                line = input_file.read(buffer);
            }
            
        } 
    }
}
