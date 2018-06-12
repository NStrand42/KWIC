package PartOne;

import SharedClasses.FileManagementForKWIC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringJoiner;

public class PartOne
{

    private static ArrayList<String> allLines;

    public static void main(String[] args)
    {
        FileManagementForKWIC filemanager = new FileManagementForKWIC();
        allLines = filemanager.getAllLines("warAndPeace_modified.txt");
        ShiftEachLine();

        //Sort the lines
        Collections.sort(allLines);

        filemanager.writeNewLinesToFile("sorted.txt", allLines);

    }

    private static void ShiftEachLine()
    {
        int iterator = 0;
        for (String line : allLines) {
            allLines.set(iterator, shiftFrontToBack(line));
            iterator++;
        }
    }

    private static String shiftFrontToBack(String lineToShift)
    {
        String[] line = lineToShift.split(" ");
        String firstWord = line[0];
        StringJoiner newLine = new StringJoiner(" ");

        // start from 1 to ignore the save firstWord above
        for (int i = 1; i < line.length; i++) {
            newLine.add(line[i]);
        }

        newLine.add(firstWord + "\n ");

        return newLine.toString();
    }

}
