package Byte_Stream;

import java.io.*;

public class BinaryBackupUtility {

    public static void copyFile(FileInputStream sourceFile, FileOutputStream destinationFile) throws IOException{

        byte[] buffer = new byte[1024];

            int inputByte = sourceFile.read(buffer);
            while(inputByte != -1){
                destinationFile.write(buffer,0,inputByte);
                inputByte = sourceFile.read(buffer);
            }
            
    }

    public static void backupVerification(FileInputStream originalFile, FileInputStream backupFile) throws IOException {

        boolean similarity = true;

        byte[] originalBuffer = new byte[1024];
        byte[] backupBuffer = new byte[1024];

        int originalFileByte ;
        int backupFileByte ;

        while(true){

            originalFileByte = originalFile.read(originalBuffer);
            backupFileByte = backupFile.read(backupBuffer);

            if(originalFileByte == -1 && backupFileByte == -1){
                break;
            }

            if(originalFileByte != backupFileByte){
                similarity = false;
                break;
            }

            for(int i=0;i<originalFileByte;i++){
                if(originalBuffer[i]!=backupBuffer[i]){
                    similarity = false;
                    break;
                }
            }

            if(!similarity){
                break;
            }
        }

        if (similarity) {
            System.out.println("Backup Verified Successfully!!");
        }
        else{
            System.out.println("Backup Verification Failed!!");
        }

    }
    public static void main(String[] args) {
        try(FileInputStream inputFile = new FileInputStream("Byte_Stream\\input_file.jpg");
            FileOutputStream outputFile = new FileOutputStream("Byte_Stream\\output_file2.jpg")) {
            copyFile(inputFile, outputFile);
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!!");
        } catch (IOException e){
            System.out.println("An I/O Error Occurred!!");
        }

        try(FileInputStream originalFile = new FileInputStream("Byte_Stream\\input_file.jpg");
            FileInputStream backupFile = new FileInputStream("Byte_Stream\\output_file2.jpg")) {
            
            backupVerification(originalFile, backupFile);

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!!");
        } catch (IOException e){
            System.out.println("An I/O Error Occurred!!");
        }
    }
}
