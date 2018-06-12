package PartTwo;

import SharedClasses.FileManagementForKWIC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PartTwo
{

    private static ArrayList<String> allLines;
    private static PriorityQueue<String> sortedDocument;

    public static void main(String[] args)
    {
        FileManagementForKWIC filemanager = new FileManagementForKWIC();
        allLines = FileManagementForKWIC.getAllLines("warAndPeace_modified.txt");

        ShiftEachLine();
        FileManagementForKWIC.tryDeque("sortedPartTwo.txt", sortedDocument);

    }

    private static void ShiftEachLine()
    {

        sortedDocument = new PriorityQueue<>();
        for (String line : allLines) {
           sortedDocument.add(shiftFrontToBack(line));


        }
    }

    private  static String shiftFrontToBack(String lineToShift)
    {
        String[] line = lineToShift.split(" ");
        String firstWord = line[0];
        StringJoiner newLine = new StringJoiner(" ");

        // start from 1 to ignore the save firstWord above
        for (int i = 1; i < line.length; i++) {
            newLine.add(line[i]);
        }

        newLine.add(firstWord + " ");

        return newLine.toString();
    }



}
