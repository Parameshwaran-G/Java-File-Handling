package Byte_Stream;

import java.io.*;

public class ByteStream_00 {
    public static void main(String[] args) throws IOException{
        try(FileInputStream input_file = new FileInputStream("Byte_Stream\\input_file.jpg");
            FileOutputStream output_file = new FileOutputStream("Byte_Stream\\output_file.jpg")) {

            byte[] buffer = new byte[1024];

            int bytes = input_file.read(buffer);
            while(bytes != -1){
                output_file.write(buffer,0,bytes);
                bytes = input_file.read(buffer);
            }
            
        } 
    }
}
