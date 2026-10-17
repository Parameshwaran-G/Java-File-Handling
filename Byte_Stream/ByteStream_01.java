package Byte_Stream;

import java.io.*;

public class ByteStream_01 {
    public static void main(String[] args) throws IOException {
        boolean flag = true;
        try(FileInputStream source_file = new FileInputStream("Byte_Stream\\input_file.jpg");
            FileInputStream destination_file = new FileInputStream("Byte_Stream\\output_file.jpg")){

            byte source_buffer[] = new byte[1024];
            byte destination_buffer[] = new byte[1024];
            int source_bytes ;
            int destination_bytes ;

            while (true){
                source_bytes =  source_file.read(source_buffer);
                destination_bytes = destination_file.read(destination_buffer);

                if(source_bytes == -1 && destination_bytes == -1){
                    break;
                }

                if(source_bytes != destination_bytes){
                    flag = false;
                    break;
                }

                for(int i=0;i<source_bytes;i++){
                    if(source_buffer[i] != destination_buffer[i]){
                        flag = false;
                        break;
                    }
                }

                if(!flag){
                    break;
                }
            }

            if(flag){
                System.out.println("Files are identical");
            }
            else{
                System.out.println("Files differ");
            }

        }
    }
}
