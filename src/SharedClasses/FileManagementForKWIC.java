package SharedClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FileManagementForKWIC
{

    public static ArrayList<String> getAllLines(String file)
    {
        ArrayList<String> allLines = new ArrayList<>();
        Scanner scanner;

        try {
            scanner = new Scanner(new File(file));

            while (scanner.hasNextLine()){
                allLines.add(scanner.nextLine());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return  allLines;
    }

    public static void writeNewLinesToFile(String newFileName, Collection<String> allLines)
    {
        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(newFileName);

            for (String line : allLines) {
                fileWriter.write(line + "\n");
                System.out.println(line);
            }

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void tryDeque(String newFileName, PriorityQueue allLines)
    {
        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(newFileName);

            while (allLines.peek() != null) {
                fileWriter.write(allLines.peek() + "\n");
                System.out.println(allLines.remove());

            }

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
