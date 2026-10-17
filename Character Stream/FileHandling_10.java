import java.io.*;
import java.util.HashSet;

public class FileHandling_10 {
    public static void main(String[] args) throws IOException
    {

        HashSet<Integer> validID = new HashSet<>();
        int validRecords = 0;
        int invalidRecords = 0;

        try(BufferedReader reader = new BufferedReader(new FileReader("students.csv"));
            BufferedWriter validWriter = new BufferedWriter(new FileWriter("valid-students.txt"));
            BufferedWriter invalidWriter = new BufferedWriter(new FileWriter("invalid-students.txt"))
            ){

            String line = reader.readLine();

            if(line == null){
                System.out.println("CSV file is empty");
                return;
            }

            line = reader.readLine();

            while(line != null){

                String reason = "";

                String[] values = line.split(",",-1);

                if(values.length != 4){
                    reason = "Four fields expected";
                } else {

                    String studentID = values[0].trim();
                    String name = values[1].trim();
                    String studentAge = values[2].trim();
                    String department = values[3].trim();

                    int id = 0;
                    int age = 0;

                    try {
                        id = Integer.parseInt(studentID);

                        if(validID.contains(id)){
                            reason = "Duplicate ID";
                        }

                    } catch (NumberFormatException e) {
                        reason = "Invalid student ID";
                    }

                    if (reason.isEmpty()) {

                        try {
                            age = Integer.parseInt(studentAge);

                            if (age < 18) {
                                reason = "Age mus be at least 18";
                            }

                        } catch (NumberFormatException e) {
                            reason = "Invalid student age";
                        }

                    }

                    if(reason.isEmpty() && name.isEmpty()){
                        reason = "Student name is empty";
                    }

                    if(reason.isEmpty() && department.isEmpty()){
                        reason = "Department name is empty";
                    }

                    if(reason.isEmpty()){
                        validID.add(id);

                        validWriter.write(line);
                        validWriter.write("\n");

                        validRecords++;
                    }
                    else {
                        invalidWriter.write(line + " : " + reason);
                        invalidWriter.write("\n");

                        invalidRecords++;
                    }
                }

                line = reader.readLine();
            }

            System.out.println("Process Completed");
            System.out.println("Total Records: "+(validRecords+invalidRecords));
            System.out.println("Valid Records: "+validRecords);
            System.out.println("Invalid Records: "+invalidRecords);
        }
    }
}
